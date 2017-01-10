<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container-fluid">

    <div class="container-fluid" style="margin-top: 100px;">
        <div class="row">
            <div class="col-md-offset-3 col-md-6 col-lg-offset-4 col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3>${appName}网站管理后台</h3>
                    </div>
                    <div class="panel-body">
                        <form class="" onsubmit="return false;">
                            <div class="form-group">
                                <span id="logLabel" class="label "></span>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span>
                                    </div>
                                    <input class="form-control" id="account" type="text" placeholder="请输入您的账号">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span>
                                    </div>
                                    <input class="form-control" id="password" type="password" placeholder="请输入您的密码">
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" id="loginBtn" class="btn btn-primary btn-block"
                                        data-loading-text="登录验证中...">登录
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<#--<script src="${pageContext.request.contextPath }/static/lib/json/json2.min.js"></script>-->
    <script type="text/javascript">
        var webRoot = "${webRoot}";
        var webStaticRoot = "${staticRoot}";
        <#noparse>

        $("#loginBtn").click(function (e) {
            e.preventDefault();
            $("#logLabel").removeClass('label-danger');
            if ($("#account").val() == "") {
                $("#logLabel").text('请输入用户名').addClass('label-danger');
                return false;
            }
            if ($("#password").val() == "") {
                $("#logLabel").text('请输入密码').addClass('label-danger');
                return false;
            }
            var $btn = $(this).button('loading');
            $.post(window.webRoot + "/signin-process", {
                username: $("#account").val(),
                password: $("#password").val()
            }, function (res) {
                $($btn).button('reset');
                if (res.success) {
                    location.href = "/";
                } else {
                    $("#logLabel").addClass('label-danger');
                    $("#logLabel").text(res.message);
                }
            }, "json");
        });
        </#noparse>
    </script>
</body>

</html>