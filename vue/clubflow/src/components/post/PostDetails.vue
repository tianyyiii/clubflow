<template>
    <!-- 背景图 -->
    <div class="container-fluid" style="background-color:rgba(102, 102, 102, 1); height: 300px;">
    </div>

    <div class="row container-fluid d-flex justify-content-center my-5">
        <!-- 左侧栏-->
        <div class="col-md-8 me-5" >
            <!-- 文章 -->
            <div class="w-100">
                <Post></Post>
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
                <ClubInfo></ClubInfo>
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
    methods: {
    }
  }
</script>

<style scoped>


</style>