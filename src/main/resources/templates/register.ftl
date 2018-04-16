<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/login-page.min.css">
</head>
<body class="login-page">
<div class="login-avatar" style="background: url(/img/default.png) no-repeat center center;" onmouseover="this.style.cursor='pointer'" onclick="document.location='/'">
</div>
<div class="login-form">
    <div class="login-content">
        <form name="loginForm">
            <div class="form-group">
                <div class="btn btn-default btn-block btn-login" id="user-type">
                    <i class="fa fa-edit"></i>
                    学生用户
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-user"></i>
                    </div>
                    <input type="text" class="form-control" name="name" id="name" placeholder="用户名" autocomplete="off" />
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-key"></i>
                    </div>
                    <input type="password" class="form-control" name="passBefore" id="passBefore" placeholder="密码" autocomplete="off" />

                    <input type="hidden" name="password" id="password"/>
                    <input type="hidden" name="role" id="role"/>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-key"></i>
                    </div>
                    <input type="password" class="form-control" name="passRepeat" id="passRepeat" placeholder="重复密码" autocomplete="off" />
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block btn-login" id="login-button">
                    <i class="fa fa-sign-in"></i>
                    注册
                </button>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="/js/md5.min.js"></script>
<script type="text/javascript">
    $("#user-type").click(function(){
        if ("学生用户" == $(this).text().trim()){
            $(this).text("教师用户");
        }else if("教师用户" == $(this).text().trim()) {
            $(this).text("学生用户");
        }
    });

    var getType=function () {
        if ("学生用户" == $("#user-type").text().trim()){
            return 1;
        }if("教师用户" == $("#user-type").text().trim()) {
            return 2;
        }
    };
    $("#login-button").bind("click",
            function() {
                var b, a = document.forms[0];
                a.action = "/register.do",
                        b = document.loginForm.passBefore.value,
                        document.loginForm.password.value = md5(b),
                        document.loginForm.role.value=getType();
                a.method = "post",
                        a.submit()
            })
</script>
</body>
</html>