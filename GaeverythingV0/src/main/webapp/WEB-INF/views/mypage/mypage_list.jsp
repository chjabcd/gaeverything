<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Basic Page Needs
================================================== -->
<title>gaeverything</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
================================================== -->
<link rel="stylesheet" href= "<c:url value = '/resources/css/style.css'/>">
<link rel="stylesheet" href= "<c:url value = '/resources/css/colors/main.css'/>" id="colors">

</head>

<body>

<!-- Wrapper -->
<div id="wrapper">

<!-- Header Container
================================================== -->
<header id="header-container" class="fixed fullwidth dashboard">

	<!-- Header -->
	<%@include file = "../header.jsp" %>
	<!-- Header / End -->

</header>
<div class="clearfix"></div>
<!-- Header Container / End -->


<!-- Dashboard -->
<div id="dashboard">

	<!-- Navigation
	================================================== -->

	<!-- Responsive Navigation Trigger -->
	<%@include file= "../navigation_triger.jsp" %>
	<!-- Navigation / End -->


	<!-- Content
	================================================== -->
	<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>My Activities (${member.myCommentSize+member.myReviewSize})</h2>
					<!-- Breadcrumbs -->
					<nav id="breadcrumbs">
						<ul>
							<li><a href="#">Home</a></li>
							<li><a href="#">Dashboard</a></li>
							<li>My Activities</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<div class="row">
	
		<!-- Listings -->
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-20">
					<h4 style="background: #37b6bd; color: white;">Comments on Care (${commentList.size()})</h4>
					<ul>
						<li>
							<div class="comments listing-reviews">
								<ul>
								<c:choose>
								<c:when test="${commentList.size()==0}">
								<li>
								<span>작성한 댓글이 없습니다.</span>
								</li>
								</c:when>
								</c:choose>	
									<c:forEach var="list" items="${commentList}" varStatus="status">									    
									<c:if test="${status.index<2}">	       								
										<li>										
											<div class="comment-by">Your Comments <div class="comment-by-listing own-comment">on <a href="/map/detail/viewDetailPage?locationSeq=${list.locationSeq}"><b>${list.address}</b></a></div> <span class="date">${list.regiDate}</span>
												<div class="star-rating" data-rating="${list.rating}"></div>
											</div>
											<p>${list.message}</p>	
									</li>
									</c:if>
									</c:forEach>
									<%-- <c:choose>
									<c:when test="${fn:length(commentList) > 2}"> --%>
									<li>						
											<a href="/mypage/viewMypageList?category=2" class="read-more">Read More <i class="fa fa-angle-right"></i></a>		
									</li>				
									<%-- </c:when>
									</c:choose> --%>
								</ul>
							</div>
						</li>

					</ul>
				</div>
			</div>
			
			<!-- Listings --><!-- 이벤트디테일의 코멘트 -->
			<div id="listing-event" class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-20">
					<h4 style="background: #F91942; color: white;">Comments on Event (${eCommentList.size()})</h4>
					<ul>
						<li>
							<div class="comments listing-reviews">
								<ul>
								<c:choose>
								<c:when test="${eCommentList.size()==0}">
								<li>
								<span>작성한 댓글이 없습니다.</span>
								</li>
								</c:when>
								</c:choose>	
									<c:forEach var="list" items="${eCommentList}" varStatus="loop"> 
									<c:if test="${loop.index<2}">	    
									<li>										
											<div class="comment-by">Your Comments <div class="comment-by-listing own-comment">on <a href="/event/detail/view?no=${list.eventNo}"><b>${list.eventName}</b></a></div> <span class="date">${list.regiDate}</span>
												<div class="star-rating" data-rating="${list.rating}"></div>
											</div>
											<p>${list.message}</p>
											<%-- <div class="buttons-to-right">
											<a onclick="cmt_url2(${list.commentSeq}, ${loop.index},${list.locationSeq});" class="rate-review"><i class="sl sl-icon-note"></i> Edit</a>										
											<a href="/mypage/removeMyMapCmt?commentSeq=${list.commentSeq}&category=2" class="rate-review"><i class="sl sl-icon-close"></i> Delete</a>		
											</div>	 --%>
											<input type="hidden" id="commNo" value="${list.commentNo}">												
									</li>
									</c:if>
									</c:forEach>
									<li>						
											<a href="/mypage/viewMypageList?category=2" class="read-more">Read More <i class="fa fa-angle-right"></i></a>		
									</li>	
								</ul>
							</div>
						</li>

					</ul>
				</div>
			</div>
			<!-- Listings --><!-- 리뷰게시판의 코멘트 -->
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-20">
					<h4 style="background: #fa5b0f; color: white;">Comments on Review (${bCommentList.size()})</h4>
					<ul>
						<li>
							<div class="comments listing-reviews">
								<ul>
								<c:choose>
								<c:when test="${bCommentList.size()==0}">
								<li>
								<span>작성한 댓글이 없습니다.</span>
								</li>
								</c:when>
								</c:choose>	
									<c:forEach var="list" items="${bCommentList}" varStatus="status">									    
									<c:if test="${status.index<2}">	       								
									<li>										
											<div class="comment-by">Your Comments <div class="comment-by-listing own-comment">on <a href="/review/readPost?boardNo=${list.groupNo}&page=1"><b>${list.title}</b></a></div> <span class="date">${list.regiDate}</span>
											</div>
											<p>${list.commentBody}</p>			
									</li>
									</c:if>
									</c:forEach>
									<li>						
											<a href="/mypage/viewMypageList?category=2" class="read-more">Read More <i class="fa fa-angle-right"></i></a>		
									</li>				
									
								</ul>
							</div>
						</li>

					</ul>
				</div>
			</div>

			<!-- Listings -->
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-20">
					<h4 style="background: #fa5b0f; color: white;">Reviews (${reviewList.size()})</h4>
					<ul>

						<li>
							<div class="comments listing-reviews">
								<ul>
								<c:choose>
								<c:when test="${reviewList.size()==0}">
								<li>
								<span>작성한 리뷰가 없습니다.</span>
								</li>
								</c:when>
								</c:choose>	
									<c:forEach var="list" items="${reviewList}" varStatus="status">									    
									<c:if test="${status.index<2}">	
										<li>
										<div class="list-box-listing">
											<div class="list-box-listing-img"><a href="/review/readPost?boardNo=${list.boardNo}&page=1">
											<c:choose>
											<c:when test="${list.uploadImg!=null}">
											<img src="/resources/upload/${list.uploadImg}" alt="">	
											</c:when>	
											<c:otherwise>
											<img src="/resources/images/hospital.jpg" alt="">	
											</c:otherwise>	
											</c:choose>
											</a></div>
											<div class="list-box-listing-content">
												<div class="inner">
												
										<a href="/review/readPost?boardNo=${list.boardNo}&page=1">
										<span><h3>${list.title}</h3></span></a>
											<div class="comment-by">review <div class="comment-by-listing own-comment">on 
											<a href="/map/detail/viewDetailPage?locationSeq=${list.locationSeq}"><b>${list.address}</b></a></div> 
											<span class="date">${list.regiDate}</span>
											<div class="star-rating" data-rating="${list.rating}"></div>
											</div>
											<p>${list.onlyText}</p>			
									
											</div>
											</div>
										</div>									
										</li>
									</c:if>
									</c:forEach>									
									<li>						
											<a href="/mypage/viewMypageList?category=1" class="read-more">Read More <i class="fa fa-angle-right"></i></a>		
									</li>
								</ul>
							</div>
						</li>

					</ul>
				</div>
			</div>

			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2017 gaeverything. All Rights Reserved.</div>
			</div>
		</div>

	</div>
	<!-- Content / End -->


</div>
<!-- Dashboard / End -->


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


</body>
</html>
