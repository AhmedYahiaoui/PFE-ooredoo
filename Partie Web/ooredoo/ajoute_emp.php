<! doctype html>
<head>
<title> Insertion </title>
</head>
<body>

<?php

$nom=$_POST['nom'];
$prenom=$_POST['prenom'];
if(isset($_POST['sexe'])) $sexe=$_POST['sexe']; else $sexe="";
$statut=$_POST['statut'];
$num_tele=$_POST['num_tele'];
$mail=$_POST['mail'];
$cin=$_POST['cin'];
$pwd=$_POST['pwd'];

mysql_connect("localhost","root","")or die ("problem de connexion au serveur de donnees");
mysql_select_db("login");
$req= "insert into user (nom,prenom,sexe,statut,num_tele,mail,cin,pwd)
      values('$nom','$prenom','$sexe','$statut','$num_tele','$mail','$cin','$pwd')";
$res=mysql_query($req);
if ($res) echo "insertion effectuee"; else echo "erreur d'insertion".mysql_error()."<br>";
mysql_close();

?>

<?php      
    header('Location:ajoute_emp.html');    
?>
</body>
</html>


