<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>main.jsp</title>
<link rel="stylesheet" href="./css/slideCss.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 반응형 웹 : 웹페이지 뿐 아니라 기기에 맞는 사이즈를 만든다. -->
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<div class="slider" >
    <input type="radio" name="slide" id="slide1" checked>
    <input type="radio" name="slide" id="slide2">
    <input type="radio" name="slide" id="slide3">
    <input type="radio" name="slide" id="slide4">
    <ul id="imgholder" class="imgs">
        <li><img src="./img/slide1.jpg"></li>
        <li><img src="./img/slide2.jpg"></li>
        <li><img src="./img/slide3.jpg"></li>
        <li><img src="./img/slide4.jpg"></li>
    </ul>
    <div class="bullets">
        <label for="slide1">&nbsp;</label>
        <label for="slide2">&nbsp;</label>
        <label for="slide3">&nbsp;</label>
        <label for="slide4">&nbsp;</label>
    </div>
</div>
</body>
</html>
