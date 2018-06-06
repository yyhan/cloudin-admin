<#compress >
<#-- 必须引入layout宏定义文件 -->
    <#import "../_common/layout_admin.ftl" as layout >

<#-- 定义title -->
    <#assign title="index | echarts" in layout />

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
    <div class="panel panel-default">
        <div class="panel-body">
            <div id="main" style="width: 600px;height:400px;"></div>
        </div>
    </div>
    </#assign>

<#-- 定义pageScript变量 -->
    <#assign pageScript in layout>
    <script type="text/javascript">

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data: ['销量']
            },
            xAxis: {
                data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>

    </#assign>

<#-- 使用layout中定义的html宏 -->
    <@layout.html/>
</#compress>



