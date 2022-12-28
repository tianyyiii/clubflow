

function get_club_information()
{
    
    $("input").each(function()
    {
        var element=$(this).val();
        if(element)
        {
            var name=$(this).attr('name');
            if($(this).attr('type')=="text")
            {
                params[name]=element;
            }
        }
    })
    $("textarea").each(function()
    {
        var element=$(this).val();
        if(element)
        {
            var name=$(this).attr('name');
            params[name]=element;
        }
    })
    var paramsJson = JSON.stringify(params);   
    alert(paramsJson);
    return  paramsJson;
}

function Submit()
{
    var club_events_json=get_club_information();
    url="";
    
}

function get_base64(str)
{  
    return "data:image/png;base64,"+str;
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