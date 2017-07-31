<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Basic Page Needs
================================================== -->
<title>Gaverything</title>
<style type="text/css">
 .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
</style>


<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
================================================== -->
<link rel="stylesheet"
	href="<c:url value = '/resources/css/style.css'/>">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/colors/main.css'/>" id="colors">

</head>

<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header Container
================================================== -->
		<header id="header-container" class="fixed fullwidth"> <%@include
			file="../header.jsp"%> </header>
		<div class="clearfix"></div>
		<!-- Header Container / End -->


		<!-- Content
================================================== -->
		<div class="fs-container">

			<div class="fs-inner-container content">
				<div class="fs-content">

					<!-- Search -->
					<section class="search">

					<div class="row">
						<div class="col-md-12">

							<!-- Row With Forms -->
							<div class="row with-forms">

								<!-- Main Search Input -->
								<div class="col-fs-6">
									<div class="input-with-icon">
										<i class="sl sl-icon-magnifier"></i> <input type="text"
											placeholder="What are you looking for?" value="" />
									</div>
								</div>

								<!-- Main Search Input -->
								<div class="col-fs-6">
									<div class="input-with-icon location">

										<input type="text" placeholder="Destination, city, address"
											value="" /> <a href="#"><i class="fa fa-dot-circle-o"></i></a>
									</div>
								</div>


								<!-- Filters -->
								<div class="col-fs-12">

									<!-- Panel Dropdown / End -->
									<div class="panel-dropdown">
										<a href="#">Categories</a>
										<div class="panel-dropdown-content checkboxes categories">

											<!-- Checkboxes -->
											<div class="row">
												<div class="col-md-6">
													<input id="check-1" type="checkbox" name="check" checked
														class="all"> <label for="check-1">All
														Categories</label> <input id="check-2" type="checkbox"
														name="check"> <label for="check-2">Shops</label> <input
														id="check-3" type="checkbox" name="check"> <label
														for="check-3">Hotels</label>
												</div>

												<div class="col-md-6">
													<input id="check-4" type="checkbox" name="check">
													<label for="check-4">Eat & Drink</label> <input
														id="check-5" type="checkbox" name="check"> <label
														for="check-5">Fitness</label> <input id="check-6"
														type="checkbox" name="check"> <label for="check-6">Events</label>
												</div>
											</div>

											<!-- Buttons -->
											<div class="panel-buttons">
												<button class="panel-cancel">Cancel</button>
												<button class="panel-apply">Apply</button>
											</div>

										</div>
									</div>
									<!-- Panel Dropdown / End -->

									<!-- Panel Dropdown -->
									<div class="panel-dropdown wide">
										<a href="#">More Filters</a>
										<div class="panel-dropdown-content checkboxes">

											<!-- Checkboxes -->
											<div class="row">
												<div class="col-md-6">
													<input id="check-a" type="checkbox" name="check"> <label
														for="check-a">Elevator in building</label> <input
														id="check-b" type="checkbox" name="check"> <label
														for="check-b">Friendly workspace</label> <input
														id="check-c" type="checkbox" name="check"> <label
														for="check-c">Instant Book</label> <input id="check-d"
														type="checkbox" name="check"> <label for="check-d">Wireless
														Internet</label>
												</div>

												<div class="col-md-6">
													<input id="check-e" type="checkbox" name="check">
													<label for="check-e">Free parking on premises</label> <input
														id="check-f" type="checkbox" name="check"> <label
														for="check-f">Free parking on street</label> <input
														id="check-g" type="checkbox" name="check"> <label
														for="check-g">Smoking allowed</label> <input id="check-h"
														type="checkbox" name="check"> <label for="check-h">Events</label>
												</div>
											</div>

											<!-- Buttons -->
											<div class="panel-buttons">
												<button class="panel-cancel">Cancel</button>
												<button class="panel-apply">Apply</button>
											</div>

										</div>
									</div>
									<!-- Panel Dropdown / End -->

									<!-- Panel Dropdown -->
									<div class="panel-dropdown">
										<a href="#">Distance Radius</a>
										<div class="panel-dropdown-content">
											<input class="distance-radius" type="range" min="1" max="100"
												step="1" value="50"
												data-title="Radius around selected destination">
											<div class="panel-buttons">
												<button class="panel-cancel">Disable</button>
												<button class="panel-apply">Apply</button>
											</div>
										</div>
									</div>
									<!-- Panel Dropdown / End -->

								</div>
								<!-- Filters / End -->

							</div>
							<!-- Row With Forms / End -->

						</div>
					</div>

					</section>
					<!-- Search / End -->


					<section class="listings-container margin-top-30" id="menu_wrap">
					<!-- Sorting / Layout Switcher -->
					<div class="row fs-switcher">

						<div class="col-md-6">
							<!-- Showing Results -->
							<p class="showing-results">Results Found</p>
						</div>
					</div>


					<!-- Listings(ul) -->
					<div class="row fs-listings" id="eventList">

						<!-- Listing Item -->

						<!-- Listing Item / End -->
					</div>
					<!-- Listings Container / End --> <!-- Pagination Container -->
					<div class="row fs-listings">
						<div class="col-md-12">

							<!-- Pagination -->
							<div class="clearfix"></div>
							<div class="row">
								<div class="col-md-12">
									<!-- Pagination -->
									<div
										class="pagination-container margin-top-15 margin-bottom-40">
										<nav class="pagination">
										<ul id="pagination">
										</ul>
										</nav>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
							<!-- Pagination / End -->

							<!-- Copyrights -->
							<div class="copyrights margin-top-0">© 2017 Listeo. All
								Rights Reserved.</div>

						</div>
					</div>
					<!-- Pagination Container / End --> </section>

				</div>
			</div>
			<div class="fs-inner-container map-fixed">

				<!-- Map -->
				<div id="map-container">
					<div id="map" data-map-zoom="9" data-map-scroll="true">
						<!-- map goes here -->
					</div>
				</div>

			</div>
		</div>


	</div>
	<!-- Wrapper / End -->


	<!-- Scripts
================================================== -->
	<script type="text/javascript" src="<c:url value = '/resources/scripts/jquery-2.2.0.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/jpanelmenu.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/chosen.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/slick.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/rangeslider.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/magnific-popup.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/waypoints.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/counterup.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/jquery-ui.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/tooltips.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/custom.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/infobox.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value = '/resources/scripts/maps1.js'/>"></script>

	<!-- Maps -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ebfbfbd7a5ec71c10c63936dd90beb22&libraries=clusterer"></script>
	
	<script>

	
	//1. 기본 지도 보이기
	var container = document.getElementById("map"), //지도띄울 div
	options = {
		center : new daum.maps.LatLng(37.6646797, 126.7421222), //지도 시작 시 좌표
		level : 12
	//확대, 축소정도
	};
	var map = new daum.maps.Map(container, options);
	/////////////////////////////////////////////////////////////////

	$(document).ready(
			function() {
				$.ajax({
					url : "/event/getAllEvents",
					dataType : "json",
					type : 'post',
					success : function(data) {
						eventList(data);
						setMarkers(map);
					},
					error : function(request, status, error) {
						alert("code:" + request.status + "\n" + "message:"+ request.responseText + "\n" + "error:"+ error);
					}
				});
			});

	var markers = [];
	var makerPostions = [];
	var overlays = [];

	///*****
	function eventList(data) {
		displayEvent(data);
		//페이징추가예정
		//displayPagination(data);
	}

	function displayEvent(data) {
		var listEl = document.getElementById("eventList"), 
			menuEl = document.getElementById("menu-wrap"), 
			fragment = document.createDocumentFragment();
			removeAllChildNods(listEl);
	
		for (var i=0; i<data.length; i++) {
			//리스트보여줄 태그
			alert(data[i].longitude);
			var placePosition = new daum.maps.LatLng(data[i].latitude, data[i].longitude),
			
			itemEl = eventItems(data[i]); //좌측 리스트 한덩어리

			var itemOverlay = createOverlay(data[i], i, placePosition);

			(function(overlay){
				itemEl.onclick = function() {
					setOverlay(overlay); 			
				};
				
				/*  itemEl.onmouseout = function() {
					clearOverlay(overlay); 			
				};  */
			})(overlays[i]);

			fragment.appendChild(itemEl);
		}//for 

		listEl.appendChild(fragment);
		starRating('.star-rating');
	}

	//좌측리스트
	function eventItems(event) {
		var el = document.createElement("div");
		var itemStr = '<a href="#" class="listing-item-container" data-marker-id="1">'
				+ '		<div class="listing-item">'
				+ '			<img src="/resources/images/event/'+event.thumbnail+'" alt="">'
				+
				//'			<div class="listing-badge now-open">Now Open</div>' + 
				'			<div class="listing-item-content">'
				+ '				<span class="tag">Fair</span>' 
				+ '				<h3>'+ event.eventName + '</h3>'
				+ '				<span><i class="fa fa-map-marker"></i>  '+ event.address+ '</span>'
				+ '				<span><i class="fa fa-calendar-check-o"></i>  '+ event.startDate+ '  ~  '+ event.endDate	+ '</span>'
				+ '				<span><i class="fa fa-dollar"></i>  '+ event.fee+ '   <i class="fa fa-check"></i>  '+ event.discountInfo+ '</span>'
				+ '			</div>'
				+ '			<span class="like-icon"></span>	'
				+ '		</div>'
				+ '		<div class="star-rating" data-rating="3.5">'
				+ '			<div class="rating-counter">(12 reviews)</div>'
				+ '		</div>' 
				+ '	   </a>';
		el.innerHTML = itemStr;
		el.className = 'col-lg-6 col-md-12';
		return el;
	}

	
	//이미지크기에따라 오버레이 크기 달라짐!!!!!
	function createOverlay(event, idx, placePosition) {
	//	alert(event.latitude, event.longitude);
		var contentStr =
		'<div class="infoBox" style="width: 270px; transform: translateZ(0px); position: absolute; visibility: visible; left: 284.75px; bottom: -185.3px; cursor: default;">' + 
        '    <div class="map-box">' + 
        '      <a href="#" class="listing-img-container">'+
        '         <div class="infoBox-close" onclick="closeOverlay('+ idx+ ')" ><i class="fa fa-times"></i></div>'+
        '         <img src="/resources/images/event/'+event.thumbnail+'" style="object-fit:cover; height:100%" alt="">'+
        '         <div class="listing-item-content">'+
        '            <h3>'+event.eventName+'</h3>'+
        '            <span>'+event.address+'</span>'+
        '         </div>'+
        '      </a>'+
        '      <div class="listing-content">   '+
        '         <div class="listing-title">'+
        '            <div class="star-rating" data-rating="3.5   ">46 Review<div>'+      
        '         </div>'+
        '      </div>'+
        '   </div>'+
        '</div>';

    	
		//2)오버레이 찍을 위치
		var overlayPosition = placePosition;
		
		//3) 오버레이 생성
		var overlay = new daum.maps.CustomOverlay({
			content : contentStr, //보여줄 내용 
			position : overlayPosition
		});
		//4)만든 오버레이 배열에 추가
		overlays.push(overlay);
		//5) 마커에 오버레이 표시
		createMarker(overlayPosition, overlay);
		return overlay;
	}
	

	function closeOverlay(index){
		 clearOverlay(overlays[index]);
	}  

	function createMarker(placePosition, overlay) {
		var markerPostion = placePosition;
		makerPostions.push(markerPostion);
		//2) 마커이미지 셋팅
		var imgSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png', 
			imgSize = new daum.maps.Size(24, 36), 
			imgOption = {offset : new daum.maps.Point(27, 69)
		};
		//3) 마커이미지 셋팅값 넣어주기
		var markerImg = new daum.maps.MarkerImage(imgSrc, imgSize,imgOption);
		//4) 마커만들기(이미지, 위치)
		var marker = new daum.maps.Marker({
			position : markerPostion,
			image : markerImg
		});
		//5)마커+오버레이에 클릭이벤트 등록
		markerClick(marker, overlay);
		//6)만든 마커를 배열에 추가
		markers.push(marker);
	}

	//마커 이벤트 리스너
	function markerClick(marker, overlay) {
		daum.maps.event.addListener(marker, 'click', function() {
			overlay.setMap(map);
		}); 
	}

	///*****
	// 배열에 추가된 마커들을 지도에 표시
	function setMarkers(map) {
		for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(map);
		}
	}

	function removeAllChildNods(el) {
		while (el.hasChildNodes()) {
			el.removeChild(el.lastChild);
		}
	}
	
	function setOverlay(overlay){
    	overlay.setMap(map);
    }
	
	function clearOverlay(overlay){
    	overlay.setMap(null);
    }

	/* function displayPagination(data){
		
	} */

	 
	</script>
	
	
	<!--<script>
	
		//1. 기본 지도 보이기
		var container = document.getElementById("map"), //지도띄울 div
		options = {
			center : new daum.maps.LatLng(37.6646797, 126.7421222), //지도 시작 시 좌표
			level : 12
		//확대, 축소정도
		};
		var map = new daum.maps.Map(container, options);
		/////////////////////////////////////////////////////////////////

		var markers = [];
		var markerPositions = [];
		var overlays = []
		
		
		$(document).ready(
				function() {
					$.ajax({
						url : "/event/getAllEvents",
						dataType : "json",
						type : 'post',
						success : function(data) {
							eventList(data);
							setMarkers(map);
						},
						error : function(request, status, error) {
							alert("code:" + request.status + "\n" + "message:"+ request.responseText + "\n" + "error:"+ error);
						}
					});
				});

	;

		///*****
		function eventList(data) {
			displayEvent(data);
			//페이징추가예정
			//dusplayPagination(data);
		}

		function displayEvent(data) {
			var listEl = document.getElementById("eventList"), 
				menuEl = document.getElementById("menu-wrap"), 
				fragment = document.createDocumentFragment();
				removeAllChildNods(listEl);

			for (var i=0; i<data.length; i++) {
				//리스트보여줄 태그
				var placePosition = new daum.maps.LatLng(data[i].latitude,data[i].longitude);
				
				markerPositions.push(placePosition);
				alert(markerPositions[0]);
				itemEl = eventItems(data[i]); //좌측 리스트 한덩어리

				//var itemOverlay = 
				//createOverlay(data[i], i);
				SimpleTextMarker(placePosition, data[i]);
				
				/* (function(overlay){
					itemEl.onmouseover = function() {
 						setOverlay(overlay); 			
					};
					
					itemEl.onmouseout = function() {
 						clearOverlay(overlay); 			
					};
				})(overlays[i]); */

				fragment.appendChild(itemEl);
			}//for 

			listEl.appendChild(fragment);
			starRating('.star-rating');
		}

		//좌측리스트
		function eventItems(event) {
			var el = document.createElement("div");
			var itemStr = '<a href="/event/detail" class="listing-item-container" data-marker-id="1">'
					+ '		<div class="listing-item">'
					+ '			<img src="/resources/images/event/'+event.thumbnail+'" alt="">'
					+
					//'			<div class="listing-badge now-open">Now Open</div>' + 
					'			<div class="listing-item-content">'
					+ '				<span class="tag">Fair</span>' 
					+ '				<h3>'+ event.eventName + '</h3>'
					+ '				<span><i class="fa fa-map-marker"></i>  '+ event.address+ '</span>'
					+ '				<span><i class="fa fa-calendar-check-o"></i>  '+ event.startDate+ '  ~  '+ event.endDate	+ '</span>'
					+ '				<span><i class="fa fa-dollar"></i>  '+ event.fee+ '   <i class="fa fa-check"></i>  '+ event.discountInfo+ '</span>'
					+ '			</div>'
					+ '			<span class="like-icon"></span>	'
					+ '		</div>'
					+ '		<div class="star-rating" data-rating="3.5">'
					+ '			<div class="rating-counter">(12 reviews)</div>'
					+ '		</div>' 
					+ '	   </a>';
			el.innerHTML = itemStr;
			el.className = 'col-lg-6 col-md-12';
			return el;
		}

		/* //마커 위 인포상자
		function createOverlay(event, idx) {
 			var content = '<div class="wrap">' 
					+ '		<div class="info">'
					+ '		<div class="title">'+ event.eventName
					+ '			<div class="close" onclick="closeOverlay('+ idx+ ')" title="닫기"></div>'
					+ '		</div>	'
					+ '		<div class="body">'
					+ '			<div class="img">'
					+ '				<img src="/resources/images/event/'+event.thumbnail+'" width="73" height="70">'
					+ '				</div>'
					+ '			<div class="desc">'
					+ '				<div class="ellipsis">'+ event.address+ '</div>'
					+ '				<div><span>'+ "날짜: "+ event.startDate+ '</span></div>'
					+ '				<div><a href="'+event.link+ '" target="_blank" class="link">홈페이지 확인</a></div>'
					+ '			</div>' 
					+ '		</div>' 
					+ '	</div>' 
					+ '</div>'; 

			var content = '';
			
			
			//2)오버레이 찍을 위치
			var overlayPosition = new daum.maps.LatLng(event.latitude, event.longitude);
			//3) 오버레이 생성
			var overlay = new daum.maps.CustomOverlay({
				content : content, //보여줄 내용 
				position : overlayPosition
			});
			//4)만든 오버레이 배열에 추가
			overlays.push(overlay);
			//5) 마커에 오버레이 표시
			createMarker(overlayPosition, overlay);
			return overlay;
		} */
		
		//오버레이 element 생성 
		function SimpleTextMarker(position, event) {
			
		    this.position = position;
		    this.node = document.createElement('div'); //오버레이 전체div
		    this.node.style.position = 'absolute';
		    this.node.style.whiteSpace = 'nowrap';
		    this.node.className = 'infobox'; 
		    /* var fragment = document.createDocumentFragment(); */
		    var overlay = overlayContent(event);
		    /* fragment.appendChild(overlayText(event)); */
		    this.node.appendChild(overlay);
		    
		    overlays.push(this.node);
		    createMarker(position, this.node);
		    
		    this.node.onmouseover = function() {
		    	overlay.style.display = 'block';
		    };
		    this.node.onmouseout = function() {
		    	overlay.style.display = 'none';
		    };
		}
		
		
		function overlayContent(event){
			var el = document.createElement("div");
			var text = 
					 '	<a href="/event/detail" class="listing-img-container">'+
					 '	<div class="infoBox-close"><i class="fa fa-times"></i></div>'+
					 '	<img src="/resources/images/event/'+event.thumbnail+'" alt="">'+
					 '	<div class="listing-item-content">'+
 					 '		<h3>'+event.eventName+'</h3>'+
 					 '		<span>'+event.address+'</span>'+
					 '	</div>'+
					 '</a>'+
					 '<div class="listing-content">'+
					 '	<div class="listing-title">'+
   					 '		<div class="'+infoBox_ratingType+'" data-rating="3.5"><div class="rating-counter">(10 reviews)</div></div>'+
					 '	</div>'+
					 '</div>';
			el.innerHTML = text; 
			el.className = 'map-box';
			return el;
		}
		
		// "AbstractOverlay":#AbstractOverlay 상속. 프로토타입 체인을 연결한다.
		SimpleTextMarker.prototype = new daum.maps.AbstractOverlay;
		
		// 필수 구현 메소드1
		// AbstractOverlay의 getPanels() 메소드로 MapPanel 객체를 가져오고
		// 거기에서 오버레이 레이어를 얻어 생성자에서 만든 엘리먼트를 자식 노드로 넣어준다.
		SimpleTextMarker.prototype.onAdd = function() {
		    var panel = this.getPanels().overlayLayer;
		    panel.appendChild(this.node);
		};
		
		// 필수 구현 메소드2
		// 생성자에서 만든 엘리먼트를 오버레이 레이어에서 제거한다.
		SimpleTextMarker.prototype.onRemove = function() {
		    this.node.parentNode.removeChild(this.node);
		};

		// 필수 구현 메소드3
		// 지도의 속성 값들이 변화할 때마다 호출된다. (zoom, center, mapType)
		// 엘리먼트의 위치를 재조정 해 주어야 한다.
		SimpleTextMarker.prototype.draw = function() {
			// 화면 좌표와 지도의 좌표를 매핑시켜주는 projection객체
		    var projection = this.getProjection();
			 // overlayLayer는 지도와 함께 움직이는 layer이므로
		    // 지도 내부의 위치를 반영해주는 pointFromCoords를 사용합니다.
		    var point = projection.pointFromCoords(this.position);
			 
			 // 내부 엘리먼트의 크기를 얻어서
		    var width = this.node.offsetWidth;
		    var height = this.node.offsetHeight;
			//해당 위치의 정중앙에 위치하도록 top, left를 지정합니다
		    this.node.style.left = (point.x - width/2) + "px";
		    this.node.style.top = (point.y - height/2) + "px";

		};
		
		// 좌표를 반환하는 메소드
		SimpleTextMarker.prototype.getPosition = function() {
			alert(this.position);
		    return this.position;
		};
		
		
/* 		createMarker(this.position, new SimpleTextMarker);
 */	
		
		
		
		/* function createOverlay(event, idx) {
			var infoBox_ratingType = 'star-rating';
			
			//var content = document.createElement("div");
			var contentStr = '<div class="map-box">'+
           					 '<a href="/event/detail" class="listing-img-container">'+
           					 '	<div class="infoBox-close"><i class="fa fa-times"></i></div>'+
           					 '	<img src="/resources/images/event/'+event.thumbnail+'" alt="">'+

           					 '	<div class="listing-item-content">'+
             				 '		<h3>'+event.eventName+'</h3>'+
             				 '		<span>'+event.address+'</span>'+
            				 '	</div>'+
							 '</a>'+
							 '<div class="listing-content">'+
            				 '	<div class="listing-title">'+
               				 '		<div class="'+infoBox_ratingType+'" data-rating="3.5"><div class="rating-counter">(10 reviews)</div></div>'+
          					 '	</div>'+
        					 '</div>'
        					 '</div>';
        	//content.innerHTML = contentStr;
       		//	content.className = 'map-box';
        	starRating('.star-rating');
    
			//2)오버레이 찍을 위치
			var overlayPosition = new daum.maps.LatLng(event.latitude, event.longitude);
			//3) 오버레이 생성
			var overlay = new daum.maps.CustomOverlay({
				content : contentStr, //보여줄 내용 
				position : overlayPosition
			});
			//4)만든 오버레이 배열에 추가
			overlays.push(overlay);
			//5) 마커에 오버레이 표시
			createMarker(overlayPosition, overlay);
			return overlay;
		} */
	
		 
		/* function closeOverlay(index){
			 clearOverlay(overlays[index]);
		}  */ 

		function createMarker(placePosition, overlay) {
			var markerPostion = placePosition;
			//makerPostions.push(markerPostion);
			//2) 마커이미지 셋팅
			var imgSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png', 
				imgSize = new daum.maps.Size(24, 36), 
				imgOption = {offset : new daum.maps.Point(27, 69)
			};
			//3) 마커이미지 셋팅값 넣어주기
			var markerImg = new daum.maps.MarkerImage(imgSrc, imgSize,imgOption);
			//4) 마커만들기(이미지, 위치)
			var marker = new daum.maps.Marker({
				position : markerPostion,
				image : markerImg
			});
			//5)마커+오버레이에 클릭이벤트 등록
			markerClick(marker, overlay);
			//6)만든 마커를 배열에 추가
			markers.push(marker);
			
			marker.setMap(map);
		}

	/* 	//마커 이벤트 리스너
		function markerClick(marker, overlay) {
			daum.maps.event.addListener(marker, 'click', function() {
 				overlay.setMap(map);
 			}); 
		} */

		///*****
		// 배열에 추가된 마커들을 지도에 표시
		function setMarkers(map) {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(map);
			}
		}

		function removeAllChildNods(el) {
			while (el.hasChildNodes()) {
				el.removeChild(el.lastChild);
			}
		}
		
		function setOverlay(overlay){
/* 	    	overlay.setMap(map);
 */	    }
		
		function clearOverlay(overlay){
/* 	    	overlay.setMap(null);
 */	    }

		/* function displayPagination(data){
			
		} */
	/* 	
		var dkpos1 = new daum.maps.LatLng(33.450707, 126.570678);
		
		var temp = SimpleTextMarker(dkpos1, 'kakao 본사'); */
	</script>  -->


</body>
</html>