<template>
    <el-upload
        list-type="picture-card"
        :action=action
        :class="{uoloadBtn:classes.showBtnDealImg,disUoloadBtn:classes.noneBtnImg}"
        :on-change="handleChange"
        :on-success="handleSuccess"
        :before-upload="beforeUpload"
        :on-progress="uploadProcess"
        :before-remove="beforeRemove"
        :file-list="fileList"
        :multiple="true"
        :limit="1"
      >
        <el-icon class="avatar-uploader-icon">
          <Plus/>
        </el-icon>
    </el-upload>
</template>

<style>
.disUoloadBtn .el-upload--picture-card{
    display:none;   /* 上传按钮隐藏 */
}
</style>

<script setup>
import {reactive,ref,getCurrentInstance} from 'vue'
import{ElMessage,ElMessageBox} from 'element-plus'
import { Plus } from "@element-plus/icons-vue";

// 可以在上传文件里console(fileList),会返回数据结构

const props = defineProps({
product_id: Number,
});
const emit = defineEmits(["upUrl"])

const fileList = reactive([]); // 上传图片
const action = getCurrentInstance()?.appContext.config.globalProperties.$Baseurl + 'comment/image' // 服务器地址
const classes= reactive({showBtnDealImg:true, noneBtnImg:false})

const percent = ref(0);
// 上传前校验
const beforeUpload = (file) => {
console.log('上传前端校验', file);
const isLt2M = file.size / 1024 / 1024 < 2;
const type = file.type;
if (!isLt2M) {
    ElMessage.success({
    message: '上传图片不能超过2MB哦!',
    });
    return false;
}
//   if(type.includes('jpg'))
};

//上传成功回调
const handleSuccess = (res, file) => {
console.log('handleSuccessres', res);
console.log('handleSuccessfile', file);
if (res) {
    ElMessage.success({
        message: '上传成功!',
    });
    emit("upUrl",file.response.imgURL)
} else {
    ElMessage.error({
        message: '上传失败，请重新上传',
    });
}
};
//上传文件
const handleChange = (file, fileList) => {
    console.log('file---', file);
    console.log('fileList---', fileList);
    classes.noneBtnImg = fileList.length >= 1;
};
// 上传时候的钩子
const uploadProcess = (event, file, fileList) => {
// console.log(event.percent);
percent.value = Math.floor(event.percent);
};
// 删除
const beforeRemove = (file, fileList) => {
const result = new Promise((resolve, reject) => {
    ElMessageBox.confirm('此操作将删除该图片, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
    })
    .then(() => {
        let index = fileList.indexOf(file);
        fileList.splice(index, 1);
        classes.noneBtnImg = false;
        // 请求删除接口
    })
    .catch(() => {
        reject(false);
    });
});
return result;
};


</script>