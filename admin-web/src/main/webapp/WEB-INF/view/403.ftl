<#compress >
<#-- 必须引入layout宏定义文件 -->
    <#import "_common/layout_admin.ftl" as layout >

<#-- 定义title -->
    <#assign title="403" in layout />

<#-- 定义pageHeader变量 -->
<#--<#assign pageHeader in layout>-->
<#--<header class="page-header">-->
<#--<h1>Welcome</h1>-->
<#--</header>-->
<#--</#assign>-->

<#-- 定义pageBody变量 -->
    <#assign pageBody in layout>
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="alert alert-warning">对不起，您无权访问该页面</div>
            </div>
        </div>
    </#assign>

<#-- 定义pageScript变量 -->
    <#assign pageScript in layout>

    </#assign>

<#-- 使用layout中定义的html宏 -->
    <@layout.html/>
</#compress>



