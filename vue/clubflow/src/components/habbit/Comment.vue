<template>

    <div class="d-flex justify-content-between align-items-end w-100">
        <div class="dropdown" >
            <button type="button" class="py-2 btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" style="font-size: 15px; width: 140px;">
                排序方式
            </button>
            <div class="dropdown-menu" style="font-size: 14px;">
                <a class="dropdown-item active" href="#">按时间排序</a>
                <a class="dropdown-item" href="#">按热度排序</a>
            </div>
        </div>
        <p class="pb-1 m-0" style="font-size:13px">
            <span style="color:#999999;">共</span>
            <span style="color:#F95E5A;">18</span>
            <span style="color:#999999;">条动态</span>
        </p>
          
    </div>

    <div class="w-100 mt-2">
        <div>
            <comment-submit v-bind:HabbitId="HabbitId"></comment-submit>
        </div>
        <div class="mt-5" >
            <ul v-for="p in comments" :key="p.CommentId" id="comment-list" class="p-0 mb-0">
                <li style="list-style-type: none;">
                    <div class="py-4 px-4" style="background-color: white; border: 1px solid #E4E4E4;" >
                        <!-- 用户名+头像+时间 -->
                        <div class="d-flex align-items-center">
                            <img class="rounded-circle" :src="p.Image" alt="用户头像" style="width: 46px; height: 46px;">
                            <div class="ms-4">
                                <p class="mb-1" style="font-size:14px;">
                                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#666666;">{{p.Name}}</span>
                                </p>
                                <p class="m-0" style="font-size:12px;">
                                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">{{p.Time}}</span>
                                </p>
                            </div>
                        </div>
                        <!-- 评论内容 -->
                        <div class="mt-3" style="font-size:13px; color:#999999; line-height: 23px;">
                            <p>
                                <span>{{p.Content}}</span>
                            </p>
                        </div>
                        <!-- 按钮组 -->
                        <div class="w-100 d-flex justify-content-evenly" style="color:#999999">
                            <button v-bind:class="{'redtext': p.Collected}" style="font-size:14px;" title="收藏">
                                <span style="font-family:'FontAwesome', sans-serif; font-weight:400; font-size:16px;"> </span>
                                <span style="font-family:'微软雅黑', sans-serif; font-weight:400;">{{p.Collections}}</span>
                            </button>
                            <!-- <button style="font-size:14px;color:#999999;" title="转发">
                                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;font-size:16px;"></span>
                                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;"> 666</span>
                            </button> -->
                            <button class="secondary-comment-btn" @click="ShowOrHide(p.CommentId)" style="font-size:14px;" title="评论">
                                <span style="font-family:'FontAwesome', sans-serif; font-weight:400; font-size:16px;"> </span>
                                <span style="font-family:'微软雅黑', sans-serif; font-weight:400;">{{p.SubComments}}</span>
                            </button>
                            <button v-bind:class="{'redtext': p.Liked}" style="font-size:14px;" title="点赞">
                                <span style="font-family:'FontAwesome', sans-serif; font-weight:400; font-size:16px;"> </span>
                                <span style="font-family:'微软雅黑', sans-serif; font-weight:400;">{{p.Likes}}</span>
                            </button>
                        </div>
                    </div>

                    <!-- 二级评论 -->
                    <div v-if="p.ShowSubComment" class="px-5 py-4 secondary-comment" style="border: 1px solid #E4E4E4; ">
                        <div class="d-flex">
                            <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width: 46px; height: 46px;">
                            <div class="ms-4 w-100">
                                <div class="mb-3">
                                    <textarea id="comment-text" class="form-control" placeholder="回复..." rows="5" name="text" style="height: 100px;border-radius: 0px;"></textarea>
                                </div>
                                <button title="发布评论" type="submit" class="btn btn-primary float-end px-4" style="font-size:14px; height: 42px; width:120px">发布</button>
                            </div>
                        </div>
                        <div>
                            <ul v-for="subcomment in subcomments" :key="subcomment.SubCommentId" class="p-0 mt-2">
                                <li class="d-flex mb-4" style="list-style-type: none;">
                                    <img class="rounded-circle" :src="subcomment.Image" alt="用户头像" style="width: 46px; height: 46px;">
                                    <div class="mx-3">
                                        <p class="mb-1" style="font-size:14px;">
                                            <span style="color:#999999;">{{subcomment.Name}}：{{subcomment.Content}} </span>
                                        </p>
                                        <p class="m-0" style="font-size:12px;">
                                            <span style="color:#CCCCCC;">{{subcomment.Time}}</span>
                                        </p>
                                    </div>
                                </li>
                            </ul>
                            
                        </div>
                    </div>
                </li>
            </ul>

            <button id="btn-more" class="w-100 text-center">
                查看更多 &gt;
            </button>
        </div>
    </div>
</template>


<script>
import CommentSubmit from '@/components/habbit/CommentSubmit.vue';

export default {
    props:['HabbitId'],
    name:"HabbitComment",
    components:{CommentSubmit},
    data(){
        return{
            comments:[
                {
                    CommentId:0,
                    Name:"Kita",
                    Time:"5 分钟前",
                    Image:require("@/assets/images/common/default-user-round.png"),
                    Content:"我爱晨跑。今天早上6:00起床，天还没有完全亮，以后应该会亮的更晚吧。想要有人和我一起晨跑！文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例。",
                    Liked:true,
                    Collected:false,
                    Likes: 777,
                    SubComments: 999,
                    Collections:333,
                    ShowSubComment:false
                },
                {
                    CommentId:1,
                    Name:"Kita",
                    Time:"5 分钟前",
                    Image:require("@/assets/images/common/default-user-round.png"),
                    Content:"我爱晨跑。今天早上6:00起床，天还没有完全亮，以后应该会亮的更晚吧。想要有人和我一起晨跑！文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例。",
                    Liked:false,
                    Collected:false,
                    Likes: 777,
                    SubComments: 999,
                    Collections:333,
                    ShowSubComment:false
                },
                {
                    CommentId:2,
                    Name:"Kita",
                    Time:"5 分钟前",
                    Image:require("@/assets/images/common/default-user-round.png"),
                    Content:"我爱晨跑。今天早上6:00起床，天还没有完全亮，以后应该会亮的更晚吧。想要有人和我一起晨跑！文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例。",
                    Liked:false,
                    Collected:false,
                    Likes: 777,
                    SubComments: 999,
                    Collections:333,
                    ShowSubComment:false
                },
            ],
            subcomments:[
                {
                    fatherId:0,
                    SubCommentId:0,
                    Name:"Windir",
                    Time:"12月25日 17:57",
                    Image:require("@/assets/images/common/default-user-round.png"),
                    Content:"发表评论。评论不超过300字。",
                },
                {
                    fatherId:0,
                    SubCommentId:0,
                    Name:"Windir",
                    Time:"12月25日 17:57",
                    Image:require("@/assets/images/common/default-user-round.png"),
                    Content:"发表评论。评论不超过300字。",
                },
                {
                    fatherId:0,
                    SubCommentId:0,
                    Name:"Windir",
                    Time:"12月25日 17:57",
                    Image:require("@/assets/images/common/default-user-round.png"),
                    Content:"发表评论。评论不超过300字。",
                }
            ]
        }
    },
    methods:{
        ShowOrHide(CommentId){
            // console.log(CommentId)
            this.comments.forEach(function(comment) {
                if(comment.CommentId==CommentId){
                    if(comment.ShowSubComment==false){
                        // 请求subcomment


                    }
                    

                    comment.ShowSubComment=!comment.ShowSubComment
                }
            });
        }
    }
}


</script>


<style scoped>

#comment-list button:hover {
    color: rgb(26, 188, 156);
}
#btn-more {
    color:#999999;
    font-size: 13px;
}
#btn-more:hover {
    text-decoration: none;
    color: black;
    cursor: pointer;
}
textarea:focus {
    box-shadow: none;
    border:1px solid rgb(26, 188, 156);
}
.redtext {
    color: rgb(145, 0, 0);
}

</style>