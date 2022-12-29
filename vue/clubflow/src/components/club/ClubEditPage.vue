<template>
    <!-- 顶部banner -->
    <ClubBanner v-bind:ClubId="ClubId"></ClubBanner>

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
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">协会名称</span>
                </p>
                <p class="mb-0" style="font-size:14px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">副标题</span>
                </p>
            </div>
            
        </div>

        <div class="d-flex" style="font-size:18px;color:#A4A4A4;">
            <div class="text-center" style="width: 140px; border-right: 1px rgb(228, 228, 228) solid;">
                <p class="mb-1" style="font-size:14px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">粉丝</span>
                </p>
                <p class="mb-0" style="font-size:20px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">222</span>
                </p>
            </div>
            <div class="text-center" style="width: 140px; border-right: 1px rgb(228, 228, 228) solid;">
                <p class="mb-1" style="font-size:14px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">文章</span>
                </p>
                <p class="mb-0" style="font-size:20px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">11</span>
                </p>
            </div>

        </div>
    </div>

    <div class="row container-fluid d-flex justify-content-center py-5" style="background-color: rgb(249, 249, 249);">
        <!-- 资料卡 -->
        <div id="basic-info" class="col-md-6 me-5" >
            <!-- 小标题 -->
            <div class="" >
                <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
                <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">资料卡</span>
                <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
            </div>
            <!-- 灰色区 -->
            <div class="px-2 py-4">
                <div style="font-family:'华文宋体', sans-serif;font-size:14px;line-height: 18px;">
                    简介：介绍协会。文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例。</div>
                <textarea id="intro-text" class="form-control mt-5" placeholder="请输入协会简要介绍信息。不超过500字。" maxlength="500" name="text" style="height: 160px;border-radius: 3px;font-size: 14px;"></textarea>
            </div>
            <!-- 按钮组 -->
            <div class="w-100 px-5 my-2 d-flex justify-content-end">
                <button class="re-btn me-2">重置</button>
                <button class="sav-btn">提交</button>
            </div>
        </div>
        <!-- 粉丝列表 -->
        <div class="col-md-4 ms-4">
            <!-- 小标题 -->
            <div class="" >
                <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
                <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">粉丝列表</span>
                <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
            </div>
            <!-- 列表 -->
            <ul class="py-3 px-4">
                <li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li>
                <li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li>
                <li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li><li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li><li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li><li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li><li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li><li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li><li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li><li class="me-5 mt-3 text-center float-start" style="list-style-type: none; text-align: center;">
                    <img class="rounded-circle" src="@/assets/images/common/default-user-round.png" alt="用户头像" style="width:50px;height:50px">
                    <p class="my-1" style="font-size: 15px; color: #999999;">Windir</p>
                </li>
            </ul>
        </div>
    </div>

    <!-- 发表文章 -->
    <div class="mt-5 px-5 mx-4">
        <!-- 小标题 -->
        <div class="" >
            <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
            <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">发表文章</span>
            <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
        </div>
        <div class="my-3 px-1">
            <PostEdit v-bind:ClubId="ClubId"></PostEdit>
        </div>
    </div>

    <!-- 历史文章 -->
    <div class="px-0 pt-1 mt-5 container-fluid" style="background-color: #f9f9f9; padding-bottom: 200px;">
        <div class="mt-5 px-5 mx-4" >
            <!-- 小标题 -->
            <div class="" >
                <span class="ms-2 me-2" style="font-family:'FontAwesome', sans-serif;font-size:22px;"></span>
                <span style="font-family:'Microsoft JhengHei UI', sans-serif;font-size:16px;color:#B82D29;">历史文章</span>
                <div class="mt-1" style="background-color:rgb(228, 228, 228); height: 8px;"></div>
            </div>
            <!-- 文章列表 -->
            <ul class="list-group m-0 p-0">
                <!-- 列表项 -->
                <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3 overflow-hidden" aria-current="true" style="border-radius: 0;">
                    <div class="img-box flex-shrink-0">
                        <img src="@/assets/images/common/default_img.png">   
                    </div>
                    <div class="gap-2 w-100 position-relative">
                        <div class="d-flex w-100 justify-content-between">
                            <div>
                                <h6 class="mb-0" style="font-family:'微软雅黑', sans-serif; font-weight: 600; font-size:16px;">
                                    [招新]2022年秋季招新
                                </h6>
                                <p class="textlines-overflow-2 mt-2 ms-1 mb-0" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:13px;
                                    color:#999999; text-align:left;">
                                    资讯内容
                                </p>
                            </div>
                            <small class="opacity-50 text-nowrap" style="font-size: 12px;">
                                <i class="fa fa-clock-o" aria-hidden="true"></i> 12-13 16:00
                            </small>
                        </div>
                        <div class="d-flex w-100 position-absolute bottom-0 justify-content-between align-items-baseline">
                            <div class="d-inline-flex align-items-center">
                                <div class="user-img-box flex-shrink-0" style="width:24px; height:24px; overflow:hidden" >
                                    <img src="@/assets/images/common/default_user.png">
                                </div>
                                <span class="ms-2" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:12px;
                                        color:#999999;">xx协会
                                </span>
                            </div>
                            <p class="m-0" style="font-family:'FontAwesome', '微软雅黑', sans-serif; font-weight:400; font-size:13px;
                            color:#999999;">
                                 6666&nbsp;  7777&nbsp;  33333
                            </p>
                        </div>
                    </div>
                </a>
                <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3 overflow-hidden" aria-current="true" style="border-radius: 0;">
                    <div class="img-box flex-shrink-0">
                        <img src="@/assets/images/common/default_img.png">   
                    </div>
                    <div class="gap-2 w-100 position-relative">
                        <div class="d-flex w-100 justify-content-between">
                            <div>
                                <h6 class="mb-0" style="font-family:'微软雅黑', sans-serif; font-weight: 600; font-size:16px;">
                                    [招新]2022年秋季招新
                                </h6>
                                <p class="textlines-overflow-2 mt-2 ms-1 mb-0" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:13px;
                                    color:#999999; text-align:left;">
                                    资讯内容
                                </p>
                            </div>
                            <small class="opacity-50 text-nowrap" style="font-size: 12px;">
                                <i class="fa fa-clock-o" aria-hidden="true"></i> 12-13 16:00
                            </small>
                        </div>
                        <div class="d-flex w-100 position-absolute bottom-0 justify-content-between align-items-baseline">
                            <div class="d-inline-flex align-items-center">
                                <div class="user-img-box flex-shrink-0" style="width:24px; height:24px; overflow:hidden" >
                                    <img src="@/assets/images/common/default_user.png">
                                </div>
                                <span class="ms-2" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:12px;
                                        color:#999999;">xx协会
                                </span>
                            </div>
                            <p class="m-0" style="font-family:'FontAwesome', '微软雅黑', sans-serif; font-weight:400; font-size:13px;
                            color:#999999;">
                                 6666&nbsp;  7777&nbsp;  33333
                            </p>
                        </div>
                    </div>
                </a>
                <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3 overflow-hidden" aria-current="true" style="border-radius: 0;">
                    <div class="img-box flex-shrink-0">
                        <img src="@/assets/images/common/default_img.png">   
                    </div>
                    <div class="gap-2 w-100 position-relative">
                        <div class="d-flex w-100 justify-content-between">
                            <div>
                                <h6 class="mb-0" style="font-family:'微软雅黑', sans-serif; font-weight: 600; font-size:16px;">
                                    [招新]2022年秋季招新
                                </h6>
                                <p class="textlines-overflow-2 mt-2 ms-1 mb-0" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:13px;
                                    color:#999999; text-align:left;">
                                    资讯内容
                                </p>
                            </div>
                            <small class="opacity-50 text-nowrap" style="font-size: 12px;">
                                <i class="fa fa-clock-o" aria-hidden="true"></i> 12-13 16:00
                            </small>
                        </div>
                        <div class="d-flex w-100 position-absolute bottom-0 justify-content-between align-items-baseline">
                            <div class="d-inline-flex align-items-center">
                                <div class="user-img-box flex-shrink-0" style="width:24px; height:24px; overflow:hidden" >
                                    <img src="@/assets/images/common/default_user.png">
                                </div>
                                <span class="ms-2" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:12px;
                                        color:#999999;">xx协会
                                </span>
                            </div>
                            <p class="m-0" style="font-family:'FontAwesome', '微软雅黑', sans-serif; font-weight:400; font-size:13px;
                            color:#999999;">
                                 6666&nbsp;  7777&nbsp;  33333
                            </p>
                        </div>
                    </div>
                </a>
                <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3 overflow-hidden" aria-current="true" style="border-radius: 0;">
                    <div class="img-box flex-shrink-0">
                        <img src="@/assets/images/common/default_img.png">   
                    </div>
                    <div class="gap-2 w-100 position-relative">
                        <div class="d-flex w-100 justify-content-between">
                            <div>
                                <h6 class="mb-0" style="font-family:'微软雅黑', sans-serif; font-weight: 600; font-size:16px;">
                                    [招新]2022年秋季招新
                                </h6>
                                <p class="textlines-overflow-2 mt-2 ms-1 mb-0" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:13px;
                                    color:#999999; text-align:left;">
                                    资讯内容
                                </p>
                            </div>
                            <small class="opacity-50 text-nowrap" style="font-size: 12px;">
                                <i class="fa fa-clock-o" aria-hidden="true"></i> 12-13 16:00
                            </small>
                        </div>
                        <div class="d-flex w-100 position-absolute bottom-0 justify-content-between align-items-baseline">
                            <div class="d-inline-flex align-items-center">
                                <div class="user-img-box flex-shrink-0" style="width:24px; height:24px; overflow:hidden" >
                                    <img src="@/assets/images/common/default_user.png">
                                </div>
                                <span class="ms-2" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:12px;
                                        color:#999999;">xx协会
                                </span>
                            </div>
                            <p class="m-0" style="font-family:'FontAwesome', '微软雅黑', sans-serif; font-weight:400; font-size:13px;
                            color:#999999;">
                                 6666&nbsp;  7777&nbsp;  33333
                            </p>
                        </div>
                    </div>
                </a>
                <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3 overflow-hidden" aria-current="true" style="border-radius: 0;">
                    <div class="img-box flex-shrink-0">
                        <img src="@/assets/images/common/default_img.png">   
                    </div>
                    <div class="gap-2 w-100 position-relative">
                        <div class="d-flex w-100 justify-content-between">
                            <div>
                                <h6 class="mb-0" style="font-family:'微软雅黑', sans-serif; font-weight: 600; font-size:16px;">
                                    [招新]2022年秋季招新
                                </h6>
                                <p class="textlines-overflow-2 mt-2 ms-1 mb-0" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:13px;
                                    color:#999999; text-align:left;">
                                    资讯内容
                                </p>
                            </div>
                            <small class="opacity-50 text-nowrap" style="font-size: 12px;">
                                <i class="fa fa-clock-o" aria-hidden="true"></i> 12-13 16:00
                            </small>
                        </div>
                        <div class="d-flex w-100 position-absolute bottom-0 justify-content-between align-items-baseline">
                            <div class="d-inline-flex align-items-center">
                                <div class="user-img-box flex-shrink-0" style="width:24px; height:24px; overflow:hidden" >
                                    <img src="@/assets/images/common/default_user.png">
                                </div>
                                <span class="ms-2" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:12px;
                                        color:#999999;">xx协会
                                </span>
                            </div>
                            <p class="m-0" style="font-family:'FontAwesome', '微软雅黑', sans-serif; font-weight:400; font-size:13px;
                            color:#999999;">
                                 6666&nbsp;  7777&nbsp;  33333
                            </p>
                        </div>
                    </div>
                </a>
                <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3 overflow-hidden" aria-current="true" style="border-radius: 0;">
                    <div class="img-box flex-shrink-0">
                        <img src="@/assets/images/common/default_img.png">   
                    </div>
                    <div class="gap-2 w-100 position-relative">
                        <div class="d-flex w-100 justify-content-between">
                            <div>
                                <h6 class="mb-0" style="font-family:'微软雅黑', sans-serif; font-weight: 600; font-size:16px;">
                                    [招新]2022年秋季招新
                                </h6>
                                <p class="textlines-overflow-2 mt-2 ms-1 mb-0" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:13px;
                                    color:#999999; text-align:left;">
                                    资讯内容
                                </p>
                            </div>
                            <small class="opacity-50 text-nowrap" style="font-size: 12px;">
                                <i class="fa fa-clock-o" aria-hidden="true"></i> 12-13 16:00
                            </small>
                        </div>
                        <div class="d-flex w-100 position-absolute bottom-0 justify-content-between align-items-baseline">
                            <div class="d-inline-flex align-items-center">
                                <div class="user-img-box flex-shrink-0" style="width:24px; height:24px; overflow:hidden" >
                                    <img src="@/assets/images/common/default_user.png">
                                </div>
                                <span class="ms-2" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:12px;
                                        color:#999999;">xx协会
                                </span>
                            </div>
                            <p class="m-0" style="font-family:'FontAwesome', '微软雅黑', sans-serif; font-weight:400; font-size:13px;
                            color:#999999;">
                                 6666&nbsp;  7777&nbsp;  33333
                            </p>
                        </div>
                    </div>
                </a>
                <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3 overflow-hidden" aria-current="true" style="border-radius: 0;">
                    <div class="img-box flex-shrink-0">
                        <img src="@/assets/images/common/default_img.png">   
                    </div>
                    <div class="gap-2 w-100 position-relative">
                        <div class="d-flex w-100 justify-content-between">
                            <div>
                                <h6 class="mb-0" style="font-family:'微软雅黑', sans-serif; font-weight: 600; font-size:16px;">
                                    [招新]2022年秋季招新
                                </h6>
                                <p class="textlines-overflow-2 mt-2 ms-1 mb-0" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:13px;
                                    color:#999999; text-align:left;">
                                    资讯内容
                                </p>
                            </div>
                            <small class="opacity-50 text-nowrap" style="font-size: 12px;">
                                <i class="fa fa-clock-o" aria-hidden="true"></i> 12-13 16:00
                            </small>
                        </div>
                        <div class="d-flex w-100 position-absolute bottom-0 justify-content-between align-items-baseline">
                            <div class="d-inline-flex align-items-center">
                                <div class="user-img-box flex-shrink-0" style="width:24px; height:24px; overflow:hidden" >
                                    <img src="@/assets/images/common/default_user.png">
                                </div>
                                <span class="ms-2" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:12px;
                                        color:#999999;">xx协会
                                </span>
                            </div>
                            <p class="m-0" style="font-family:'FontAwesome', '微软雅黑', sans-serif; font-weight:400; font-size:13px;
                            color:#999999;">
                                 6666&nbsp;  7777&nbsp;  33333
                            </p>
                        </div>
                    </div>
                </a>
                <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3 overflow-hidden" aria-current="true" style="border-radius: 0;">
                    <div class="img-box flex-shrink-0">
                        <img src="@/assets/images/common/default_img.png">   
                    </div>
                    <div class="gap-2 w-100 position-relative">
                        <div class="d-flex w-100 justify-content-between">
                            <div>
                                <h6 class="mb-0" style="font-family:'微软雅黑', sans-serif; font-weight: 600; font-size:16px;">
                                    [招新]2022年秋季招新
                                </h6>
                                <p class="textlines-overflow-2 mt-2 ms-1 mb-0" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:13px;
                                    color:#999999; text-align:left;">
                                    资讯内容
                                </p>
                            </div>
                            <small class="opacity-50 text-nowrap" style="font-size: 12px;">
                                <i class="fa fa-clock-o" aria-hidden="true"></i> 12-13 16:00
                            </small>
                        </div>
                        <div class="d-flex w-100 position-absolute bottom-0 justify-content-between align-items-baseline">
                            <div class="d-inline-flex align-items-center">
                                <div class="user-img-box flex-shrink-0" style="width:24px; height:24px; overflow:hidden" >
                                    <img src="@/assets/images/common/default_user.png">
                                </div>
                                <span class="ms-2" style="font-family:'微软雅黑', sans-serif; font-weight:400; font-size:12px;
                                        color:#999999;">xx协会
                                </span>
                            </div>
                            <p class="m-0" style="font-family:'FontAwesome', '微软雅黑', sans-serif; font-weight:400; font-size:13px;
                            color:#999999;">
                                 6666&nbsp;  7777&nbsp;  33333
                            </p>
                        </div>
                    </div>
                </a>
            </ul>
        </div>
    </div>
    
</template>

<script>

import ClubBanner from '@/components/club/ClubBanner.vue';
import PostEdit from '../post/PostEdit.vue';

export default {
    name: 'ClubEditPage',
    components: {ClubBanner,PostEdit},
    data(){
        return{
            ClubId: 1,
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


.sav-btn {
  width:80px;
  height:30px;
  background-color:rgba(184, 45, 41, 1);
  border-radius:0px;
  font-family:'微软雅黑', sans-serif;
  font-weight:400;
  font-style:normal;
  font-size:12px;
  color:#FFFFFF;
}
.sav-btn:hover{
    opacity: 80%;
}
.re-btn{
    width:80px;
  height:30px;
  background-color:white;
  border: 1px solid rgba(184, 45, 41, 1);
  border-radius:0px;
  font-family:'微软雅黑', sans-serif;
  font-weight:400;
  font-style:normal;
  font-size:12px;
  color:rgba(184, 45, 41, 1);
}

textarea:focus {
    box-shadow: none;
    border:1px solid rgba(0, 121, 254, 1);
}

.list-group a {
    border-width: 0;
}

.list-group a:hover {
    background-color: white;
    border-width:2px;
    border-top: 0;
    border-left:0 ;
    border-right: 0;
    border-color: var(--themecolor);
    cursor: pointer;
}
.list-group-item {
    height: 140px;
    overflow:hidden
}
.img-box {
    width:153px; height:108px;overflow:hidden;
}
.img-box>img {
    max-width:153px;
    /* _width:expression( this.width > 153 ? "153px" : this.width); */
}
.user-img-box>img {
    max-width:24px;
    /* _width:expression( this.width > 24 ? "24px" : this.width); */
}

</style>