/**
 * Created by GZR on 2017/7/6.
 */
var login;
$().ready(function () {
    window.changeImg=function(){
        console.log("changeImg");
        $('#codeImg').attr("src", "/common/imgCode?abc=" + new Date().getTime());
    }
    window.submitFun=function(){
        var code = $('#imgCode').val();
        $.get("/login/checkCode?code=" + code, function (data, status) {
            console.log("data:" + data + "status:" + status);
            if (status == "success" && data == "success") {
                /*document.getElementById("loginAction").submit();*/
                $('#adminForm').submit();
            } else {
                //changePhoneImage();
                layer.open({
                    title: "错误提示",
                    content:"验证码填写错误"
                });
            }
        });
    }
});