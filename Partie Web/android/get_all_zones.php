<?php
 
/*
 * ce script va permettre de recuperer la liste des users
 */

$host='localhost';
$uname='root';
$pwd='';
$db="login";

$con = mysqli_connect($host,$uname,$pwd,$db) or die("connection failed");
/* Verification de la connexion */
if (mysqli_connect_errno()) {
    printf("Echec de la connexion : %s\n", mysqli_connect_error());
    $reponse["SUCCESS"] = 0;
    $reponse["MESSAGE"] = "connexion echouee";
     echo json_encode($reponse);

    exit();
}

$reponse=array();

// recupérer la liste

$resultat = mysqli_query($con,"SELECT * FROM zone") or die(mysql_error());
$num_rows = mysqli_num_rows($resultat);

if($num_rows>0){
    // boucler sur les lignes du resultat
    $reponse["ZONES"]=array();
    while ($row = mysqli_fetch_array($resultat)) {
        // un enregistrement en cours
        $zone=array();
        $zone["id"] = $row["id"];
        $zone["altitude"] = $row["altitude"];
        $zone["longitude"] = $row["longitude"];
		$zone["radius1"] = $row["radius1"];
		$zone["radius2"] = $row["radius2"];
 
        // mettre une zone  cree dans le tableau
        array_push($reponse["ZONES"], $zone);
    }
    // success
    $reponse["SUCCESS"] = 1;
    $reponse["MESSAGE"] = "success";

    // envoyer JSON response
    echo json_encode($reponse);
} else {
    // aucune zone
    $reponse["SUCCESS"] = 0;
    $reponse["MESSAGE"] = "aucune zone";
 
    // envoyer json (aucune zone)
    echo json_encode($reponse);
}
mysqli_close($con);
?>