<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>

<head>
<title>Login</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link href="/css/style.css" rel="stylesheet" />

<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
	</head>

<body>

<div class="login-form">
						<h1>Sign In</h1>
						<h2><a href="#">Create Account</a></h2>
				<form>
					<li>
						<input type="text" class="text" value="User Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Name';}" ><a href="#" class=" icon user"></a>
					</li>
					<li>
						<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"><a href="#" class=" icon lock"></a>
					</li>
					
					 <div class ="forgot">
						<h3><a href="#">Forgot Password?</a></h3>
						<input type="submit" onclick="myFunction()" value="Sign In" > <a href="#" class=" icon arrow"></a>                                                                                                                                                                                                                                 </h4>
					</div>
				</form>
			</div>
			<!--//End-login-form-->
					<div class="ad728x90" style="text-align:center">
				<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
				<!-- w3layouts_demo_728x90 -->
				<ins class="adsbygoogle"
				     style="display:inline-block;width:728px;height:90px"
				     data-ad-client="ca-pub-9153409599391170"
				     data-ad-slot="8639520288"></ins>
				<script>
				(adsbygoogle = window.adsbygoogle || []).push({});
				</script>
		   </div>


		 


</body>
</html>