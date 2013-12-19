'use strict';

angular.module('yoApp')
    .factory('amisFactory', ['$http', function($http) {

    var server = 'http://localhost:8080';
    var urlBase = server + '/endomondolike/personnes';
    var dataFactory = {};

    
    dataFactory.getPersonne = function (name) {
        return $http.get(urlBase + '/afficher/' + name);
    };

    dataFactory.creerPersonne = function (name) {
        return $http.put(urlBase + '/creer/ ' + name);
    };

    dataFactory.modifierPersonne = function (id, duree) {
        return $http.post(urlBase + '/modifierPersonne/' + id + '/' + duree);
    };

    dataFactory.getAmis = function (name) {
        return $http.get(urlBase + '/rechercheAmis/' + name);
    };

    dataFactory.ajouterAmis = function (name) {
        return $http.put(urlBase + '/ajouterAmis/ ' + name);
    };

    dataFactory.supprimerAmis = function (id) {
        return $http.delete(urlBase + '/supprimerAmis/' + id);
    };

    return dataFactory;
}]);
    

angular.module('yoApp')
  .controller('AmisController', ['$scope', 'amisFactory', 
        function ($scope, dataFactory) {
    
        $scope.amis;
        $scope.status;
        
        chargerListeAmis();
        
        function chargerListeAmis() {
            dataFactory.getAmis()
                .success(function (amis) {
                    $scope.status = 'Ok';
                    $scope.amis = amis;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération des amis';
                });
        }
  }]);
