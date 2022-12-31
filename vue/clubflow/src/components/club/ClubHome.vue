<template>
    <!-- 顶部banner -->
    <div class="container-fluid position-relative" style="background-color:rgba(102, 102, 102, 1); height: 300px;"></div>

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

    <div class="row container-fluid d-flex justify-content-center my-5">
        <!-- 历史文章 -->
        <div class="col-md-6 me-5">
            <HistoryArticles :ClubId="ClubId"></HistoryArticles>
        </div>
        <!-- 协会信息 -->
        <div class="col-md-3 ms-5 px-4">
            <ClubInfo v-bind:ClubId="ClubId"></ClubInfo>
        </div>
    </div>

    <div class="my-5 w-100">
        <SubTitle v-bind:subtitle="cainixihuan"></SubTitle>
    </div>
    

</template>


<script>
import ClubInfo from '../post/ClubInfo.vue';
import SubTitle from '../common/SubTitle.vue';
import HistoryArticles from './HistoryArticles.vue';

export default{
    name:"ClubHome",
    components:{
    ClubInfo,
    SubTitle,
    HistoryArticles
},
    data () {
        return{
            cainixihuan:"猜你喜欢",
            ClubId:0,
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
        }
    },
    methods:{
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },
    },
    created(){
        this.ClubId=this.$route.query.ClubId
        this.UserId=this.$store.state.UserId
        if(!String(this.UserId)){this.UserId=0}
        else{this.IsLogin=true}
    },
    mounted(){
        var UserId=this.UserId
        let that = this
        this.$axios
        .get('/club/view',{params:{ClubId:this.ClubId,UserId:UserId}})
        .then(
            resp => {
                console.log(resp)
                var ct = new Date(resp.data['created time']);
                this.ClubInfo.CreateTime=ct.Format('yyyy-MM-dd')
                this.ClubInfo.Name=resp.data.name
                this.ClubInfo.FansNumber=resp.data['fans number']
                if(resp.data.profile){
                    var a = that.checkImgUrl(resp.data.profile)
                    // console.log(a)
                    if(a){this.ClubInfo.Profile=resp.data.profile}
                }
                this.ClubInfo.PubNum=resp.data['publications number']
                this.ClubInfo.Subscribe=resp.data.subscribe
                this.ClubInfo.CommentNum=resp.data['comments number']
                this.ClubInfo.Inform=resp.data.inform
                if(resp.data.announcement){this.ClubInfo.Announcement=resp.data.announcement}
        }
        )
        .catch(failResponse => {console.log(failResponse)})
    }
}

</script>

<style scoped>

</style>