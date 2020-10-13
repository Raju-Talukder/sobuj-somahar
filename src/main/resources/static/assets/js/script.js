/*-----------------------------------------------------------------------------------

 Template Name:Multikart
 Template URI: themes.pixelstrap.com/multikart
 Description: This is E-commerce website
 Author: Pixelstrap
 Author URI: https://themeforest.net/user/pixelstrap

 ----------------------------------------------------------------------------------- */
// 01.Pre loader
// 02.Tap on Top
// 03.Age verify modal
// 04.Mega menu js
// 05.Image to background js
// 06.Filter js
// 07.Left offer toggle
// 08.Toggle nav
// 09.Footer according
// 10.Add to cart quantity Counter
// 11.Product page Quantity Counter
// 12.Full slider
// 13.Slick slider
// 14.Header z-index js
// 15.Tab js
// 16.Category page
// 17.Filter sidebar js
// 18.Add to cart
// 19.Add to wishlist
// 20.Color Picker
// 21.RTL & Dark-light
// 22.Menu js
// 23.Theme-setting
// 24.Add to cart sidebar js
// 25.Tooltip


(function($) {
    "use strict";

    /*=====================
     01.Pre loader
     ==========================*/
    $(window).on('load', function() {
        setTimeout(function() {
            $('.loader_skeleton').fadeOut('slow');
            $('body').css({
                'overflow': 'auto'
            });
        }, 500);
        $('.loader_skeleton').remove('slow');
        $('body').css({
            'overflow': 'hidden'
        });
    });
    $('#preloader').fadeOut('slow', function() {
        $(this).remove();
    });


    /*=====================  
     02.Tap on Top
     ==========================*/
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


    /*=====================
     03. Age verify modal
     ==========================*/
    $(window).on('load', function() {
        $('#ageModal').modal('show');
    });



    /*=====================
     04. Mega menu js
     ==========================*/
    if ($(window).width() > '1200') {
        $('#hover-cls').hover(
            function() {
                $('.sm').addClass('hover-unset');
            }
        )

    }
    if ($(window).width() > '1200') {
        $('#sub-menu > li').hover(
            function() {
                if ($(this).children().hasClass('has-submenu')) {
                    $(this).parents().find('nav').addClass('sidebar-unset');
                }
            },
            function() {
                $(this).parents().find('nav').removeClass('sidebar-unset');
            }
        )
    }


    /*=====================
     05. Image to background js
     ==========================*/
    $(".bg-top").parent().addClass('b-top');
    $(".bg-bottom").parent().addClass('b-bottom');
    $(".bg-center").parent().addClass('b-center');
    $(".bg_size_content").parent().addClass('b_size_content');
    $(".bg-img").parent().addClass('bg-size');
    $(".bg-img.blur-up").parent().addClass('blur-up lazyload');

    jQuery('.bg-img').each(function() {

        var el = $(this),
            src = el.attr('src'),
            parent = el.parent();

        parent.css({
            'background-image': 'url(' + src + ')',
            'background-size': 'cover',
            'background-position': 'center',
            'display': 'block'
        });

        el.hide();
    });


    /*=====================
     06. Filter js
     ==========================*/
    $(".filter-button").click(function() {
        $(this).addClass('active').siblings('.active').removeClass('active');
        var value = $(this).attr('data-filter');
        if (value == "all") {
            $('.filter').show('1000');
        } else {
            $(".filter").not('.' + value).hide('3000');
            $('.filter').filter('.' + value).show('3000');
        }
    });

    $("#formButton").click(function() {
        $("#form1").toggle();
    });


    /*=====================
     07. left offer toggle
     ==========================*/
    $(".heading-right h3").click(function() {
        $(".offer-box").toggleClass("toggle-cls");
    });


    /*=====================
     08. toggle nav
     ==========================*/
    $('.toggle-nav').on('click', function() {
        $('.sm-horizontal').css("right", "0px");
    });
    $(".mobile-back").on('click', function() {
        $('.sm-horizontal').css("right", "-410px");
    });


    /*=====================
     09. footer according
     ==========================*/
    var contentwidth = jQuery(window).width();
    if ((contentwidth) < '750') {
        jQuery('.footer-title h4').append('<span class="according-menu"></span>');
        jQuery('.footer-title').on('click', function() {
            jQuery('.footer-title').removeClass('active');
            jQuery('.footer-contant').slideUp('normal');
            if (jQuery(this).next().is(':hidden') == true) {
                jQuery(this).addClass('active');
                jQuery(this).next().slideDown('normal');
            }
        });
        jQuery('.footer-contant').hide();
    } else {
        jQuery('.footer-contant').show();
    }

    if ($(window).width() < '1183') {
        jQuery('.menu-title h5').append('<span class="according-menu"></span>');
        jQuery('.menu-title').on('click', function() {
            jQuery('.menu-title').removeClass('active');
            jQuery('.menu-content').slideUp('normal');
            if (jQuery(this).next().is(':hidden') == true) {
                jQuery(this).addClass('active');
                jQuery(this).next().slideDown('normal');
            }
        });
        jQuery('.menu-content').hide();
    } else {
        jQuery('.menu-content').show();
    }


    /*=====================
     10. Add to cart quantity Counter
     ==========================*/
    $("button.add-button").click(function() {
        $(this).next().addClass("open");
        $(".qty-input").val('1');
    });
    $('.quantity-right-plus').on('click', function() {
        var $qty = $(this).siblings(".qty-input");
        var currentVal = parseInt($qty.val());
        if (!isNaN(currentVal)) {
            $qty.val(currentVal + 1);
        }
    });
    $('.quantity-left-minus').on('click', function() {
        var $qty = $(this).siblings(".qty-input");
        var _val = $($qty).val();
        if (_val == '1') {
            var _removeCls = $(this).parents('.cart_qty');
            $(_removeCls).removeClass("open");
        }
        var currentVal = parseInt($qty.val());
        if (!isNaN(currentVal) && currentVal > 0) {
            $qty.val(currentVal - 1);
        }
    });


    /*=====================
     11. Product page Quantity Counter
     ==========================*/
    $('.collection-wrapper .qty-box .quantity-right-plus').on('click', function() {
        var $qty = $('.qty-box .input-number');
        var currentVal = parseInt($qty.val(), 10);
        if (!isNaN(currentVal)) {
            $qty.val(currentVal + 1);
        }
    });
    $('.collection-wrapper .qty-box .quantity-left-minus').on('click', function() {
        var $qty = $('.qty-box .input-number');
        var currentVal = parseInt($qty.val(), 10);
        if (!isNaN(currentVal) && currentVal > 1) {
            $qty.val(currentVal - 1);
        }
    });


    /*=====================
     12. Full slider
     ==========================*/
    if ($(window).width() > 767) {
        var $slider = $(".full-slider");
        $slider.
        on('init', function() {
            mouseWheel($slider);
        }).
        slick({
            dots: true,
            nav: false,
            vertical: true,
            infinite: false
        });

        function mouseWheel($slider) {
            $(window).on('wheel', {
                $slider: $slider
            }, mouseWheelHandler);
        }

        function mouseWheelHandler(event) {
            event.preventDefault();
            var $slider = event.data.$slider;
            var delta = event.originalEvent.deltaY;
            if (delta > 0) {
                $slider.slick('slickNext');
            } else {
                $slider.slick('slickPrev');
            }
        }
    } else {
        var $slider = $(".full-slider");
        $slider.
        on('init', function() {
            mouseWheel($slider);
        }).
        slick({
            dots: true,
            nav: false,
            vertical: false,
            infinite: false
        });

        function mouseWheel($slider) {
            $(window).on('wheel', {
                $slider: $slider
            }, mouseWheelHandler);
        }

        function mouseWheelHandler(event) {
            event.preventDefault();
            var $slider = event.data.$slider;
            var delta = event.originalEvent.deltaY;
            if (delta > 0) {
                $slider.slick('slickNext');
            } else {
                $slider.slick('slickPrev');
            }
        }
    }


    /*=====================
     13. slick slider
     ==========================*/
    $('.slide-1').slick({
        // autoplay: true,
        // autoplaySpeed: 5000
    });

    $('.slide-2').slick({
        infinite: true,
        slidesToShow: 2,
        slidesToScroll: 2,
        responsive: [{
            breakpoint: 991,
            settings: {
                slidesToShow: 1,
                slidesToScroll: 1
            }
        }]
    });

    $('.slide-3').slick({
        infinite: true,
        speed: 300,
        slidesToShow: 3,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 5000,
        responsive: [{
                breakpoint: 1200,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 767,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            }
        ]
    });

    $('.team-4').slick({
        infinite: true,
        speed: 300,
        slidesToShow: 4,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
        responsive: [{
                breakpoint: 1200,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 991,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 586,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                }
            }
        ]
    });

    $('.slide-4').slick({
        infinite: false,
        speed: 300,
        slidesToShow: 4,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 5000,
        responsive: [{
                breakpoint: 1200,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 991,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 586,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            }
        ]
    });

    $('.product-4').slick({
        infinite: true,
        speed: 300,
        slidesToShow: 4,
        slidesToScroll: 4,
        autoplay: true,
        autoplaySpeed: 3000,
        responsive: [{
                breakpoint: 1200,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 991,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            }
        ]
    });

    $('.tools-product-4').slick({
        infinite: true,
        speed: 300,
        slidesToShow: 4,
        slidesToScroll: 4,
        autoplay: true,
        autoplaySpeed: 5000,
        responsive: [{
                breakpoint: 1200,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 767,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            }
        ]
    });

    $('.product_4').slick({
        infinite: true,
        speed: 300,
        slidesToShow: 4,
        slidesToScroll: 4,
        autoplay: true,
        autoplaySpeed: 5000,
        responsive: [{
                breakpoint: 1430,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 1200,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 991,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            }
        ]
    });

    $('.product-3').slick({
        infinite: true,
        speed: 300,
        slidesToShow: 3,
        slidesToScroll: 3,
        autoplay: true,
        autoplaySpeed: 5000,
        responsive: [{
            breakpoint: 991,
            settings: {
                slidesToShow: 2,
                slidesToScroll: 2
            }
        }]
    });

    $('.slide-5').slick({
        dots: false,
        infinite: true,
        speed: 300,
        slidesToShow: 5,
        slidesToScroll: 5,
        responsive: [{
                breakpoint: 1367,
                settings: {
                    slidesToShow: 4,
                    slidesToScroll: 4
                }
            },
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3,
                    infinite: true
                }
            },
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            }
        ]
    });

    $('.slide-6').slick({
        dots: false,
        infinite: true,
        speed: 300,
        slidesToShow: 6,
        slidesToScroll: 6,
        responsive: [{
                breakpoint: 1367,
                settings: {
                    slidesToShow: 5,
                    slidesToScroll: 5,
                    infinite: true
                }
            },
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 4,
                    slidesToScroll: 4,
                    infinite: true
                }
            },
            {
                breakpoint: 767,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3,
                    infinite: true
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            }

        ]
    });

    $('.brand-6').slick({
        dots: false,
        infinite: true,
        speed: 300,
        slidesToShow: 6,
        slidesToScroll: 6,
        responsive: [{
                breakpoint: 1367,
                settings: {
                    slidesToShow: 5,
                    slidesToScroll: 5,
                    infinite: true
                }
            },
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 4,
                    slidesToScroll: 4,
                    infinite: true
                }
            },
            {
                breakpoint: 767,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3,
                    infinite: true
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 360,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            }

        ]
    });

    $('.product-slider-5').slick({
        dots: false,
        infinite: true,
        speed: 300,
        slidesToShow: 5,
        slidesToScroll: 5,
        responsive: [{
                breakpoint: 1200,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 991,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            }
        ]
    });

    $('.product-5').slick({
        dots: false,
        infinite: true,
        speed: 300,
        slidesToShow: 5,
        slidesToScroll: 5,
        responsive: [{
                breakpoint: 1367,
                settings: {
                    slidesToShow: 4,
                    slidesToScroll: 4
                }
            },
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3,
                    infinite: true
                }
            },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            }
        ]
    });

    $('.slide-7').slick({
        dots: false,
        infinite: true,
        speed: 300,
        slidesToShow: 7,
        slidesToScroll: 7,
        responsive: [{
                breakpoint: 1367,
                settings: {
                    slidesToShow: 6,
                    slidesToScroll: 6
                }
            },
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 5,
                    slidesToScroll: 5,
                    infinite: true
                }
            },
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 4,
                    slidesToScroll: 4
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3
                }
            }
            // You can unslick at a given breakpoint now by adding:
            // settings: "unslick"
            // instead of a settings object
        ]
    });

    $('.slide-8').slick({
        infinite: true,
        slidesToShow: 8,
        slidesToScroll: 8,
        responsive: [

            {
                breakpoint: 1200,
                settings: {
                    slidesToShow: 6,
                    slidesToScroll: 6
                }
            }
        ]
    });

    $('.center').slick({
        centerMode: true,
        centerPadding: '60px',
        slidesToShow: 3,
        responsive: [{
                breakpoint: 768,
                settings: {
                    arrows: false,
                    centerMode: true,
                    centerPadding: '40px',
                    slidesToShow: 3
                }
            },
            {
                breakpoint: 480,
                settings: {
                    arrows: false,
                    centerMode: true,
                    centerPadding: '40px',
                    slidesToShow: 1
                }
            }
        ]
    });

    $('.product-slick').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: true,
        fade: true,
        asNavFor: '.slider-nav'
    });

    $('.slider-nav').slick({
        vertical: false,
        slidesToShow: 3,
        slidesToScroll: 1,
        asNavFor: '.product-slick',
        arrows: false,
        dots: false,
        focusOnSelect: true
    });

    $('.product-right-slick').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: true,
        fade: true,
        asNavFor: '.slider-right-nav'
    });
    if ($(window).width() > 575) {
        $('.slider-right-nav').slick({
            vertical: true,
            verticalSwiping: true,
            slidesToShow: 3,
            slidesToScroll: 1,
            asNavFor: '.product-right-slick',
            arrows: false,
            infinite: true,
            dots: false,
            centerMode: false,
            focusOnSelect: true
        });
    } else {
        $('.slider-right-nav').slick({
            vertical: false,
            verticalSwiping: false,
            slidesToShow: 3,
            slidesToScroll: 1,
            asNavFor: '.product-right-slick',
            arrows: false,
            infinite: true,
            centerMode: false,
            dots: false,
            focusOnSelect: true,
            responsive: [{
                breakpoint: 576,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 1
                }
            }]
        });
    }


    /*=====================
     14.Header z-index js
     ==========================*/
    if ($(window).width() < 1199) {
        $('.header-2 .navbar .sidebar-bar, .header-2 .navbar .sidebar-back, .header-2 .mobile-search img').on('click', function() {
            if ($('#mySidenav').hasClass('open-side')) {
                $('.header-2 #main-nav .toggle-nav').css('z-index', '99');
            } else {
                $('.header-2 #main-nav .toggle-nav').css('z-index', '1');
            }
        });
        $('.sidebar-overlay').on('click', function() {
            $('.header-2 #main-nav .toggle-nav').css('z-index', '99');
        });
        $('.header-2 #search-overlay .closebtn').on('click', function() {
            $('.header-2 #main-nav .toggle-nav').css('z-index', '99');
        });
        $('.layout3-menu .mobile-search .ti-search, .header-2 .mobile-search .ti-search').on('click', function() {
            $('.layout3-menu #main-nav .toggle-nav, .header-2 #main-nav .toggle-nav').css('z-index', '1');
        });
    }


    /*=====================
     15.Tab js
     ==========================*/
    $("#tab-1").css("display", "Block");
    $(".default").css("display", "Block");
    $(".tabs li a").on('click', function() {
        event.preventDefault();
        $('.tab_product_slider').slick('unslick');
        $('.product-4').slick('unslick');
        $(this).parent().parent().find("li").removeClass("current");
        $(this).parent().addClass("current");
        var currunt_href = $(this).attr("href");
        $('#' + currunt_href).show();
        $(this).parent().parent().parent().find(".tab-content").not('#' + currunt_href).css("display", "none");
        $(".product-4").slick({
            arrows: true,
            dots: false,
            infinite: false,
            speed: 300,
            slidesToShow: 4,
            slidesToScroll: 1,
            responsive: [{
                    breakpoint: 1200,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 991,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                },
                {
                    breakpoint: 420,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ]
        });
    });
    $(".tabs li a").on('click', function() {
        event.preventDefault();
        $('.tab_product_slider').slick('unslick');
        $('.product-5').slick('unslick');
        $(this).parent().parent().find("li").removeClass("current");
        $(this).parent().addClass("current");
        var currunt_href = $(this).attr("href");
        $('#' + currunt_href).show();
        $(this).parent().parent().parent().find(".tab-content").not('#' + currunt_href).css("display", "none");
        // var slider_class = $(this).parent().parent().parent().find(".tab-content").children().attr("class").split(' ').pop();
        $(".product-5").slick({
            arrows: true,
            dots: false,
            infinite: false,
            speed: 300,
            slidesToShow: 5,
            slidesToScroll: 1,
            responsive: [{
                    breakpoint: 1367,
                    settings: {
                        slidesToShow: 4,
                        slidesToScroll: 4
                    }
                },
                {
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3,
                        infinite: true
                    }
                },
                {
                    breakpoint: 768,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                },
                {
                    breakpoint: 576,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ]

        });
    });



    $("#tab-1").css("display", "Block");
    $(".default").css("display", "Block");
    $(".tabs li a").on('click', function() {
        event.preventDefault();
        $('.tab_product_slider').slick('unslick');
        $('.product-3').slick('unslick');
        $(this).parent().parent().find("li").removeClass("current");
        $(this).parent().addClass("current");
        var currunt_href = $(this).attr("href");
        $('#' + currunt_href).show();
        $(this).parent().parent().parent().parent().find(".tab-content").not('#' + currunt_href).css("display", "none");
        $(".product-3").slick({
            arrows: true,
            dots: false,
            infinite: false,
            speed: 300,
            slidesToShow: 3,
            slidesToScroll: 1,
            responsive: [{
                breakpoint: 991,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            }]
        });
    });


    /*=====================
     16 .category page
     ==========================*/
    $('.collapse-block-title').on('click', function(e) {
        e.preventDefault;
        var speed = 300;
        var thisItem = $(this).parent(),
            nextLevel = $(this).next('.collection-collapse-block-content');
        if (thisItem.hasClass('open')) {
            thisItem.removeClass('open');
            nextLevel.slideUp(speed);
        } else {
            thisItem.addClass('open');
            nextLevel.slideDown(speed);
        }
    });
    $('.color-selector ul li').on('click', function(e) {
        $(".color-selector ul li").removeClass("active");
        $(this).addClass("active");
    });
    //list layout view
    $('.list-layout-view').on('click', function(e) {
        $('.collection-grid-view').css('opacity', '0');
        $(".product-wrapper-grid").css("opacity", "0.2");
        $('.shop-cart-ajax-loader').css("display", "block");
        $('.product-wrapper-grid').addClass("list-view");
        $(".product-wrapper-grid").children().children().removeClass();
        $(".product-wrapper-grid").children().children().addClass("col-lg-12");
        setTimeout(function() {
            $(".product-wrapper-grid").css("opacity", "1");
            $('.shop-cart-ajax-loader').css("display", "none");
        }, 500);
    });
    //grid layout view
    $('.grid-layout-view').on('click', function(e) {
        $('.collection-grid-view').css('opacity', '1');
        $('.product-wrapper-grid').removeClass("list-view");
        $(".product-wrapper-grid").children().children().removeClass();
        $(".product-wrapper-grid").children().children().addClass("col-lg-3");

    });
    $('.product-2-layout-view').on('click', function(e) {
        if ($('.product-wrapper-grid').hasClass("list-view")) {} else {
            $(".product-wrapper-grid").children().children().removeClass();
            $(".product-wrapper-grid").children().children().addClass("col-lg-6");
        }
    });
    $('.product-3-layout-view').on('click', function(e) {
        if ($('.product-wrapper-grid').hasClass("list-view")) {} else {
            $(".product-wrapper-grid").children().children().removeClass();
            $(".product-wrapper-grid").children().children().addClass("col-lg-4");
        }
    });
    $('.product-4-layout-view').on('click', function(e) {
        if ($('.product-wrapper-grid').hasClass("list-view")) {} else {
            $(".product-wrapper-grid").children().children().removeClass();
            $(".product-wrapper-grid").children().children().addClass("col-lg-3");
        }
    });
    $('.product-6-layout-view').on('click', function(e) {
        if ($('.product-wrapper-grid').hasClass("list-view")) {} else {
            $(".product-wrapper-grid").children().children().removeClass();
            $(".product-wrapper-grid").children().children().addClass("col-lg-2");
        }
    });


    /*=====================
     17.filter sidebar js
     ==========================*/
    $('.sidebar-popup').on('click', function(e) {
        $('.open-popup').toggleClass('open');
        $('.collection-filter').css("left", "-15px");
    });
    $('.filter-btn').on('click', function(e) {
        $('.collection-filter').css("left", "-15px");
    });
    $('.filter-back').on('click', function(e) {
        $('.collection-filter').css("left", "-365px");
        $('.sidebar-popup').trigger('click');
    });

    $('.account-sidebar').on('click', function(e) {
        $('.dashboard-left').css("left", "0");
    });
    $('.filter-back').on('click', function(e) {
        $('.dashboard-left').css("left", "-365px");
    });

    $(function() {
        $(".product-load-more .col-grid-box").slice(0, 8).show();
        $(".loadMore").on('click', function(e) {
            e.preventDefault();
            $(".product-load-more .col-grid-box:hidden").slice(0, 4).slideDown();
            if ($(".product-load-more .col-grid-box:hidden").length === 0) {
                $(".loadMore").text('no more products');
            }
        });
    });


    /*=====================
     18.Add to cart
     ==========================*/
    $('.product-box button .ti-shopping-cart').on('click', function() {
        $.notify({
            icon: 'fa fa-check',
            title: 'Success!',
            message: 'Item Successfully added to your cart'
        }, {
            element: 'body',
            position: null,
            type: "success",
            allow_dismiss: true,
            newest_on_top: false,
            showProgressbar: true,
            placement: {
                from: "top",
                align: "right"
            },
            offset: 20,
            spacing: 10,
            z_index: 1031,
            delay: 5000,
            animate: {
                enter: 'animated fadeInDown',
                exit: 'animated fadeOutUp'
            },
            icon_type: 'class',
            template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
                '<button type="button" aria-hidden="true" class="close" data-notify="dismiss">×</button>' +
                '<span data-notify="icon"></span> ' +
                '<span data-notify="title">{1}</span> ' +
                '<span data-notify="message">{2}</span>' +
                '<div class="progress" data-notify="progressbar">' +
                '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
                '</div>' +
                '<a href="{3}" target="{4}" data-notify="url"></a>' +
                '</div>'
        });
    });


    /*=====================
     19.Add to wishlist
     ==========================*/
    $('.product-box a .ti-heart , .product-box a .fa-heart').on('click', function() {

        $.notify({
            icon: 'fa fa-check',
            title: 'Success!',
            message: 'Item Successfully added in wishlist'
        }, {
            element: 'body',
            position: null,
            type: "info",
            allow_dismiss: true,
            newest_on_top: false,
            showProgressbar: true,
            placement: {
                from: "top",
                align: "right"
            },
            offset: 20,
            spacing: 10,
            z_index: 1031,
            delay: 5000,
            animate: {
                enter: 'animated fadeInDown',
                exit: 'animated fadeOutUp'
            },
            icon_type: 'class',
            template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
                '<button type="button" aria-hidden="true" class="close" data-notify="dismiss">×</button>' +
                '<span data-notify="icon"></span> ' +
                '<span data-notify="title">{1}</span> ' +
                '<span data-notify="message">{2}</span>' +
                '<div class="progress" data-notify="progressbar">' +
                '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
                '</div>' +
                '<a href="{3}" target="{4}" data-notify="url"></a>' +
                '</div>'
        });
    });


    /*=====================
     20. Color Picker
     ==========================*/
    var color_picker1 = document.getElementById("ColorPicker1").value;
    document.getElementById("ColorPicker1").onchange = function() {
        color_picker1 = this.value;
        document.documentElement.style.setProperty('--theme-deafult', color_picker1);
    };


})(jQuery);


/*------------------------------
 21. RTL & Dark Light
 -------------------------------*/
$("#ltr_btn").click(function() {
    $('body').addClass('ltr');
    $('body').removeClass('rtl');
});
$("#rtl_btn").click(function() {
    $('body').addClass('rtl');
    $('body').removeClass('ltr');
});
$(".setting_buttons li").click(function() {
    $(this).addClass('active').siblings().removeClass('active');
});
$(".color-box li").click(function() {
    $(this).addClass('active').siblings().removeClass('active');
});

// dark & light
(function() {
    $('<div class="sidebar-btn dark-light-btn">' +
        '<div class="dark-light">' +
        '<div class="theme-layout-version">Dark' +
        '</div>' +
        '</div>' +
        '</div>').appendTo($('body'));
})();

var body_event = $("body");
body_event.on("click", ".theme-layout-version", function() {
    $(this).toggleClass('dark');
    $('body').removeClass('dark');
    if ($('.theme-layout-version').hasClass('dark')) {
        $('.theme-layout-version').text('Light');
        $('body').addClass('dark');
    } else {
        $('#theme-dark').remove();
        $('.theme-layout-version').text('Dark');
    }

    return false;
});


/*=====================
 22. Menu js
 ==========================*/
function openNav() {
    document.getElementById("mySidenav").classList.add('open-side');
}

function closeNav() {
    document.getElementById("mySidenav").classList.remove('open-side');
}
$(function() {
    $('#main-menu').smartmenus({
        subMenusSubOffsetX: 1,
        subMenusSubOffsetY: -8
    });
    $('#sub-menu').smartmenus({
        subMenusSubOffsetX: 1,
        subMenusSubOffsetY: -8
    });
});


/*=====================
 23. theme-setting
 ==========================*/
function openSetting() {
    document.getElementById("setting_box").classList.add('open-setting');
    document.getElementById("setting-icon").classList.add('open-icon');
}

function closeSetting() {
    document.getElementById("setting_box").classList.remove('open-setting');
    document.getElementById("setting-icon").classList.remove('open-icon');
}
jQuery('.setting-title h4').append('<span class="according-menu"></span>');
jQuery('.setting-title').on('click', function() {
    jQuery('.setting-title').removeClass('active');
    jQuery('.setting-contant').slideUp('normal');
    if (jQuery(this).next().is(':hidden') == true) {
        jQuery(this).addClass('active');
        jQuery(this).next().slideDown('normal');
    }
});
jQuery('.setting-contant').hide();


/*=====================
 24. add to cart sidebar js
 ==========================*/
function openCart() {
    document.getElementById("cart_side").classList.add('open-side');
}

function closeCart() {
    document.getElementById("cart_side").classList.remove('open-side');
}


/*=====================
 25.Tooltip
 ==========================*/
$(window).on('load', function() {
    $('[data-toggle="tooltip"]').tooltip()
});