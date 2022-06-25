<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
</head>
<body>
	<%
	String readonly = "readonly";
	%>
	<c:if test="${update }">
		<script type="text/javascript">
			
		<%readonly = "required";%>
			
		</script>
	</c:if>
	<%@ include file="../../include/header.jsp"%>
	<form action="noticeDetail.do" method="post">
		<div class="container_main">
			<div class="container_center">
				<div class="container_center_top">
					タイトル : <input type="text" name="title" value="${notice.title }"
						<%=readonly %> />
				</div>
				<div class="container_center_top">
					名前 : <input type="text" name="" value="${loginedName }"
						<%=readonly %> />
				</div>
				<div class="container_center_top">
					パスワード : <input type="text" name="" value="${loginedName }"
						<%=readonly %> />
				</div>
				<div class="container_center_center">
					<textarea style="height: 100%; width: 100%; padding: 2%;"
						name="contents" <%=readonly%>>${notice.contents }</textarea>
				</div>
				<div class="container_center_bottom">
					<c:choose>
						<c:when test="${update }">
							<input value="登録" type="submit" />
						</c:when>
						<c:otherwise>
							<input value="修正" type="button"
								onclick="location.href='noticeDetail.do?update=true'" />
						</c:otherwise>
					</c:choose>

				</div>
				<div class="container_center_bottom">댓글</div>
			</div>
		</div>
	</form>
</body>
</html>