<template>
    <!-- 小组信息 -->
    <div class="w-100">

        <!-- 社团名片 -->
        <div id="id-card" class="px-3 d-inline-flex w-100" style="background-color:rgb(228, 228, 228); padding-top: 30px; padding-bottom: 30px;">
            <img class="mt-2" src="@/assets/images/common/default-user-square-dark.png" style="width: 74px; height: 74px;" alt="用户头像">
            <div class="ms-4 w-100">
                <p class="mb-2" style="font-size:14px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">{{ HabbitInfo.Name }}</span>
                </p>
                <p class="mb-1" style="font-size:12px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">{{ HabbitInfo.Category}}</span>
                </p>
                <p class="m-0" style="font-size:12px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">{{ HabbitInfo.CreateTime }} 创建</span>
                </p>
                <p class="m-0" style="font-size:12px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">发起人：{{ HabbitInfo.Creator }}</span>
                </p>
            </div>
        </div>

        <div class="w-75 bg-white pt-4">
            <!-- 简介 -->
            <div class="w-100">
                <div class="w-100 px-3" style="height:260px; font-size: 13px; font-family:'华文宋体', sans-serif; line-height: 17px;">
                    {{ HabbitInfo.Announcement }}
                </div>
                <div class="w-100 pe-4 d-flex justify-content-end">
                    <button style="font-family:'Cambria', sans-serif; font-size:13px;">
                        >> more
                    </button>
                </div>
            </div>

            <!-- 积极成员 -->
            <div id="act-mems" class="mt-4 position-relative" style="font-family:'微软雅黑', sans-serif; font-size:12px; color:#999999;z-index: 1;">
                <!-- 阴影蒙版 -->
                <div class="back-img"></div>
                <div style="background-color: white;">
                    <div class="px-3 py-2" style="border-bottom: 1px solid #E4E4E4;">
                        积极成员
                    </div>
                    <div class="ms-3 w-100" style="height: 160px;">
                        <ul v-for="fanProfile in fanProfiles" class="m-0 p-0">
                            <!-- <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;"> -->
                            <img class="me-3 mt-3 float-start" :src="fanProfile" alt="用户头像" style="width: 50px; height: 50px;">
                        </ul>
                    </div>
                </div>
            </div>

            <!-- 最新加入 -->
            <div id="new-mems" class="mt-4 position-relative" style="font-family:'微软雅黑', sans-serif; font-size:12px; color:#999999;z-index: 1;">
                <!-- 阴影蒙版 -->
                <div class="back-img"></div>
                <div style="background-color: white;">
                    <div class="px-3 py-2" style="border-bottom: 1px solid #E4E4E4;">
                        最新加入
                    </div>
                    <div class="ms-3 w-100" style="height: 160px;">
                        <ul class="m-0 p-0">
                            <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                            <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                            <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                            <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                            <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                            <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                            <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                            
                        </ul>
                    </div>
                </div>
            </div>

        </div>


        
    </div>
</template>

<script>
import {reactive} from 'vue'
export default {
    name:"GroupInfo",
    props: ['HabbitId'],
    data: function () {
      return {
        UserId:0,
        IsLogin:false,
        Habbit:0,
        HabbitInfo:reactive({ // reactive响应式数据
            CreateTime:'2022-10-30',
            Name:'晨跑小组',
            Category:'爱好社区',
            Creator: 'Windir',
            FansNumber:0,
            Profile:require("@/assets/images/common/default-user-square-dark.png"),
            PubNum:0,
            Subscribe:0, // 用户是否关注
            CommentNum:0,
            Inform:'',
            Announcement:"简介：介绍协会。文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例。"
        }),
        fanProfiles:[],
        fans:null
      }
    },
    methods:{
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },

        viewFans(){
            this.$axios
            .get('/habbit/view_fans',{params:{HabbitId:this.Habbit}})
            .then(
                resp => {
                    // console.log(resp)
                    this.fans=resp.data
                    let obj = this.fans;
                    for (let i in obj ){
                        //console.log(i)
                        //console.log(this.fans[i].image)
                        var a = this.checkImgUrl(this.fans[i].image)
                        // console.log(a)
                        if(a){
                            this.fanProfiles.push(this.fans[i].image)
                        }else{
                            // 非法则插入默认图片
                            this.fanProfiles.push(require("@/assets/images/common/default-user-square-light.png"))
                        }
                    }
                    // console.log(this.fanProfiles)
            }
            )
            .catch(failResponse => {console.log(failResponse)})
        },

        getCreatorName(creator){ // 从Id到名字
            this.$axios
            .get('/user/view',{params:{UserIdtoView:creator,UserId:this.UserId}})
            .then(
                resp => {
                    // console.log(resp)
                    this.HabbitInfo.Creator=resp.data.name
                    return resp.data.name
            }
            )
            .catch(error => {console.log(error)})
        }
    },
    created:function(){
        this.UserId=this.$store.state.UserId
        if(!this.UserId){
            this.UserId=0
        }else{
            this.IsLogin=true
        }
        // console.log(this.UserId)
    },
    watch: {
        HabbitId: {
            // 监测父组件传过来的值有没有更新
            immediate: true,
            deep: true,
            handler(newVal, oldVal) {
                // console.log(newVal, "newVal");
                if(!newVal){
                    // console.log(this.Habbit)
                    return
                }
                this.UserId=this.$store.state.UserId
                if(!this.UserId){
                    this.UserId=0
                }else{
                    this.IsLogin=true
                }
                this.Habbit=newVal;
                // console.log(this.Habbit)
                let that = this
                this.$axios
                .get('/habbit/view',{params:{HabbitId:this.Habbit,UserId:this.UserId}})
                .then(
                    resp => {
                        // console.log(resp)
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
                        this.getCreatorName(this.HabbitInfo.Creator)
                        if(resp.data.announcement){this.HabbitInfo.Announcement=resp.data.announcement}
                }
                )
                .catch(failResponse => {console.log(failResponse)})

                this.viewFans()
                
                
            }
        }
    },
    mounted:function(){
    }
  }

</script>



<style scoped>

.back-img {
    visibility:hidden;
    position:absolute;
    left:-1px;
    top:-1px;
    width:0;
    /* width: 406px; */
    height:198px;
    background:inherit;
    background-color:rgba(228, 228, 228, 1);
    box-sizing:border-box;
    border-width:1px;
    border-style:solid;
    border-color:rgba(121, 121, 121, 1);
    border-radius:0px;
    -moz-box-shadow:3px 3px 5px rgba(0, 0, 0, 0.349019607843137);
    -webkit-box-shadow:3px 3px 5px rgba(0, 0, 0, 0.349019607843137);
    box-shadow:3px 3px 5px rgba(0, 0, 0, 0.349019607843137);
    z-index: -1;
    transition: ease;
    transition-duration: 0.8s;
}

#act-mems:hover .back-img{
    visibility:visible;
    width:406px;
}

#new-mems:hover .back-img{
    visibility:visible;
    width:406px;
}


</style>