<template>
    <!-- 顶部banner -->
    <ClubBanner v-bind:ClubId="ClubId"></ClubBanner>

    <!-- 标题栏 -->
    <div class="my-3 d-flex px-3 py-3 mx-4 align-items-center" style="border-bottom: rgb(233, 233, 233) 1px solid;">
        <div class="mx-5 d-inline-flex align-items-center">
            <!-- 头像 -->
            <div class="me-4">
                <img class="rounded-circle" src="@/assets/images/common/default-user-round-dark.png" alt="用户头像" style="width:79px;height:79px">
            </div>
            <!-- 标题 -->
            <div class="">
                <p class="mb-0" style="font-size:18px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">社团名称</span>
                </p>
                <p class="mb-0" style="font-size:14px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">副标题</span>
                </p>
            </div>
            
        </div>

        <div class="ms-5" style="font-size:18px;color:#A4A4A4;">
            创建者编辑页
        </div>
    </div>

    <!-- 基本信息 -->
    <div id="basic-info" class="my-4 px-5 mx-5">
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">基本信息</span>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <!-- 灰色区 -->
        <div class="px-2 py-4" style="background-color: rgb(250, 250, 250);">
            <div class="w-100 d-flex mb-4 align-items-center" style="font-size: 14px;">
                <div style="width:105px">社区标题：</div>
                <input v-model="clubInform.name" type="text" placeholder="请输入社团名称" maxlength="20"/>
            </div>
            <div class="w-100 d-flex mb-4 align-items-center" style="font-size: 14px;">
                <div style="width:105px">副标题：</div>
                <input v-model="clubInform.inform" type="text" placeholder="请输入副标题" maxlength="20"/>
            </div>
            <div id="up-img-form" class="w-100 d-flex mb-4 align-items-center" style="font-size: 14px;">
                <div style="width:105px">上传头像：</div>
                <!-- 上传图片 -->
                <UpImage @upUrl="getImgURL"></UpImage> 
            </div>
        </div>
        <!-- 按钮组 -->
        <div class="w-100 px-5 my-2 d-flex justify-content-end">
            <button class="re-btn me-2">重置</button>
            <button class="sav-btn">保存</button>
        </div>
    </div>

    <!-- 资料卡 -->
    <div style="background-color: rgb(250, 250, 250);">
        <div id="basic-info" class="my-4 px-5 mx-5 py-3">
            <!-- 小标题 -->
            <div class="" >
                <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
                <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">资料卡</span>
                <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
            </div>
            <!-- 灰色区 -->
            <div class="px-2 py-4">
                <div style="font-family:'华文宋体', sans-serif;font-size:14px;line-height: 18px;">
                    简介：介绍协会。文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例。
                </div>
                <textarea v-model="announcement" id="intro-text" class="form-control mt-5" placeholder="请输入协会简要介绍信息。不超过500字。" maxlength="500" name="text" style="height: 160px;border-radius: 3px;font-size: 14px;"></textarea>
            </div>
            <!-- 按钮组 -->
            <div class="w-100 px-5 my-2 d-flex justify-content-end">
                <button class="re-btn me-2">重置</button>
                <button class="sav-btn">保存</button>
            </div>
        </div>
    </div>

    <!-- 提交区 -->
    <div class="my-5 px-5 mx-5 py-3">
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">提交创建或更改（等待审核后可通过）</span>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <!-- 按钮组 -->
        <div class="w-100 px-5 my-4 d-flex justify-content-evenly">
            <button class="re-btn" style="width:145px;height:55px;font-size: 18px;"><span style="font-family:'FontAwesome', sans-serif;"> </span>重置</button>
            <button @click="submitBasicInform" class="sav-btn" style="width:145px;height:55px;font-size: 18px;"><span style="font-family:'FontAwesome', sans-serif;"> </span>提交</button>
        </div>
    </div>
    
    

</template>

<script>
import ClubBanner from '@/components/club/ClubBanner.vue';
import UpImage from '@/components/common/UpImage.vue';

export default {
    name: 'CreateClub',
    components: {ClubBanner,UpImage},
    data(){
        return{
            ClubId: 0,
            UserId:0,
            clubInform:{
                profile:"",
                name:"",
                inform:"", //副标题
                UserId:0
            },
            announcement:""
        }
    },
    methods: {
        getImgURL(url){
            console.log("image:",url)
            this.profile=url
        },
        submitBasicInform(){
            let that = this
            this.$axios
            .put('club/create',this.clubInform)
            .then(
                resp => {
                    console.log(resp.data)
                    var data=resp.data;
                    if(data.state==1){
                        this.ClubId=data.clubId
                        console.log(data.clubId)
                        that.submitAnnouncement(data.clubId)
                        // alert("注册成功！");
                    }
                    else{
                        alert("创建失败！社团名重复！");
                        location.reload();
                    }
            })
            .catch(failResponse => {alert("请求异常");})
        },
        submitAnnouncement(ClubId){
            var clubann={
                UserId:this.UserId,
                ClubId:ClubId,
                context:this.announcement
            }
            console.log("CLUBID",ClubId)
            let that = this
            this.$axios
            .put('club/announcement/create',clubann)
            .then(
                resp => {
                    console.log("第二次",resp)
                    var data=resp.data;
                    if(data.state==1){
                        alert("创建成功！");
                        that.$router.push({path:'/clubeditpage',query:{ClubId:ClubId}})
                    }
                    else{
                        alert("创建失败！");
                        location.reload();
                    }
            })
            .catch(failResponse => {alert("请求异常");})
        }
    },
    created(){
        this.UserId=this.$store.state.UserId
        if(!this.UserId){this.UserId=0}
        this.clubInform.UserId=this.UserId
    },
    mounted(){
        
    }
  }

</script>

<style scoped>

.upimg {
  background-color:rgba(249, 249, 249, 1);
  box-sizing:border-box;
  border-width:1px;
  border-style:solid;
  border-color:rgba(233, 233, 233, 1);
  border-radius:3px;
  width:100px;
  height:100px;
  color:#CCCCCC;
  line-height:28px;
}
.upimg:hover {
  border-color:rgba(0, 121, 254, 1);
  color:rgba(0, 121, 254, 1);
}

/* 样式穿透 */
#up-img-form::v-deep .el-upload{
  width:100px;
  height:100px;
}
#up-img-form::v-deep .el-upload-list--picture-card .el-upload-list__item{
    width:100px;
  height:100px;
}


#basic-info input {
    width:332px;
    height:40px;
    font-size:13px; color:#cccccc;
    background-color: white;
    border: #CCCCCC 1px solid;
    padding: 2px 15px 2px 15px;
    vertical-align:none;
    text-align:left;
    border-radius: 3px;
}
#basic-info input::-webkit-input-placeholder { /* WebKit, Blink, Edge */
    color:    #cccccc;
}
#basic-info input:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
   color:    #cccccc;
   opacity:  1;
}
#basic-info input::-moz-placeholder { /* Mozilla Firefox 19+ */
   color:    #cccccc;
   opacity:  1;
}
#basic-info input:-ms-input-placeholder { /* Internet Explorer 10-11 */
   color:    #cccccc;
}
#basic-info input:focus, #basic-info input:focus-within, #basic-info input:focus-visible {
    border: rgba(0, 121, 254, 1) 1px solid;
    /* box-shadow: none; */
    outline: 0;
    box-shadow: 0px 0px 1px 1px #459fffba;
}

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

</style>