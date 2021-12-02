<?php
	session_start();
	require_once('dbconfig/config.php');
	//phpinfo();
?>

<!DOCTYPE html>
<html>
<head>
<title>Login Admin</title>
<link rel="stylesheet" href="css/style.css">

		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<meta name="description" content="Circular Progress Button with SVG">
		<meta name="keywords" content="circular progress button, progress indicator, svg line animation, radial progress, css">
		<meta name="author" content="Codrops">
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css">
		<link rel="stylesheet" type="text/css" href="css/demo.css">
		<link rel="stylesheet" type="text/css" href="css/component.css">
		<script src="js/modernizr.custom.js"></script>

</head>
<body style="background-color:#bdc3c7">
	<div id="main-wrapper">
	<center><h2><img src="imgs/a.png" width="361" height="54"></h2>
	</center>
			<div class="imgcontainer">
				<img src="imgs/avatar.png" alt="Avatar" class="avatar">
				<br><label><center><b>Admin</b></center></label>
			</div>
		<form action="list_demande.php" method="post">
		
			<div class="inner_container">
				<br><label><center><b>Username</b></center></label>
				<input type="text" placeholder="Enter Username" name="username" required>
				<br>
				<br><label><center><b>Password</b></center></label> 
				<input type="password" placeholder="Enter Password" name="password" required>
				
				<center><div class="progress-button">
						<button name="login" type="submit" <span>Login</span></button>
						<svg class="progress-circle" width="70" height="70">
						<path d="m35,2.5c17.955803,0 32.5,14.544199 32.5,32.5c0,17.955803 -14.544197,32.5 -32.5,32.5c-17.955803,0 -32.5,-14.544197 -32.5,-32.5c0,-17.955801 14.544197,-32.5 32.5,-32.5z" style="stroke-dasharray: 204.244; stroke-dashoffset: 204.244;"></path></svg>
						<svg class="checkmark" width="70" height="70"><path d="m31.5,46.5l15.3,-23.2" style="stroke-dasharray: 27.7908; stroke-dashoffset: 27.7908;"></path><path d="m31.5,46.5l-8.5,-7.1" style="stroke-dasharray: 11.0752; stroke-dashoffset: 11.0752;"></path></svg>
						<svg class="cross" width="70" height="70"><path d="m35,35l-9.3,-9.3" style="stroke-dasharray: 13.1522; stroke-dashoffset: 13.1522;"></path><path d="m35,35l9.3,9.3" style="stroke-dasharray: 13.1522; stroke-dashoffset: 13.1522;"></path><path d="m35,35l-9.3,9.3" style="stroke-dasharray: 13.1522; stroke-dashoffset: 13.1522;"></path><path d="m35,35l9.3,-9.3" style="stroke-dasharray: 13.1522; stroke-dashoffset: 13.1522;"></path></svg>
					</div></center>
			</div>
		</form>
		
		<?php
			if(isset($_POST['login']))
			{
				@$username=$_POST['username'];
				@$password=$_POST['password'];
				$query = "select * from users where username='$username' and password='$password' ";
				//echo $query;
				$query_run = mysqli_query($con,$query);
				//echo mysql_num_rows($query_run);
				if($query_run)
				{
					if(mysqli_num_rows($query_run)>0)
					{
					$row = mysqli_fetch_array($query_run,MYSQLI_ASSOC);
					
					$_SESSION['username'] = $username;
					$_SESSION['password'] = $password;
					
					header( "Location: inscription.html");
					}
					else
					{
						echo '<script type="text/javascript">alert("No such User exists. Invalid Credentials")</script>';
					}
				}
				else
				{
					echo '<script type="text/javascript">alert("Database Error")</script>';
				}
			}
			else
			{
			}
		?>
		
	</div>

</body>
</html>




