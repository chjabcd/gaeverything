<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>지도 위 버튼으로 로드뷰 표시하기</title>
    <style>
#container {overflow:hidden;height:300px;position:relative;}
#mapWrapper {width:100%;height:300px;z-index:1;}
#rvWrapper {width:50%;height:300px;top:0;right:0;position:absolute;z-index:0;}
#container.view_roadview #mapWrapper {width: 50%;}
#roadviewControl {position:absolute;top:5px;left:5px;width:65px;height:24px;padding:2px;z-index: 1;background: #f7f7f7;border-radius: 4px;border: 1px solid #c8c8c8;box-shadow: 0px 1px #888;cursor: pointer;}
#roadviewControl span {background: url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/mapworker.png) no-repeat;  padding-left:23px;height:24px;font-size: 12px;display: inline-block;line-height: 2;font-weight: bold;}
#roadviewControl.active {background: #ccc;box-shadow: 0px 1px #5F616D;border: 1px solid #7F818A;}
#roadviewControl.active span {background: url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/mapworker_on.png) no-repeat;color: #4C4E57;}
#close {position: absolute;padding: 4px;top: 5px;left: 5px;cursor: pointer;background: #fff;border-radius: 4px;border: 1px solid #c8c8c8;box-shadow: 0px 1px #888;}
#close .img {display: block;background: url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/rv_close.png) no-repeat;width: 14px;height: 14px;}
</style>
</head>
<body>
<div id="container">
    <div id="rvWrapper">
        <div id="roadview" style="width:100%;height:100%;"></div> 로드뷰를 표시할 div 입니다
        <div id="close" title="로드뷰닫기" onclick="closeRoadview()"><span class="img"></span></div>
    </div> 
    <div id="mapWrapper">
        <div id="map" style="width:100%;height:100%"></div> <!-- 지도를 표시할 div 입니다 -->
        <div id="roadviewControl" onclick="setRoadviewRoad()"><span>Road View</span></div>
    </div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ebfbfbd7a5ec71c10c63936dd90beb22&libraries=clusterer"></script>
<script>
var overlayOn = false, // 지도 위에 로드뷰 오버레이가 추가된 상태를 가지고 있을 변수
    container = document.getElementById('container'), // 지도와 로드뷰를 감싸고 있는 div 입니다
    mapWrapper = document.getElementById('mapWrapper'), // 지도를 감싸고 있는 div 입니다
    mapContainer = document.getElementById('map'), // 지도를 표시할 div 입니다 
    rvContainer = document.getElementById('roadview'); //로드뷰를 표시할 div 입니다

var mapCenter = new daum.maps.LatLng(33.45042 , 126.57091), // 지도의 중심좌표
    mapOption = {
        center: mapCenter, // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
var map = new daum.maps.Map(mapContainer, mapOption);

// 로드뷰 객체를 생성합니다 
var rv = new daum.maps.Roadview(rvContainer); 

// 좌표로부터 로드뷰 파노라마 ID를 가져올 로드뷰 클라이언트 객체를 생성합니다 
var rvClient = new daum.maps.RoadviewClient(); 

// 로드뷰에 좌표가 바뀌었을 때 발생하는 이벤트를 등록합니다 
daum.maps.event.addListener(rv, 'position_changed', function() {

    // 현재 로드뷰의 위치 좌표를 얻어옵니다 
    var rvPosition = rv.getPosition();

    // 지도의 중심을 현재 로드뷰의 위치로 설정합니다
    map.setCenter(rvPosition);

    // 지도 위에 로드뷰 도로 오버레이가 추가된 상태이면
    if(overlayOn) {
        // 마커의 위치를 현재 로드뷰의 위치로 설정합니다
        marker.setPosition(rvPosition);
    }
});

// 마커 이미지를 생성합니다
var markImage = new daum.maps.MarkerImage(
    'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/roadview_wk.png',
    new daum.maps.Size(35,39), {
    //마커의 좌표에 해당하는 이미지의 위치를 설정합니다.
    //이미지의 모양에 따라 값은 다를 수 있으나, 보통 width/2, height를 주면 좌표에 이미지의 하단 중앙이 올라가게 됩니다.
    offset: new daum.maps.Point(14, 39)
});

// 드래그가 가능한 마커를 생성합니다
var marker = new daum.maps.Marker({
    image : markImage,
    position: mapCenter,
    draggable: true
});

// 마커에 dragend 이벤트를 등록합니다
daum.maps.event.addListener(marker, 'dragend', function(mouseEvent) {

    // 현재 마커가 놓인 자리의 좌표입니다 
    var position = marker.getPosition();

    // 마커가 놓인 위치를 기준으로 로드뷰를 설정합니다
    toggleRoadview(position);
});

//지도에 클릭 이벤트를 등록합니다
daum.maps.event.addListener(map, 'click', function(mouseEvent){
    
    // 지도 위에 로드뷰 도로 오버레이가 추가된 상태가 아니면 클릭이벤트를 무시합니다 
    if(!overlayOn) {
        return;
    }

    // 클릭한 위치의 좌표입니다 
    var position = mouseEvent.latLng;

    // 마커를 클릭한 위치로 옮깁니다
    marker.setPosition(position);

    // 클락한 위치를 기준으로 로드뷰를 설정합니다
    toggleRoadview(position);
});

// 전달받은 좌표(position)에 가까운 로드뷰의 파노라마 ID를 추출하여
// 로드뷰를 설정하는 함수입니다
function toggleRoadview(position){
    rvClient.getNearestPanoId(position, 50, function(panoId) {
        // 파노라마 ID가 null 이면 로드뷰를 숨깁니다
        if (panoId === null) {
            toggleMapWrapper(true, position);
        } else {
         toggleMapWrapper(false, position);

            // panoId로 로드뷰를 설정합니다
            rv.setPanoId(panoId, position);
        }
    });
}

// 지도를 감싸고 있는 div의 크기를 조정하는 함수입니다
function toggleMapWrapper(active, position) {
    if (active) {

        // 지도를 감싸고 있는 div의 너비가 100%가 되도록 class를 변경합니다 
        container.className = '';

        // 지도의 크기가 변경되었기 때문에 relayout 함수를 호출합니다
        map.relayout();

        // 지도의 너비가 변경될 때 지도중심을 입력받은 위치(position)로 설정합니다
        map.setCenter(position);
    } else {

        // 지도만 보여지고 있는 상태이면 지도의 너비가 50%가 되도록 class를 변경하여
        // 로드뷰가 함께 표시되게 합니다
        if (container.className.indexOf('view_roadview') === -1) {
            container.className = 'view_roadview';

            // 지도의 크기가 변경되었기 때문에 relayout 함수를 호출합니다
            map.relayout();

            // 지도의 너비가 변경될 때 지도중심을 입력받은 위치(position)로 설정합니다
            map.setCenter(position);
        }
    }
}

// 지도 위의 로드뷰 도로 오버레이를 추가,제거하는 함수입니다
function toggleOverlay(active) {
    if (active) {
        overlayOn = true;

        // 지도 위에 로드뷰 도로 오버레이를 추가합니다
        map.addOverlayMapTypeId(daum.maps.MapTypeId.ROADVIEW);

        // 지도 위에 마커를 표시합니다
        marker.setMap(map);

        // 마커의 위치를 지도 중심으로 설정합니다 
        marker.setPosition(map.getCenter());

        // 로드뷰의 위치를 지도 중심으로 설정합니다
        toggleRoadview(map.getCenter());
    } else {
        overlayOn = false;

        // 지도 위의 로드뷰 도로 오버레이를 제거합니다
        map.removeOverlayMapTypeId(daum.maps.MapTypeId.ROADVIEW);

        // 지도 위의 마커를 제거합니다
        marker.setMap(null);
    }
}

// 지도 위의 로드뷰 버튼을 눌렀을 때 호출되는 함수입니다
function setRoadviewRoad() {
    var control = document.getElementById('roadviewControl');

    // 버튼이 눌린 상태가 아니면
    if (control.className.indexOf('active') === -1) {
        control.className = 'active';

        // 로드뷰 도로 오버레이가 보이게 합니다
        toggleOverlay(true);
    } else {
        control.className = '';

        // 로드뷰 도로 오버레이를 제거합니다
        toggleOverlay(false);
    }
}

// 로드뷰에서 X버튼을 눌렀을 때 로드뷰를 지도 뒤로 숨기는 함수입니다
function closeRoadview() {
    var position = marker.getPosition();
    toggleMapWrapper(true, position);
}
</script>
</body>
</html>