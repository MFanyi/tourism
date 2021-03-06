$(function () {
    $('#loginForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    }, stringLength: {
                        min: 5,
                        max: 12,
                        message: '用户名长度必须在5到12位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }, stringLength: {
                        min: 6,
                        max: 18,
                        message: '密码长度必须在6到18位之间'
                    }
                }
            }
        }
    });
});

$("#register").on("click", function () {
    window.location.href = "register.html"
});

$("#login").click(function () {
    $("#loginForm").ajaxSubmit(function (data) {
        data = $.parseJSON(data);
        if (data.code == 0) {
            alert("登陆成功");
            window.location.href = "../index.html";
        } else {
            alert(data.msg);
        }
        return false;
    });
});


//Ajax访问方式
// $("#login").on("click", function () {
//     var username = $("#username").val();
//     var password = $("#password").val();
//     var remember = $("#remember").val();
//     var param = {
//         'username': username,
//         'password': password,
//         'remember': remember
//     };
//     $.post("login", param, function (data) {
//         data = $.parseJSON(data);
//         if (data.code == 0) {
//             alert("登陆成功");
//             window.location.href = "../index.html?pageNum=1"
//         } else {
//             alert(data.msg);
//         }
//     });
// });
