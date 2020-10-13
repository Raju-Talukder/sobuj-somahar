/*=====================
 Parallax effect Js
 ==========================*/

window.onload = function(){
    let sky   = document.querySelector('#tool-bg'),
        elemOne   = document.querySelector('#tool-1'),
        elemTwo   = document.querySelector('#tool-2'),
        elemThree   = document.querySelector('#tool-3');

    sky.addEventListener('mousemove',function(e){
        var pageX = e.clientX - window.innerWidth/2,
            pageY = e.clientY - window.innerHeight/2;
        elemOne.style.transform = 'translateX(' + (5 + pageX/150) + '%) translateY(' + (1 + pageY/150) + '%)';
        elemTwo.style.transform = 'translateX(-' + (5 + pageX/160) + '%) translateY(-' + (1 + pageY/160) +  '%)';
        elemThree.style.transform = 'translateX(-' + (5 + pageX/150) + '%) translateY(-' + (1 + pageY/150) +  '%)';
    });
}

