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
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">关注列表（包括社团社区和爱好社区）</span>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <div class="my-3 px-1 py-1">
            <!-- 社团 -->
            <button @click="jumpToClubShow(club.clubId)" v-for="club in showlist" class="py-3 px-3 w-100 d-flex" style="border-bottom: 1px rgba(242, 242, 242, 1) solid;">
                <div class="me-5 col-2">
                    <img class="rounded-circle" :src="club.image" style="height: 38px;width: 38px;">
                    <p class="mt-3 mb-0" style="font-size: 14px;">{{ club.clubName }}</p>
                    <p class="mb-1" style="color:#999999;font-size:12px;">{{ club.clubInfo }}</p>
                    <p style="color:#999999;font-size:12px;"><span>分类：</span><span style="color:#0079FE;">文化艺术类</span></p>
                </div>
                <div class="" style="">
                    <div class="" style="text-align: start;line-height: 18px;">
                        <span style="font-family:'Arial Normal', 'Arial', sans-serif;font-size: 15px;">协会简介：</span>
                        <span style="font-family:'华文宋体', sans-serif;font-size: 14px;">{{ club.announcement }}</span>
                    </div>
                </div>
            </button>
            <!-- 爱好 -->
            <button @click="jumpToHabbitShow(habbit.habbitId)" v-for="habbit in showhabbitlist" class="py-3 px-3 w-100 d-flex" style="border-bottom: 1px rgba(242, 242, 242, 1) solid;">
                <div class="me-5 col-2">
                    <img class="rounded-circle" :src="habbit.image" style="height: 38px;width: 38px;">
                    <p class="mt-3 mb-0" style="font-size: 14px;">{{ habbit.habbitName }}</p>
                    <p class="mb-1" style="color:#999999;font-size:12px;">{{ habbit.habbitInfo }}</p>
                    <p style="color:#999999;font-size:12px;"><span>分类：</span><span style="color:#0079FE;">爱好社区</span></p>
                </div>
                <div class="" style="">
                    <div class="" style="text-align: start;line-height: 18px;">
                        <span style="font-family:'Arial Normal', 'Arial', sans-serif;font-size: 15px;">协会简介：</span>
                        <span style="font-family:'华文宋体', sans-serif;font-size: 14px;">{{ habbit.announcement }}</span>
                    </div>
                </div>
            </button>
        </div>
    </div>


    <!-- 我创建的社团/爱好社区 -->
    <div class="mt-5 px-5 mx-4">
        <UserCreated></UserCreated>
    </div>
</template>

<script>
import UserBanner from './UserBanner.vue';
import UpImage from '../common/UpImage.vue';
import UserCreated from "@/components/user/UserCreated.vue"

export default{
    name:"UserHome",
    components:{UserBanner,UpImage,UserCreated},
    data(){
        return{
            UserId:0,
            UserInfo:{
                image:require("@/assets/images/common/default-user-round-dark.png"),
                name:"用户名称",
                password:""
            },
            clubs:null,
            habbits:null,
            showlist:[],
            showhabbitlist:[]
        }
    },
    methods:{
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },
        jumpToClubShow(ClubId){
            this.$router.push({path:'/clubhome',query:{ClubId:ClubId}})
        },
        jumpToHabbitShow(HabbitId){
            this.$router.push({path:'/habbit',query:{HabbitId:HabbitId}})
        },
        getImgURL(url){
            console.log("image:",url)
            this.UserInfo.image=url
            var inform={name:this.UserInfo.name,password:this.UserInfo.password,profile:this.UserInfo.image}
            this.$axios
            .post('user/modify/'+this.UserId,inform)
            .then(resp=>{
                // console.log(resp)
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
    },
    mounted(){

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
        
        let that=this
        this.$axios
        .get('club/view_by_account',{params:{UserId:this.UserId}})
        .then(resp=>{
            // console.log(resp)
            this.clubs = resp.data;
            for (let i in this.clubs ){
                this.showlist.push(this.clubs[i])
            }
            // console.log(this.showlist)
            // 处理图片
            this.showlist.forEach(function(post){
                // console.log(_this.checkImgUrl(post[field]))
                if (post['image']==undefined || post['image']=='' || !that.checkImgUrl(post['image'])){
                    post['image']=require("@/assets/images/common/default-user-round.png")
                }
            })
        })
        .catch(failResponse => {
            console.log(failResponse)
        })

        this.$axios
        .get('habbit/view_by_account',{params:{UserId:this.UserId}})
        .then(resp=>{
            console.log(resp)
            this.habbits = resp.data;
            for (let i in this.habbits ){
                this.showhabbitlist.push(this.habbits[i])
            }
            // console.log(this.showlist)
            // 处理图片
            this.showhabbitlist.forEach(function(post){
                // console.log(_this.checkImgUrl(post[field]))
                if (post['image']==undefined || post['image']=='' || !that.checkImgUrl(post['image'])){
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