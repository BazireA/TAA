'use strict';

/*****************************************************************************\
 * Factory
\*****************************************************************************/
angular.module('yoApp')
    .factory('meteoFactory', ['$http', function($http) {

    var server = 'http://localhost:8080';
    var urlBase = server + '/endomondolike/meteo';
    var dataFactory = {};

    dataFactory.getMeteoById = function (id) {
        return $http.get(urlBase + '/afficher/' + id);
    };

    dataFactory.getMeteo = function () {
        return $http.get(urlBase + '/afficher');
    };

    dataFactory.getTempsLibelles = function () {
        return $http.get(urlBase + '/tempsLibelles');
    };

    dataFactory.getTempsIdByLibelle = function (libelle) {
        return $http.get(urlBase + '/tempsId/' + libelle);
    };

    dataFactory.creerMeteo = function (temps) {
        return $http.put(urlBase + '/creer/' + temps);
    };

    dataFactory.modifierMeteo = function (id, temps, temperature, vent, uv) {
        return $http.post(urlBase + '/modifier/' + id + '/' + temps + '/' + temperature + '/' + vent + '/' + uv);
    };

    dataFactory.supprimerMeteo = function (id) {
        return $http.delete(urlBase + '/delete/' + id);
    };

    return dataFactory;
}]);
/*****************************************************************************/
    


    
/*****************************************************************************\
 * Controller
\*****************************************************************************/
angular.module('yoApp')
  .controller('MeteoController', ['$scope', 'meteoFactory',
        function ($scope, dataFactory) {
    
        /*********************************************************************\
         * Variables
        \*********************************************************************/
        $scope.tempsLibelles;
        $scope.status;
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Initialisation
        \*********************************************************************/      
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Create
        \*********************************************************************/
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Read
        \*********************************************************************/
        $scope.getTempsLibelles = function() {
            dataFactory.getTempsLibelles()
                .success(function (libelles) {
                    $scope.status = 'Ok';
                    $scope.tempsLibelles = libelles;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération des libelles des temps';
                });
        }
        
        
        $scope.getTempsIdByLibelle = function(libelle) {
            dataFactory.getTempsIdByLibelle(libelle)
                .success(function (id) {
                    alert(id);
                    return id;
                })
                .error(function (error) {
                    alert("Echec de la récupération de l'id du temps");
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Update
        \*********************************************************************/
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Delete
        \*********************************************************************/
        /*********************************************************************/
  }]);
/*****************************************************************************/
