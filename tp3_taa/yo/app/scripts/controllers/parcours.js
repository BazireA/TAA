'use strict';

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

    dataFactory.creerParcours = function (name) {
        return $http.put(urlBase + '/creer/' + name);
    };

    dataFactory.modifierParcours = function (id, name) {
        return $http.post(urlBase + '/modifier/' + id + '/' + name);
    };

    dataFactory.supprimerParcours = function (id) {
        return $http.delete(urlBase + '/delete/' + id);
    };

    return dataFactory;
}]);
    
    
angular.module('yoApp')
  .controller('ParcoursController', ['$scope', 'parcoursFactory',
        function ($scope, dataFactory) {
    
        $scope.lesParcours;
        $scope.status;
        
        
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
  }]);
