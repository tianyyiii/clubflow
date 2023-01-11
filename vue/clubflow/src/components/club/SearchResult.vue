<template>
    <!-- banner -->
    <div>
        <ClubSearch></ClubSearch>
    </div>

    <!-- 社团分类 -->
    <SubTitle v-bind:subtitle="sousuojieguo"></SubTitle>
    <div class="container-fluid mt-5 mb-5 col-md-10 offset-md-1 justify-content-center row">
        <!-- col-auto很重要 -->
        <ul v-for="club in clubs_list" class="m-0 p-0 d-flex col-auto" :key="club.clubId">
            <li class="card me-5 mb-5 p-0 position-relative" style="width:200px; border-radius: 0;">
                <!-- 遮罩 -->
                <div class="position-absolute cover" style="width: 100%; height:140px; background-color: #a93931; z-index: 2; opacity: 50%;display:none; "></div>
                <div class="arrow" style="z-index: 3;position: absolute;text-align: center;width: 100%;top: 50px;display:none;">
                    <img style="width:36px;height:36px;" src="@/assets/images/clubspace/u40.svg"/>
                </div>
                <!-- 图片部分 -->
                <div class="card-img w-100" style="height: 140px; z-index: 1;">
                    <img v-if="club.haveimage" :src="club.image" alt="社团头像">
                    <img v-else src="@/assets/images/common/default_img.png" alt="社团头像">
                </div>
                <!-- 文字部分 -->
                <div class="card-body pt-2 px-0 pb-0" style="z-index: 1;">
                    <h5 class="card-title text-center mb-1" style="font-size: 16px; font-weight: 900;">{{club.clubName}}</h5>
                    <p class="text-center mt-0 mb-2" style="font-size: 13px;color: rgb(158, 158, 158);">{{ club.clubInfo }}</p>
                    <p class="mx-2 mb-1 textlines-overflow-2" style="height: 36px; font-size: 11px;">{{ club.announcement }}</p>
                    <div class="w-100 d-flex justify-content-end p-0">
                    <button @click="goToClubPage(club.clubId)" class="btn p-1 pure-text-btn">查看更多>></button></div>
                </div>
            </li>
        </ul>
        
        
    </div>

</template>

<script>
import ClubSearch from './ClubSearch.vue';
import SubTitle from '../common/SubTitle.vue';
export default {
    name: 'SearchClub',
    components: {ClubSearch,SubTitle},
    data: function () {
      return {
        sousuojieguo:"搜索结果",
        clubs:null,
        clubs_list:[],
        key:'',
      }
    },
    created:function(){
        this.key=this.$route.query.key
        // console.log(this.key)
    },
    computed(){
    },
    methods:{
        checkImgUrl(str){
            // str="http://localhost:8080/file/3232.jpg"
            var r = /^http/g; // 检查是否是域名
            var a = r.test(str) // true or false
            return a
        },
        check_img_fields : function(field){
            // 检查是否有图片，没有则设havefield为false，field为 'img' 或 'club profile' 等键值
            let _this = this
            this.clubs_list.forEach(function(post){
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
        goToClubPage(ClubId){
            this.$router.push({path:'/clubhome',query:{ClubId:ClubId}})
        }
    },
    mounted(){
        let that = this
        this.$axios
        .post('/search/club',{key:this.key})
        .then(response => {
            // console.log(response)
            this.clubs = response.data;
            // console.log(this.clubs);
            let obj = this.clubs;
            for (let i in obj ){
                this.clubs_list.push(obj [i])
            }
            // 验证是否有图片域
            that.check_img_fields('image');
        })
        .catch(failResponse => {console.log(failResponse)})

        //加载时延
        setTimeout(function () {
            // 动画
            $(".card-img").mouseenter(function(){
                var cover=$(this).siblings(".cover")
                cover.slideDown()
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

<style scoped>

.pure-text-btn {
    font-size: 11px; color: rgb(158, 158, 158);
}

.pure-text-btn:hover {
    color: #4e4e4e;;
}

.img-default {
    background-color:rgba(228, 228, 228, 1);
    font-family:'FontAwesome', sans-serif;
    font-size:100px;
    color:#FFFFFF;
    text-align: center;
}

.card img {
    /* max-width:153px; */
    object-fit: cover; /* background-size */
    object-position: center; /* 类似background-position */
    /* 图片必须width和height为100% */
    width:100%;
    height: 100%;
    /* _width:expression( this.width > 153 ? "153px" : this.width); */
}




</style>