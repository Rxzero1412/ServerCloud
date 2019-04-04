<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>windy</title>
    <link href="css/ol.css" rel="stylesheet" type="text/css" />
    <link href="css/popup.css" rel="stylesheet" type="text/css" />
    <style>
        html, body, #map {
            height: 100%;
            padding: 0;
            margin: 0;
        }
        .menu {
            position: absolute;
            width: 100%;
            height: 40px;
            line-height: 40px;
            text-align: center;
            z-index: 2;
        }

        .base-button {
            height: 30px;
            line-height: 30px;
            background: #1b9de8;
            color: #ffffff;
            border-radius: 6px;
            border: 1px solid #bfcbd9;
            padding: 0 10px;
            box-shadow: 0 4px 10px rgba(73, 127, 255, .42);
            transition: .3s;
        }

        .base-button:hover {
            cursor: pointer;
            border-color: #1b9de8;
            color: #ffffff;
        }
    </style>
</head>
<body>
<div id="map">
    <div class="menu">
        <button class="base-button" onclick="getData()">获取数据</button>
        <button class="base-button" onclick="setData()">设置数据</button>
        <button class="base-button" onclick="clearWind()">移除图层</button>
    </div>
</div>
<script type="text/javascript" src="moment/moment.js"></script>">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<%--<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/ol-debug.js"></script>
<script type="text/javascript" src="js/main.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/openlayers/dist/ol.js"></script>--%>
<script type="text/javascript" src="js/ol-debug.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.js"></script>--%>
<script type="text/javascript" src="js/axios.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/wind-layer@0.0.4/dist/windLayer.js"></script>--%>
<%--<script type="text/javascript" src="js/windLayer.js"></script>--%>
<script type="text/javascript" src="dist/windLayer.js"></script>
<script>
    var map = new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                layerName: 'baseLayer',
                preload: 4,
                source: new ol.source.OSM({
                    url: "http://{a-c}.sm.mapstack.stamen.com/" +
                    "(toner-lite,$fff[difference],$fff[@23],$fff[hsl-saturation@20])/" +
                    "{z}/{x}/{y}.png"
                })
            })
        ],
        loadTilesWhileAnimating: true,
        pixelRatio: 1,
        view: new ol.View({
            projection: 'EPSG:4326',
            center: [113.53450137499999, 34.44104525],
            zoom: 5
        })
    });
    var wind, data;
    axios.get('json/ex1.json').then(function (res) {
        if (res.data) {
            data = res.data
            wind = new windLayer.OlWind(data, {
                layerName: 'data',
                projection: 'EPSG:4326',
                ratio: 1,
                map: map
            })
            console.log(wind);
            // map.addLayer(wind)
            wind.appendTo(map);
            /*map.on('pointermove', function (event) {
                var _data = wind.getPointData(ol.proj.transform(event.coordinate, map.getView().getProjection(), 'EPSG:4326'));
                console.log(_data);
            });*/
        }
    });

    function getData () {
        var _data = wind.getData();
        console.log(_data)
    }

    function setData () {
        wind.setData(data)
    }

    function clearWind () {
        wind.clearWind()
    }
</script>
</body>
</html>
