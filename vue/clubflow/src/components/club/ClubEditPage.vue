<template>
    <!-- 顶部banner -->
    <ClubBanner v-bind:ClubId="ClubId"></ClubBanner>

    <!-- 标题栏 -->
    <div class="mt-3 d-flex px-3 py-3 mx-4 align-items-center justify-content-between" style="border-bottom: rgb(233, 233, 233) 1px solid;">
        <div class="mx-5 d-inline-flex align-items-center">
            <!-- 头像 -->
            <div class="me-4">
                <img class="rounded-circle" src="@/assets/images/common/default-user-round-dark.png" alt="用户头像" style="width:79px;height:79px">
            </div>
            <!-- 标题 -->
            <div class="">
                <p class="mb-0" style="font-size:18px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">{{ ClubInfo.Name }}</span>
                </p>
                <p class="mb-0" style="font-size:14px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">{{ ClubInfo.Inform }}</span>
                </p>
            </div>
            
        </div>

        <div class="d-flex" style="font-size:18px;color:#A4A4A4;">
            <div class="text-center" style="width: 140px; border-right: 1px rgb(228, 228, 228) solid;">
                <p class="mb-1" style="font-size:14px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">粉丝</span>
                </p>
                <p class="mb-0" style="font-size:20px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">{{ ClubInfo.FansNumber }}</span>
                </p>
            </div>
            <div class="text-center" style="width: 140px; border-right: 1px rgb(228, 228, 228) solid;">
                <p class="mb-1" style="font-size:14px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">文章</span>
                </p>
                <p class="mb-0" style="font-size:20px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">{{ ClubInfo.PubNum }}</span>
                </p>
            </div>

        </div>
    </div>

    <div class="row container-fluid d-flex justify-content-center py-5" style="background-color: rgb(249, 249, 249);">
        <!-- 资料卡 -->
        <div id="basic-info" class="col-md-6 me-5" >
            <!-- 小标题 -->
            <div class="" >
                <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
                <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">资料卡</span>
                <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
            </div>
            <!-- 灰色区 -->
            <div class="px-2 py-4">
                <div style="font-family:'华文宋体', sans-serif;font-size:14px;line-height: 18px;">
                    {{ ClubInfo.Announcement }}</div>
                <textarea v-model="newAnnouncement" id="intro-text" class="form-control mt-5" placeholder="请输入协会简要介绍信息。不超过500字。" maxlength="500" name="text" style="height: 160px;border-radius: 3px;font-size: 14px;"></textarea>
            </div>
            <!-- 按钮组 -->
            <div class="w-100 px-5 my-2 d-flex justify-content-end">
                <button class="re-btn me-2">重置</button>
                <button @click="submitAnnouncement" class="sav-btn">提交</button>
            </div>
        </div>
        <!-- 粉丝列表 -->
        <div class="col-md-4 ms-4">
            <!-- 小标题 -->
            <div class="" >
                <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
                <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">粉丝列表</span>
                <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
            </div>
            <!-- 列表 -->
            <ul class="py-3 px-4">
                <li v-for="fan in fanProfiles" class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" :src="fan.image" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">{{fan.name}}</p>
                </li>
            </ul>
        </div>
    </div>

    <!-- 发表文章 -->
    <div class="mt-5 px-5 mx-4">
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">发表文章</span>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <div class="my-3 px-1">
            <PostEdit v-bind:ClubId="ClubId"></PostEdit>
        </div>
    </div>

    <!-- 历史文章 -->
    <div class="px-0 pt-1 mt-5 container-fluid" style="background-color: #f9f9f9; padding-bottom: 200px;">
        <div class="mt-5 px-5 mx-4" >
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
    </div>
    
</template>

<script>

import ClubBanner from '@/components/club/ClubBanner.vue';
import PostEdit from '../post/PostEdit.vue';

export default {
    name: 'ClubEditPage',
    components: {ClubBanner,PostEdit},
    data(){
        return{
            ClubId: 0,
            UserId:0,
            IsLogin:false,
            ClubInfo:{
                CreateTime:'2011-03-30',
                Name:'xx协会',
                Category:'文化艺术类',
                FansNumber:0,
                Profile:require("@/assets/images/common/default-user-round-dark.png"),
                PubNum:0,
                Subscribe:0, // 用户是否关注
                CommentNum:0,
                Inform:'',
                Announcement:"介绍协会。协会简介。"
            },
            fanProfiles:[],
            fans:null,
            posts:null,
            posts_json:[],
            newAnnouncement:""
        }
    },
    methods: {
        submitAnnouncement(){
            var inform={
                ClubId:this.ClubId,
                UserId:this.UserId,
                context:this.newAnnouncement
            }
            this.$axios
            .post('club/announcement/modify',inform)
            .then(resp=>{
                console.log(resp)
                if(resp.data.state==1){
                    alert("修改成功！")
                    location.reload()
                }else{
                    alert("错误！",resp.data.state)
                }
            })
            .catch(failResponse => {
                    console.log(failResponse)
                })
        },
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },
        getClubInfo(){
            return new Promise((resolve, reject) => {
                let that = this
                this.$axios
                .get('club/get_created_club',{params:{UserId:this.UserId}})
                .then(resp=>{
                    // console.log(resp)
                    this.ClubId=resp.data.clubId
                    var ct = new Date(resp.data['createdDate']);
                    this.ClubInfo.CreateTime=ct.Format('yyyy-MM-dd')
                    this.ClubInfo.Name=resp.data.clubName
                    this.ClubInfo.FansNumber=resp.data['fansNum']
                    if(resp.data.image){
                        var a = that.checkImgUrl(resp.data.image)
                        // console.log(a)
                        if(a){this.ClubInfo.Profile=resp.data.image}
                    }
                    this.ClubInfo.PubNum=resp.data['publicationsNum']
                    this.ClubInfo.Subscribe=resp.data.subscribe
                    this.ClubInfo.CommentNum=resp.data['commentsNum']
                    this.ClubInfo.Inform=resp.data.clubInfo
                    if(resp.data.announcement){this.ClubInfo.Announcement=resp.data.announcement}
                    this.viewFans()
                    resolve('社团基本信息完成请求')
                })
                .catch(failResponse => {
                    console.log(failResponse)
                })
            });
        },
        viewFans(){
            this.$axios
            .get('/club/view_fans',{params:{ClubId:this.ClubId}})
            .then(
                resp => {
                    // console.log(resp)
                    this.fans=resp.data
                    let obj = this.fans;
                    for (let i in obj ){
                        //console.log(i)
                        // console.log(this.fans[i])
                        var a = this.checkImgUrl(this.fans[i].image)
                        // console.log(a)
                        if(a){
                            this.fanProfiles.push({image:this.fans[i].image,name:this.fans[i].name})
                        }else{
                            // 非法则插入默认图片
                            this.fanProfiles.push({image:require("@/assets/images/common/default-user-round.png"),name:this.fans[i].name})
                        }
                    }
                    // console.log(this.fanProfiles)
            }
            )
            .catch(failResponse => {console.log(failResponse)})
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
            const str = richCont;
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
            .get('post/view_by_club',{params:{ClubId:this.ClubId,UserId:this.UserId}})
            .then( response =>{
                this.posts = response.data;
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
        },
        jumpToPost(postId){
            this.$router.push({path:'/postdetails',query:{PostId:postId}})
        },
        async getAllPageInfo(){
            await this.getClubInfo()
            // console.log("finish:1")
            this.getPosts()
        }
    },
    created(){
        this.ClubId=this.$route.query.ClubId
        this.UserId=this.$store.state.UserId
        if(!String(this.UserId)){
            this.UserId=0
        }else{
            this.IsLogin=true
        }
    },
    mounted(){
        if(this.UserId){
            this.getAllPageInfo()
            
        }
        
    }
  }

</script>

<style scoped>


.sav-btn {
  width:80px;
  height:30px;
  background-color:rgba(184, 45, 41, 1);
  border-radius:0px;
  font-family:'微软雅黑', sans-serif;
  font-weight:400;
  font-style:normal;
  font-size:12px;
  color:#FFFFFF;
}
.sav-btn:hover{
    opacity: 80%;
}
.re-btn{
    width:80px;
  height:30px;
  background-color:white;
  border: 1px solid rgba(184, 45, 41, 1);
  border-radius:0px;
  font-family:'微软雅黑', sans-serif;
  font-weight:400;
  font-style:normal;
  font-size:12px;
  color:rgba(184, 45, 41, 1);
}

textarea:focus {
    box-shadow: none;
    border:1px solid rgba(0, 121, 254, 1);
}

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