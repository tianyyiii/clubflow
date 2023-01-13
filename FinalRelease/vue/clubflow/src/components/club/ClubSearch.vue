<template>
<!-- banner -->
    <div class="container-fluid d-flex text-center justify-content-center p-0">
        <img id="banner_img" class="img col-12 banner" src="@/assets/images/shetuanshequ_index/banner.png"/>
        <img id="title_img" class="img position-absolute" src="@/assets/images/shetuanshequ_index/title.png"/>
        
        <div class="position-absolute" id="so">
            <form @submit.prevent="search">
                <div class="input-group">               
                    <span class="input-group-text opacity-25" id="searchicon1">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </span>
                    <!-- <input v-model="search_text" type="text" id="main-searchbox" class="form-control opacity-50 border-0" onkeydown="onKeyDown(event)"  -->
                    <input v-model="search_text" type="text" id="main-searchbox" class="form-control opacity-50 border-0" 
                        placeholder="请输入社团关键字……" aria-label="Search-content" aria-describedby="searchicon1"/>
                </div>
            </form>
        </div>
    </div>
</template>

<script>

export default {
    name: 'ClubSearch',
    components: {},
    data: function () {
      return {
        search_text:''
      }
    },
    created:function(){
    },
    methods:{
        search(){
            this.$router.push({path:'/searchclub',query:{key:this.search_text}})
            
        }
    },
    mounted(){
        
    }
  }

</script>

<style scoped>

#banner_img {
    z-index: -1;
}

#title-text {
    font-family: NGlipingshouxie, sans-serif;
    top:30%;
}
#title_img {
    top: 237px;
    width: 250px;
}

#so {
    top: 380px;
    width: 32%;
}

#main-searchbox {
    padding-left: 20px;
    border-radius: 0;
    height: 60px;
    font-size: 12px;
}
</style>