<! doctype html>
<head>
<title> Accepter le demande </title>
</head>
<body>

<?php

$id=$_POST['id'];
$nom=$_POST['nom'];
$mail=$_POST['mail'];
$pwd=$_POST['pwd'];


$bdd = new PDO('mysql:host=localhost;dbname=login;charset=utf8', 'root', '');
$reponse = $bdd->query("insert into user_acc (nom,mail,pwd)
  //    values('$nom','$mail','$pwd') WHERE id = '$id'");


//mysql_connect("localhost","root","")or die ("problem de connexion au serveur de donnees");
//mysql_select_db("login");
//$req= "insert into user_acc (nom,mail,pwd)
  //    values('$nom','$mail','$pwd')";
//$res=mysql_query($req);
//if ($res) echo "insertion effectuee"; else echo "erreur d'insertion".mysql_error()."<br>";
//mysql_close();

?>

<?php      
    header('Location:list_demande.php');    
?>
</body>
</html>
