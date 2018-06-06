<#compress >
<#-- 必须引入layout宏定义文件 -->
    <#import "_common/layout_default.ftl" as layout >

<#-- 定义title -->
    <#assign title="good" in layout />

<#-- 定义pageHeader变量 -->
    <#assign pageHeader in layout>
    <header class="page-header">
        <h1>403</h1>
    </header>
    </#assign>

<#-- 定义pageBody变量 -->
    <#assign pageBody in layout>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="alert alert-warning">403,无权访问该页面</div>
                    </div>
                </div>
            </div>
        </div>
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



