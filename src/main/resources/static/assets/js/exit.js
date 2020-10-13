/*=====================
 Exit Js
 ==========================*/
$(function() {
    $.exitIntent('enable');
    $(document).bind('exitintent', function() {
        if(typeof(Storage) !== "undefined") {
            if(sessionStorage.exit_popup == 'true'){
            }
            else{
                sessionStorage.exit_popup = 'true';
                setTimeout(function () {
                    if( $.cookie("exit-popup") == 'hide_exit_popup' ){
                    }
                    else{
                        $("#exit_popup").modal('show');
                    }
                }, 100);
            }
        }
    });
    $("#exit_popup a").bind('click', function() {
        $("#exit_popup").hide();
        return false;
    });
});