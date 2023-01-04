# Clubflow

## VUE+Springboot 部署办法

1. clone项目到本地。

   ```git clone https://github.com/control-cyber/clubflow.git```

   后端文件夹`version_0.9.0/`，前端为`vue/clubflow/`，数据库文件在Dump压缩包中（或直接导入clubflow.sql也可）

2. 配置数据库：mysql新建一个clubflow的数据库，编码设置为utf8mb4，导入解压后的sql文件，并在`version_0.9.0/src/main/resources/application.yml`中修改数据库的密码。默认端口为3306。

3. 后端动态资源的存储：配置在`version_0.9.0/src/main/java/com/example/club/config/MyWebConfigure.java`中，默认存在`d:/workspace/img/`，可修改。已有的资源文件在仓库的`workspace`文件夹中，运行时请更改MyWebConfigure.java中的路径，或将仓库中的workspace文件夹拷贝到`D:/`。

4. 在IntelliJ IDEA中运行后端项目，默认端口为8080。

5. 前端项目配置了端口自动转发和跨域处理。默认端口为8081，转发数据到后端的8080接口中。转发与跨域配置在`vue\clubflow\vue.config.js`中。

6. 在vue/clubflow目录下执行`npm install` 安装vue环境依赖。完成后执行`npm run serve`编译并运行。此时访问`http://localhost:8081`即可进入首页。右上角登录键可进入登录页面。登录状态下右上角有退出登录的按钮。

7. 普通用户的默认账户：用户名和密码都是geyuanyuan，其余见数据库。角色分配（role）: 1 -- admin开发人员,  2 -- official account社团管理,  3 -- common user普通用户,  4 -- black user。在`vue\clubflow\src\router\index.js`中配置了各个页面的路由和具体访问权限，包括角色权限和登录拦截。目前在前端做了基于locationStorage的登录缓存，在登录状态下全局保存用户名和角色。具体配置在`vue\clubflow\src\store\index.js`。

8. 图片的上传一律采用保存url到数据库的形式，并未保存Base64格式的数据。数据库中的image表格实际上并未使用。上传图片的接口在`version_0.9.0/src/main/java/com/example/club/controller/CommentController.java`中，函数为`public JSONObject imageUpload(MultipartFile file)`。如果更改过MyWebConfigure.java中的路径，此处也应修改图片保存的目录。

9. 其他待补充。

