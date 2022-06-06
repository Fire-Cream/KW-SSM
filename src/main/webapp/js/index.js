$(document).ready(function () {
    //定义标记
    var isOk = false;
    $("input#rusername").blur(function () {
        var username = $(this).val();
        $.post("/user/checkUser",
            {username: username},
            function (data) {
                console.log(data);
                if (data.code == "0") {
                    isOk = false;
                    $("#rs").css("display", "inline");
                } else {
                    isOk = true;
                    $("#rs").css("display", "none");
                }
            });
    });

    $("#registerForm").submit(function () {
        return isOk;
    })
});


//点击更换验证码的方法
function changeCode() {
    //获取图片对象
    let img = document.querySelector("#showCode");
    //创建时间对象
    let date = new Date();
    //设置图片的src属性
    img.src = "/HappyCaptcha?d=" + date.getTime();
}