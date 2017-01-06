<#compress >
<#-- 必须引入layout宏定义文件 -->
    <#import "../_common/layout.ftl" as layout >

<#-- 定义title -->
    <#assign title="map | echarts" in layout />

    <#assign pageHead in layout>
    <script src="//cdn.bootcss.com/echarts/3.3.2/echarts.min.js"></script>
    </#assign>

<#-- 定义pageHeader变量 -->
    <#assign pageHeader in layout>
    <header class="page-header">
        <h1>地图示例</h1>
    </header>
    </#assign>

<#-- 定义pageBody变量 -->
    <#assign pageBody in layout>
        <div class="panel panel-default">
            <div class="panel-body">
                <div id="map" style="width: 1000px;height:600px;"></div>
            </div>
        </div>
    </#assign>

<#-- 定义pageScript变量 -->
    <#assign pageScript in layout>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=4ytQf3esZOtPM2WnQ24R2R3s"></script>
    <script type="text/javascript">
        // 百度地图API功能
        var map = new BMap.Map("map",{minZoom: 12, maxZoom:19});
        map.centerAndZoom(new BMap.Point(112.956932,35.093624), 12);
        map.enableScrollWheelZoom();


        function getBoundary(){
            var bdary = new BMap.Boundary();
            bdary.get("沁阳市", function(rs){       //获取行政区域
//                map.clearOverlays();        //清除地图覆盖物
                var count = rs.boundaries.length; //行政区域的点有多少个
                if (count === 0) {
                    alert('未能获取当前输入行政区域');
                    return ;
                }
                var pointArray = [];
                for (var i = 0; i < count; i++) {
                    var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#ff0000"}); //建立多边形覆盖物
                    map.addOverlay(ply);  //添加覆盖物
                    pointArray = pointArray.concat(ply.getPath());
                }
                map.setViewport(pointArray);    //调整视野
            });
        }
        setTimeout(function(){
            getBoundary();
        }, 2000);


        var townList = [
            {
                id: 1,
                name: "柏香镇杨庄",
                point:new BMap.Point(112.777993,35.060242),
                police: [{
                    id: 1,
                    name: "张三",
                    office: "柏香镇派出所"
                }],
                policeOffice:{
                    id: 1,
                    name: "柏香镇派出所"
                }
            },
            {
                id: 2,
                name: "王曲乡中王占村",
                point:new BMap.Point(112.872998,35.088646),
                police: [{
                    id: 2,
                    name: "李四",
                    office: "王曲乡派出所"
                }],
                policeOffice:{
                    id: 2,
                    name: "王曲乡派出所"
                }
            },
            {
                id: 3,
                name: "王召乡段庄村",
                point:new BMap.Point(112.988089,35.056031),
                police: [{
                    id: 3,
                    name: "王五",
                    office: "王召乡派出所"
                }],
                policeOffice:{
                    id: 3,
                    name: "王召乡派出所"
                }
            }
        ];
        var opts = {
            width : 250,     // 信息窗口宽度
            height: 80,     // 信息窗口高度
            title : "信息窗口" , // 信息窗口标题
            enableMessage:true//设置允许信息窗发送短息
        };
        for(var i=0;i<townList.length;i++){
            var town = townList[i];
            var marker = new BMap.Marker(town.point);  // 创建标注
            map.addOverlay(marker);               // 将标注添加到地图中
            addClickHandler(town,marker);
        }
        function addClickHandler(town,marker){
            marker.addEventListener("click",function(e){
                openInfo(town,e)}
            );
        }
        function openInfo(town,e){
            var p = e.target;
            var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
            var infoWindow = new BMap.InfoWindow("片警："+town.police[0].name+"<br>派出所："+town.policeOffice.name+"<br><a href='#"+town.id+"'>查看详情</a>",{
                width : 250,     // 信息窗口宽度
                height: 80,     // 信息窗口高度
                title : town.name , // 信息窗口标题
                enableMessage:true//设置允许信息窗发送短息
            });  // 创建信息窗口对象
            map.openInfoWindow(infoWindow,point); //开启信息窗口
        }
    </script>
    </#assign>

<#-- 使用layout中定义的html宏 -->
    <@layout.html/>
</#compress>



