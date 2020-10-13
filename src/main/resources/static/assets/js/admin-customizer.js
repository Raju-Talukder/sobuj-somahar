// RTl & Ltr
$('<div class="btn-light custom-theme">RTL</div>').appendTo($('body'));
(function() {
})();
//live customizer js
$(document).ready(function() {

    $('.custom-theme').on('click', function() {
      $("html").attr("dir", "");
      $(this).toggleClass('rtl');
        if($('.custom-theme').hasClass('rtl')){
            $('.custom-theme').text('LTR');
            $('body').addClass('rtl');
            $("html").attr("dir", "rtl");
        }else{
          $('.custom-theme').text('RTL');
          $('body').removeClass('rtl');
          $("html").attr("dir", "");
        }
    });
});
