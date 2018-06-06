<#compress >
<#-- 必须引入layout宏定义文件 -->
    <#import "../_common/layout.ftl" as layout >

<#-- 定义title -->
    <#assign title="line | echarts" in layout />

    <#assign pageHead in layout>
    <script src="//cdn.bootcss.com/echarts/3.3.2/echarts.min.js"></script>
    </#assign>

<#-- 定义pageHeader变量 -->
    <#assign pageHeader in layout>
    <header class="page-header">
        <h1>Example page header
            <small>Subtext for header</small>
        </h1>
    </header>
    </#assign>

<#-- 定义pageBody变量 -->
    <#assign pageBody in layout>
    <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-body">
                <div id="main" style="width: 600px;height:400px;"></div>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-body">
                <div id="main" style="width: 600px;height:400px;"></div>
            </div>
        </div>
    </div>
    </#assign>

<#-- 定义pageScript变量 -->
    <#assign pageScript in layout>
    <script src="${staticRoot}/js/admin/index.js"></script>
    </#assign>

<#-- 使用layout中定义的html宏 -->
    <@layout.html/>
</#compress>



