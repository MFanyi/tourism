$(document).ready(function () {
    $.get("user/loginUser", function (data) {
        data = $.parseJSON(data);
        if (data.code == 0) {
            $("#user").hide();
            $("#userLogin").show();
            $("#username").text("欢迎您," + data.userName);
            $("#user-img").attr("src",data.userImg);
        } else {
            $("#user").show();
            $("#userLogin").hide();
        }
    });
});