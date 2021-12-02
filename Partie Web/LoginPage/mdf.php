<! doctype html>
<head> 
      <title> Modification </title>
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
$id=$_GET['id'];
$bdd = new PDO('mysql:host=localhost;dbname=login;charset=utf8', 'root', '');
$reponse = $bdd->query("SELECT * FROM zone WHERE id = '$id'");
?>



<div class="container">
   <div class="row">
        <section>
		  <div class="col-lg-8 col-lg-offset-2">    
			   <div class="page-header"> <h1>Modification <small>des Zones éligibles </small></h1> </div>
			   
			  

			   <form name="f" id="f" method="POST" class="form-horizontal" >
			    <?php while ($donnees = $reponse->fetch())
				{?> 
			<input type="hidden" class=" form-control" name="id" id="id" value="<?php echo $donnees["id"]; ?>" />
			      

				  				  <div class="form-group">
                            <label class="col-lg-2 control-label">Nom</label>
                            <div class="col-lg-4">
                            <input type="text" class=" form-control" name="nom" id="nom" value="<?php echo $donnees["nom"]; ?>" />
                            </div>
               </div>
				  
				  <div class="form-group">
                            <label class="col-lg-2 control-label">altitude</label>
                            <div class="col-lg-4">
                            <input type="text" class=" form-control" name="altitude" id="altitude" value="<?php echo $donnees["altitude"]; ?>" />
                            </div>
               </div>
			   

			   <div class="form-group">
                          <label class="col-lg-2 control-label">longitude</label>
                            <div class="col-lg-4">
                            <input type="text" class="form-control" name="longitude"id="longitude" value="<?php echo $donnees["longitude"]; ?>"   />
                            </div>
			   </div>
			   <div class="form-group">
                          <label class="col-lg-2 control-label">Le premier Radius : Indoor </label>
                            <div class="col-lg-4">
                            <input type="text" class="form-control" name="radius1" id="radius1"  value="<?php echo $donnees["radius1"]; ?>"/>
                            </div>
               </div>	
						
						
				<div class="form-group">
                          <label class="col-lg-2 control-label">le deuxième Radius : Outdoor </label>
                            <div class="col-lg-4">
                            <input type="text" class="form-control" name="radius2" id="radius2" value="<?php echo $donnees["radius2"]; ?>" />
                            </div>
               </div>
			   
			   
			    <?php } ?>
				
			   <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-2">
							<a style="text-decoration: none" class="confirmModalLink" > 
                             <button class="btn btn-success" >
                              <span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>   Mettre à jour
                              </button> </a>
							</div>
 			    </div>
			  
 
				  
			   </form>
		  </div>
        </section>
   </div>
</div>

			   
<div class="col-lg-9 col-lg-offset-2">
<div class="col-lg-5 col-lg-offset-2">
<a href="list.php" class="btn btn-block btn-primary"> <span class="glyphicon glyphicon-remove" aria-hidden="true">
</span> Annuler et retourner a la liste des utlisateurs</a>
</div>
</div>



<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> <span class="glyphicon glyphicon-remove" aria-hidden="true"> </span> </button>
            <h4 class="modal-title" id="myModalLabel">Confirmation de Modification</h4>
            </div>
            <div class="modal-body">
            <h3>Voulez vous Modifier cet Zone ?</h3>
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-success" id="confirmModalYes">Modifier</button>
		    <button type="button" class="btn btn-default" id="confirmModalNo">Annuler</button>
        </div>
    </div>
  </div>
</div>

<script type="text/javascript">
function adduser() {
	
	var id=$("#id").val();
	var nom=$("#nom").val();
	var altitude=$("#altitude").val();
	var longitude=$("#longitude").val();
    var radius1=$("#radius1").val();
    var radius2=$("#radius2").val(); 
				
		$.ajax({ // fonction permettant de faire de l'ajax
		   type: "POST", // methode de transmission des données au fichier php
		   url: "mdf2.php", // url du fichier php
		   data: 'id=' + id + '&nom=' + nom + '&altitude=' + altitude + '&longitude=' + longitude +'&radius1=' + radius1 +'&radius2=' + radius2 , // données à transmettre
		   success: function(result){ // si l'appel a bien fonctionné
				$("#confirmModal").modal("hide");
				
				if(result) window.location.href = "list.php";
		   }
		});

				}
$(document).ready(function() {
    $('#f').formValidation({
        message: 'This value is not valid',
       
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
			           nom: {
                validators: {
                    notEmpty: {                      
						message: 'Le nom est obligatoire et ne peut être vide'
                    },					
					regexp: {
                        regexp: /^[A-Z\s]+$/i,
                        message: 'Le nom ne peut pas contenir des caractères alphabétiques et des espaces'
                    }
				
                }
            },
			
			
           altitude: {
                validators: {
                    notEmpty: {                      
						message: 'L altitude est obligatoire et ne peut être vide'
                    },					
					
				
                }
            },
            longitude: {
                validators: {
                    notEmpty: {
                        message: 'La longitude est obligatoire et ne peut être vide'
                    },
					
                }
            },

			
			radius1: {
                validators: {
                    notEmpty: {                      
						message: 'le radius est obligatoire et ne peut être vide'
                    },					
					regexp: {
                        regexp: /^[0-9\s]+$/i,
                        message: 'Le  radius ne peut pas contenir des caractères alphabétiques et des espaces'
                    }
				
                }
            },
            radius2: {
                validators: {
                    notEmpty: {
                        message: 'Le radius est obligatoire et ne peut être vide'
                    },
					regexp: {
                       regexp: /^[0-9\s]+$/i,
                        message: 'Le radius ne peut pas contenir des caractères alphabétiques et des espaces'
                    }
                }
            },
           
        }
    });
});
function myFunction() {
    location.reload();
	}


</script>

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
		adduser();
    });
});

</script>
</body>
</html>