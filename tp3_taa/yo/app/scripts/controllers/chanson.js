'use strict';

/*****************************************************************************\
 * Factory
\*****************************************************************************/
angular.module('yoApp')
    .factory('chansonFactory', ['$http', function($http) {

    var server = 'http://localhost:8080';
    var urlBase = server + '/endomondolike/chansons';
    var dataFactory = {};

    dataFactory.getChansonById = function (id) {
        return $http.get(urlBase + '/afficher/' + id);
    };

    dataFactory.getChansons = function () {
        return $http.get(urlBase + '/afficher');
    };

    dataFactory.creer = function (name, duration) {
        return $http.put(urlBase + '/creer/' + name + '/' + duration);
    };

    dataFactory.modifier = function (id, name, duration) {
        return $http.post(urlBase + '/modifier/' + id + '/' + name + '/' + duration);
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
  .controller('ChansonController', ['$scope', '$routeParams', 'chansonFactory', 
        function ($scope, $routeParams, dataFactory) {
    
        /*********************************************************************\
         * Variables
        \*********************************************************************/
        $scope.chansons;
        $scope.status;
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Initialisation
        \*********************************************************************/
        $scope.initialiserChamps = function(id) {
            dataFactory.getChansonById(id)
                .success(function (chanson) {
                    $scope.status = 'Ok';
                    
                    $scope.name = chanson.nom;
                    $scope.duration = chanson.nom;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération de la playlist';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Create
        \*********************************************************************/
        $scope.creer = function() {
            var name = initialiserParametreString($scope.name);
            var duration = initialiserParametreInt($scope.duration);
            
            dataFactory.creer(name, duration)
                .success(function (chanson) {
                    $scope.status = 'Chanson créée';
                    
                    document.location.reload(true);
                })
                .error(function (error) {
                    $scope.status = 'Echec de la création de la chanson';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Read
        \*********************************************************************/
        $scope.getChansons = function () {
            dataFactory.getChansons()
                .success(function (chansons) {
                    $scope.status = 'Ok';
                    $scope.chansons = chansons;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération des chansons';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Update
        \*********************************************************************/
        $scope.modifier = function() {
            var name = initialiserParametreString($scope.name);
            var duration = initialiserParametreInt($scope.duration);
            
            dataFactory.modifier($routeParams.playlistId, name, duration)
                .success(function (chanson) {
                    $scope.status = 'Chanson modifiée';
                    
                    document.location.reload(true);
                })
                .error(function (error) {
                    $scope.status = 'Echec de la modification de la chanson';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Delete
        \*********************************************************************/
        $scope.supprimer = function(id) {
            dataFactory.supprimer(id)
                .success(function (result) {
                    $scope.status = 'Chanson supprimée';
                }) .error(function (error) {
                    $scope.status = 'Echec de la suppression de la chanson';
                    
                    alert("Echec de la suppression de la playlist." + error);
                });
        }
        /*********************************************************************/
  }]);
/*****************************************************************************/
