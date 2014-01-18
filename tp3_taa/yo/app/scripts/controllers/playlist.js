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

    dataFactory.enleverChanson = function (id, idSong) {
        return $http.delete(urlBase + '/enleverChanson/' + id + '/' + idSong);
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
  .controller('PlaylistController', ['$scope', '$routeParams', 'playlistFactory', 'chansonFactory',
        function ($scope, $routeParams, dataFactory, chansonFactory) {
    
        /*********************************************************************\
         * Variables
        \*********************************************************************/
        $scope.playlists;
        $scope.chansons;
        $scope.status;
        $scope.itemSelected = {
            playlist: '',
            chanson: '',
            chansonToAdd: ''
        }
        
        $scope.setPlaylistSelected = function(playlist) {
            $scope.itemSelected.playlist = playlist;
        }
        
        $scope.setChansonSelected = function(chanson) {
            $scope.itemSelected.chanson = chanson;
        }
        /*********************************************************************/
        
        
        
        
        /*********************************************************************\
         * Initialisation
        \*********************************************************************/
        $scope.initialiserChamps = function(id) {
            dataFactory.getPlaylistById(id)
                .success(function (playlist) {
                    $scope.status = 'Ok';
                    
                    $scope.name = playlist.nom;
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
                    
                    document.location.reload(true);
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
        
        $scope.getChansons = function () {
            chansonFactory.getChansons()
                .success(function (chansons) {
                    $scope.status = 'Ok';
                    $scope.chansons = chansons;
                        
                    for(var i = chansons.length-1; i >= 0; i--) {
                        if (contains(chansons[i].id, $scope.itemSelected.playlist.chanson)) {
                            $scope.chansons.splice(i, 1);
                        }
                    }
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
            
            dataFactory.modifier($scope.itemSelected.playlist.id, name)
                .success(function (playlist) {
                    $scope.status = 'Playlist modifiée';
                    
                    document.location.reload(true);
                })
                .error(function (error) {
                    $scope.status = 'Echec de la modification de la playlist';
                });
        }
        
        
        $scope.ajouterChanson = function() {
            dataFactory.ajouterChanson($scope.itemSelected.playlist.id, $scope.itemSelected.chansonToAdd)
                .success(function () {
                    $scope.status = 'Chanson ajoutée';
                    
                    document.location.reload(true);
                })
                .error(function (error) {
                    $scope.status = 'Echec de l\'ajout de la chanson dans la playlist';
                });
        }
        
        $scope.enleverChanson = function() {
            dataFactory.enleverChanson($scope.itemSelected.playlist.id, $scope.itemSelected.chanson.id)
                .success(function () {
                    $scope.status = 'Chanson supprimée';
                    
                    document.location.reload(true);
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
                    $scope.itemSelected.playlist = null;
                    
                    document.location.reload(true);
                }) .error(function (error) {
                    $scope.status = 'Echec de la suppression de la playlist';
                    
                    alert("Echec de la suppression de la playlist.");
                });
        }
        
        $scope.supprimerChanson = function(id) {
            chansonFactory.supprimer(id)
                .success(function (result) {
                    $scope.status = 'Chanson supprimée';
                    
                    document.location.reload(true);
                }) .error(function (error) {
                    $scope.status = 'Echec de la suppression de la chanson';
                });
        }
        /*********************************************************************/
  }]);
/*****************************************************************************/
