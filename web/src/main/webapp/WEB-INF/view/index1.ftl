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
    <link href="../static/admin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<#include "/WEB-INF/view/_common/header.ftl" >

<div class="container-fluid">

    <div class="page-sidebar-wrapper">
    <#include "/WEB-INF/view/_common/sider.ftl" >
    </div>

    <div class="page-content-wrapper">
        <div class="page-content">
            <header class="page-header">
                <h1>Example page header
                    <small>Subtext for header</small>
                </h1>
            </header>
            <article class="page-body">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div id="main" style="width: 600px;height:400px;"></div>
                    </div>
                </div>
            </article>
        <#include "/WEB-INF/view/_common/footer.ftl" >
        </div>
    </div>

    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="//cdn.bootcss.com/echarts/3.3.2/echarts.min.js"></script>
    <script src="../static/js/admin/index.js"></script>
</body>

</html>