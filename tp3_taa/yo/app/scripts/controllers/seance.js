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

    dataFactory.modifier = function (id, distance, duree, vitesse, frequenceCardiaque, calorie, sport, playlist, meteoId, temps, temperature, vent, uv, parcours) {
        return $http.post(urlBase + '/modifier/' + id + '/' + distance + '/' + duree + '/' + vitesse + '/' + frequenceCardiaque + '/' + calorie + '/' + sport + '/' + playlist + '/' + meteoId + '/' + temps + '/' + temperature + '/' + vent + '/' + uv + '/' + parcours);
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

    dataFactory.supprimer = function (id) {
        return $http.delete(urlBase + '/supprimer/' + id);
    };

    return dataFactory;
}]);




angular.module('yoApp')
    .controller('SeanceController', ['$scope', '$routeParams', 'seanceFactory', 'meteoFactory',
        function ($scope, $routeParams, dataFactory, meteoFactory) {
    
        $scope.status;
        $scope.seances;
        $scope.itemSelected = {
            sport: '',
            playlist: '',
            parcours: '',
            meteo: {
                id: 0,
                temps: ''
            }
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
        
        
        $scope.initialiserChamps = function() {
            dataFactory.getSeanceById($routeParams.seanceId)
                .success(function (seance) {
                    $scope.status = 'Ok';
                    
                    $scope.itemSelected.sport = seance.typeSport.id;
                    $scope.distance = seance.distance;
                    $scope.duree = seance.duree;
                    $scope.vitesse = seance.vitesse;
                    $scope.frequenceCardiaque = seance.rythmeCardiaque;
                    $scope.calorie = seance.calorie;
                    $scope.itemSelected.playlist = seance.listeChanson.id;
                    $scope.temperature = seance.meteo.temperature;
                    $scope.vitesseVent = seance.meteo.vent;
                    $scope.indiceUV = seance.meteo.uv;
                    $scope.itemSelected.parcours = seance.parcours.id;
                    
                    meteoFactory.getTempsIdByLibelle(seance.meteo.temps)
                        .success(function (id) {
                            $scope.itemSelected.meteo.id = seance.meteo.id;
                            $scope.itemSelected.meteo.temps = id;
                        })
                        .error(function (error) {
                            alert("Echec de la récupération de l'id du temps");
                        });
                })
                .error(function (error) {
                    $scope.status = 'Echec de la récupération de la séance';
                    alert(error);
                });
        }
        
        
        $scope.creer = function() {
            var distance = initialiserParametreInt($scope.distance);
            var duree = initialiserParametreInt($scope.duree);
            var vitesse = initialiserParametreInt($scope.vitesse);
            var frequenceCardiaque = initialiserParametreInt($scope.frequenceCardiaque);
            var calorie = initialiserParametreInt($scope.calorie);
            
            var sport = initialiserParametreString($scope.itemSelected.sport);
            var playlist = initialiserParametreString($scope.itemSelected.playlist);
            var temps = initialiserParametreString($scope.itemSelected.meteo.temps);
            var temperature = initialiserParametreInt($scope.temperature);
            var vent = initialiserParametreInt($scope.vitesseVent);
            var uv = initialiserParametreInt($scope.indiceUV);
            var parcours = initialiserParametreString($scope.itemSelected.parcours);
            
            if (temps !== '0') {
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
        
        
        $scope.modifier = function() {
            var distance = initialiserParametreInt($scope.distance);
            var duree = initialiserParametreInt($scope.duree);
            var vitesse = initialiserParametreInt($scope.vitesse);
            var frequenceCardiaque = initialiserParametreInt($scope.frequenceCardiaque);
            var calorie = initialiserParametreInt($scope.calorie);
            
            var sport = initialiserParametreString($scope.itemSelected.sport);
            var playlist = initialiserParametreString($scope.itemSelected.playlist);
            var meteoId = $scope.itemSelected.meteo.id;
            var temps = initialiserParametreString($scope.itemSelected.meteo.temps);
            var temperature = initialiserParametreInt($scope.temperature);
            var vent = initialiserParametreInt($scope.vitesseVent);
            var uv = initialiserParametreInt($scope.indiceUV);
            var parcours = initialiserParametreString($scope.itemSelected.parcours);
            
            if (temps !== 0) {
                temps--;
            }
            
            dataFactory.modifier(
                                $routeParams.seanceId,
                                distance,
                                duree,
                                vitesse,
                                frequenceCardiaque,
                                calorie,
                                sport,
                                playlist,
                                meteoId,
                                temps,
                                temperature,
                                vent,
                                uv,
                                parcours)
                .success(function (seance) {
                    $scope.status = 'Séance modifiée';
                    
                    window.location = "#/seances";
                })
                .error(function (error) {
                    $scope.status = 'Echec de la modification de la séance';
                });
        }
        
        
        $scope.supprimer = function(id) {
            dataFactory.supprimer(id)
                .success(function (result) {
                    $scope.status = 'Séance supprimée';
                    
                    document.location.reload(true);
                }) .error(function (error) {
                    $scope.status = 'Echec de la suppression de la séance';
                    
                    alert("Echec de la suppression de la séance.");
                });
        }
  }]);
