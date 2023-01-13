package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson2.schema.JSONSchema.Type.Null;
@Repository
public class ClubPostDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userdao;
    @Autowired
    private ClubDAO clbdao;

    public int createPost(JSONObject inform){
        //返回0，重名；返回1，成功；返回2，超时
        try{
            int type=inform.getInteger("type");
            int ClubId = inform.getIntValue("club");
            String posttitle = inform.getString("title");
            String sql = "select title, club from post where club=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, ClubId);
            for (int i=0; i<list.size(); ++i){
                Map post = list.get(i);
                if (post.get("title").equals(posttitle))
                    return 0;
            }

            //System.out.println(inform);
            if(type==0){

                // 更新club信息中的publicationsNum
                String sql1 = "select publicationsNum from club where clubId=?";
                List<Map<String,Object>> list1 = jdbcTemplate.queryForList(sql1, ClubId);
                Map<String,Object> clubInfo = list1.get(0);
                if(clubInfo.get("publicationsNum")!=null) {
                    int pubNum = (int) clubInfo.get("publicationsNum");
                    jdbcTemplate.update("update club set publicationsNum=? where clubId=?",
                            pubNum+1, ClubId);
                }
                else {
                    jdbcTemplate.update("update club set publicationsNum=? where clubId=?",
                            1, ClubId);
                }}
            else {
                // 更新club信息中的publicationsNum
                String sql1 = "select publicationNum from habbit where habbitId=?";
                List<Map<String,Object>> list1 = jdbcTemplate.queryForList(sql1, ClubId);
                System.out.println(list1);
                Map<String,Object> clubInfo = list1.get(0);
                if(clubInfo.get("publicationNum")!=null) {
                    int pubNum = (int) clubInfo.get("publicationNum");
                    System.out.println(pubNum);
                    jdbcTemplate.update("update habbit set publicationNum=? where habbitId=?",
                            pubNum+1, ClubId);
                }
                else {
                    jdbcTemplate.update("update habbit set publicationNum=? where habbitId=?",
                            1, ClubId);
                }

            }

            jdbcTemplate.update("insert into post(creator,context,thumbs,createDate,lastModifyDate,club,title,image,type)values(?,?,?,?,?,?,?,?,?)",
                inform.getIntValue("creator"), inform.getString("context"),
                inform.getIntValue("thumbs"), inform.getDate("date"), inform.getDate("datemodify"),
                inform.getIntValue("club"), inform.getString("title"), inform.getString("image"),inform.getInteger("type"));

            return 1;
        }
        catch(RuntimeException e){
            System.out.println(e);
            return 2;
        }
    }

    public int modifypost(JSONObject inform, int PostId, int UserId){
        //返回0，重名；返回1，成功修改；返回2，修改超时
        try{
            String newTitle = inform.getString("title");
            String sql = "select title from post where creator=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, UserId);
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("title").equals(newTitle))
                    return 0;
            }

            Date datemodify = new Date();
            jdbcTemplate.update("update post set title=?,context=?,lastModifyDate=? where postId=?",
                    inform.getString("title"), inform.getString("context"),datemodify,PostId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public JSONObject getPostbyId(int PostId){
        try{
            String sql = "select * from post where postId=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, PostId);
            Map<String,Object> post = list.get(0);
            JSONObject res = new JSONObject(post);
            res.put("club name", clbdao.getClubbyId(res.getIntValue("club")).getString("clubName"));
            System.out.println(res);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res=new JSONObject();
            res.put("state",2);
            return res;
        }
    }

    public JSONObject getPostbyTitleANDClub(int ClubId, String PostTitle){
        try{
            String sql = "select * from post where title=? AND club=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, PostTitle, ClubId);
            Map<String,Object> post = list.get(0);
            JSONObject res = new JSONObject(post);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state",2);
            return res;
        }
    }

    public JSONObject listAllPosts(){
        try{
//            String sql = "select * from post order by UNIX_TIMESTAMP(lastModifyDate) desc"; // 排序顺序总是有问题
            String sql = "select * from post";
            // System.out.println(sql);
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
            JSONObject res = new JSONObject();
            for (int i=0; i<list.size(); i++){
                JSONObject post = new JSONObject(list.get(i));
                int UserId=post.getIntValue("creator");
                JSONObject tmp = new JSONObject();
                tmp.put("title", post.getString("title"));
                tmp.put("context", post.getString("context"));
                tmp.put("thumbs-up num", post.getIntValue("thumbs"));
                tmp.put("comments num", 0);
                tmp.put("creator name", userdao.getusername(UserId));
                tmp.put("club name", clbdao.getClubbyId(post.getIntValue("club")).getString("clubName"));
                tmp.put("club profile", clbdao.getClubbyId(post.getIntValue("club")).getString("image"));
                tmp.put("image", post.getString("image"));
                tmp.put("club id", post.getIntValue("club"));
                tmp.put("date", post.getString("lastModifyDate"));
                tmp.put("postId",post.getString("postId"));
                res.put("post"+Integer.toString(i),tmp);
            }
            //System.out.println(res);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state", 2);
            return res;
        }
    }

    public JSONObject listUserPosts(int UserId){
        try{
            String sql = "select * from post where creator=?";
            // System.out.println(sql);
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, UserId);
            JSONObject res = new JSONObject();
            for (int i=0; i<list.size(); i++){
                JSONObject post = new JSONObject(list.get(i));
                JSONObject tmp = new JSONObject();
                tmp.put("title", post.getString("title"));
                tmp.put("context", post.getString("context"));
                tmp.put("thumbs-up num", post.getIntValue("thumbs"));
                tmp.put("comments num", 0);
                tmp.put("creator name", userdao.getusername(UserId));
                tmp.put("club name", clbdao.getClubbyId(post.getIntValue("club")).getString("clubName"));
                tmp.put("club profile", clbdao.getClubbyId(post.getIntValue("club")).getString("image"));
                tmp.put("image", post.getString("image"));
                tmp.put("club id", post.getIntValue("club"));
                tmp.put("date", post.getString("lastModifyDate"));
                tmp.put("postId",post.getString("postId"));
                res.put("post"+Integer.toString(i),tmp);
            }
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state", 2);
            return res;
        }
    }

    public JSONObject listClubPosts(int ClubId,int type){
        try{
            if (type==2){
                String sql = "select * from post where club=?";
                // System.out.println(sql);
                List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, ClubId);
                JSONObject res = new JSONObject();
                for (int i=0; i<list.size(); i++){
                    JSONObject post = new JSONObject(list.get(i));
                    JSONObject tmp = new JSONObject();
                    tmp.put("title", post.getString("title"));
                    tmp.put("context", post.getString("context"));
                    tmp.put("thumbs-up num", post.getIntValue("thumbs"));
                    tmp.put("comments num", 0);
                    tmp.put("club name", clbdao.getClubbyId(post.getIntValue("club")).getString("clubName"));
                    tmp.put("club profile", clbdao.getClubbyId(post.getIntValue("club")).getString("image"));
                    tmp.put("image", post.getString("image"));
                    tmp.put("club id", post.getIntValue("club"));
                    tmp.put("date", post.getString("lastModifyDate"));
                    tmp.put("postId",post.getString("postId"));
                    res.put("post"+Integer.toString(i),tmp);
                }
                return res;
            }
            else{
            String sql = "select * from post where club=? and type=?";
            // System.out.println(sql);
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, ClubId,type);
            JSONObject res = new JSONObject();
            for (int i=0; i<list.size(); i++){
                JSONObject post = new JSONObject(list.get(i));
                JSONObject tmp = new JSONObject();
                tmp.put("title", post.getString("title"));
                tmp.put("context", post.getString("context"));
                tmp.put("thumbs-up num", post.getIntValue("thumbs"));
                tmp.put("comments num", 0);
                tmp.put("club name", clbdao.getClubbyId(post.getIntValue("club")).getString("clubName"));
                tmp.put("club profile", clbdao.getClubbyId(post.getIntValue("club")).getString("image"));
                tmp.put("image", post.getString("image"));
                tmp.put("club id", post.getIntValue("club"));
                tmp.put("date", post.getString("lastModifyDate"));
                tmp.put("postId",post.getString("postId"));
                res.put("post"+Integer.toString(i),tmp);
            }
            return res;}
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state", 2);
            return res;
        }
    }
    //返回1表示该用户已点赞，返回0表示没有点赞
    public int thumbedOrNot(int PostId, int ThumberId){
        String sql = "select postId, thumberId, state from postthumb where postId=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, PostId);
        for(int i=0;i<list.size();++i){
            Map post = list.get(i);
            if (post.get("thumberId").equals(ThumberId)){
                if (post.get("state").equals(0))
                    return 0;
                else
                    return 1;
            }
        }
        return 0;
    }
    //改变用户对post的点赞状态
    public int changethumbpost(int PostId, int ThumberId){
        try{
            int flag = 0;
            String sql = "select postId, thumberId, state from postthumb where postId=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, PostId);
            for(int i=0;i<list.size();++i){
                Map post = list.get(i);
                if (post.get("thumberId").equals(ThumberId)){
                    if (post.get("state").equals(1))
                        flag = 1;
                    else
                        flag = 2;
                    break;
                }
            }
            //flag=0说明没有该用户对该post的点赞信息，flag = 1说明有，且是点赞状态，flag = 2说明有，且是不点赞状态
            Date date = new Date();
            String sqll = "select thumbs from post where postId=?";
            List<Map<String, Object>> listt = jdbcTemplate.queryForList(sqll, PostId);
            Map<String,Object> postt = listt.get(0);
            int thumbNum = (int) postt.get("thumbs");
            System.out.println(flag);
            if (flag == 0 || flag == 2){
                jdbcTemplate.update("update post set thumbs=? where postId=?",
                        thumbNum+1, PostId);
            }
            else{
                if(thumbNum>0)
                    jdbcTemplate.update("update post set thumbs=? where postId=?",
                        thumbNum-1, PostId);
            }

            if (flag == 0) {
                jdbcTemplate.update("insert into postthumb(postId,thumberId,lastThumbDate,state)values(?,?,?,?)",
                        PostId, ThumberId, date, 1);
            }
            else if(flag == 1){

                jdbcTemplate.update("update postthumb set state=?, lastThumbDate=? where postId=? AND thumberId=?",
                        0, date, PostId, ThumberId);
            }
            else{
                jdbcTemplate.update("update postthumb set state=?, lastThumbDate=? where postId=? AND thumberId=?",
                        1, date, PostId, ThumberId);
            }
            return 1;
        }
        catch (RuntimeException e){
            return 2;
        }
    }
}
