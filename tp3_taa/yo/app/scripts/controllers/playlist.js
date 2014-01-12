'use strict';

/*****************************************************************************\
 * Factory
\*****************************************************************************/
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

    dataFactory.creer = function (name) {
        return $http.put(urlBase + '/creer/' + name);
    };

    dataFactory.modifier = function (id, name) {
        return $http.post(urlBase + '/modifier/' + id + '/' + name);
    };

    dataFactory.ajouterChanson = function (id, idSong) {
        return $http.post(urlBase + '/ajouterChanson/' + id + '/' + idSong);
    };

    dataFactory.supprimerChanson = function (id, idSong) {
        return $http.delete(urlBase + '/supprimerChanson/' + id + '/' + idSong);
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
  .controller('PlaylistController', ['$scope', '$routeParams', 'playlistFactory', 
        function ($scope, $routeParams, dataFactory) {
    
        /*********************************************************************\
         * Variables
        \*********************************************************************/
        $scope.playlists;
        $scope.status;
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Initialisation
        \*********************************************************************/
        $scope.initialiserChamps = function() {
            dataFactory.getPlaylistById($routeParams.playlistId)
                .success(function (playlist) {
                    $scope.status = 'Ok';
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
            
            dataFactory.creer(name)
                .success(function (playlist) {
                    $scope.status = 'Playlist créée';
                    
                    window.location = "#/listechansons";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la création de la playlist';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Read
        \*********************************************************************/
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
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Update
        \*********************************************************************/
        $scope.modifier = function() {
            var name = initialiserParametreString($scope.name);
            
            dataFactory.modifier($routeParams.playlistId, name)
                .success(function (playlist) {
                    $scope.status = 'Playlist modifiée';
                    
                    window.location = "#/listechansons";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la modification de la playlist';
                });
        }
        
        
        $scope.ajouterChanson = function() {
            dataFactory.ajouterChanson($routeParams.playlistId, $scope.chansonId)
                .success(function () {
                    $scope.status = 'Playlist modifiée';
                    
                    window.location = "#/listechansons";
                })
                .error(function (error) {
                    $scope.status = 'Echec de l\'ajout de la chanson dans la playlist';
                });
        }
        
        $scope.supprimerChanson = function() {
            dataFactory.supprimerChanson($routeParams.playlistId, $scope.chansonId)
                .success(function () {
                    $scope.status = 'Playlist modifiée';
                    
                    window.location = "#/listechansons";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la suppression de la chanson dans la playlist';
                });
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Delete
        \*********************************************************************/
        $scope.supprimer = function(id) {
            dataFactory.supprimer(id)
                .success(function (result) {
                    $scope.status = 'Playlist supprimée';
                    
                    document.location.reload(true);
                }) .error(function (error) {
                    $scope.status = 'Echec de la suppression de la playlist';
                    
                    alert("Echec de la suppression de la playlist.");
                });
        }
        /*********************************************************************/
  }]);
/*****************************************************************************/
