<template>
    <!-- 背景图 -->
    <div class="container-fluid" style="background-color:rgba(102, 102, 102, 1); height: 300px;">
    </div>

    <div class="row container-fluid d-flex justify-content-center my-5">
        <!-- 左侧栏-->
        <div class="col-md-8 me-5" >
            <!-- 文章 -->
            <div class="w-100">
                <Post v-bind:PostId="PostId"></Post>
            </div>

            <!-- 评论 -->
            <div class="my-1 w-100">
                <Comments></Comments>
            </div>
        </div>

        <!-- 右侧栏 -->
        <div class="col-md-3 px-4">
            <!-- 协会信息 -->
            <div class="w-100">
                <ClubInfo v-bind:ClubId="ClubId"></ClubInfo>
            </div>
            
            <!-- 热门文章 -->
            <div class="w-100 mt-5">
                <ArtList></ArtList>
            </div>
        </div>
    </div>
    
</template>

<script>
import ClubInfo from './ClubInfo.vue'
import Comments from './Comments.vue'
import ArtList from './ArtList.vue'
import Post from './Post.vue'

  export default {
    name: 'PostDetails',
    components: {ClubInfo, Comments, ArtList, Post},
    data(){
        return{
            PostId:0,
            ClubId:0,
            UserId:0
        }
    },
    methods: {
    },
    created(){
        this.PostId=this.$route.query.PostId
        // console.log(this.PostId)
        this.UserId=this.$store.state.UserId
        if(!String(this.UserId)){
            this.UserId=0
        }else{
            this.IsLogin=true
        }
        var UserId=this.UserId
        // console.log(UserId)
        this.$axios
        .get('post/'+this.PostId, {params:{UserId:UserId}})
        .then( response =>{
            console.log(response.data)
            this.ClubId=response.data.club
            console.log(this.ClubId)
        }
            )
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
    },
    mounted(){
        

    }
  }
</script>

<style scoped>


</style>