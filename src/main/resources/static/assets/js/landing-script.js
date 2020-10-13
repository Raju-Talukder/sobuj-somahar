/*=====================
 Parallax effect Js
 ==========================*/

window.onload = function(){
    let sky   = document.querySelector('#img-bg'),
        elemOne   = document.querySelector('#img-1'),
        elemTwo   = document.querySelector('#img-2'),
        elemThree   = document.querySelector('#img-3'),
    elemFour   = document.querySelector('#img-4'),
    elemFive   = document.querySelector('#img-5'),
    elemSix   = document.querySelector('#img-6'),
    elemSeven   = document.querySelector('#img-7'),
    elemEight   = document.querySelector('#img-8'),
    elemNine   = document.querySelector('#img-9'),
    elemTen   = document.querySelector('#img-10'),
    elemEleven   = document.querySelector('#img-11');


    sky.addEventListener('mousemove',function(e){
        var pageX = e.clientX - window.innerWidth/2,
            pageY = e.clientY - window.innerHeight/2;
        elemOne.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) + '%)';
        elemTwo.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
        elemThree.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
        elemFour.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
        elemFive.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
        elemSix.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
        elemSeven.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
        elemEight.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
        elemNine.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
        elemTen.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
        elemEleven.style.transform = 'translateX(' + (7 + pageX/150) + '%) translateY(' + (1 + pageY/150) +  '%)';
    });
};

"use strict";

$(document).ready(function() {

    $(window).on('scroll', function() {
        if ($(this).scrollTop() > 600) {
            $('.tap-top').fadeIn();
        } else {
            $('.tap-top').fadeOut();
        }
    });
    $('.tap-top').on('click', function() {
        $("html, body").animate({
            scrollTop: 0
        }, 600);
        return false;
    });

    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('header').addClass("sticky");
        }
        else {
            $('header').removeClass("sticky");
        }
    });
    $('ul.tabs li').click(function () {
        var tab_id = $(this).attr('data-tab');

        $('ul.tabs li').removeClass('current');
        $('.tab-content').removeClass('current');

        $(this).addClass('current');
        $("#" + tab_id).addClass('current');
    });

    // Scrollspy initiation
    $('body').scrollspy({
        target: '#scroll-spy',
        offset: 70
    });

    // On render, adjust body padding to ensure last Scroll target can reach top of screen
    var height = $('#howto').innerHeight();
    var windowHeight = $(window).height();
    var navHeight = $('nav.navbar').innerHeight();
    var siblingHeight = $('#howto').nextAll().innerHeight();


    if(height < windowHeight){
        $('body').css("padding-bottom", windowHeight-navHeight-height-siblingHeight + "px");
    }

    // On window resize, adjust body padding to ensure last Scroll target can reach top of screen
    $(window).resize(function(event){
        var height = $('#howto').innerHeight();
        var windowHeight = $(window).height();
        var navHeight = $('nav.navbar').innerHeight();
        var siblingHeight = $('#howto').nextAll().innerHeight();


        if(height < windowHeight){
            $('body').css("padding-bottom", windowHeight-navHeight-height-siblingHeight + "px");
        }
    });

    $('nav.navbar a, .scrollTop').click(function(event){
        // Make sure this.hash has a value before overriding default behavior
        if (this.hash !== "") {
            // Prevent default anchor click behavior
            event.preventDefault();

            // Store hash (#)
            var hash = this.hash;

            // Ensure no section has relevant class
            $('section').removeClass("focus");

            // Add class to target
            $(hash).addClass("focus");

            // Remove thy class after timeout
            setTimeout(function(){
                $(hash).removeClass("focus");
            }, 2000);

            // Using jQuery's animate() method to add smooth page scroll
            // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area (the speed of the animation)
            $('html, body').animate({
                scrollTop: $(hash).offset().top - 69
            }, 600, function(){

                // Add hash (#) to URL when done scrolling (default click behavior)
                window.location.hash = hash;
            });

            // Collapse Navbar for mobile view
            $(".navbar-collapse").collapse('hide');
        }

    });
    $(window).scroll(function(){
        var scrollPos = $('body').scrollTop();
        if(scrollPos > 0){
            $('.navbar').addClass('show-color');
            $('.scrollTop').addClass('show-button');
        } else{
            $('.navbar').removeClass('show-color');
            $('.scrollTop').removeClass('show-button');
        }

    });
    
    
});