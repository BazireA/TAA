'use strict';

angular.module('yoApp')
    .factory('playlistFactory', ['$http', function($http) {

    var server = 'http://localhost:8080';
    var urlBase = server + '/endomondolike/listechansons';
    var dataFactory = {};

    dataFactory.getPlaylistById = function (id) {
        return $http.get(urlBase + '/afficher/' + id);
    };

    dataFactory.getPlaylists = function () {
        return $http.get(urlBase + '/afficher');
    };

    dataFactory.creerPlaylist = function (name) {
        return $http.put(urlBase + '/creer/' + name);
    };

    dataFactory.modifierPlaylist = function (oldName, newName) {
        return $http.post(urlBase + '/modifier/' + oldName + '/' + newName);
    };

    dataFactory.ajouterChanson = function (playlist, song) {
        return $http.post(urlBase + '/ajouter/' + playlist + '/' + song);
    };

    dataFactory.supprimerChanson = function (playlist, song) {
        return $http.delete(urlBase + '/delete/' + playlist + '/' + song);
    };

    return dataFactory;
}]);
    
    
angular.module('yoApp')
  .controller('PlaylistController', ['$scope', 'playlistFactory', 
        function ($scope, dataFactory) {
    
        $scope.playlists;
        $scope.status;
        
        
        $scope.getPlaylists = function () {
            dataFactory.getPlaylists()
                .success(function (playlists) {
                    $scope.status = 'Ok';
                    $scope.playlists = playlists;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération des playlists';
                });
        }
  }]);
