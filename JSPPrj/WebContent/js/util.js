    
function slideIn(selector){
    var screen = document.createElement("div");
    var aside = document.querySelector("#aside");

    screen.style.width = "100%";
    screen.style.height = "100%";
    screen.style.backgroundColor = "black";
    screen.style.position = "fixed";
    screen.style.top = "0px";
    screen.style.left = "0px";
    screen.style.opacity = 0;
    screen.style.transition = ".5s";

    setTimeout(function(){
        screen.style.opacity = 0.7;
    },10);
    document.body.append(screen);

    screen.ontransitionend = function(e){
        aside.style.position = "fixed";
        aside.style.width = "70%";
        aside.style.height = "100%";
        aside.style.top = "0px";
        aside.style.left = "100%";
        aside.style.zIndex = 10;
        aside.style.transition = ".5s";
        
        setTimeout(function(){
            aside.style.left = "30%";
        },0);
    }

    screen.onclick = function(){
        aside.style = "";
        //초기화
        screen.remove();
        /* 에니메이션 사라지기
        aside.style.left = "100%";
        aside.ontransitionend = function(e){
        aside.style.position = "static";
        screen.style.opacity = 0;
        */


    };
}