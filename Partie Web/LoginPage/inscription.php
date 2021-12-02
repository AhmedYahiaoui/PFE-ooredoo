<! doctype html>
<head>
<title> Insertion </title>
</head>
<body>

<?php
$nom=$_POST['nom'];
$altitude=$_POST['altitude'];
$longitude=$_POST['longitude'];
$radius1=$_POST['radius1'];
$radius2=$_POST['radius2'];


mysql_connect("localhost","root","")or die ("problem de connexion au serveur de donnees");
mysql_select_db("login");
$req= "insert into zone (nom,altitude,longitude,radius1,radius2)values('$nom','$altitude','$longitude','$radius1','$radius2')";
$res=mysql_query($req);
if ($res) echo "insertion effectuee"; else echo "erreur d'insertion".mysql_error()."<br>";
mysql_close();

?>

<?php      
    header('Location:inscription.html');    
?>
</body>
</html>
















