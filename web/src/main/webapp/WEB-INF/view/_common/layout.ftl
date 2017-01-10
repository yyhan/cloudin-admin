<#-- 宏：html -->
<#-- title：页面标题（浏览器标题） -->
<#-- pageHead：html附加head内容，一般用于设置额外的css代码 -->
<#-- pageHeader：页面标题（在页面上显示的标题） -->
<#-- pageBody：页面内容 -->
<#-- pageScript：页面附加脚本，一般用于设置额外的js代码 -->
<#macro html >
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title!"index"}</title>
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="${staticRoot}/css/admin.css" rel="stylesheet">
    <#if pageHead??>
    ${pageHead}
    </#if>
</head>
<body>
    <#include "header.ftl" parse=true encoding="UTF-8" >
<div class="container-fluid">
    <div class="page-sidebar-wrapper">
        <#include "sider.ftl"  parse=true encoding="UTF-8">
    </div>
    <div class="page-content-wrapper">
        <div class="page-content">
            <#if pageHeader??>
            ${pageHeader}
            </#if>
            <article class="page-body">
                <#if pageBody??>
                ${pageBody}
                <#else>
                    <p>this is a empty page.</p>
                </#if>
            </article>
            <#include "footer.ftl" parse=false encoding="UTF-8">
        </div>
    </div>
</div>
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var webRoot = "${webRoot}";
    var webStaticRoot = "${staticRoot}";
    $(".page-sidebar-menu").find("a").on("click", function(e) {
        $(this).parent().siblings(".active").find(".sub-menu").collapse('hide');
        $(this).parent().addClass("active");
        $(this).siblings().filter(".sub-menu").collapse('toggle');
    });

    $(".page-sidebar-menu").find(".collapse").on("hidden.bs.collapse", function(e) {
        $(this).parent().removeClass("active");
    });
</script>
    <#if pageScript??>
    ${pageScript}
    </#if>
</body>
</html>
</#macro>
