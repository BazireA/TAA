'use strict';

angular.module('yoApp')
    .factory('sportFactory', ['$http', function($http) {

    var server = 'http://localhost:8080';
    var urlBase = server + '/endomondolike/sport';
    var dataFactory = {};

    dataFactory.getSportById = function (id) {
        return $http.get(urlBase + '/afficher/' + id);
    };

    dataFactory.getSports = function () {
        return $http.get(urlBase + '/afficher');
    };

    dataFactory.creerSport = function (name) {
        return $http.put(urlBase + '/creer/' + name);
    };

    dataFactory.modifierSport = function (id, name) {
        return $http.post(urlBase + '/modifier/' + id + '/' + name);
    };

    dataFactory.supprimerSport = function (id) {
        return $http.delete(urlBase + '/delete/' + id);
    };

    return dataFactory;
}]);
    
    
angular.module('yoApp')
  .controller('SportController', ['$scope', 'sportFactory',
        function ($scope, dataFactory) {
    
        $scope.sports;
        $scope.status;
        
        
        $scope.getSports = function () {
            dataFactory.getSports()
                .success(function (sports) {
                    $scope.status = 'Ok';
                    $scope.sports = sports;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération des types de sport';
                });
        }
  }]);
