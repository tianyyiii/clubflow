<template>
    <!-- 顶部banner -->
    <div class="container-fluid position-relative" style="background-color:rgba(102, 102, 102, 1); height: 300px;">
        <div class="ellipse ">
            <img src="@/assets/images/common/default_user.png" alt="小组用户头像" style="width:100px;height:100px;">
            <p class="mt-3 mb-0" style="font-size:18px; font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">
                晨跑小组
            </p>
            <p class="mb-2" style="font-size:14px;font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">
                副标题
            </p>
            <button class="follow-btn" style="font-size: 13px;">
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;">&nbsp;</span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;"> 关注</span>
            </button>
            <p class="mt-2 mb-0" style="font-size: 14px;color:#888888;">
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;">粉丝 </span>
                <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">222</span>
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
                <GroupInfo></GroupInfo>
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
        }
    },
    methods: {
    },
    created(){

    },
    mounted(){

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