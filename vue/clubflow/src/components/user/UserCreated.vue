<template>

    <!-- 我的创建（社团用户） -->
    <div v-if="IsClubUser" >
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">我创建的社团社区</span>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <div class="my-3 mx-5 px-4 px-1 py-1 d-flex justify-content-center">
            <button @click="jumpToClubEdit" v-if="CreatedClub" class="text-center">
                <div class="card rounded-circle position-relative" style="overflow: hidden;width: 150px;height: 150px;">
                    <!-- 遮罩 -->
                    <div class="cover position-absolute" style="z-index:1;width: 100%;height: 100%;background-color: #B82D29;opacity: 50%;display: none;"></div>
                    <div class="arrow" style="z-index: 3;position: absolute;text-align: center;width: 100%;top: 55px;display:none;">
                        <img style="width:36px;height:36px;" src="@/assets/images/clubspace/u40.svg"/>
                    </div>
                    <!-- 卡片图片 -->
                    <img :src="ClubImage" class="card-img" style="width: 100%;height: 100%;object-fit: cover;object-position: center;">
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">{{ClubName}}</p>
            </button>
            <router-link to="/createclub" v-else class="text-center" style="text-decoration: none; color: inherit;">
                <div class="rounded-circle d-flex align-items-center justify-content-center" style="overflow: hidden;width: 150px;height: 150px;background-color: #e4e4e4;">
                    <i class="fa fa-plus" aria-hidden="true" style="color: white; font-size: 68px;"></i>
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">新建社团</p>
            </router-link>
        </div>
    </div>

    <!-- 我的创建（普通用户） -->
    <div v-else >
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">我创建的爱好社区</span>
            <router-link to="/createhabbit"><i class="fa fa-plus-circle ms-3" aria-hidden="true" style="color:#999999;"> 新建我的社区</i></router-link>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <div class="my-3 mx-5 px-4 px-1 py-1">
            <button @click="jumpToHabbitShow(habbit.habbitId)" v-for="habbit in createdHabbitsList" class="mx-5 px-3 my-3 text-center">
                <div class="card rounded-circle position-relative" style="overflow: hidden;width: 150px;height: 150px;">
                    <!-- 遮罩 -->
                    <div class="cover position-absolute" style="z-index:1;width: 100%;height: 100%;background-color: #B82D29;opacity: 50%;display: none;"></div>
                    <div class="arrow" style="z-index: 3;position: absolute;text-align: center;width: 100%;top: 55px;display:none;">
                        <img style="width:36px;height:36px;" src="@/assets/images/clubspace/u40.svg"/>
                    </div>
                    <!-- 卡片图片 -->
                    <img :src="habbit.image" class="card-img" style="width: 100%;height: 100%;object-fit: cover;object-position: center;">
                </div>
                <p class="mt-2 mb-0" style="font-size: 16px;font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">{{habbit.habbitName}}</p>
            </button>
            
        </div>
    </div>
</template>

<script>

export default{
    name:"UserCreated",
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
            createdHabbits:null,
            createdHabbitsList:[],
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
        jumpToHabbitShow(HabbitId){
            this.$router.push({path:'/habbit',query:{HabbitId:HabbitId}})
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
            // 展示创建的社团
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
        else{
            // 展示创建的爱好社区
            let that=this
            this.$axios
            .get('habbit/get_created_habbit',{params:{UserId:this.UserId}})
            .then(resp=>{
                // console.log(resp)
                this.createdHabbits = resp.data;
                for (let i in this.createdHabbits ){
                    this.createdHabbitsList.push(this.createdHabbits[i])
                }
                // console.log(this.showlist)
                // 处理图片
                this.createdHabbitsList.forEach(function(post){
                    // console.log(_this.checkImgUrl(post[field]))
                    if (post['image']==undefined || post['image']=='' || !that.checkImgUrl(post['image'])){
                        post['image']=require("@/assets/images/common/default_img.png")
                    }
                })
            })
            .catch(failResponse => {
                console.log(failResponse)
            })
        }


        //加载时延
        setTimeout(function () {
            // 动画
            $(".card-img").mouseenter(function(){
                var cover=$(this).siblings(".cover")
                cover.slideDown("slow")
                var arrow=$(this).siblings(".arrow")
                arrow.delay("fast").fadeIn()
            });
            $(".card").mouseleave(function(){
                var arrow=$(this).children(".arrow")
                arrow.fadeOut("fast")
                var cover=$(this).children(".cover")
                cover.delay("fast").slideUp()
            });
        }, 100);
    }
}
</script>