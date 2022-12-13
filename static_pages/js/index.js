$(document).ready(function(){
    $(".login-content").mouseenter(function(){
        $(".ellipse").animate({top:'-8px'},"slow");
    });
    $(".login-content").mouseleave(function(){
        $(".ellipse").animate({top:'38px'},"slow");
    });



    var url_head="http://localhost:8080/"
    $("button").click(function(){
        var userName=$("#username input").val();
        var pwd=$("#password input").val();
        var result_json={state:0,UserId:0};
        // alert(userName);
        $.getJSON(url_head+"user",
        {
            UserName:userName,
            password:pwd
        },
        function(result){
            // alert(result);
            result_json.state=result.state;
            result_json.UserId=result.UserId;
            console.log(result_json);
            // alert(result_json);
            if(result_json.state!=1){
                alert("不存在该用户或密码错误！");
                location.reload();
            }
            else{
                window.location.href = "./shetuanshequ_index.html?UserId="+result_json.UserId;
            }
        });
        
    });
    

  });