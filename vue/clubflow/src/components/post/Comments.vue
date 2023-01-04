<template>
    <div class="p-3 border border-1">
        <!-- 标题 -->
        <div class="">
            <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;font-size:14px;color:#666666;">发表评论 </span>
            <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;color:#CCCCCC;">文明上网理性发言，请遵守评论服务协议</span>
        </div>

        <!-- 发表区 -->
        <div class="my-3 w-100 d-inline-flex">
            <div v-if="IsLogin" id="user-img" class="user-img me-1 text-center" style="width: 10%; color:#999999;">
                <div>
                    <img class="rounded-circle" :src="UserInfo.image" alt="用户头像" style="width: 46px; height: 46px;">
                </div>
                <div class="mt-2" title="请先登录" style="font-family:'微软雅黑', sans-serif; font-size:12px;">
                    <span>{{ UserInfo.name }}</span>
                </div>
            </div>
            <div v-else id="user-img" class="user-img me-1 text-center" style="width: 10%; color:#999999;">
                <!-- <div class="default-img-big" style="font-family:'FontAwesome', sans-serif; font-size:48px; color:#CCCCCC;">
                    <span></span>
                </div> -->
                <div>
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width: 46px; height: 46px;">
                </div>
                <div class="mt-2" title="请先登录" style="font-family:'微软雅黑', sans-serif; font-size:12px;">
                    <span>未登录</span>
                </div>
            </div>

            <div class="ms-3 w-100">
                <div v-if="IsLogin">
                    <div class="mb-3">
                        <textarea v-model="NewComment" id="comment-text" class="form-control" placeholder="请文明评论！" rows="5" name="text"></textarea>
                    </div>
                    <button @click="submitComment" title="发布评论" class="btn btn-primary float-end" style="font-size:14px; width:80px">发布</button>
                </div>
                <fieldset v-else disabled>
                    <div class="mb-3">
                        <textarea id="comment-text" class="form-control" placeholder="您未登录，请先登录！" rows="5" name="text"></textarea>
                    </div>
                    <button title="发布评论" class="btn btn-primary float-end" style="font-size:14px; width:80px">发布</button>
                </fieldset>
            </div>
        </div>

        <!-- 评论显示区 -->
        <div class="mt-3">
            <div class="d-flex justify-content-between border-bottom pb-2">
                <div style="font-size: 14px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">全部评论 </span>
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;">{{CommentNum}}条</span>
                </div>
                <div class="" style="font-size: 13px;">
                    <button style="border: 0; background-color: inherit; color:#999999;">最新</button>
                    <button style="border: 0; background-color: inherit; color:#666666;"> / 最热</button>
                </div>
            </div>

            <!-- 评论列表 -->
            <!-- <ul class="p-1 mb-3 w-100" v-show="Commentlist.length>0 && Commentlist[0].UserInfo.image"> -->
            <ul class="p-1 mb-3 w-100">
                <li v-for="(comment,idx) in Commentlist" class="mt-3 w-100" style="list-style-type: none;">
                    <div class="d-inline-flex w-100 border-bottom" >
                        <div class="m-2 me-4">
                            <img class="rounded-circle" :src="comment.image" alt="用户头像" style="width: 46px; height: 46px;">
                        </div>
                        <div class="w-100" style="color:#999999;">
                            <div class="mb-3 w-100 d-flex justify-content-between">
                                <div class="" style="font-size:14px;">
                                    <span style="color:#666666;">{{comment.name}}&nbsp;</span>
                                    <span style="font-size:12px;color:#999999;">{{comment.commentDate}}</span>
                                </div>
                                <button class="">
                                    <span style="font-family:'FontAwesome', sans-serif; font-size:14px;"></span>
                                    <span style="font-family:'微软雅黑', sans-serif; font-size:12px;"> 举报</span>
                                </button>
                            </div>
                            
                            <p class="textlines-overflow-2" style="height: 40px; font-size: 14px;">
                                {{comment.context}}</p>

                            <p style="font-size:14px;">
                                <button @click="CommentLikeOrUnlike(comment.commentId,idx)" title="点赞">
                                    <span v-if="comment.isthumbed" style="font-family:'FontAwesome', sans-serif;font-weight:400; color: rgba(184, 45, 41, 1);"></span>
                                    <span v-else style="font-family:'FontAwesome', sans-serif;font-weight:400;"></span>
                                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 点赞 {{comment.thumbs}} &nbsp;</span>
                                </button>
                                <button title="评论" data-bs-toggle="modal" data-bs-target="#myModal" @click="TransId(comment.commentId)">
                                    <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"></span>
                                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 回复 {{ comment.SubNum }} </span>
                                </button>
                            </p>
                        </div>
                    </div>
                    <!-- 二级评论 -->
                    <div class="">
                        <ul class="ms-4 mt-2">
                            <li v-for="(subcomment,sidx) in comment.SubComment" class="mt-2 d-inline-flex w-100 border-bottom pt-1" style="list-style-type: none;">
                                <div class="me-4">
                                    <img class="rounded-circle" :src="subcomment.image" alt="用户头像" style="width: 46px; height: 46px;">
                                </div>
                                <div class="w-100" style="color:#999999;">
                                    <div class="mb-1 w-100 d-flex justify-content-between">
                                        <div class="" style="font-size:14px;">
                                            <span style="color:#666666;">{{subcomment.name}}&nbsp;</span>
                                            <span style="font-size:12px;color:#999999;">{{subcomment.commentDate}}</span>
                                        </div>
                                        <button class="" >
                                            <span style="font-family:'FontAwesome', sans-serif; font-size:14px;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif; font-size:12px;"> 举报</span>
                                        </button>
                                    </div>
                                    
                                    <p class="textlines-overflow-2 m-0" style="height: 40px; font-size: 14px;">
                                        {{ subcomment.context }}</p>

                                    <p class="mt-0 mb-1" style="font-size:14px;">
                                        <button @click="SubCommentLikeOrUnlike(subcomment.subcommentId,idx,sidx)" title="点赞">
                                            <span v-if="subcomment.isthumbed" style="font-family:'FontAwesome', sans-serif;font-weight:400;color: rgba(184, 45, 41, 1);"></span>
                                            <span v-else style="font-family:'FontAwesome', sans-serif;font-weight:400;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 点赞 {{subcomment.thumbs}} &nbsp;</span>
                                        </button>
                                    </p>
                                </div>
                            </li>
                        </ul>
                    </div>
                    
                
                </li>

            </ul>
        </div>
    </div>

    <!-- 模态框 -->
    <div class="modal fade" ref="reply" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">在此添加回复</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- 模态框内容 -->
            <div class="modal-body">
                <textarea ref="replycontent" id="comment-text" class="form-control" placeholder="回复..." rows="5" name="text" style="height: 100px;border-radius: 0px;"></textarea>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <!-- <button type="button" class="btn btn-danger" data-bs-dismiss="modal">关闭</button> -->
                <button @click="Reply" title="发布评论" class="btn btn-primary float-end px-4" style="font-size:14px; width:80px">发布</button>
            </div>

            </div>
        </div>
    </div>
</template>

<script>
import { reactive } from 'vue';


export default {
    name:"Comments",
    props:['PostId'],
    components:{},
    data(){
        return {
            IsLogin:false,
            UserId:0,
            UserInfo:{
                image:require("@/assets/images/common/default-user-round.png"),
                name:""
            },
            NewComment:"",
            Commentlist:reactive([]),
            CommentNum:0,
            Comments:null,
        }
    },
    methods:{
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },
        getUserInfo(UserId){
            // 先拿到当前用户头像和名字
            let _this = this
            this.$axios
            .get('user/view', {params:{UserIdtoView:UserId, UserId:UserId}})
            .then( resp =>{
                // console.log(resp.data)
                if(resp.data.image && _this.checkImgUrl(resp.data.image)){
                    this.UserInfo.image=resp.data.image
                }
                this.UserInfo.name=resp.data.name
            })
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
        },
        // 提交主评论
        submitComment(){
            const sub = {
                PostId:this.PostId,
                UserId:this.UserId,
                context:this.NewComment
            }
            this.$axios
            .put('comment/create', sub)
            .then( resp =>{
                // console.log(resp.data)
                if(resp.data.state==1){
                    alert("发布成功！")
                    location.reload()
                }
                else{
                    alert("发布失败！")
                }
            })
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
        },
        // 展示评论列表
        async showComments(){
            await this.showMainComments()
            this.showSubComments()
        },
        showMainComments(){
            return new Promise((resolve, reject) => {
                this.$axios
                .get('comment/view', {params:{PostId:this.PostId, UserId:this.UserId}})
                .then( resp =>{
                    console.log(resp.data)
                    this.Comments=resp.data
                    for (let i in this.Comments ){
                        if(i!="state"){
                            var comment = this.Comments [i]
                            // 处理图片
                            if(!comment.image || !this.checkImgUrl(comment.image)){
                                comment.image=require("@/assets/images/common/default-user-round.png")
                            }
                            // 转化日期
                            if (comment.commentDate!=undefined){
                                var ct = new Date(comment.commentDate);
                                comment.commentDate=ct.Format('MM-dd hh:mm')
                            }
                            this.Commentlist.push(comment)
                            console.log(comment)
                        }
                    }
                    this.CommentNum=this.Commentlist.length
                    console.log(this.Commentlist)
                    resolve('主评论完成请求')
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });                
            });
        },
        showSubComments(){
            let that=this
            this.Commentlist.forEach(function(comment){
                const CommentId=comment.commentId
                that.$axios
                .get('subcomment/view', {params:{CommentId:CommentId, UserId:that.UserId}})
                .then( resp =>{
                    console.log(resp.data)
                    var SubCommentList = []
                    for (let i in resp.data ){
                        var subcomment = resp.data[i]
                        // 处理图片
                        if(!subcomment.image || !that.checkImgUrl(subcomment.image)){
                            subcomment.image=require("@/assets/images/common/default-user-round.png")
                        }
                        // 转化日期
                        if (subcomment.commentDate!=undefined){
                            var ct = new Date(subcomment.commentDate);
                            subcomment.commentDate=ct.Format('MM-dd hh:mm')
                        }
                        SubCommentList.push(subcomment)
                    }
                    comment.SubComment=SubCommentList
                    comment.SubNum=SubCommentList.length // 记录一共多少二级评论
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
            })
        },
        // 主评论点赞
        CommentLikeOrUnlike(CommentId,index){
            if(!this.Commentlist[index].isthumbed){
                // 未点赞
                const sub = {CommentId:CommentId,UserId:this.UserId}
                this.$axios
                .post('comment/thumb', sub)
                .then( resp =>{
                    // console.log(resp.data)
                    if(resp.data.state==1){
                        // alert("点赞成功！")
                    }
                    else{
                        alert(resp.data.error)
                    }
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
            }else{
                // 已点赞
                const sub = {CommentId:CommentId,UserId:this.UserId}
                this.$axios
                .post('comment/unthumb', sub)
                .then( resp =>{
                    // console.log(resp.data)
                    if(resp.data.state==1){
                        // alert("取消成功！")
                    }
                    else{
                        alert(resp.data.error)
                    }
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
            }
            // 切换点赞状态
            this.Commentlist[index].isthumbed=!this.Commentlist[index].isthumbed
        },
        // 二级评论点赞
        SubCommentLikeOrUnlike(SubCommentId,index,subindex){
            if(!this.Commentlist[index].SubComment[subindex].isthumbed){
                // 未点赞
                const sub = {SubCommentId:SubCommentId,UserId:this.UserId}
                this.$axios
                .post('subcomment/thumb', sub)
                .then( resp =>{
                    // console.log(resp.data)
                    if(resp.data.state==1){
                        // alert("点赞成功！")
                    }
                    else{
                        alert(resp.data.error)
                    }
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
            }else{
                // 已点赞
                const sub = {SubCommentId:SubCommentId,UserId:this.UserId}
                this.$axios
                .post('subcomment/unthumb', sub)
                .then( resp =>{
                    // console.log(resp.data)
                    if(resp.data.state==1){
                        // alert("取消成功！")
                    }
                    else{
                        alert(resp.data.error)
                    }
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
            }
            // 切换点赞状态
            this.Commentlist[index].SubComment[subindex].isthumbed=!this.Commentlist[index].SubComment[subindex].isthumbed
        },
        TransId(CommentId){
            this.$refs.reply.val=CommentId
        },
        // 回复评论
        Reply(){
            const CommentId = this.$refs.reply.val
            const Context = this.$refs.replycontent.value
            // console.log(context)
            const sub = {
                CommentId:CommentId,
                UserId:this.UserId,
                Context:Context
            }
            this.$axios
            .put('subcomment/create', sub)
            .then( resp =>{
                console.log(resp.data)
                if(resp.data.state==1){
                    alert("发布成功！")
                    location.reload()
                }
                else{
                    alert("发布失败！")
                }
            })
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
        }
    },
    created(){
        if(this.$store.state.UserId){
            this.IsLogin=true
            this.UserId=this.$store.state.UserId
            this.getUserInfo(this.UserId)
        }
        else{
            this.UserId=0
        }
    },
    mounted(){
        this.showComments()
    }
}

</script>

<style scoped>

#comment-text:focus {
    box-shadow: none;
    border:1px solid rgb(134, 134, 255);
}

</style>