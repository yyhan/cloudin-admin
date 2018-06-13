<#compress >
<#-- 必须引入layout宏定义文件 -->
    <#import "../_common/layout_admin.ftl" as layout >

<#-- 定义title -->
    <#assign title="首页" in layout />

<#-- 定义 pageHead 变量 -->
    <#assign pageHead in layout>
    <link rel="stylesheet" href="/static/plugin/datatables-1.10.15/css/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet" href="/static/plugin/bootstrap-daterangepicker/daterangepicker.css"/>
    <link rel="stylesheet" href="/static/plugin/select2-4.0.6-rc.1/css/select2.min.css"/>
    <link rel="stylesheet" href="/static/plugin/select2-4.0.6-rc.1/themes/select2-bootstrap.min.css"/>
    </#assign>

<#-- 定义pageBody变量 -->
    <#assign pageBody in layout>
        <div class="box box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">管理员配置</h3>
            </div>
            <div class="box-body">
                <form class="form-horizontal" onsubmit="return false;">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label for="qAccount" class="col-sm-3 control-label">账号</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="qAccount">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label for="qName" class="col-sm-3 control-label">姓名</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="qName">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label for="qEmail" class="col-sm-3 control-label">邮箱</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="qEmail">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-4">
                            <label for="qMobile" class="col-sm-3 control-label">手机号</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="qMobile">
                            </div>
                        </div>
                        <div class="col-md-offset-4 col-md-4">
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

        <div class="modal fade" id="administratorModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">管理员信息</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="administratorForm">
                            <div class="form-group" id="idContainer">
                                <label for="id" class="col-sm-3 control-label">Id</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="id" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="account" class="col-sm-3 control-label">账号</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="account">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name" class="col-sm-3 control-label">姓名</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-3 control-label">邮箱</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mobile" class="col-sm-3 control-label">手机号</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="mobile">
                                </div>
                            </div>
                            <div class="form-group" id="passwordContainer">
                                <label for="password" class="col-sm-3 control-label">密码</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="password">
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
            <div class="modal fade" id="rModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">管理员角色配置</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="rId" class="col-sm-3 control-label">Id</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="rId" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="rName" class="col-sm-3 control-label">姓名</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="rName">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="rolesSelector" class="col-sm-3 control-label">角色</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" id="rolesSelector"></select>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary" id="rSubmitBtn">提交</button>
                        </div>
                    </div>
                </div>
            </div>
    </#assign>

<#-- 定义pageScript变量 -->
    <#assign pageScript in layout>
    <script src="/static/plugin/datatables-1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="/static/plugin/datatables-1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="/static/plugin/select2-4.0.6-rc.1/js/select2.full.min.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            var dtTableContainer = $("#dtTableContainer");
            var administratorModal = $("#administratorModal");
            var administratorModalTitle = administratorModal.find(".modal-title");
            var rolesModal = $("#rModal");
            var dtTableDom = $("#dtTable");
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
                        account: $("#qAccount").val(),
                        name: $("#qName").val(),
                        email: $("#qEmail").val(),
                        mobile: $("#qMobile").val()
                    };
                    dtTableContainer.block({message: '加载中...'});
                    $.post("/ajax/administrator/list.htm", reqParams, function (res, status, xhr) {
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
                    {data: "name", title: "姓名"},
                    {data: "account", title: "账号"},
                    {data: "email", title: "邮箱"},
                    {data: "mobile", title: "手机号"},
                    {
                        title: "操作", render: function (data, type, row, meta) {
                            return '<button class="btn btn-info js-btn-update" data-rowid="' + meta.row + '">修改</button>' +
                                   '<button class="btn btn-warning js-btn-delete" data-rowid="' + meta.row + '">删除</button>' +
                                   '<button class="btn btn-link js-btn-show-roles" data-rowid="' + meta.row + '">查看角色</button>';
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

                $("#administratorForm").resetForm();
                $("#idContainer").hide();
                $("#passwordContainer").show();

                $("#submitBtn").html("添加");
                administratorModal.data("action", "add");
                administratorModalTitle.html("添加管理员信息");

                administratorModal.modal("show");
            });
            $("#submitBtn").on("click", function () {
                var action = administratorModal.data("action");

                var reqParam = {
                    account: $("#account").val(),
                    name: $("#name").val(),
                    email: $("#email").val(),
                    mobile: $("#mobile").val(),
                    password: $("#password").val()
                };
                if (action === "add") {
                    $.post("/ajax/administrator/add.htm", reqParam, function (res) {
                        if (res.success) {
                            alert("添加成功");
                            dtTable.draw();
                        } else {
                            alert(res.message);
                        }
                        administratorModal.modal("hide");
                    }, 'json')
                } else if (action === "update") {
                    reqParam.id = $("#id").val();
                    $.post("/ajax/administrator/update.htm", reqParam, function (res) {
                        if (res.success) {
                            alert("修改成功");
                            dtTable.draw();
                        } else {
                            alert(res.message);
                        }
                        administratorModal.modal("hide");
                    }, 'json')
                }

            });
            dtTableDom.on("click", ".js-btn-update", function () {
                var rowId = $(this).data("rowid");
                var administrator = dtTable.row(rowId).data();

                $("#administratorForm").resetForm();
                $("#idContainer").show();
                $("#passwordContainer").hide();
                $("#account").prop("readonly", true);

                $("#submitBtn").html("修改");
                administratorModal.data("action", "update");
                administratorModalTitle.html("修改管理员信息");

                $("#id").val(administrator.id);
                $("#name").val(administrator.name);
                $("#account").val(administrator.account);
                $("#email").val(administrator.email);
                $("#mobile").val(administrator.mobile);

                administratorModal.modal("show");
            });
            dtTableDom.on("click", ".js-btn-delete", function () {
                var rowId = $(this).data("rowid");
                var administrator = dtTable.row(rowId).data();
                if (confirm("确定删除管理员：【" + administrator.name + "】？")) {
                    $.post("/ajax/administrator/delete.htm", {administratorId: administrator.id}, function (res) {
                        if (res.success) {
                            alert("删除成功");
                        } else {
                            alert(res.message);
                        }
                        administratorModal.modal("hide");
                    }, 'json')
                }
            });
            dtTableDom.on("click", ".js-btn-show-roles", function () {
                var rowId = $(this).data("rowid");
                var administrator = dtTable.row(rowId).data();
                $("#rId").val(administrator.id);
                $("#rName").val(administrator.name);
                rolesModal.data("administrator", administrator);
                rolesModal.modal("show");
            });
            var roleList = [];
            $.get("/ajax/role/listAll.htm", function(res) {
                if(res.success) {
                    roleList = res.data;
                    for(var i = 0; i < roleList.length; i++) {
                        var item = roleList[i];
                        item.text = item.name;
                    }
                    $('#rolesSelector').select2({
                        theme: 'bootstrap',
                        multiple: true,
                        allowClear: true,
                        language: "zh-CN",
                        placeholder: "请选择角色",
                        width: '100%',
                        tags: true,
                        data: roleList
                    }, "json");
                } else {
                    $('#rolesSelector').select2({
                        theme: 'bootstrap',
                        multiple: true,
                        allowClear: true,
                        language: "zh-CN",
                        placeholder: "请选择角色",
                        width: '100%',
                        disabled: true
                    });
                }
            }, "json");

            rolesModal.on("shown.bs.modal", function() {
                rolesModal.block({message: "加载中..."});
                var administrator = rolesModal.data("administrator");
                $.get("/ajax/administrator/listRoles.htm", {id: administrator.id}, function(res) {
                    if(res.success) {
                        var selectedRoles = res.data;
                        var selectedRoleIds = [];

                        for(var i = 0; i < selectedRoles.length; i++) {
                            selectedRoleIds.push(selectedRoles[i].id);
                        }
                        $('#rolesSelector').val(selectedRoleIds).trigger("change");
                    }
                    rolesModal.unblock();
                }, "json");
            });
            rolesModal.on("hidden.bs.modal", function() {
                $('#rolesSelector').val(null).trigger("change");
            });
            // 如果配置了 deferLoading，这里需要手动加载一次数据。
            dtTable.draw();

            $("#rSubmitBtn").on("click", function () {
                var administrator = rolesModal.data("administrator");
                var selectedRoleIds = $('#rolesSelector').val();
                var selectedRoleIdStr = "";
                for(var i = 0; i < selectedRoleIds.length; i++) {
                    selectedRoleIdStr += selectedRoleIds[i] + ",";
                }
                $.post("/ajax/administrator/saveRoles.htm", {
                    administratorId: administrator.id,
                    selectedRoleIdStr: selectedRoleIdStr
                }, function(res) {
                    if(res.success) {
                        alert("保存角色成功");
                    } else {
                        alert(res.message);
                    }
                }, "json");
            });
        });
    </script>
    </#assign>

<#-- 使用layout中定义的html宏 -->
    <@layout.html/>
</#compress>



