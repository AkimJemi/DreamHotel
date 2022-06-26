<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../include/header.jsp"%>
<meta charset="UTF-8">
<title>QnADetail.jsp</title>
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
	<form action="noticeDetail.do" method="post">
		<div class="container_main">
			<div class="container_center">
				<div class="container_center_top">
					タイトル : <input type="text" name="title" value="${consultation.title }"
						<%=readonly %> />
				</div>
				<div class="container_center_center">
					<textarea style="height: 100%; width: 100%; padding: 2%;"
						name="contents" <%=readonly%>>${consultation.contents }</textarea>
				</div>
				<div class="container_center_bottom">
					<c:choose>
						<c:when test="${update }">
							<input value="登録" type="submit" />
						</c:when>
						<c:otherwise>
							<c:if test="${loginedAdmin }">
								<input value="修正" type="button"
									onclick="location.href='noticeDetail.do?update=true'" />
							</c:if>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="container_center_bottom">댓글</div>
			</div>
		</div>
	</form>
</body>
</html>