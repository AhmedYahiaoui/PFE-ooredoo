<! doctype html>
<head>
<title> supp </title>
</head>
<body>

<?php
$id=$_POST['id'];
$nom=$_POST['nom'];
$altitude=$_POST['altitude'];
$longitude=$_POST['longitude'];
$radius1=$_POST['radius1'];
$radius2=$_POST['radius2'];


$bdd = new PDO('mysql:host=localhost;dbname=login;charset=utf8', 'root', '');
$reponse = $bdd->query('UPDATE zone SET nom="'.$nom.'",altitude="'.$altitude.'",longitude="'.$longitude.'",radius1="'.$radius1.'",radius2="'.$radius2.'" WHERE id="'.$id.'"');
?>
</body>
</html>