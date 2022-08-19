<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.tailwindcss.com"></script>

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

@font-face {
	font-family: 'Happiness-Sans-Title';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/Happiness-Sans-Title.woff2')
		format('woff2');
	font-weight: normal;
	font-style: normal;
}

html>body {
	font-family: 'Happiness-Sans-Title';
}

.navbar-right li {
	width: 180px;
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
				<li>${loginedUser }/${loginedAdmin }</li>
				<li>
					<br>
					<a href="logout.do?a=all"><i
						class="fa-solid fa-arrow-right-from-bracket"></i>
						<button
							class="btn-header-admin-open border border-indigo-500 bg-indigo-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-indigo-600 focus:outline-none focus:shadow-outline">initialization</button></a>
				</li>
				<li>
					<br>
					<c:if test="${loginedUser }">
						<a href="logout.do?a=user"><i
							class="fa-solid fa-arrow-right-from-bracket"></i>
							<button
								class="btn-header-admin-open border border-indigo-500 bg-indigo-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-indigo-600 focus:outline-none focus:shadow-outline">U-Logout</button></a>
					</c:if>
				</li>
				<li>
					<br>
					<c:if test="${loginedAdmin }">
						<a href="logout.do?a=admin"><i
							class="fa-solid fa-arrow-right-from-bracket"></i>
							<button
								class="btn-header-admin-open border border-indigo-500 bg-indigo-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-indigo-600 focus:outline-none focus:shadow-outline">A-Logout</button>
						</a>
					</c:if>
				</li>
				<li>
					<br>
					<c:choose>
						<c:when test="${loginedUser }">
							<a href="login.do"><span class="glyphicon glyphicon-log-in"></span>
								<button
									class="border border-indigo-500 bg-indigo-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-indigo-600 focus:outline-none focus:shadow-outline">予約確認</button></a>

						</c:when>
						<c:otherwise>
							<a><span class="glyphicon glyphicon-user"></span>
								<button
									class="btn-header-user-open border border-indigo-500 bg-indigo-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-indigo-600 focus:outline-none focus:shadow-outline">U-Login</button>
							</a>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<br>
					<c:choose>
						<c:when test="${loginedAdmin }">
							<a href="adminPage.do"><button
									onclick="location.href='adminPage.do'"
									class="border border-indigo-500 bg-indigo-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-indigo-600 focus:outline-none focus:shadow-outline">
									<span class="glyphicon glyphicon-log-in"></span> 管理者ページ
								</button> </a>
						</c:when>
						<c:otherwise>
							<a><span class="glyphicon glyphicon-user"></span>
								<button
									class="btn-header-admin-open border border-indigo-500 bg-indigo-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-indigo-600 focus:outline-none focus:shadow-outline">A-Login</button>
							</a>

						</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div>
	</div>
</nav>

<!-- User Login -->
<div
	class="popup-User hidden flex justify-center items-center absolute top-0 left-0 right-0 bottom-0 bg-[#000000AA] z-100">
	<form action="login.do" method="post">
		<div class="popup-content min-w-[500px] min-h-[400px] bg-white z-100">
			<div class="min-h-[20px] min-w-[100px] bg-red-100 flex justify-end">
				<span class="btn-header-admin-close p-3 cursor-pointer"><i
					class="fa fa-times-circle"></i></span>
			</div>
			Name : <input type="text" name="name" /> Phone : <input type="text"
				name="phone" /> <input type="submit"
				class="border border-teal-500 bg-teal-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-teal-600 focus:outline-none focus:shadow-outline"
				value="Sumbit" />
		</div>
	</form>
</div>

<!-- Admin Login -->
<div
	class="popup-Admin hidden flex justify-center items-center absolute top-0 left-0 right-0 bottom-0 bg-[#000000AA] z-100">
	<form action="adminPage.do" method="post">
		<div class="popup-content min-w-[500px] min-h-[400px] bg-white z-100">
			<div class="min-h-[20px] min-w-[100px] bg-red-100 flex justify-end">
				<span class="btn-header-admin-close p-3 cursor-pointer"><i
					class="fa fa-times-circle"></i></span>
			</div>
			AdminCode : <input type="text" name="adminCode" /> <input
				type="submit"
				class="border border-teal-500 bg-teal-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-teal-600 focus:outline-none focus:shadow-outline"
				value="Sumbit" />
		</div>
	</form>
</div>
<script type="text/javascript">
	$('.btn-header-user-open').click(function() {
		$(".popup-User").removeClass("hidden");
	});
	$('.btn-header-user-close').click(function() {
		$(".popup-User").addClass("hidden");
	});
	$('.btn-header-admin-open').click(function() {
		$(".popup-Admin").removeClass("hidden");
	});
	$('.btn-header-admin-close').click(function() {
		$(".popup-Admin").addClass("hidden");
	});
</script>
<h4><%=request.getRequestURI()%></h4>
<h4><%=request.getSession().getAttribute("loginedAdmin")%></h4>
<h4><%=request.getParameterMap().containsKey("type")%></h4>