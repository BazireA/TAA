'use strict';

/*****************************************************************************\
 * Factory
\*****************************************************************************/
angular.module('yoApp')
    .factory('parcoursFactory', ['$http', function($http) {

    var server = 'http://localhost:8080';
    var urlBase = server + '/endomondolike/parcours';
    var dataFactory = {};

    dataFactory.getParcoursById = function (id) {
        return $http.get(urlBase + '/afficher/' + id);
    };

    dataFactory.getParcours = function () {
        return $http.get(urlBase + '/afficher');
    };

    dataFactory.creer= function (name) {
        return $http.put(urlBase + '/creer/' + name);
    };

    dataFactory.modifier = function (id, name) {
        return $http.post(urlBase + '/modifier/' + id + '/' + name);
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
  .controller('ParcoursController', ['$scope', '$routeParams', 'parcoursFactory',
        function ($scope, $routeParams, dataFactory) {
    
        /*********************************************************************\
         * Variables
        \*********************************************************************/
        $scope.lesParcours;
        $scope.status;
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Initialisation
        \*********************************************************************/
        $scope.initialiserChamps = function() {
            dataFactory.getParcoursById($routeParams.parcoursId)
                .success(function (parcours) {
                    $scope.status = 'Ok';
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération de la parcours';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Create
        \*********************************************************************/
        $scope.creer = function() {
            var name = initialiserParametreString($scope.name);
            
            dataFactory.creer(name)
                .success(function (playlist) {
                    $scope.status = 'Parcours créée';
                    
                    window.location = "#/parcours";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la création du parcours';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Read
        \*********************************************************************/
        $scope.getParcours = function () {
            dataFactory.getParcours()
                .success(function (parcours) {
                    $scope.status = 'Ok';
                    $scope.lesParcours = parcours;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération des parcours';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Update
        \*********************************************************************/
        $scope.modifier = function() {
            var name = initialiserParametreString($scope.name);
            
            dataFactory.modifier($routeParams.playlistId, name)
                .success(function (playlist) {
                    $scope.status = 'Parcours modifiée';
                    
                    window.location = "#/parcours";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la modification du parcours';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Delete
        \*********************************************************************/
        $scope.supprimer = function(id) {
            dataFactory.supprimer(id)
                .success(function (result) {
                    $scope.status = 'Parcours supprimée';
                    
                    document.location.reload(true);
                }) .error(function (error) {
                    $scope.status = 'Echec de la suppression du parcours';
                    
                    alert("Echec de la suppression du parcours.");
                });
        }
        /*********************************************************************/
  }]);
/*****************************************************************************/
