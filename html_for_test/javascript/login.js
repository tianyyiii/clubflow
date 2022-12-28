//登录方法
function login(username, password) {
	$.ajax({
		alert("log in");
		type: "post", // 以post方式发起请求
		url: "F:\文件\clubflow-main\html\社团内容.html", // 你的请求链接
		data: { // 提交数据
			"username": username, // 前者为字段名，后者为数据
			"password": password,
		},
		success(data) {
			// data为返回值,这里只返回了用户名
			// 成功后的回调方法
			if (data.toString() == username) {
				//输入的值与后端返回值相同跳转的界面
				window.location.href = '../yw_cjrlxbtsq.html';
			} else if (data.toString() == "lose") {
				//登录失败后的提示
				alert("用户名或密码错误！")
			}
		}
	})
}; //初始化方法

