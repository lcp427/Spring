<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello</title>
<style type="text/css">
html,body,section,div,h1,h2,h3,h4,i,span,p,ul,dl,dt,dd,li,ol,input,textarea
	{
	margin: 0;
	padding: 0;
}

ul,ol,dl,dt,dd,li {
	list-style: none
}

h1,h2,h3,h4 {
	font-weight: normal;
}

body {
	font-family: 'Microsoft Yahei', arial, sans-serif;
}

img {
	border: 0;
	max-width: 100%;
}

i {
	font-style: normal;
}

a {
	text-decoration: none
}

.center {
	text-align: center;
}

.relative {
	position: relative;
}

.flex {
	display: -webkit-box;
	display: -webkit-flex;
	display: flex;
}

.flex-item {
	-webkit-box-flex: 1;
	-webkit-flex: 1;
	flex: 1;
	width: 1px;
	display: block;
}

html,body {
	min-height: 100%;
}

.body-bg {
	background: #f4f4f4;
	height: 100%;
}

.header {
	background: #f26743 url(../img/head-bg.png) no-repeat center 25px;
	height: 140px;
	padding-top: 25px;
	color: #ffdc70;
	font-size: 26px;
	text-align: center;
}

.wrap {
	background: url(../img/wave.png) repeat-x left top;
}

.wrap-bg {
	padding-top: 25px;
	background: url(../img/code-bg.png)
		no-repeat center 25px;
}

.lottery {
	width: 328px;
	margin: 0 auto;
	padding-top: 38px;
}

.lottery .lottery-bg {
	height: 251px;
	border-radius: 3px;
	padding: 20px;
}

.lottery .lottery-cont {
	background: #bcdfd1 url(http://p0.qhmsg.com/t01f23782f9f93b7c02.png);
	background-image: -webkit-image-set(url(http://p0.qhmsg.com/t01f23782f9f93b7c02.png) 1x,
		url(http://p9.qhmsg.com/t0192466381c34dac35.png) 2x);
	background-size: 56px auto;
	background-position: 6px 6px;
	border-radius: 3px
}

.lottery .lottery-bg {
	background: url(http://p9.qhmsg.com/t01e1d4ae550e1dcd7c.png);
	background-image: -webkit-image-set(url(http://p9.qhmsg.com/t01e1d4ae550e1dcd7c.png) 1x,
		url(http://p9.qhmsg.com/t01f8aeb8cba6441386.png) 2x);
	background-size: 56px auto;
	background-position: 6px 6px;
	animation: flash 1s infinite;
	-webkit-animation: flash 1s infinite;
}

@-webkit-keyframes flash { 
0% {
	background: url(http://p9.qhmsg.com/t01e1d4ae550e1dcd7c.png);
	background-image: -webkit-image-set(url(http://p9.qhmsg.com/t01e1d4ae550e1dcd7c.png) 1x,
		url(http://p9.qhmsg.com/t01f8aeb8cba6441386.png) 2x);
	background-position: 6px 6px;
	}

50%{background:none;background-position:6px 6px;}
}

@keyframes flash { 
0% {
	background: url(http://p9.qhmsg.com/t01e1d4ae550e1dcd7c.png);
	background-image: -webkit-image-set(url(http://p9.qhmsg.com/t01e1d4ae550e1dcd7c.png) 1x,
		url(http://p9.qhmsg.com/t01f8aeb8cba6441386.png) 2x);
	background-position: 6px 6px;
}
50%{background:none;background-position: 6px 6px;}
}
.lottery .lottery-inner {
	border-radius: 3px;
	background: #95beb5;
	width: 100%;
	height: 100%;
}

.bgicon {
	background: url(http://p6.qhmsg.com/d/inn/49c3d25d/icon.png) no-repeat;
} 
.bottom {
	padding: 0 30px;
	text-align: center;
	line-height: 1.6;
}

.qrcode-top {
	width: 100px;
	height: 80px;
	background-position: 0 16px;
	margin: 0 auto;
}

.qrcode {
	padding: 7px;
	background-color: #ebfdf6;
	display: inline-block;
	margin-top: -9px
}

.qrcode img {
	display: block;
}

.act-time {
	color: #f26743;
	text-align: center;
	margin-top: 13px;
	margin-bottom: 15px
}

.btn-wrap {
	text-align: center;
}

.btn-wrap a {
	text-decoration: none
}

.btn-cyan {
	display: inline-block;
	height: 44px;
	position: relative;
	width: 156px;
	background-position: 0 -180px;
	text-align: center;
	line-height: 44px;
	color: #bb4c41;
}

.btn-cyan:hover {
	background-position: 0 -304px;
}
</style>
</head>
<body class="body-bg">
	<div class="header">Redis例子 HELLO</div>
	<div class="wrap">
		<div class="wrap-bg">
		</div>
	</div>
</body>

</html>