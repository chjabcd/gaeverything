
	function displayInfoList(pList, infoList, amount, page){
	    var listEl = document.getElementById('placesList'), 
	    menuEl = document.getElementById('menu_wrap'),
	    fragment = document.createDocumentFragment(),
	    pageList = document.getElementById('pageList'),
	    itemEl;
	    	    
	    // 검색 결과 목록에 추가된 항목들을 제거합니다
	    removeAllChildNods(listEl);
	    var url = '/map/detail/viewDetailPage?locationSeq=';
	    //페이징 리스트 만들기
	    for(var i=0;i<infoList.length;i++){
	    	// 검색 결과 항목 Element를 생성합니다
		    itemEl = getListItem(i, infoList[i]);
		 	// 검색결과 항목들을 검색결과 목록 Element에 추가합니다
		    fragment.appendChild(itemEl);
		 	
	        (function(marker, title, imageUrl, address, placeUrl, radius) {
	        	itemEl.addEventListener('click', function(){
	            	setOverlay(map, makeContent(title, imageUrl, address, placeUrl, radius), marker.getPosition());
	            }); 
	        })(markers[amount*page+i], infoList[i].title, infoList[i].imageUrl, infoList[i].address, url+infoList[i].locationSeq , infoList[i].radius); 
	    }
	    
 	    // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
	    listEl.appendChild(fragment);
	    pageList.innerHTML = pList;
	}
	
	
	function getListItem(index, places) {
	    var el = document.createElement('div');
	    var itemStr ='<div class="listing-item-container list-layout" data-marker-id="1">'+
	  			   	'<a href="#" class="listing-item">';
	  			   	if(places.imageUrl){
		  			   	itemStr +=	'<div class="listing-item-image">'+
					  			    	'<img src="'+places.imageUrl+'" alt="">'+
					  			    	'<span class="tag">Hospital</span>'+
				  			    	'</div>';
	  			   	}else {
		  			  	itemStr +=	'<div class="listing-item-image">'+
	  			    					'<img src="/resources/images/hospital.jpg" alt="">'+
	  			    					'<span class="tag">Hospital</span>'+
				    				'</div>';		
		  			   	}
	  			  	itemStr +=	'<div class="listing-item-content">'+
				   			    	'<div class="listing-item-inner">'+
				  			    		'<h3>'+places.title+'</h3>'+
				  			    		'<span>'+places.address+'('+places.radius+'km)</span>'+
				  			    		'<div class="star-rating" data-rating="3.5">'+
				  			    			'<div class="rating-counter">(12 reviews)</div>'+
				  			    		'</div>'+
				  			    	'</div>'+
				  			    	'<span class="like-icon"></span>'+
				  			    '</div>'+
				  			'</a>'+
				  		'</div>';
  		el.innerHTML = itemStr;
  		el.className = 'col-lg-12 col-md-12';
	    return el;
	}
	

	 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
	function removeAllChildNods(el) {   
	    while (el.hasChildNodes()) {
	        el.removeChild (el.lastChild);
	    }
	}