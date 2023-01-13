<template>
    <!-- 顶部banner -->
    <div class="container-fluid position-relative" style="background-color:rgba(102, 102, 102, 1); height: 300px;">
        <!-- 上传封面 -->
        <button id="upcover" class="upimg">
            <p class="mb-1" style="font-size:28px;">
                <span style="font-family:'FontAwesome Regular', 'FontAwesome', sans-serif;font-weight:400;"></span>
            </p>
            <p class="mb-0" style="font-size:14px;">
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;">上传封面</span>
            </p>
        </button>
    </div>
</template>

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
#upcover {
  position:absolute;
  /* left:1305px; */
  right:30px;
  top:170px;
}

.upimg:hover {
  border-color:rgba(0, 121, 254, 1);
  color:rgba(0, 121, 254, 1);
}
</style>

<script>

export default {
    name:"ClubBanner",
    components:{},
    props:["ClubId"]
}
</script>