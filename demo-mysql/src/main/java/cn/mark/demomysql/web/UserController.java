package cn.mark.demomysql.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/getAllThings",method = RequestMethod.GET)
    @ResponseBody
    /*
     * List 里的对象是Map对象，而Map对象是
     * 由一个String类型的键和Object类型的值组成
     * */
    public List<Map<String,Object>> getAllThings(String wantedThings,String tableName){
        String sql="select "+wantedThings+" from "+tableName;//SQL查询语句
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }
    @RequestMapping(value = "/getSomeThings",method = RequestMethod.GET)
    @ResponseBody
    /*
     * List 里的对象是Map对象，而Map对象是
     * 由一个String类型的键和Object类型的值组成
     * */
    public List<Map<String,Object>> getSomeThings(String wantedThings,String tableName,String condition){
        String sql="select "+wantedThings+" from "+tableName+" where "+condition;//SQL查询语句
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    @RequestMapping(value = "/deleteSomeThings",method = RequestMethod.GET)
    @ResponseBody
    /*
     * List 里的对象是Map对象，而Map对象是
     * 由一个String类型的键和Object类型的值组成
     * */
    public List<Map<String,Object>> insertSomeThings(String tableName,String wantedThingsList,String valueList){
        String sql="insert into"+tableName+"("+wantedThingsList+")"+" values "+"("+valueList+")";//SQL查询语句
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    @RequestMapping(value = "/deleteSomeThings",method = RequestMethod.GET)
    @ResponseBody
    /*
     * List 里的对象是Map对象，而Map对象是
     * 由一个String类型的键和Object类型的值组成
     * */
    public List<Map<String,Object>> updateSomeThings(String wantedThings,String tableName,String value,String condition){
        String sql="update "+tableName+" set "+value+" where "+condition;//SQL查询语句
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    @RequestMapping(value = "/deleteSomeThings",method = RequestMethod.GET)
    @ResponseBody
    /*
     * List 里的对象是Map对象，而Map对象是
     * 由一个String类型的键和Object类型的值组成
     * */
    public List<Map<String,Object>> deleteSomeThings(String wantedThings,String tableName,String condition){
        String sql="delete from "+tableName+" where "+condition;//SQL查询语句
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }
}
