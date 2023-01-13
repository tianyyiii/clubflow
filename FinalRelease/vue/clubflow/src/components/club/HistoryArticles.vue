<template>
    <div>
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">历史文章</span>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <!-- 文章列表 -->
        <ul class="list-group m-0 p-0">
            <!-- 列表项 -->
            <a @click="jumpToPost(post.postId)" v-for="post in posts_json" class="list-group-item list-group-item-action d-flex gap-3 py-3 overflow-hidden" aria-current="true" style="border-radius: 0;">
                <div class="img-box flex-shrink-0">
                    <img v-if="post.haveimage" :src="post.image">   
                    <img v-else src="@/assets/images/common/default_img.png">   
                </div>
                <div class="gap-2 w-100 position-relative">
                    <div class="d-flex w-100 justify-content-between">
                        <div>
                            <h6 class="mb-0" style="font-family:'微软雅黑', sans-serif; font-weight: 600; font-size:16px;">
                                {{post.title}}
                            </h6>
                            <p class="textlines-overflow-2 mt-2 ms-1 mb-0" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:13px;
                                color:#999999; text-align:left;">
                                {{post.context}}
                            </p>
                        </div>
                        <small class="opacity-50 text-nowrap" style="font-size: 12px;">
                            <i class="fa fa-clock-o" aria-hidden="true"></i> {{post.date}}
                        </small>
                    </div>
                    <div class="d-flex w-100 position-absolute bottom-0 justify-content-between align-items-baseline">
                        <div class="d-inline-flex align-items-center">
                            <div class="user-img-box flex-shrink-0" style="width:24px; height:24px; overflow:hidden" >
                                <img v-if="post['haveclub profile']" :src="post['club profile']">
                                <img v-else src="@/assets/images/common/default_user.png">
                            </div>
                            <span class="ms-2" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:12px;
                                    color:#999999;">{{ post['club name'] }}
                            </span>
                        </div>
                        <p class="m-0" style="font-family:'FontAwesome', '微软雅黑', sans-serif; font-weight:400; font-size:13px;
                        color:#999999;">
                             {{post['thumbs-up num']}}&nbsp;  {{post['comments num']}}&nbsp;  --
                        </p>
                    </div>
                </div>
            </a>
        </ul>
    </div>
</template>

<script>

export default {
    name:"HistoryArticles",
    props:['ClubId'],
    data(){
        return{
            Club:0,
            UserId:0,
            posts:null,
            posts_json:[],
        }
    },
    methods:{
        jumpToPost(postId){
            this.$router.push({path:'/postdetails',query:{PostId:postId}})
        },
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },
        check_img_fields : function(field){
            // 检查是否有图片，没有则设havefield为false，field为 'img' 或 'club profile' 等键值
            let _this = this
            this.posts_json.forEach(function(post){
                // console.log(_this.checkImgUrl(post[field]))
                if (post[field]==undefined || post[field]=='' || !_this.checkImgUrl(post[field])){
                    post['have'+field]=false;
                }
                else {
                    post['have'+field]=true;
                    // post[field+'forurl']="data:image/png;base64,"+post[field];//html标签的src中的url
                    post[field+'forurl']=post[field];//html标签的src中的url
                }
            })
        },
        convertIdeogramToNormalCharacter(val) {
            const arrEntities = {'lt':'<','gt':'>','nbsp':' ','amp':'&','quot':'"'};
            return val.replace(/&(lt|gt|nbsp|amp|quot);/ig,function(all,t){return arrEntities[t];});
        },
        // 获取富文本的纯文字内容
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
        getPosts(){
            let that=this
            this.$axios
            .get('post/view_by_club',{params:{ClubId:this.Club,UserId:this.UserId}})
            .then( response =>{
                this.posts = response.data;
                this.posts_json = []
                // console.log(this.posts)
                let obj = this.posts;
                for (let i in obj ){
                    this.posts_json.push(obj [i])
                }
                // 验证是否有图片域
                var fields = ['image', 'club profile'];
                for (var i=0,len=fields.length; i<len; i++)
                {
                    var field=fields[i];
                    that.check_img_fields(field);
                }
                // 解析html文本
                this.posts_json.forEach(function(post){
                    if (post.context!=undefined){
                        post.context=that.getPlainText(post.context)
                    }
                })
                // 转化日期
                this.posts_json.forEach(function(post){
                    if (post.date!=undefined){
                        var ct = new Date(post.date);
                        post.date=ct.Format('yyyy-MM-dd hh:mm')
                    }
                })
            })
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
        }
    },
    created(){
        this.UserId=this.$store.state.UserId
        if(!String(this.UserId)){this.UserId=0}
    },
    watch: {
        ClubId: {
            // 监测父组件传过来的值有没有更新
            immediate: true,
            deep: true,
            handler(newVal, oldVal) {
                // console.log(newVal, "newVal");
                this.Club=newVal;
                if(this.Club!=undefined){
                    // console.log(this.Club)
                    this.getPosts()
                }
                
            }
        }
    },
}
</script>

<style scoped>
.list-group a {
    border-width: 0;
}

.list-group a:hover {
    background-color: white;
    border-width:2px;
    border-top: 0;
    border-left:0 ;
    border-right: 0;
    border-color: var(--themecolor);
    cursor: pointer;
}
.list-group-item {
    height: 140px;
    overflow:hidden
}
.img-box {
    width:153px; height:108px;overflow:hidden;
}
.img-box>img {
    max-width:153px;
    /* _width:expression( this.width > 153 ? "153px" : this.width); */
}
.user-img-box>img {
    max-width:24px;
    /* _width:expression( this.width > 24 ? "24px" : this.width); */
}
</style>