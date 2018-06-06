<#compress >
<#-- 必须引入layout宏定义文件 -->
    <#import "_common/layout_default.ftl" as layout >

<#-- 定义title -->
    <#assign title="登录" in layout />

<#-- 定义pageHeader变量 -->
    <#assign pageHeader in layout>
    <header class="page-header">
        <h1>Welcome</h1>
    </header>
    </#assign>

<#-- 定义pageBody变量 -->
    <#assign pageBody in layout>
<div class="login-box">
    <div class="login-logo">
        <a href="/index.htm"><b>Cloudin Admin</b></a>
    </div>
    <div class="login-box-body">
        <#if errMsg??>
            <p class="login-box-msg">${errMsg}</p>
        </#if>
        <form action="/ajax/signin.htm" method="post">
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" name="username" class="form-control" placeholder="账号" value="root">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" name="password" class="form-control" placeholder="密码" value="123456">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
    </#assign>

<#-- 定义pageScript变量 -->
    <#assign pageScript in layout>
    <#--<script src="${staticRoot!}/js/admin/index.js"></script>-->
    </#assign>

<#-- 使用layout中定义的html宏 -->
    <@layout.html/>
</#compress>



