$(document).ready(function(){
    $(".login-content").mouseenter(function(){
        $(".ellipse").animate({top:'-8px'},"slow");
    });
    $(".login-content").mouseleave(function(){
        $(".ellipse").animate({top:'38px'},"slow");
    });
  });