<! doctype html>
<head>
<title> supp </title>
</head>
<body>

<?php
$id=$_GET['id'];

mysql_connect("localhost","root","")or die ("problem de connexion au serveur de donnees");
mysql_select_db("login");
$req= "DELETE FROM zone 
       WHERE id = '$id'" ;
	  $res=mysql_query($req);
if ($res) echo "suppresion effectuee"; else echo "erreur de suppresion".mysql_error()."<br>";
mysql_close();

 
?>

<?php
header('Location:list.php');    
?>
</body>
</html>