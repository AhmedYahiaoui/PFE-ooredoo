<! doctype html>
<head> 
      <title>Liste des Employers</title>
      <meta charset="UTF-8">
      <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.css"/>
      <link rel="stylesheet" href="dist/css/formValidation.css"/>
      <script type="text/javascript" src="vendor/jquery/jquery.min.js"></script>
      <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="dist/js/formValidation.js"></script>
      <script type="text/javascript" src="dist/js/framework/bootstrap.js"></script>	
</head>

<body background="img/ins.jpg">
<?php
  $bdd = new PDO('mysql:host=localhost;dbname=login;charset=utf8', 'root', '');
  $reponse = $bdd->query('SELECT * FROM user_acc');
?>
 <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <ul class="nav navbar-nav">
		  <li> <a href="http://localhost/ooredoo/index.html"> <span class="glyphicon glyphicon-home" aria-hidden="true"> </span>  Accueil</a> </li>
            <li> <a href="list_demande.php"> <span class="glyphicon glyphicon-user" aria-hidden="true"> </span>  Liste des demandes </a> </li>
            <li class="active"> <a href="affiche_emp.php"> <span class="glyphicon glyphicon-user" aria-hidden="true"> </span>  Liste des Employers (Accepté) </a> </li>           
			
          </ul>
        </div>
      </nav>


<div class="container">
    <div class="row">
          <section>
		  <div class="col-lg-8 col-lg-offset-2">
               
<table class="table table-striped" style="border-width:1px;border-color:black;" >  
   <thead>
      <tr>

		 <th>Nom</th>
	     <th>E-mail</th>
   	     <th>Password</th>
	     <th>Options </th>
		 
	  </tr>
   </thead>
   <tbody>
   <?php while ($donnees = $reponse->fetch())
   {
   ?>
   <tr>
   <td> <?php echo $donnees["nom"]; ?> </td>
   <td> <?php echo $donnees["mail"]; ?> </td>
   <td> <?php echo $donnees["pwd"]; ?> </td>   
   <td> 

	
<a style="text-decoration: none" class="confirmModalLink" href="supp_emp.php?id=<?php echo $donnees["id"]; ?>"> 
<button  class="btn btn-danger"> 
<span class="glyphicon glyphicon-trash" aria-hidden="true"> </span> </button></a> 								
   </td>
   </tr>   
   </tbody>                                                                     
   <?php } 
   $reponse->closeCursor();
   ?>
</table>
<div class="col-lg-4 col-lg-offset-4">
</div>
	 	   
</div>
</section>
</div>
</div>
<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> <span class="glyphicon glyphicon-remove" aria-hidden="true"> </span> </button>
            <h4 class="modal-title" id="myModalLabel">Confirmation de suppression</h4>
            </div>
            <div class="modal-body">
            <h3>Voulez vous supprimer cette Coordonées ?</h3>
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-danger" id="confirmModalYes">Supprimer</button>
		    <button type="button" class="btn btn-default" id="confirmModalNo">Annuler</button>
        </div>
    </div>
  </div>
</div>
<footer style="position: absolute;bottom: 0;">
        <div class="container text-center">
            <p>Copyright &copy;  2017</p>
        </div>
    </footer>
<script>
$(document).ready(function () {
    var theHREF;

    $(".confirmModalLink").click(function(e) {
        e.preventDefault();
        theHREF = $(this).attr("href");
        $("#confirmModal").modal("show");
    });

    $("#confirmModalNo").click(function(e) {
        $("#confirmModal").modal("hide");
    });

    $("#confirmModalYes").click(function(e) {
        window.location.href = theHREF;
    });
});
</script>
</body>
</html>