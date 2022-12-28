edit_list={};

function F(userid,clubid)
	{
		var j_data=new Array();
		var j_label=new Array();
		var res=new Array();
		$.ajaxSetup({async:false});
				$.getJSON('http://localhost:8080/club/view',{"UserId":userid,"ClubId":clubid},function(result)
				{
					$.each(result, function(i, field)
					{
						var I=i;
						var F=field;
						j_label.push(I);
						j_data.push(F);
					});
					return j_data.length;
				});
				res.push(j_label);
				res.push(j_data);
				return res;
	};

function change_text()
{
	var announcement_text=document.getElementById("announcement_text");
	var input_area=document.createElement("input");
	input_area.type="text";
	announcement_text.append(input_area);
	var button=document.createElement("button");
	button.click="submit_change_text()";
	announcement_text.append(button);
}

function submit_change_text()
{
	var element;
	$("input").each(function()
    {
        element=$(this).val();
    })
	var announcement_text=document.getElementById("announcement_text");
	announcement_text="";
	announcement_text.append(element);

	edit_list.append({"text",element});
}

function change_picture()
{
	var announcement_photo=document.getElementById("announcement_photo");
	var input_area=document.createElement("input");
	input_area.type="file";
	input_area.accept="image/png";
	announcement_photo.append(input_area);
	var button=document.createElement("button");
	button.click="submit_change_photo()";
	announcement_photo.append(button);
}

function imgChange(obj) {
	var image = obj.files[0]; //获取文件域中选中的图片
	var reader = new FileReader(); //实例化文件读取对象
	reader.readAsDataURL(image); //将文件读取为 DataURL,也就是base64编码
	reader.onload = function(ev) { //文件读取成功完成时触发
		var dataURL = ev.target.result; //获得文件读取成功后的DataURL,也就是base64编码
		var name="profile";
		params[name]=dataURL;
	}
	console.log(image);
	return image;
}

function submit_change_photo()
{
	var element;
	$("input").each(function()
    {
        element=$(this).val();
    })
	var image=imgChange(element);
	edit_list.append({"image",iimage});
}

function send_json(url,obj,userid,clubid)
{
    $.ajax({
        url: url,
        data:obj,
        type: "PUT",
        dataType: "json",
        // false为同步，true为异步，默认为false
        // 对于success返回，设置为false或true，似乎看不出影响
        async: false,
        // xhrFields不设置将则后端服务器不会保存session会话
        xhrFields: {
            withCredentials: true
        },
        // 跨域请求访问,不设置则在浏览器中无法访问服务器
        crossDomain: true,
        // 错误处理函数最好加上，否则将很难排错
        error:function(msg){
        /* 
            msg为json对象，返回以下字符串：
            {"readyState":4,"responseText":"success","status":200,"statusText":"parsererror"}
            说明后端服务器没有正确返回json数据类型
        */
            document.write(JSON.stringify(msg));
            
        },
        success: function(data) {
            // data为json对象
            document.getElementById("content").innerText=JSON.stringify(data);
        }
    });
}

function submit()
{

}

function cancel()
{

}
