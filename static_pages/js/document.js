$(document).ready(function(){
    $(".dropdown").mouseenter(function(){
        var top=$(".nav-link").offset().top+$(".nav-link").height(); 
        var left=$(".nav-item").offset().left;

        console.log(left);
        $(".dropdown-menu").css({"visibility": "visible","top":top*2, "left":left-10});
        
      $(".dropdown-menu").show();
    });
    $(".dropdown").mouseleave(function(){
        $(".dropdown-menu").css({"visibility": "hidden"});
      $(".dropdown-menu").hide();
    });
  });