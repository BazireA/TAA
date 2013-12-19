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

    dataFactory.creerSeance = function () {
        return $http.put(urlBase + '/creer');
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
    .controller('SeanceController', ['$scope', 'seanceFactory', 'meteoFactory',
        function ($scope, dataFactory, meteoFactory) {
    
        $scope.status;
        $scope.seances;
        $scope.itemSelected = {
            sport: '',
            playlist: '',
            parcours: '',
            meteo: ''
        };
        
        
        function verifierEtModifier(id, valeur, fonction, messageErreur) {
            if (valeur !== undefined) {
                fonction(id, valeur)
                    .success(function (ok) {
                        $scope.status = 'Ok';
                    })
                    .error(function (error) {
                        $scope.status = messageErreur;
                        dataFactory.supprimerSeance(id);
                        alert(error);
                    });
            }
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
            dataFactory.creerSeance()
                .success(function (seance) {
                    $scope.status = 'Séance créée';
                    
                    var distance = $scope.distance;
                    var duree = $scope.duree;
                    var vitesse = $scope.vitesse;
                    var frequenceCardiaque = $scope.frequenceCardiaque;
                    var calorie = $scope.calorie;
                    
                    var sport = $scope.itemSelected.sport;
                    var playlist = $scope.itemSelected.playlist;
                    var meteo = $scope.itemSelected.meteo;
                    var parcours = $scope.itemSelected.parcours;
                    
                    //verifierEtModifier(seance, distance,dataFactory.modifierDistanceSeance, "La modification de la distance a échouée.");
                    //verifierEtModifier(seance, duree, dataFactory.modifierDureeSeance, "La modification de la durée a échouée.");
                    //verifierEtModifier(seance, vitesse, dataFactory.modifierVitesseSeance, "La modification de la vitesse a échouée.");
                    //verifierEtModifier(seance, frequenceCardiaque, dataFactory.modifierRythmeCardiaqueSeance, "La modification de la fréquence cardiaque a échouée.");
                    //verifierEtModifier(seance, calorie, dataFactory.modifierCalorieSeance, "La modification des calories a échouée.");
                    
                    //verifierEtModifier(seance, playlist, dataFactory.modifierDistanceSeance, "Erreur");
                    //verifierEtModifier(seance, parcours, dataFactory.modifierDistanceSeance, "Erreur");
                    //verifierEtModifier(seance, sport, dataFactory.modifierDistanceSeance, "Erreur");
                    
                    dataFactory.modifier(seance,
                                         distance,
                                         duree,
                                         vitesse,
                                         frequenceCardiaque,
                                         calorie,
                                         sport,
                                         playlist,
                                         meteo,
                                         parcours)
                    .success(function(seance) {
                        $scope.status = 'Ok';
                                                                    
                        //var tempsSelectionne = $scope.itemSelected.meteo;
                        //
                        //meteoFactory.creerMeteo(tempsSelectionne)
                        //    .success(function (meteo) {
                        //        var temperature = $scope.temperature;
                        //        var vitesseVent = $scope.vitesseVent;
                        //        var indiceUV = $scope.indiceUV;
                        //        
                        //        
                        //    })
                        //    .error(function (error) {
                        //    
                        //    });
                                            
                        window.location = "#/seances";
                    })
                    .error(function (error) {
                        $scope.status = 'Echec de la création de la séance';
                    });
                })
                .error(function (error) {
                    $scope.status = 'Echec de la création de la séance';
                });
        }
  }]);
