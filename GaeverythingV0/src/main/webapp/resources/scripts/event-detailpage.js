var longitude = document.getElementById('longitude').value;
var latitude = document.getElementById('latitude').value;

var mapContainer = document.getElementById('singleListingMap'), // 지도를 표시할 div
	mapOption = { 
		center: new daum.maps.LatLng(latitude, longitude), // 지도의 중심좌표
		level: 3 // 지도의 확대 레벨
	};
var map = new daum.maps.Map(mapContainer, mapOption); 
var markerPosition  = new daum.maps.LatLng(latitude, longitude); 
var marker = new daum.maps.Marker({
	position: markerPosition
});
map.setCenter(new daum.maps.LatLng(latitude, longitude));
marker.setMap(map);

$('#bookNow').on('click',function(){
	var eventNo = document.getElementById("eventNo3").value;
	checkBooking(eventNo);
	var book = document.getElementById("booking-calendar");
	var url = "/mypage/calendar/addBookingEvent";
	book.action = url;
	book.submit();
});

function checkBooking(eventNo){
	var isLogin = document.getElementById("isLogin3");
	if(isLogin.value==''){
		alert("일정등록은 회원만 가능합니다.");
		location.href = "/viewLogin?uri=/map/detail/viewDetailPage?eventNo="+eventNo;
	}
}

//댓글 등록 버튼 클릭시
$('#registComment').click(function(){
	var eventNo = document.getElementById("eventNo").value;
	checkMessage(eventNo);
	var ds = document.getElementById("add-comment");
	var url = "/event/detail/addComment";
	ds.action = url;
	if($("#commMsg").val()!='' && 
			$('input:radio[name="rating"]').is(":checked")){
		ds.submit();
	}else{
		return;
	}			
});

//댓글 수정 버튼 클릭시
$('#modifyComment').click(function(){
	var ds = document.getElementById("add-comment");
	var url = "/event/detail/editComment";
	ds.action = url;
	ds.submit();
});

//댓글  Edit, Delete
function go_url(type, commNo){	
	var commentNo = document.getElementById("commentNo");
	var commMsg = document.getElementById("commMsg");
	var changeMsg = document.getElementById("changeMsg"+commSeq);
	var ratingVal = document.getElementById("ratingVal"+commSeq);
	var ment = document.getElementById("ment");
	if(type==1){		
		commentNo.value = commSeq;
		commMsg.innerHTML = changeMsg.innerHTML;
		if(ratingVal.value==0.5){
			$('input:radio[name=rating]:input[value="0.5"]').attr("checked", true);			
		}else if(ratingVal.value==1.0){
			$('input:radio[name=rating]:input[value="1.0"]').attr("checked", true);		
		}else if(ratingVal.value==1.5){
			$('input:radio[name=rating]:input[value="1.5"]').attr("checked", true);		
		}else if(ratingVal.value==2.0){
			$('input:radio[name=rating]:input[value="2.0"]').attr("checked", true);		
		}else if(ratingVal.value==2.5){
			$('input:radio[name=rating]:input[value="2.5"]').attr("checked", true);		
		}else if(ratingVal.value==3.0){
			$('input:radio[name=rating]:input[value="3.0"]').attr("checked", true);		
		}else if(ratingVal.value==3.5){
			$('input:radio[name=rating]:input[value="3.5"]').attr("checked", true);		
		}else if(ratingVal.value==4.0){
			$('input:radio[name=rating]:input[value="4.0"]').attr("checked", true);		
		}else if(ratingVal.value==4.5){
			$('input:radio[name=rating]:input[value="4.5"]').attr("checked", true);		
		}else if(ratingVal.value==5.0){
			$('input:radio[name=rating]:input[value="5.0"]').attr("checked", true);		
		}		
		commMsg.focus();
 		$('#modifyComment').show();
		$('#registComment').hide();
		ment.innerHTML = 'Edit Comment';
	}else if(type==2){
		var ds = document.getElementById("add-comment");
		var url = "/event/detail/deleteComment?commentNo="+commNo;
		ds.action = url;
		ds.submit();
	}
}

function addEventPhoto(){
	var url = "/event/detail/addPhoto";
	addPhoto.action = url;
	addPhoto.submit();
}

function box_clicked(eventNo){
	alert("댓글작성은 회원만 가능합니다.");	
	location.href = "/viewLogin?uri=/event/detail/view?no="+eventNo;
}

function no_login_like(eventNo){
	alert("로그인을 해주세요!");
	var eventNo = document.getElementById("eventNo").value;
	location.href = "/viewLogin?uri=/event/detail/view?no="+eventNo;
}

function like_clicked(){
	var class_name = document.getElementById("like").className;
	var eventNo = document.getElementById("eventNo").value;
	var email = document.getElementById("memberEmail").value;
	var url = '/review/updateEventDetailLike?like='+class_name+'&eventNo='+eventNo+'&email='+email;
	var id = document.getElementById("numOflike");
	
	$.ajax({
        url 	 : url,
        dataType : 'json',
        type	 : "POST",
        success  : function(data) {
        	id.innerHTML=data+' people bookmarked this event.'; 
        },
        error : function(request, status, error) {
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
          }
     });
}


//등록시 필수항목 체크
function checkMessage(eventNo){
	  var isLogin = document.getElementById("isLogin");
	  if(isLogin.value==''){
		  alert("댓글작성은 회원만 가능합니다.");	
		  location.href = "/viewLogin?uri=/event/detail/view?no="+eventNo;
	  }else{
		  if($('input:radio[name="rating"]').is(":checked")==false){
			  alert('별점을 표시해주세요.');
		  }
		  if($("#commMsg").val()==''){
			  alert('코멘트를 입력해주세요.');
		  }	
	  }
}

$(document).ready(function() {
	var eventNo = document.getElementById("eventNo").value;
	url = '/event/detail/getCmtData?eventNo='+eventNo;
	$.ajax({
		url 	 : url,
		dataType : 'json',
		type	 :"POST",
		success  : function(commentlist) {
			list = commentlist;
			if(commentlist.length<=5){
				displayInfoList(0,commentlist.length,commentlist);
			}else{
				displayInfoList(0,5,commentlist);	
				commentStart = 5;
				commentEnd = commentlist.length>10?10:commentlist.length;
			}
		},
		error : function(request, status, error) {
			 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
	});		
});

function displayInfoList(start,end,commentlist){
    var listEl = document.getElementById('replyList'),
    fragment = document.createDocumentFragment(),
    itemEl; 
	for(var i=start;i<end;i++){
	    itemEl = getListItem(commentlist[i]);
	    fragment.appendChild(itemEl);
	 }    
    listEl.appendChild(fragment);
    clearStarRating('.star');
    starRating('.star');       
} 

var commentStart;
var commentEnd;
 
$('#commentMore').click(function(){
	 displayInfoList(commentStart,commentEnd,list);	
	 if(commentEnd==list.length){
		 $('#commentMore').hide();
	 }	
	 commentStart = commentStart+5;
	 commentEnd = commentEnd+5;
	 commentEnd = commentEnd>list.length?list.length:commentEnd;
});   

function getListItem(reply) {
	    var el = document.createElement('div');
	    var nickname = document.getElementById('isLogin').value;
	    var regi = new Date(reply.regiDate); 
	    regi = regi.getFullYear() + '-' + leadingZeros((regi.getMonth()+1),2) + '-' + leadingZeros(regi.getDate(),2)
	    +' '+leadingZeros(regi.getHours(),2)+':'+leadingZeros(regi.getMinutes(),2)+':'+leadingZeros(regi.getSeconds(),2);
	    var itemStr ='	<input type="hidden" id="ratingVal'+reply.commentNo+'" value="'+reply.rating+'">'+
		  	'<li><div class="avatar"><img src="/resources/upload/'+reply.photo+'" alt="" /></div>'+
		'<div class="comment-content"><div class="arrow-comment"></div>'+
			'<div class="comment-by">'+
				reply.nickname+'<span class="date">'+regi+'</span>'+
				'<div class="star star-rating" data-rating="'+reply.rating+'"></div>'+
			'</div>'+
			'<p id="changeMsg'+reply.commentSeq+'">'+reply.message+'</p></div>';
			if(nickname==reply.nickname){
				itemStr +=	'<div class="comment-by" >'+
							'	<a class="reply" style="margin-top: 20px;" " onclick="go_url(1, '+reply.commentNo+');" return false; ><i class="sl sl-icon-note"></i> Edit</a>'+
							'</div>';
				itemStr +=	'<div class="comment-by">'+
							'	<a class="reply" style="margin-top: 60px;" " onclick="go_url(2, '+reply.commentNo+');" return false; ><i class="sl sl-icon-note"></i> Delete</a>'+
							'</div>';		
	 		}
			el.innerHTML = itemStr;	
	    return el;
	}	

function leadingZeros(n, digits) {
	  var zero = '';
	  n = n.toString();

	  if (n.length < digits) {
	    for (var i = 0; i < digits - n.length; i++)
	      zero += '0';
	  }
	  return zero + n;
	}

//검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
   while (el.hasChildNodes()) {
       el.removeChild (el.lastChild);
   }
}

var list = [];

var count=1;

function photoListView(start,end,photoList){
    var photoListEl = document.getElementById('photoMoreView'),
    photoFragment = document.createDocumentFragment(),
    photoEl; 
    var El = document.createElement('div');
    photoEl = '<div class="review-images col-lg-12" style="padding-top: 8px;" id="mfp-'+count+'">';
	
	for(var i=start;i<end;i++){
		photoEl += getPhotoList(photoList[i]);
	 }  
	photoEl += '</div>';
	El.innerHTML = photoEl;
    photoFragment.appendChild(El);
    count++;
    photoListEl.appendChild(photoFragment);
} 

var photoStart;
var photoEnd;

/*$('#photoHide').click(function(){
	for(var i=2;i<count;i++){
		$('#mfp-'+i).hide();
	}
});*/

$('#photoMore').click(function(){
	 photoListView(photoStart,photoEnd,pList);	
	 if(photoEnd==pList.length){
		 $('#photoMore').hide();
	 }	
	 photoStart = photoStart+4;
	 photoEnd = photoEnd+4;
	 photoEnd = photoEnd>pList.length?pList.length:photoEnd;
});  

var pList = [];

$(document).ready(function() {
	var eventNo = document.getElementById("eventNo").value;
	url = '/event/detail/getPhotoData?eventNo='+eventNo;
	$.ajax({
		url 	 : url,
		dataType : 'json',
		type	 :"POST",
		success  : function(photoList) {
			pList = photoList;
			if(pList.length<=4){
				photoListView(0,pList.length,pList);
			}else{
				photoListView(0,4,pList);	
				photoStart = 4;
				photoEnd = pList.length>8?8:pList.length;
			}
		},
		error : function(request, status, error) {
			 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
	});		
});

function getPhotoList(photo) {
    var itemStr ='<a href="/resources/upload/'+photo.eventPhoto+'" class="mfp-gallery listing-item-container">'
    			+'<div class="listing-item">'
    			+'<img src="/resources/upload/'+photo.eventPhoto+'" alt="">'
    			+'</div> </a>';
    return itemStr;
}

function makeNearByList(){
	var ele = document.getElementById("nearbyList");
	//for(var i=0; i<; i++){
		nearbyFragment = createDocumentFragment();
		var itemEle = document.createElement("div");
		var nearbyItem = 
		'	<a href="listings-single-page.html" class="listing-item-container">'+
		'		<div class="listing-item">'+
		'			<img src="/resource/images/listing-item-01.jpg" alt="">		'+
		'			<div class="listing-item-content">'+
		'				<span class="tag" style="background: #f91942;">Cafe</span>'+
		'				<h3>Tos Restaurant</h3>'+
		'				<span>964 School Street, New York</span>'+
		'			</div>'+
		'			<span class="like-icon"></span>'+
		'		</div>'+
		'	</a>';
		itemEle.innerHTML = nearbyItem;
		itemEle.className = 'carousel-item';
		nearbyFragment.appendChild(itemEle);
		ele.appendChild(nearbyFragment);
	//}
	return ele;
}