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
	String readonly = "required";
	%>
	<c:if test="${detail }">
		<script type="text/javascript">
		<%readonly = "readonly";%>
		</script>
	</c:if>
	<div class="container_main">
		<div class="container_center">
			<div class="h-[100%]">
				<form action="qnADetail.do" method="post">
					<div class="container_center_top">
						タイトル : <input type="text" name="title"
							value="${consultation.title }" <%=readonly %> />
					</div>
					<div class="container_center_center">
						<textarea style="height: 100%; width: 100%; padding: 2%;"
							name="contents" <%=readonly%>>${consultation.contents }</textarea>
					</div>
					<div class="container_center_bottom">
						<c:choose>
							<c:when test="${not detail }">
								<input value="登録" type="submit" />
							</c:when>
							<c:otherwise>
								<c:if test="${loginedAdmin }">
									<input value="修正" type="button"
										onclick="location.href='qnADetail.do?type=update'" />
								</c:if>
							</c:otherwise>
						</c:choose>
					</div>
				</form>
			</div>
			<div class="container_center_bottom">
				<div class="flex justify-center items-center h-[100%]">
					<span class="text-4xl">返事</span>
				</div>
			</div>
			<div class="container_center_bottom">
				<form action=""
					class="h-[100%] grid grid-flow-row-dense grid-cols-2 flex justify-center items-center">
					<div class="flex justify-between mx-20">
						Name : <input type="text" name="name" class="w-150 border-2 h-10" />
					</div>
					<div class="flex justify-between mx-20">
						passwd : <input type="text" name="passwd"
							class="w-150 border-2 h-10" />
					</div>
					<div class="flex justify-between mx-20">
						title : <input type="text" name="title"
							class="w-150 border-2 h-10" />
					</div>
					<div class="flex justify-between mx-20">
						contents : <input type="text" name="contents"
							class="w-150 border-2 h-10" />
					</div>
					<div class="flex justify-between mx-20">
						<input value="登録"
							onclick="location.href='QnADetail.do?type=create&create=reply'"
							class="btn-header-admin-open border border-indigo-500 bg-indigo-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-indigo-600 focus:outline-none focus:shadow-outline"
							type="button" />
					</div>
				</form>
			</div>
			<div class="container_center_bottom">
				<c:forEach var="reply" items="${replys }">
					<div class="flex justify-between mx-20">Name : ${reply.name }
					</div>
					<div class="flex justify-between mx-20">title : ${reply.title }
					</div>
					<div class="flex justify-between mx-20">contents :
						${reply.contents }</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>