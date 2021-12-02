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
$reponse = $bdd->query("SELECT * FROM user WHERE id = '$id'");
?>

<div class="container">
   <div class="row">
        <section>
		  <div class="col-lg-8 col-lg-offset-2">    
			   <div class="page-header"> <h1>Enregister <small> L'Employer </small></h1> </div>
			   
			  

			   <form name="f" id="f" method="POST" class="form-horizontal" >
			    <?php while ($donnees = $reponse->fetch())
				{?> 
			<input type="hidden" class=" form-control" name="id" id="id" value="<?php echo $donnees["id"]; ?>" />
			      
				  				  <div class="form-group">
                            <label class="col-lg-2 control-label">Nom</label>
                            <div class="col-lg-4">
                            <input type="text" class=" form-control" name="Votre nom" id="nom" value="<?php echo $donnees["nom"]; ?>" />
                            </div>
               </div>
				  
				  <div class="form-group">
                            <label class="col-lg-2 control-label">prenom</label>
                            <div class="col-lg-4">
                            <input type="text" class=" form-control" name="Votre prenom" id="prenom" value="<?php echo $donnees["prenom"]; ?>" />
                            </div>
               </div>
			   
			   
			    <div class="form-group">
                          <label class="col-lg-2 control-label">sexe</label>
                            <div class="col-lg-4">
                            <input type="text" class="form-control" name="Votre sexe "id="sexe" value="<?php echo $donnees["sexe"]; ?>"   />
                            </div>
				</div>			

			   <div class="form-group">
                          <label class="col-lg-2 control-label">Statut</label>
                            <div class="col-lg-4">
                            <input type="text" class="form-control" name="Votre Statut"id="statut" value="<?php echo $donnees["statut"]; ?>"   />
                            </div>
			   </div>
			   <div class="form-group">
                          <label class="col-lg-2 control-label">Telephone</label>
                            <div class="col-lg-4">
                            <input type="text" class="form-control" name="Numero telephone" id="num_tele"  value="<?php echo $donnees["num_tele"]; ?>"/>
                            </div>
               </div>	
						
						
				<div class="form-group">
                          <label class="col-lg-2 control-label">E-mail </label>
                            <div class="col-lg-4">
                            <input type="text" class="form-control" name="Adresse electronique" id="mail" value="<?php echo $donnees["mail"]; ?>" />
                            </div>
               </div>
			   
			   
			   	<div class="form-group">
                          <label class="col-lg-2 control-label">Identiter</label>
                            <div class="col-lg-4">
                            <input type="text" class="form-control" name="Carte d'identiter" id="cin" value="<?php echo $donnees["cin"]; ?>" />
                            </div>
               </div>
			   
			   	<div class="form-group">
                          <label class="col-lg-2 control-label">Password </label>
                            <div class="col-lg-4">
                            <input type="text" class="form-control" name="radius2" id="pwd" value="<?php echo $donnees["pwd"]; ?>" />
                            </div>
               </div>
		   
			   
			    <?php } ?>
				
			   <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-2">
							<a style="text-decoration: none" class="confirmModalLink" > 
                             <button class="btn btn-success" >
                              <span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>   Mettre à jour et Enregister
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
<a href="list_demande.php" class="btn btn-block btn-primary"> <span class="glyphicon glyphicon-remove" aria-hidden="true">
</span> Annuler et retourner a la liste des demandes</a>
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
            <h3>Voulez vous Modifier ou Enregister ce utilisateur ?</h3>
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-success" id="confirmModalYes">Modifier et Enregister</button>
		    <button type="button" class="btn btn-default" id="confirmModalNo">Annuler</button>
        </div>
    </div>
  </div>
</div>

<script type="text/javascript">
function adduser() {

	var id=$("#id").val();
	var nom=$("#nom").val();
	var prenom=$("#prenom").val();
	var sexe=$("#sexe").val();
    var statut=$("#statut").val();
    var num_tele=$("#num_tele").val();
    var mail=$("#mail").val();
	var cin=$("#cin").val();
	var pwd=$("#pwd").val();

				
		$.ajax({ // fonction permettant de faire de l'ajax
		   type: "POST", // methode de transmission des données au fichier php
		   url: "envoi_employer.php", // url du fichier php
		   data: 'id=' + id + '&nom=' + nom + '&prenom=' + prenom + '&sexe=' + sexe +'&statut=' + statut +'&num_tele=' + num_tele + '&mail=' + mail +'&cin=' + cin +'&pwd=' + pwd ,
		   // données à transmettre
		   success: function(result){ // si l'appel a bien fonctionné
				$("#confirmModal").modal("hide");
				
				if(result) window.location.href = "list_demande.php";
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
                        message: 'Le  nom ne peut pas contenir des caractères alphabétiques et des espaces'
                    }
				
                }
            },
            prenom: {
                validators: {
                    notEmpty: {
                        message: 'Le prénom est obligatoire et ne peut être vide'
                    },
					regexp: {
                        regexp: /^[A-Z\s]+$/i,
                        message: 'Le  prénom ne peut pas contenir des caractères alphabétiques et des espaces'
                    }
                }
            },
			
			 sexe: {
                validators: {
                    notEmpty: {
                        message: 'Le sexe est obligatoire'
                    }
                }
            },
			
			statut: {
                validators: {
                    notEmpty: {
                        message: 'Le statut est obligatoire et ne peut être vide'
                    },
					regexp: {
                        regexp: /^[A-Z\s]+$/i,
                        message: 'Le statut ne peut pas contenir que des caractères alphabétiques et des espaces'
                    }
                }
            },
			
			cin: {
                validators: {
                    notEmpty: {
                        message: 'La CIN est obligatoire et ne peut être vide'
                    },
					regexp: {
                        regexp: /^[0-9\s]+$/i,
                        message: 'La CIN ne peut pas contenir  des caractères alphabétiques et des espaces'
                    },
					stringLength: {
                        min: 8,
                        max: 8,
                        message: 'La numero du Catre d"identiter doit contenir 8 caractères'
                    }
                }
            },
			
			
			
           mail: {
                validators: {
                    
					notEmpty: {
                        message: 'L adresse email est non valide '
                    },
					
					regexp: {
					          regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                              message: 'L adresse email est non valide'
                    }
					
			
                }
            },
            num_tele: {
                validators: {
                    notEmpty: {
                        message: 'Le numero de telephone est obligatoire et ne peut être vide'
                    },
                    regexp: {
                        regexp: /^[0-9\s]+$/i,
                        message: 'Le numero de telephone ne peut pas contenir  des caractères alphabétiques et des espaces'
                    },
					stringLength: {
                        min: 8,
                        max: 8,
                        message: 'Le numero de telephone doit contenir 8 chiffre'
                    }
				
                }
            },
			
		   pwd: {
                validators: {
                    notEmpty: {
                        message: 'Le numero de telephone est obligatoire et ne peut être vide'
                    },
					stringLength: {
                        min: 6,
                        max: 250,
                        message: 'Le numero de telephone doit contenir 6 chiffres ou lettres au minimum '
                    }
				
                }
            }
		   
		   
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