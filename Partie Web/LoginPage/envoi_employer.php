<! doctype html>
<head>
<title> supp </title>
</head>
<body>

<?php

$id=$_POST['id'];
$nom=$_POST['nom'];
$mail=$_POST['mail'];
$pwd=$_POST['pwd'];
   
mysql_connect("localhost","root","")or die ("problem de connexion au serveur de donnees");
mysql_select_db("login");
$req= "insert into user_acc (nom,mail,pwd)
    values('$nom','$mail','$pwd')";
$res=mysql_query($req);
if ($res) echo "insertion effectuee"; else echo "erreur d'insertion".mysql_error()."<br>";
mysql_close();
  
  
  ?>
</body>
</html>