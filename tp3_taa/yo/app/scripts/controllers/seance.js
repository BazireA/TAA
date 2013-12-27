'use strict';

angular.module('yoApp')
    .factory('seanceFactory', ['$http', function($http) {

    var server = 'http://localhost:8080';
    var urlBase = server + '/endomondolike/seances';
    var dataFactory = {};

    dataFactory.getSeanceById = function (id) {
        return $http.get(urlBase + '/afficher/' + id);
    };

    dataFactory.getSeances = function () {
        return $http.get(urlBase + '/afficher');
    };

    dataFactory.creer = function () {
        return $http.put(urlBase + '/creer');
    };
    
    dataFactory.creer = function (distance, duree, vitesse, frequenceCardiaque, calorie, sport, playlist, temps, temperature, vent, uv, parcours) {
        return $http.put(urlBase + '/creer/' + distance + '/' + duree + '/' + vitesse + '/' + frequenceCardiaque + '/' + calorie + '/' + sport + '/' + playlist + '/' + temps + '/' + temperature + '/' + vent + '/' + uv + '/' + parcours);
    };

    dataFactory.modifier = function (id, distance, duree, vitesse, frequenceCardiaque, calorie, sport, playlist, meteo, parcours) {
        return $http.post(urlBase + '/modifier/' + id + '/' + distance + '/' + duree + '/' + vitesse + '/' + frequenceCardiaque + '/' + calorie + '/' + sport + '/' + playlist + '/' + meteo + '/' + parcours);
    };

    dataFactory.modifierDureeSeance = function (id, duree) {
        return $http.post(urlBase + '/modifierDuree/' + id + '/' + duree);
    };

    dataFactory.modifierDistanceSeance = function (id, distance) {
        return $http.post(urlBase + '/modifierDistance/' + id + '/' + distance);
    };

    dataFactory.modifierVitesseSeance = function (id, vitesse) {
        return $http.post(urlBase + '/modifierVitesse/' + id + '/' + vitesse);
    };

    dataFactory.modifierCalorieSeance = function (id, calorie) {
        return $http.post(urlBase + '/modifierCalorie/' + id + '/' + calorie);
    };

    dataFactory.modifierRythmeCardiaqueSeance = function (id, rythmeCardiaque) {
        return $http.post(urlBase + '/modifierRythmeCardiaque/' + id + '/' + rythmeCardiaque);
    };

    dataFactory.modifierObjectifSeance = function (id, objectif) {
        return $http.post(urlBase + '/modifierObjectif/' + id + '/' + objectif);
    };

    dataFactory.modifierParcoursSeance = function (id, parcours) {
        return $http.post(urlBase + '/modifierParcours/' + id, parcours);
    };

    dataFactory.modifierListeChansonsSeance = function (id, listeChansons) {
        return $http.post(urlBase + '/modifierListeChansons/' + id, listeChansons);
    };

    dataFactory.modifierTypeDeSportSeance = function (id, typeSport) {
        return $http.post(urlBase + '/modifierTypeDeSport/' + id, typeSport);
    };

    dataFactory.modifierMeteoSeance = function (id, meteo) {
        return $http.post(urlBase + '/modifierMeteo/' + id, meteo);
    };

    dataFactory.supprimerSeance = function (id) {
        return $http.delete(urlBase + '/supprimerSeance/' + id);
    };

    return dataFactory;
}]);




angular.module('yoApp')
    .controller('SeanceController', ['$scope', 'seanceFactory',
        function ($scope, dataFactory) {
    
        $scope.status;
        $scope.seances;
        $scope.itemSelected = {
            sport: '',
            playlist: '',
            parcours: '',
            meteo: ''
        };
        
        
        
        function initialiserParametreInt(valeur) {
            var result = 0;
            
            if (valeur !== undefined) {
                result = valeur;
            }
            
            return result;
        }
        
        function initialiserParametreString(valeur) {
            var result = '0';
            
            if ((valeur !== undefined) && (valeur !== '')) {
                result = valeur;
            }
            
            return result;
        }
        
        
        
        $scope.getSeances = function () {
            dataFactory.getSeances()
                .success(function (seances) {
                    $scope.status = 'Ok';
                    $scope.seances = seances;
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération de la liste des séances';
                });
        }
        
        
        $scope.creerSeance = function() {
            var distance = initialiserParametreInt($scope.distance);
            var duree = initialiserParametreInt($scope.duree);
            var vitesse = initialiserParametreInt($scope.vitesse);
            var frequenceCardiaque = initialiserParametreInt($scope.frequenceCardiaque);
            var calorie = initialiserParametreInt($scope.calorie);
            
            var sport = initialiserParametreString($scope.itemSelected.sport);
            var playlist = initialiserParametreString($scope.itemSelected.playlist);
            var temps = initialiserParametreString($scope.itemSelected.meteo);
            var temperature = initialiserParametreInt($scope.temperature);
            var vent = initialiserParametreInt($scope.vitesseVent);
            var uv = initialiserParametreInt($scope.indiceUV);
            var parcours = initialiserParametreString($scope.itemSelected.parcours);
            
            if (temps !== 0) {
                temps--;
            }
            
            dataFactory.creer(  distance,
                                duree,
                                vitesse,
                                frequenceCardiaque,
                                calorie,
                                sport,
                                playlist,
                                temps,
                                temperature,
                                vent,
                                uv,
                                parcours)
                .success(function (seance) {
                    $scope.status = 'Séance créée';
                    
                    window.location = "#/seances";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la création de la séance';
                });
        }
  }]);
