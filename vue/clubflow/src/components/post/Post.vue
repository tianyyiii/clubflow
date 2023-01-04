<template>
    <div class="w-100">
        <div id="art-title" style="border-color: #e1e1e1;border-width: thin; border-top: 0; border-left: 0; border-right: 0; border-style: solid;">
            <p style="font-size:20px;">
                <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">{{title}}</span>
            </p>
            <p style="font-size:14px;">
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#666666;">&nbsp;原创文章</span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">&nbsp; xx协会&nbsp; 分类：</span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#0079FE;">文化艺术类&nbsp; </span>
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;font-size:13px;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:13px;color:#999999;">文章分类</span>
            </p>
            <p style="font-size:14px;">
                <!-- 点赞 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;">&nbsp; </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">{{thumbs}}&nbsp;&nbsp;</span>
                <!-- 评论 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">---&nbsp; </span>
                <!-- 收藏 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">---&nbsp; </span>
                <!-- 浏览 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">---&nbsp; &nbsp;&nbsp; </span>
                <!-- 日期 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">{{date}}</span>
            </p>
        </div>

        <div v-html="context" id="art-text" class="mt-3 w-100"></div>

        <div class="m-3">
            <span style="font-size: 13px; color:#999999;font-family:'FontAwesome', sans-serif;">&nbsp; 文章分类</span>
        </div>

        <div class="d-flex w-100 justify-content-center position-relative">
            <button @click="changeThumbState" id="like" class="d-flex justify-content-center align-items-end">
                <p style="font-size:20px;">
                    <span v-bind:class="{'redtext': thumbOrNot}" style="font-family:'FontAwesome', sans-serif;font-weight:400;"> </span>
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:14px;">点赞 {{thumbs}}</span>
                </p>
            </button>

            <div class="position-absolute" style="right: 0;">
                <button href="#" id="collect" class="text-center">
                    <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"> </span>
                    <span style="font-family:'FontAwesome','微软雅黑', sans-serif;font-weight:400;font-size:14px;">收藏</span>
                </button>
                <div id="collectnum" class="text-center" style="font-family:sans-serif; font-size:12px; color:#999999;">
                    <span>--+人收藏</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    name:"Post",
    props:['PostId'],
    components:{},
    data(){
        return {
            UserId:0,
            post: null,
            context: '',
            title:'',
            clubName:'',
            thumbs: 0,
            date:"10-23 12:00",
            thumbOrNot:false,
        }
    },
    methods:{
        showHtml(str){
            return str
            .replace(str ? /&(?!#?\w+;)/g : /&/g, '&amp;')
            .replace(/&lt;/g,"<")
            .replace(/&gt;/g,">")
            .replace(/&quot;/g,"\"")
            .replace(/&#39;/g, "\'")
            .replace(/&amp;nbsp;/g,'\u3000')
        },
        changeThumbState(){
            this.thumbOrNot=!this.thumbOrNot
            var UserId=this.UserId
            if(!UserId){
                this.$router.push('/login')
            }
            this.$axios
            .get('post/change_thumb_state', {
                params:{
                    PostId:this.PostId,
                    UserId:UserId
                }
            })
            .then(response =>{
                console.log(response.data)
            }
            )
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
        }
    },
    created(){

    },
    mounted(){
        let that = this;
        // console.log(that.$store.state.UserId)
        var UserId=that.$store.state.UserId
        this.UserId=UserId
        //console.log(this.PostId)
        if(String(UserId)){
            this.IsLogin=true
        }else{
            UserId=0
        }
        this.$axios
        .get('post/'+that.PostId, {params:{UserId:UserId}})
        // .get('post/view', {params:{PostId:this.PostId,UserId:UserId}})
        .then( response =>{
            this.post = response.data;
            // console.log(this.post);
            this.title=this.post.title
            this.clubName=this.post['club name']
            this.thumbs=this.post.thumbs
            this.thumbOrNot=this.post['thumbed or not']
            // 解析html文本
            if (this.post.context!=undefined){
                this.context=that.showHtml(this.post.context)
                // console.log(this.post.context)
            }
            // 转化日期
            if (this.post.lastModifyDate!=undefined){
                var ct = new Date(this.post.lastModifyDate);
                this.date=ct.Format('yyyy-MM-dd hh:mm')
            }
        }
            )
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
    }
}
</script>

<style scoped>


#like {
    width:148px;
    height:59px;
    background:inherit;
    background-color:var(--themecolor);
    border:none;
    border-left:0px;
    border-top:0px;
    border-right:0px;
    border-radius:74px;
    border-bottom-right-radius:0px;
    border-bottom-left-radius:0px;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
    box-shadow:none;
    font-family:'FontAwesome', sans-serif;
    font-weight:400;
    font-style:normal;
    color:#FFFFFF;
    line-height:22px;
  }


#like:hover {
    opacity:0.8;
    cursor: pointer;
}

#collect {
    display: block;
    border: var(--greycolor);
    border-width:1px;
    border-top: 0;
    border-left: 0;
    border-right: 0;
    border-style: solid;
    width:120px;
    height:40px;
    font-family:'FontAwesome', sans-serif;
    font-weight:400;
    font-style:normal;
    color:#999999;
    text-align: center;
    font-size:20px;
    text-decoration: none;
  }
#collect:hover {
    color: rgb(78, 78, 78);
    cursor: pointer;
}

.redtext {
    color: rgb(77, 0, 0);
}

/* 穿透 */
#art-text::v-deep img{
  max-width: 100%;
  object-fit: fill;
}



</style>