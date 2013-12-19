'use strict';

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
    
    
angular.module('yoApp')
  .controller('MeteoController', ['$scope', 'meteoFactory',
        function ($scope, dataFactory) {
    
        $scope.tempsLibelles;
        $scope.status;
        
        
        $scope.getTempsLibelles = function getTempsLibelles() {
            dataFactory.getTempsLibelles()
                .success(function (libelles) {
                    $scope.status = 'Ok';
                    $scope.tempsLibelles = libelles;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération des libelles des temps';
                });
        }
  }]);
