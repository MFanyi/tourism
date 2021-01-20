$(document).ready(function () {
    $.get("user/loginUser", function (data) {
        data = $.parseJSON(data);
        if (data.code == 0) {
            var html = "<ul class=\"custom-flex\">\n" +
                "                <li>\n" +
                "                    <a href=\"\" class=\"text-custom-white\" id=\"username\">欢迎您,携程用户</a>\n" +
                "                </li>\n" +
                "                <li style=width:50px;height:50px;border-radius:5px>\n" +
                "                    <img src=\"\" class=img-circle alt=\"头像\" id=\"user-img\"/>\n" +
                "                </li>\n" +
                "                <li>\n" +
                "                    <a href=\"\">退出登录</a>\n" +
                "                </li>\n" +
                "            </ul>";
            $("#user").html(html);
            $("#userLogin").show();
            $("#username").text("欢迎您," + data.userName);
            $("#user-img").attr("src",data.userImg);
        } else {
            var html = "<ul class=\"custom-flex\">\n" +
                "                            <li>\n" +
                "                                <a href=\"user/login.html\" class=\"text-custom-white\">登录</a>\n" +
                "                            </li>\n" +
                "                            <li>\n" +
                "                                <a href=\"user/register.html\" class=\"text-custom-white\">注册</a>\n" +
                "                            </li>\n" +
                "                        </ul>";
            $("#user").html(html);
        }
    });
});