<template>
    <div class="w-100">
        <div class="px-3 py-2" style="border-bottom: 1px solid #E4E4E4; font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;
        font-size: 12px;" >
            热门文章
        </div>

        <!-- 文章列表 -->
        <ul class="mt-2 px-2">
            <button @click="jumpToPost(post.PostId)" v-for="(post,idx) in posts" class="w-100 text-start p-0 m-0">
                <li v-if="post.avail" class="py-2 w-100 d-inline-flex" style="list-style-type: none; border-bottom: 1px solid #E4E4E4;">
                    <div class="img-box" style="width:110px;height:61px; overflow:hidden">
                        <img :src="post.image" alt="文章图片" style="object-fit: cover;object-position: center;width:100%;height: 100%;">
                    </div>
                    <div class="ms-3 py-2 w-100 align-items-center">
                        <p class="mb-1" style="font-size: 12px; font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">
                            {{ post.title }}
                        </p>
                        <p class="mb-0" style="font-size:12px; font-family:'微软雅黑', sans-serif;color:#999999;">
                            {{ post.date }}
                        </p>
                    </div>
                </li>
            </button>
            
        </ul>
    </div>
</template>

<script>
import { useRoute } from 'vue-router'
import {watch} from 'vue'
export default {
    name:"ArtList",
    components:{},
    props:['PostId'],
    data(){
        return {
            postids:null,
            posts:[]
        }
    },
    methods:{
        async getPosts(){
            await this.getPostIds()
            this.getPostDetails()
        },
        getPostIds(){
            let that = this
            return new Promise((resolve, reject) => {
                this.$axios
                .get('embedding/similar_post', {params:{PostId:this.PostId}})
                .then( resp =>{
                    // console.log(resp.data)
                    this.postids=resp.data.post.split(',')
                    console.log(this.postids)
                    this.postids.forEach(function(postid){
                        if(postid){
                            const post = {PostId:postid}
                            that.posts.push(post)
                        }
                    })
                    resolve('拿到文章ids')
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });                
            });
        },
        convertIdeogramToNormalCharacter(val) {
            const arrEntities = {'lt':'<','gt':'>','nbsp':' ','amp':'&','quot':'"'};
            return val.replace(/&(lt|gt|nbsp|amp|quot);/ig,function(all,t){return arrEntities[t];});
        },
        getPlainText (richCont) {
            let value = richCont;
            if(richCont){
                // 方法一： 
                value= value.replace(/\s*/g, "");  //去掉空格
                value= value.replace(/<[^>]+>/g, ""); //去掉所有的html标记
                value = value.replace(/↵/g, "");     //去掉所有的↵符号
                value = value.replace(/[\r\n]/g, "") //去掉回车换行
                value = value.replace(/&nbsp;/g, "") //去掉空格
                value = this.convertIdeogramToNormalCharacter(value);
                return value;
            }
        },
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },
        jumpToPost(postId){
            this.$router.push({path:'/postdetails',query:{PostId:postId}})
            // location.reload()
        },
        getPostDetails(){
            let _this = this
            this.posts.forEach(function(post){
                const PostId = post.PostId
                // console.log(PostId)
                _this.$axios
                .get('post/'+PostId, {params:{UserId:0}})
                .then( response =>{
                    post.post = response.data;
                    // console.log(post.post);
                    if(response.data.state == 2){
                        // 我不知道为什么，但是有可能不存在该文章
                        post.avail = false
                    }
                    else{
                        post.avail = true
                        post.title=post.post.title
                        post.clubName=post.post['club name']
                        post.thumbs=post.post.thumbs
                        post.thumbOrNot=post.post['thumbed or not']
                        if(!post.post.image || !_this.checkImgUrl(post.post.image)){
                            // 检查非法图像
                            post.image = require("@/assets/images/common/default_img-small.png")
                        }else{
                            post.image = post.post.image
                        }
                        // 解析html文本
                        if (post.post.context!=undefined){
                            post.context=_this.getPlainText(post.post.context)
                            // console.log(post.post.context)
                        }
                        // 转化日期
                        if (post.post.lastModifyDate!=undefined){
                            var ct = new Date(post.post.lastModifyDate);
                            post.date=ct.Format('yyyy-MM-dd')
                        }
                    }
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
            })
            // console.log(this.posts)
        }
        
    },
    created(){

    },
    mounted(){
        this.getPosts()

        let router = useRoute()
        watch(router,(newValue, oldValue) => {
            if(this.$route.query.PostId!=this.PostId){
                location.reload()
            }
        },
        { immediate: true });
    }
}
</script>