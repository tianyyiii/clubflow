<template>
    <div class="p-3 border border-1">
        <!-- 标题 -->
        <div class="">
            <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;font-size:14px;color:#666666;">发表评论 </span>
            <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;color:#CCCCCC;">文明上网理性发言，请遵守评论服务协议</span>
        </div>

        <!-- 发表区 -->
        <div class="my-3 w-100 d-inline-flex">
            <div id="user-img" class="user-img me-1 text-center" style="width: 10%; color:#999999;">

                <!-- <div class="default-img-big" style="font-family:'FontAwesome', sans-serif; font-size:48px; color:#CCCCCC;">
                    <span></span>
                </div> -->
                <div>
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width: 46px; height: 46px;">
                </div>
                <div class="mt-2" title="请先登录" style="font-family:'微软雅黑', sans-serif; font-size:12px;">
                    <span>未登录</span>
                </div>

            </div>
            <form class="ms-3 w-100" action="">
                <fieldset disabled>
                    <div class="mb-3">
                        <textarea id="comment-text" class="form-control" placeholder="您未登录，请先登录！" rows="5" name="text"></textarea>
                    </div>
                    <button title="发布评论" type="submit" class="btn btn-primary float-end" style="font-size:14px; width:80px">发布</button>
                </fieldset>
            </form>
        </div>

        <!-- 评论显示区 -->
        <div class="mt-3">
            <div class="d-flex justify-content-between border-bottom pb-2">
                <div style="font-size: 14px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">全部评论 </span>
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;">100条</span>
                </div>
                <div class="" style="font-size: 13px;">
                    <button style="border: 0; background-color: inherit; color:#999999;">最新</button>
                    <button style="border: 0; background-color: inherit; color:#666666;"> / 最热</button>
                </div>
            </div>

            <!-- 评论列表 -->
            <ul class="p-1 mb-3 w-100">
                <li class="mt-3 w-100" style="list-style-type: none;">
                    <div class="d-inline-flex w-100 border-bottom" >
                        <div class="m-2 me-4">
                            <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width: 46px; height: 46px;">
                        </div>
                        <div class="w-100" style="color:#999999;">
                            <div class="mb-3 w-100 d-flex justify-content-between">
                                <div class="" style="font-size:14px;">
                                    <span style="color:#666666;">Windir </span>
                                    <span style="font-size:12px;color:#999999;">6分钟前</span>
                                </div>
                                <button class="" >
                                    <span style="font-family:'FontAwesome', sans-serif; font-size:14px;"></span>
                                    <span style="font-family:'微软雅黑', sans-serif; font-size:12px;"> 举报</span>
                                </button>
                            </div>
                            
                            <p class="textlines-overflow-2" style="height: 40px; font-size: 14px;">
                                喜欢加入。喜欢在这里的感觉。评论文字示例。</p>
    

                            <p style="font-size:14px;">
                                <button title="点赞">
                                    <span style="font-family:'FontAwesome', sans-serif;font-weight:400; color: rgba(184, 45, 41, 1);"></span>
                                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 点赞 100 &nbsp;</span>
                                </button>
                                <button title="评论" data-bs-toggle="modal" data-bs-target="#myModal">
                                    <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"></span>
                                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 回复 100 </span>
                                </button>
                            </p>
                        </div>
                    </div>
                    <!-- 二级评论 -->
                    <div class="">
                        <ul class="ms-4 mt-2">
                            <li class="mt-2 d-inline-flex w-100 border-bottom pt-1" style="list-style-type: none;">
                                <div class="me-4">
                                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width: 46px; height: 46px;">
                                </div>
                                <div class="w-100" style="color:#999999;">
                                    <div class="mb-1 w-100 d-flex justify-content-between">
                                        <div class="" style="font-size:14px;">
                                            <span style="color:#666666;">Windir </span>
                                            <span style="font-size:12px;color:#999999;">6分钟前</span>
                                        </div>
                                        <button class="" >
                                            <span style="font-family:'FontAwesome', sans-serif; font-size:14px;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif; font-size:12px;"> 举报</span>
                                        </button>
                                    </div>
                                    
                                    <p class="textlines-overflow-2 m-0" style="height: 40px; font-size: 14px;">
                                        这里是二级评论。
                                    </p>

                                    <p class="mt-0 mb-1" style="font-size:14px;">
                                        <button title="点赞">
                                            <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 点赞 100 &nbsp;</span>
                                        </button>
                                    </p>
                                </div>
                            </li>

                            <li class="mt-2 d-inline-flex w-100 border-bottom pt-1" style="list-style-type: none;">
                                <div class="me-4">
                                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width: 46px; height: 46px;">
                                </div>
                                <div class="w-100" style="color:#999999;">
                                    <div class="mb-1 w-100 d-flex justify-content-between">
                                        <div class="" style="font-size:14px;">
                                            <span style="color:#666666;">Windir </span>
                                            <span style="font-size:12px;color:#999999;">6分钟前</span>
                                        </div>
                                        <button class="" >
                                            <span style="font-family:'FontAwesome', sans-serif; font-size:14px;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif; font-size:12px;"> 举报</span>
                                        </button>
                                    </div>
                                    
                                    <p class="textlines-overflow-2 m-0" style="height: 40px; font-size: 14px;">
                                        这里是二级评论。
                                    </p>

                                    <p class="mt-0 mb-1" style="font-size:14px;">
                                        <button title="点赞">
                                            <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 点赞 100 &nbsp;</span>
                                        </button>
                                    </p>
                                </div>
                            </li>
                        </ul>
                    </div>
                    
                
                </li>
                
                <li class="mt-3 w-100" style="list-style-type: none;">
                    <div class="d-inline-flex w-100 border-bottom" >
                        <div class="m-2 me-4">
                            <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width: 46px; height: 46px;">
                        </div>
                        <div class="w-100" style="color:#999999;">
                            <div class="mb-3 w-100 d-flex justify-content-between">
                                <div class="" style="font-size:14px;">
                                    <span style="color:#666666;">Windir </span>
                                    <span style="font-size:12px;color:#999999;">6分钟前</span>
                                </div>
                                <button class="" >
                                    <span style="font-family:'FontAwesome', sans-serif; font-size:14px;"></span>
                                    <span style="font-family:'微软雅黑', sans-serif; font-size:12px;"> 举报</span>
                                </button>
                            </div>
                            
                            <p class="textlines-overflow-2" style="height: 40px; font-size: 14px;">
                                喜欢加入。喜欢在这里的感觉。评论文字示例。</p>
    

                            <p style="font-size:14px;">
                                <button title="点赞">
                                    <span style="font-family:'FontAwesome', sans-serif;font-weight:400; color: rgba(184, 45, 41, 1);"></span>
                                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 点赞 100 &nbsp;</span>
                                </button>
                                <button title="评论" data-bs-toggle="modal" data-bs-target="#myModal">
                                    <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"></span>
                                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 回复 100 </span>
                                </button>
                            </p>
                        </div>
                    </div>
                    <!-- 二级评论 -->
                    <div class="">
                        <ul class="ms-4 mt-2">
                            <li class="mt-2 d-inline-flex w-100 border-bottom pt-1" style="list-style-type: none;">
                                <div class="me-4">
                                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width: 46px; height: 46px;">
                                </div>
                                <div class="w-100" style="color:#999999;">
                                    <div class="mb-1 w-100 d-flex justify-content-between">
                                        <div class="" style="font-size:14px;">
                                            <span style="color:#666666;">Windir </span>
                                            <span style="font-size:12px;color:#999999;">6分钟前</span>
                                        </div>
                                        <button class="" >
                                            <span style="font-family:'FontAwesome', sans-serif; font-size:14px;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif; font-size:12px;"> 举报</span>
                                        </button>
                                    </div>
                                    
                                    <p class="textlines-overflow-2 m-0" style="height: 40px; font-size: 14px;">
                                        这里是二级评论。
                                    </p>

                                    <p class="mt-0 mb-1" style="font-size:14px;">
                                        <button title="点赞">
                                            <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 点赞 100 &nbsp;</span>
                                        </button>
                                    </p>
                                </div>
                            </li>

                            <li class="mt-2 d-inline-flex w-100 border-bottom pt-1" style="list-style-type: none;">
                                <div class="me-4">
                                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width: 46px; height: 46px;">
                                </div>
                                <div class="w-100" style="color:#999999;">
                                    <div class="mb-1 w-100 d-flex justify-content-between">
                                        <div class="" style="font-size:14px;">
                                            <span style="color:#666666;">Windir </span>
                                            <span style="font-size:12px;color:#999999;">6分钟前</span>
                                        </div>
                                        <button class="" >
                                            <span style="font-family:'FontAwesome', sans-serif; font-size:14px;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif; font-size:12px;"> 举报</span>
                                        </button>
                                    </div>
                                    
                                    <p class="textlines-overflow-2 m-0" style="height: 40px; font-size: 14px;">
                                        这里是二级评论。
                                    </p>

                                    <p class="mt-0 mb-1" style="font-size:14px;">
                                        <button title="点赞">
                                            <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"></span>
                                            <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:12px;"> 点赞 100 &nbsp;</span>
                                        </button>
                                    </p>
                                </div>
                            </li>
                        </ul>
                    </div>
                    
                
                </li>
            </ul>
        </div>
    </div>

    <!-- 模态框 -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">在此添加回复</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- 模态框内容 -->
            <div class="modal-body">
                <textarea id="comment-text" class="form-control" placeholder="回复..." rows="5" name="text" style="height: 100px;border-radius: 0px;"></textarea>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <!-- <button type="button" class="btn btn-danger" data-bs-dismiss="modal">关闭</button> -->
                <button title="发布评论" type="submit" class="btn btn-primary float-end px-4" style="font-size:14px; width:80px">发布</button>
            </div>

            </div>
        </div>
    </div>
</template>

<script>
export default {
    name:"Comments",
    components:{},
    data(){
        return {

        }
    },
    methods:{

    },
    created(){

    },
    mounted(){
        
    }
}

</script>

<style scoped>

#comment-text:focus {
    box-shadow: none;
    border:1px solid rgb(134, 134, 255);
}

</style>