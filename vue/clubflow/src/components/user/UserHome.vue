<template>
    <!-- 顶部banner -->
    <UserBanner></UserBanner>

    <!-- 标题栏 -->
    <div class="mt-3 d-flex px-3 py-3 mx-4 align-items-center justify-content-between" style="border-bottom: rgb(233, 233, 233) 1px solid;">
        <div class="mx-5 d-inline-flex align-items-center">
            <!-- 头像 -->
            <div id="userimg" class="me-4 d-flex position-relative">
                <img class="rounded-circle" :src="UserInfo.image" alt="用户头像" style="width:79px;height:79px">
                <UpImage @upUrl="getImgURL" class="position-absolute"></UpImage>
            </div>
            <!-- 标题 -->
            <div class="">
                <p class="mb-0" style="font-size:18px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">{{ UserInfo.name }}</span>
                </p>
                <p class="mb-0" style="font-size:14px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">副标题</span>
                </p>
            </div>
            
        </div>

    </div>

    <!-- 关注列表 -->
    <div class="mt-5 px-5 mx-4">
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">关注列表</span>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <div class="my-3 px-1 py-1">
            <button @click="jumpToClubShow(club.clubId)" v-for="club in showlist" class="py-3 px-3 w-100 d-flex" style="border-bottom: 1px rgba(242, 242, 242, 1) solid;">
                <div class="me-5" style="width:450px">
                    <img class="rounded-circle" :src="club.image" style="height: 38px;width: 38px;">
                    <p class="mt-3 mb-0" style="font-size: 14px;">{{ club.clubName }}</p>
                    <p class="mb-1" style="color:#999999;font-size:12px;">{{ club.clubInfo }}</p>
                    <p style="color:#999999;font-size:12px;"><span>分类：</span><span style="color:#0079FE;">文化艺术类</span></p>
                </div>
                <div class="">
                    <div class="" style="text-align: start;line-height: 18px;">
                        <span style="font-family:'Arial Normal', 'Arial', sans-serif;font-size: 15px;">协会简介：</span>
                        <span style="font-family:'华文宋体', sans-serif;font-size: 14px;">{{ club.announcement }}</span>
                    </div>
                </div>
            </button>
        </div>
    </div>


    <!-- 我的创建（社团用户） -->
    <div v-if="IsClubUser" class="mt-5 px-5 mx-4">
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">我创建的社团社区</span>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <div class="my-3 mx-5 px-4 px-1 py-1 d-flex justify-content-center">
            <button @click="jumpToClubEdit" v-if="CreatedClub" class="text-center">
                <div class="rounded-circle" style="overflow: hidden;width: 150px;height: 150px;">
                    <img :src="ClubImage" style="width: 100%;height: 100%;object-fit: cover;object-position: center;">
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">{{ClubName}}</p>
            </button>
            <router-link to="/createclub" v-else class="text-center">
                <div class="rounded-circle d-flex align-items-center justify-content-center" style="overflow: hidden;width: 150px;height: 150px;background-color: #e4e4e4;">
                    <i class="fa fa-plus" aria-hidden="true" style="color: white; font-size: 68px;"></i>
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">新建社团</p>
            </router-link>
        </div>
    </div>

    <!-- 我的创建（普通用户） -->
    <div v-else class="mt-5 px-5 mx-4">
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">我创建的爱好社区</span>
            <button><i class="fa fa-plus-circle ms-3" aria-hidden="true" style="color:#999999;"> 新建我的社区</i></button>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <div class="my-3 mx-5 px-4 px-1 py-1">
            <button class="mx-5 px-3 my-3 text-center">
                <div class="rounded-circle" style="overflow: hidden;width: 150px;height: 150px;">
                    <img src="@/assets/images/common/default_img.png" style="width: 100%;height: 100%;object-fit: cover;object-position: center;">
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">DOTA</p>
            </button>
            <button class="mx-5 px-3 my-3 text-center">
                <div class="rounded-circle" style="overflow: hidden;width: 150px;height: 150px;">
                    <img src="@/assets/images/common/default_img.png" style="width: 100%;height: 100%;object-fit: cover;object-position: center;">
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">DOTA</p>
            </button>
            <button class="mx-5 px-3 my-3 text-center">
                <div class="rounded-circle" style="overflow: hidden;width: 150px;height: 150px;">
                    <img src="@/assets/images/common/default_img.png" style="width: 100%;height: 100%;object-fit: cover;object-position: center;">
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">DOTA</p>
            </button>
            <button class="mx-5 px-3 my-3 text-center">
                <div class="rounded-circle" style="overflow: hidden;width: 150px;height: 150px;">
                    <img src="@/assets/images/common/default_img.png" style="width: 100%;height: 100%;object-fit: cover;object-position: center;">
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">DOTA</p>
            </button>
            <button class="mx-5 px-3 my-3 text-center">
                <div class="rounded-circle" style="overflow: hidden;width: 150px;height: 150px;">
                    <img src="@/assets/images/common/default_img.png" style="width: 100%;height: 100%;object-fit: cover;object-position: center;">
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">DOTA</p>
            </button>
            <button class="mx-5 px-3 my-3 text-center">
                <div class="rounded-circle" style="overflow: hidden;width: 150px;height: 150px;">
                    <img src="@/assets/images/common/default_img.png" style="width: 100%;height: 100%;object-fit: cover;object-position: center;">
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">DOTA</p>
            </button>
        </div>
    </div>
</template>

<script>
import UserBanner from './UserBanner.vue';
import UpImage from '../common/UpImage.vue';

export default{
    name:"UserHome",
    components:{UserBanner,UpImage},
    data(){
        return{
            // role: 1 -- 开发人员,   2 -- 社团管理,   3 -- 普通用户,   4 -- black user
            Role:3,
            UserId:0,
            IsClubUser:false,
            CreatedClub:false,
            ClubName:'',
            ClubId:0,
            ClubImage:require("@/assets/images/common/default_img.png"),
            UserInfo:{
                image:require("@/assets/images/common/default-user-round-dark.png"),
                name:"用户名称",
                password:""
            },
            clubs:null,
            habbits:null,
            showlist:[]
        }
    },
    methods:{
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },
        jumpToClubEdit(){
            this.$router.push({path:'/clubeditpage',query:{ClubId:this.ClubId}})
        },
        jumpToClubShow(ClubId){
            this.$router.push({path:'/clubhome',query:{ClubId:ClubId}})
        },
        getImgURL(url){
            console.log("image:",url)
            this.UserInfo.image=url
            var inform={name:this.UserInfo.name,password:this.UserInfo.password,profile:this.UserInfo.image}
            this.$axios
            .post('user/modify/'+this.UserId,inform)
            .then(resp=>{
                console.log(resp)
                var data=resp.data
                if(data.state==1){
                    // 修改成功
                    alert("头像上传成功！")
                }
            })
            .catch(failResponse => {
                console.log(failResponse)
            })
        }
    },
    created(){
        this.UserId = this.$store.state.UserId
        this.Role = this.$store.state.Role
        this.IsClubUser = (this.Role == 2)
        // console.log(this.Role)
    },
    mounted(){
        if(this.IsClubUser){
            this.$axios
            .get('club/get_created_club',{params:{UserId:this.UserId}})
            .then(resp=>{
                // console.log(resp)
                var data=resp.data
                if(data.state==1){
                    // 有创建过的社团
                    this.CreatedClub=true,
                    this.ClubName=data.clubName
                    if(this.checkImgUrl(data.image)){this.ClubImage=data.image}
                    this.ClubId=data.ClubId
                }
            })
            .catch(failResponse => {
                console.log(failResponse)
            })
        }
        this.$axios
        .get('user/view',{params:{UserIdtoView:this.UserId,UserId:this.UserId}})
        .then(resp=>{
            // console.log(resp)
            var data=resp.data
            if(data.state==1){
                if(this.checkImgUrl(data.image)){this.UserInfo.image=data.image}
                this.UserInfo.name=data.name
                this.UserInfo.password=data.passwd
            }
        })
        .catch(failResponse => {
            console.log(failResponse)
        })
        
        this.$axios
        .get('club/view_by_account',{params:{UserId:this.UserId}})
        .then(resp=>{
            console.log(resp)
            this.clubs = resp.data;
            for (let i in this.clubs ){
                this.showlist.push(this.clubs [i])
            }
            // console.log(this.showlist)
            // 处理图片
            this.showlist.forEach(function(post){
                // console.log(_this.checkImgUrl(post[field]))
                if (post['image']==undefined || post['image']=='' || !this.checkImgUrl(post['image'])){
                    post['image']=require("@/assets/images/common/default-user-round.png")
                }
            })

        })
        .catch(failResponse => {
            console.log(failResponse)
        })
    }
}

</script>

<style scoped>
a {
    text-decoration: none;
    color: inherit;
}
#userimg:hover {
    opacity: 80%;cursor: pointer;
}

/* 样式穿透 */
#userimg::v-deep .el-upload{
  width:79px;
  height:79px;
  border-radius: 100%;
  opacity: 0%;
}
#userimg::v-deep .el-upload-list--picture-card .el-upload-list__item{
    width:79px;
  height:79px;
  border-radius: 100%;
  opacity: 0%;
}
</style>