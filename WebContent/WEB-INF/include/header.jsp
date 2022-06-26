<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- CSS 추가 -->
<style>
.navbar-default {
	background-color: #f5d08a;
}

.navbar-default .navbar-nav>.active>a {
	background-color: #ea9a56;
}

/* customerlize */
.container_main {
	margin: auto;
	display: flex;
	width: 80%;
	height: 800px;
	border: 5px solid;
}

.container_right {
	display: inline-block;
	width: 30%;
	height: 100%;
	border: 2px solid;
}

.container_right_top {
	width: 100%;
	height: 30%;
	border: 2px solid;
	text-align: center;
	padding: 10%;
}

.container_right_bottom {
	padding: 10%;
	text-align: center;
	width: 100%;
	height: 70%;
	border: 2px solid;
}

.container_center {
	display: inline-block;
	width: 100%;
	height: 100%;
	border: 2px solid;
}

.container_center_top {
	width: 100%;
	height: 10%;
	border: 2px solid;
}

.container_center_center {
	width: 100%;
	height: 50%;
	border: 2px solid;
}

.container_center_bottom {
	width: 100%;
	height: 10%;
	border: 2px solid;
}

table {
	width: 100%;
}
</style>
<%-- <%@ include file="/WEB-INF/include/dhShortcut.tag"%> --%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active">
					<a href="main.do">夢にホテル</a>
				</li>
				<li class="">
					<a href="noticeList.do">お知らせ</a>
				</li>
				<li class="">
					<a href="roomList.do">客室</a>
				</li>
				<li class="">
					<a href="QnAList.do">相談</a>
				</li>
			</ul>
			<!-- http://bootstrapk.com/components/ 접속 -->
			<ul class="nav navbar-nav navbar-right">
				<li>
					<c:choose>
						<c:when test="${loginedUser }">
							<a href="login.do"><span class="glyphicon glyphicon-log-in">予約確認</span></a>

						</c:when>
						<c:otherwise>
							<a href="login.do"><span class="glyphicon glyphicon-user">User</span></a>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<c:choose>
						<c:when test="${loginedUser }">
							<a href="adminPage.do"><span class="glyphicon glyphicon-log-in">管理者ページ</span></a>

						</c:when>
						<c:otherwise>
							<a href="adminPage.do"><span class="glyphicon glyphicon-user">管理者</span></a>
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div>
	</div>
</nav>
<h4><%=request.getRequestURI()%></h4>