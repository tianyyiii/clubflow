$(document).ready(function(){
    var w1=$(".user-img-box > img").width()> 24 ? "24px" : $(".user-img-box > img").width();
    $(".user-img-box > img").css({"width":w1, "max-width": 24});

    var w2=$(".img-box>img").width()> 153 ? "153px" : $(".img-box>img").width();
    $(".img-box>img").css({"width":w2, "max-width": 153});
  });


