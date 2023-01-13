<template>
    <!-- 顶部banner+基本信息 -->
    <div class="container-fluid position-relative" style="background-color:rgba(102, 102, 102, 1); height: 300px;">
        <div class="ellipse ">
            <img :src="HabbitInfo.Profile" alt="小组用户头像" style="width:100px;height:100px;border-top-left-radius: 50%;border-top-right-radius: 50%;">
            <p class="mt-3 mb-0" style="font-size:18px; font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">
                {{ HabbitInfo.Name }}
            </p>
            <p class="mb-2" style="font-size:14px;font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">
                {{ HabbitInfo.Inform }}
            </p>
            <button @click="subOrUnsub" class="follow-btn" style="font-size: 13px;">
                <span v-if="HabbitInfo.Subscribe" style="font-family:'FontAwesome', sans-serif;font-weight:400;">&nbsp;</span>
                <span v-else style="font-family:'FontAwesome', sans-serif;font-weight:400;">&nbsp;</span>
                <span v-if="HabbitInfo.Subscribe" style="font-family:'微软雅黑', sans-serif;font-weight:400;"> 已关注</span>
                <span v-else style="font-family:'微软雅黑', sans-serif;font-weight:400;"> 关注</span>
            </button>
            <p class="mt-2 mb-0" style="font-size: 14px;color:#888888;">
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;">粉丝 </span>
                <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">{{ HabbitInfo.FansNumber }}</span>
            </p>
        </div>
    </div>

    <div class="pt-2 mt-5 mb-0 pb-4" style="background-color: rgb(249, 249, 249); z-index: -1;">
        <!-- 中部 -->
        <div class="row container-fluid d-flex justify-content-center my-5">
            <!-- 左侧栏-->
            <div class="col-md-6 me-5" >
                <HabbitComment v-bind:HabbitId="HabbitId"></HabbitComment>
            </div>

            <!-- 右侧栏 -->
            <div class="col-md-4 px-4">
                <GroupInfo :HabbitId="HabbitId"></GroupInfo>
            </div>
        </div>

        <!-- 猜你喜欢 -->
        <SubTitle v-bind:subtitle="subtitle"></SubTitle>
    </div>
    
</template>

<script>

import SubTitle from '@/components/common/SubTitle.vue'
import GroupInfo from '@/components/habbit/GroupInfo.vue'
import HabbitComment from '@/components/habbit/Comment.vue'

export default {
    name: 'HabbitContent',
    components: {SubTitle, GroupInfo, HabbitComment},
    data(){
        return{
            subtitle:'猜你喜欢',
            HabbitId: 0,
            UserId:0,
            IsLogin:false,
            HabbitInfo:{
                CreateTime:'2022-10-30',
                Name:'晨跑小组',
                Category:'爱好社区',
                Creator:'Windir',
                FansNumber:0,
                Profile:require("@/assets/images/common/default_user.png"),
                PubNum:0,
                Subscribe:0, // 用户是否关注
                CommentNum:0,
                Inform:'',
                Announcement:"简介：介绍协会。文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例。"
            }
        }
    },
    methods: {
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },
        // 关注
        subOrUnsub(){
            // 检查是否登录
            if(!this.IsLogin){
                alert("请先登录！")
                this.$router.push('/login')
            }
            else{
                if(this.HabbitInfo.Subscribe){
                    this.$axios
                    .post('/habbit/unsubscribe', { 
                        HabbitId: this.HabbitId,
                        UserId: this.UserId
                    })
                    .then(resp => {
                        if (resp.data.state === 1) {
                            // console.log(resp.data)
                            alert("取消成功！")
                            location.reload() // 刷新页面
                        } else {
                            alert(resp.data.error)
                        }
                    })
                    .catch(failResponse => {
                        alert("取消失败！")
                    })
                } else {
                    this.$axios
                    .post('/habbit/subscribe', { 
                        HabbitId: this.HabbitId,
                        UserId: this.UserId
                    })
                    .then(resp => {
                        if (resp.data.state === 1) {
                            console.log(resp.data)
                            alert("关注成功！")
                            location.reload() // 刷新页面
                        } else {
                            alert(resp.data.error)
                        }
                    })
                    .catch(failResponse => {
                        alert("关注失败！")
                    })
                }
            }
            
        },
    },
    created(){
        this.UserId=this.$store.state.UserId
        this.HabbitId=this.$route.query.HabbitId
        // console.log(this.HabbitId)
        if(!this.UserId){
            this.UserId=0
        }else{
            this.IsLogin=true
        }
        // console.log(this.UserId)
    },
    mounted(){
        let that = this
        // 获取基本信息
        this.$axios
        .get('/habbit/view',{params:{HabbitId:this.HabbitId,UserId:this.UserId}})
        .then(
            resp => {
                console.log(resp)
                var ct = new Date(resp.data['created time']);
                this.HabbitInfo.CreateTime=ct.Format('yyyy-MM-dd')
                this.HabbitInfo.Name=resp.data.name
                this.HabbitInfo.FansNumber=resp.data['fans number']
                if(resp.data.profile){
                    var a = that.checkImgUrl(resp.data.profile)
                    // console.log(a)
                    if(a){this.HabbitInfo.Profile=resp.data.profile}
                }
                this.HabbitInfo.PubNum=resp.data['publications number']
                this.HabbitInfo.Subscribe=resp.data.subscribe
                this.HabbitInfo.CommentNum=resp.data['comments number']
                this.HabbitInfo.Inform=resp.data.inform
                this.HabbitInfo.Creator=resp.data.creator
                if(resp.data.announcement){this.HabbitInfo.Announcement=resp.data.announcement}
        })
        .catch(failResponse => {console.log(failResponse)})
    }
  }

</script>



<style scoped>

.ellipse{
  position:absolute;
  left:113px;
  /* top:78px; */
  top:24px;
  width:301px;
  height:302px;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  justify-content: center;
  background-image: url("@/assets/images/habbitcontent/u603.svg");
}

.follow-btn {
    width:80px;
    height:35px;
    background-color:rgba(184, 45, 41, 1);
    border:none;
    border-radius:3px;
    border-bottom-right-radius:0px;
    border-bottom-left-radius:0px;
    color:#FFFFFF;
    text-align: center;
  }
.follow-btn:hover {
    opacity:0.8;
  }


</style>