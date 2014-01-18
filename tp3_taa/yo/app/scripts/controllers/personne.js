'use strict';


/*****************************************************************************\
 * Factory
\*****************************************************************************/
angular.module('yoApp')
    .factory('personneFactory', ['$http', function($http) {

    var server = 'http://localhost:8080';
    var urlBase = server + '/endomondolike/personnes';
    var dataFactory = {};

    dataFactory.getPersonneById = function (id) {
        return $http.get(urlBase + '/afficher/' + id);
    };
    
    dataFactory.getPersonne = function () {
        return $http.get(urlBase + '/afficher');
    };
    
    dataFactory.login = function (login, password) {
        return $http.get(urlBase + '/login/' + login + '/' + password);
    };

    dataFactory.creer = function (lastName, firstName, mail, password) {
        return $http.put(urlBase + '/creer/ ' + lastName + '/' + firstName + '/' + mail + '/' + password);
    };

    dataFactory.modifier = function (id, lastName, firstName, mail, password) {
        return $http.post(urlBase + '/modifier/' + id + '/' + lastName + '/' + firstName + '/' + mail + '/' + password);
    };

    dataFactory.getAmis = function (id) {
        return $http.get(urlBase + '/rechercherAmis/' + id);
    };

    dataFactory.ajouterAmis = function (id, idAmis) {
        return $http.put(urlBase + '/ajouterAmis/ ' + id + '/' + idAmis);
    };

    dataFactory.supprimerAmis = function (id, idAmis) {
        return $http.delete(urlBase + '/supprimerAmis/' + id + '/' + idAmis);
    };

    dataFactory.supprimer = function (id) {
        return $http.delete(urlBase + '/supprimer/' + id);
    };

    return dataFactory;
}]);
/*****************************************************************************/




/*****************************************************************************\
 * Controller
\*****************************************************************************/
angular.module('yoApp')
  .controller('PersonneController', ['$scope', '$routeParams', 'personneFactory', 
        function ($scope, $routeParams, dataFactory) {
    
        /*********************************************************************\
         * Variables
        \*********************************************************************/
        $scope.amis;
        $scope.status;
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Code jQuery pour le switch entre "Identification" et "Enregistrement"
        \*********************************************************************/
        $(function() {
            function redirectToRegister() {
                $(".form-signin-heading").text("Enregistrement");
                $(".login").hide();
                $(".register").show();
            }
            
            
            function redirectToLogin() {
                $(".form-signin-heading").text("Identification");
                $(".register").hide();
                $(".login").show();
            }
            
            $(".register").hide();
        
            $("#registerLink")
                .button()
                .click(function(event) {
                    event.preventDefault();
                    redirectToRegister();
                });
        
            $("#loginLink")
                .button()
                .hide()
                .click(function(event) {
                    event.preventDefault();
                    redirectToLogin();
                });
        });
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Initialisation
        \*********************************************************************/
        $scope.initialiserChamps = function() {
            dataFactory.getPersonneById($routeParams.personneId)
                .success(function (personne) {
                    $scope.status = 'Ok';
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération de la personne';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Create
        \*********************************************************************/
        $scope.creer = function() {
            var firstName = initialiserParametreString($scope.firstName);
            var lastName = initialiserParametreString($scope.lastName);
            var mail = initialiserParametreString($scope.mail);
            var password = initialiserParametreString($scope.password);
            
            dataFactory.creer(lastName, firstName, mail, password)
                .success(function (personne) {
                    $scope.status = 'Personne créée';
                    
                    // Pas le temps de faire sécurisé
                    localStorage['authentificated'] = true;
                    window.location = "#/";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la création de la personne';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Read
        \*********************************************************************/
        $scope.login = function() {
            var mail = initialiserParametreString($scope.mail);
            var password = initialiserParametreString($scope.password);
            
            dataFactory.login(mail, password)
                .success(function (authentificated) {
                    $scope.status = 'Ok';
                    
                    if (authentificated === "true") {
                        // Pas le temps de faire sécurisé
                        localStorage['authentificated'] = true;
                        window.location = "#/";
                    }
                    else {
                        $("#login-failed").modal('show');
                    }
                })
                .error(function (error) {
                    $scope.status = 'Echec de la tentative de connexion';
                });
        }
        
        
        $scope.getAmis = function() {
            dataFactory.getAmis() // TODO : Ajouter l'id en paramètre
                .success(function (amis) {
                    $scope.status = 'Ok';
                    $scope.amis = amis;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération des amis';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Update
        \*********************************************************************/
        $scope.modifier = function() {
            var firstName = initialiserParametreInt($scope.firstName);
            var lastName = initialiserParametreInt($scope.lastName);
            var mail = initialiserParametreInt($scope.mail);
            var password = initialiserParametreInt($scope.password);
            
            dataFactory.modifier($routeParams.personneId, lastName, firstName, mail, password)
                .success(function () {
                    $scope.status = 'Personne modifiée';
                    
                    window.location = "#/dashboard";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la modification de la personne';
                });
        }
        
        
        $scope.ajouterAmis = function() {
            dataFactory.ajouterAmis($routeParams.personneId, $scope.newFriendId)
                .success(function () {
                    $scope.status = 'Amis ajouté';
                    
                    window.location = "#/amis";
                })
                .error(function (error) {
                    $scope.status = 'Echec de l\'ajout de la personne en amis';
                });
        }
        
        
        $scope.supprimerAmis = function() {
            dataFactory.supprimerAmis($routeParams.personneId, $scope.oldFriendId)
                .success(function () {
                    $scope.status = 'Amis supprimé';
                    
                    window.location = "#/amis";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la suppression de la personne en amis';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Delete
        \*********************************************************************/
        $scope.supprimer = function(id) {
            dataFactory.supprimer(id)
                .success(function () {
                    $scope.status = 'Personne supprimée';
                    
                    window.location = "#/login";
                }) .error(function (error) {
                    $scope.status = 'Echec de la suppression de la personne';
                    
                    alert("Echec de la suppression de la personne.");
                });
        }
        /*********************************************************************/
  }]);
/*****************************************************************************/
