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
        <div class="box box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">权限配置</h3>
            </div>
            <div class="box-body">
                <form class="form-horizontal" onsubmit="return false;">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label for="qName" class="col-sm-3 control-label">名称</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="qName">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="col-md-6">
                                <button id="queryBtn" class="btn btn-primary btn-block"><i class="fa fa-search"></i> 查询
                                </button>
                            </div>
                            <div class="col-md-6">
                                <button id="addBtn" class="btn btn-success btn-block"><i class="fa fa-plus"></i> 添加
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="box box-solid">
            <div class="box-body" id="dtTableContainer">
                <table id="dtTable" class="table table-striped table-hover table-condensed table-bordered">
                </table>
            </div>
        </div>

        <div class="modal fade" id="permissionModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">权限信息</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="permissionForm">
                            <div class="form-group" id="idContainer">
                                <label for="id" class="col-sm-3 control-label">Id</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="id" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name" class="col-sm-3 control-label">名称</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="content" class="col-sm-3 control-label">权限内容</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="content">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="icon" class="col-sm-3 control-label">图标</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="icon">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="category" class="col-sm-3 control-label">分类</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="category">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="order" class="col-sm-3 control-label">排序</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="order">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="parentId" class="col-sm-3 control-label">父级权限Id</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="parentId">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extInfo" class="col-sm-3 control-label">扩展信息</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="extInfo">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="submitBtn">提交</button>
                    </div>
                </div>
            </div>
        </div>
    </#assign>

<#-- 定义pageScript变量 -->
    <#assign pageScript in layout>
    <script src="/static/plugin/datatables-1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="/static/plugin/datatables-1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {

            var dtTableContainer = jQuery("#dtTableContainer");
            var permissionModal = $("#permissionModal");
            var permissionModalTitle = permissionModal.find(".modal-title");
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
                        start: params.start,
                        name: $("#qName").val()
                    };
                    dtTableContainer.block({message: '加载中...'});
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
                    {data: "extInfo", title: "扩展信息"},
                    {
                        title: "操作", render: function (data, type, row, meta) {
                            return '<button class="btn btn-info js-btn-update" data-rowid="' + meta.row + '">修改</button>' +
                                   '<button class="btn btn-warning js-btn-delete" data-rowid="' + meta.row + '">删除</button>';
                        }
                    }
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
                    dtTableContainer.unblock();
                }
            });
            $("#queryBtn").on("click", function () {
                dtTable.draw();
            });
            $("#addBtn").on("click", function () {

                $("#permissionForm").resetForm();
                $("#idContainer").hide();

                $("#submitBtn").html("添加");
                permissionModal.data("action", "add");
                permissionModalTitle.html("添加权限信息");

                permissionModal.modal("show");
            });
            $("#submitBtn").on("click", function () {
                var action = permissionModal.data("action");

                var reqParam = {
                    name: $("#name").val(),
                    content: $("#content").val(),
                    category: $("#category").val(),
                    order: $("#order").val(),
                    parentId: $("#parentId").val(),
                    extInfo: $("#extInfo").val(),
                    icon: $("#icon").val()
                };
                if (action === "add") {
                    $.post("/ajax/permission/add.htm", reqParam, function (res) {
                        if (res.success) {
                            alert("添加成功");
                            dtTable.draw();
                        } else {
                            alert(res.message);
                        }
                        permissionModal.modal("hide");
                    }, 'json')
                } else if (action === "update") {
                    reqParam.id = $("#id").val();
                    $.post("/ajax/permission/update.htm", reqParam, function (res) {
                        if (res.success) {
                            alert("修改成功");
                            dtTable.draw();
                        } else {
                            alert(res.message);
                        }
                        permissionModal.modal("hide");
                    }, 'json')
                }

            });
            dtTableDom.on("click", ".js-btn-update", function () {
                var rowId = $(this).data("rowid");
                var permission = dtTable.row(rowId).data();

                $("#permissionForm").resetForm();
                $("#idContainer").show();

                $("#submitBtn").html("修改");
                permissionModal.data("action", "update");
                permissionModalTitle.html("修改权限信息");

                $("#id").val(permission.id);
                $("#name").val(permission.name);
                $("#content").val(permission.content);
                $("#icon").val(permission.icon);
                $("#category").val(permission.category);
                $("#order").val(permission.order);
                $("#parentId").val(permission.parentId);
                $("#extInfo").val(permission.extInfo);

                permissionModal.modal("show");
            });
            dtTableDom.on("click", ".js-btn-delete", function () {
                var rowId = $(this).data("rowid");
                var permission = dtTable.row(rowId).data();
                if (confirm("确定删除权限：【" + permission.name + "】？")) {
                    $.post("/ajax/permission/delete.htm", {permissionId: permission.id}, function (res) {
                        if (res.success) {
                            alert("删除成功");
                        } else {
                            alert(res.message);
                        }
                        permissionModal.modal("hide");
                    }, 'json')
                }
            });
            // 如果配置了 deferLoading，这里需要根据需要手动加载一次数据。
            dtTable.draw();
        });
    </script>
    </#assign>

<#-- 使用layout中定义的html宏 -->
    <@layout.html/>
</#compress>



