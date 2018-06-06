<#compress >
<#-- 必须引入layout宏定义文件 -->
    <#import "../_common/layout_admin.ftl" as layout >

<#-- 定义title -->
    <#assign title="首页" in layout />

<#-- 定义 pageHead 变量 -->
    <#assign pageHead in layout>
    <link rel="stylesheet" href="/static/plugin/datatables-1.10.15/css/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet" href="/static/plugin/bootstrap-daterangepicker/daterangepicker.css"/>
    </#assign>

<#-- 定义pageBody变量 -->
    <#assign pageBody in layout>
        <div class="panel panel-default">
            <div class="panel-body">
                <table id="dtTable" class="table table-striped table-hover table-condensed table-bordered">
                </table>
            </div>
        </div>
    </#assign>

<#-- 定义pageScript变量 -->
    <#assign pageScript in layout>
    <script src="/static/plugin/jquery.blockUI.js"></script>
    <script src="/static/plugin/datatables-1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="/static/plugin/datatables-1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript">
        var dtTableDom = jQuery("#dtTable");
        var dtTable = dtTableDom.DataTable({
            serverSide: true, // 开启服务端处理
            stateSave: false, // 关闭状态保存
            dom: '<"row" <"col-md-12" t>><"row" <"col-md-6" i><"col-md-6" p>>',
            pageLength: 10, // 每页容量
            ordering: false, // 是否开启排序，默认true
            deferLoading: 0,
            ajax: function (params, callback, obj) {
                var reqParams = {
                    draw: params.draw,
                    length: params.length,
                    start: params.start
                };
                $.post("/ajax/permission/list.htm", reqParams, function (res, status, xhr) {
                    if (res.success) {
                        callback(res);
                    } else {
                        callback({
                            data: [],
                            draw: params.draw,
                            recordsFiltered: 0,
                            recordsTotal: 0
                        });
                        alert(res.message);
                    }
                }, 'json');
            },
            order: [
                [0, 'desc']
            ],
            // 列绑定，通过data和数据里的属性绑定
            columns: [
                {data: "id", title: "id"},
                {data: "name", title: "名称"},
                {data: "content", title: "内容"},
                {data: "icon", title: "图标"},
                {data: "category", title: "分类"},
                {data: "order", title: "排序"},
                {data: "parentId", title: "父级权限Id"},
                {data: "extInfo", title: "扩展信息"}
            ],
            language: {
                emptyTable: "暂无数据...",
                info: "_START_ 到 _END_, 总共 _TOTAL_ 条记录",
                infoEmpty: "0 到 0 总共 0 条记录",
                infoFiltered: "(总共 _MAX_ 条记录)",
                infoPostFix: "",
                thousands: ".",
                lengthMenu: "_MENU_  条 / 每页",
                loadingRecords: "正在加载中...",
                processing: "正在加载中...",
                search: "搜索",
                zeroRecords: "未找到任何相关记录.",
                paginate: {
                    first: "首页",
                    previous: "上一页",
                    next: "下一页",
                    last: "最后一页"
                }
            },
            initComplete: function (settings, json) {
                // 表格初始化完成时回调
            },
            drawCallback: function (settings) {
                // 表格绘制完成时回调
                // dtTableDom.unblock();
            }
        });
        $("#queryBtn").on("click", function () {
            dtTable.draw();
        });
        // 如果配置了 deferLoading，这里需要根据需要手动加载一次数据。
        dtTable.draw();//手动渲染数据
    </script>
    </#assign>

<#-- 使用layout中定义的html宏 -->
    <@layout.html/>
</#compress>



