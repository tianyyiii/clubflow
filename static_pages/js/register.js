$(document).ready(function(){
    

    var url_head="http://localhost:8080/"
    $("button").click(function(){
        var userName=$("#username-input").val();//input的值存在value中jquery和Dom有一些区别
        var pwd=$("#password-input").val();
        var role = $("input[name='userType']:checked").val();
        var put={name:userName,passwd:pwd,role:role,profile:"0"};
        // alert(JSON.stringify(put));
        // var put_json=JSON.parse(put)
        // alert(put_json);
        var result_json={state:0,UserId:0,name:"0"};
        $.ajax({
            type: 'PUT',
            url: url_head+"user/create",
            data: JSON.stringify(put),
            dataType: "json",
            contentType:'application/json;charset=utf-8',
            success: function(data){
                // alert(JSON.stringify(data));
                
                result_json.state=data.state;
                result_json.UserId=data.id;
                result_json.name=data.name;
                if(result_json.state==1){
                    alert("注册成功！");
                    window.location.href = "./shetuanshequ_index.html?UserId="+result_json.UserId;
                }
                else{
                    alert("注册失败！用户名重复！");
                    location.reload();
                }
                
            },
            error: function(data){
                alert("请求异常");
            }
        });
        
        
    });
    

  });