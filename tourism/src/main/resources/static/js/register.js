$(function () {
    $('#registerForm').bootstrapValidator({
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
            },
            truePassword: {
                validators: {
                    notEmpty: {
                        message: '请确认密码'
                    }, identical: {
                        field: 'password',
                        message: '两次密码输入不一致'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '请输入正确的邮箱格式'
                    }
                }
            },
            name: {
                validators: {
                    notEmpty: {
                        message: '名字不能为空'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: '手机号不能为空'
                    }, digits: {
                        message: '手机号只能包含数字。'
                    }
                }
            },
            birthday: {
                validators: {
                    notEmpty: {
                        message: '生日不能为空'
                    }, date: {
                        format: 'YYYY/MM/DD',
                        message: '日期无效'
                    }
                }
            },
            gender: {
                validators: {
                    notEmpty: {
                        message: '性别不能为空'
                    }
                }
            },
        }
    });
});


$(".form_datetime").datetimepicker({
    minView: "month",
    language: 'zh-CN',
    format: 'yyyy-mm-dd',
    todayBtn: 1,
    autoclose: 1,
});
$('#birthday').datetimepicker();

$("#register").click(function () {
    $("#registerForm").ajaxSubmit(function (data) {
        data = $.parseJSON(data);
        if (data.code == 0) {
            alert(data.msg);
            window.location.href = "register_success.html";
        } else {
            alert(data.msg);
        }
    });
    return false;
});


//Ajax方式注册
// $('#register').on("click", function () {
//     var username = $("#username").val();
//     var password = $("#password").val();
//     var email = $("#email").val();
//     var name = $("#name").val();
//     var phone = $("#phone").val();
//     var birthday = $("#birthday").val();
//     var gender = $("input[type='radio']:checked").val();
//     var param = {
//         'username': username,
//         'password': password,
//         'email': email,
//         'name': name,
//         'phone': phone,
//         'birthday': birthday,
//         'gender': gender
//     };
//     $.post("register", param, function (data) {
//         data = $.parseJSON(data);
//         if (data.code == 0) {
//             alert(data.msg);
//             window.location.href = "register_success.html"
//         } else {
//             alert(data.msg);
//         }
//     });
// });
