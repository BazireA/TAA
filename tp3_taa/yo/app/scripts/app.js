'use strict';

angular.module('yoApp', ['ngCookies', 'ngResource', 'ngSanitize'])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/dashboard/dashboard.html',
        controller: 'DashboardController'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'PersonneController'
      })
      .when('/seances', {
        templateUrl: 'views/seance/seance.html',
        controller: 'SeanceController'
      })
      .when('/seances/add', {
        templateUrl: 'views/seance/form-add.html',
        controller: 'SeanceController'
      })
      .when('/seances/edit/:seanceId', {
        templateUrl: 'views/seance/form-edit.html',
        controller: 'SeanceController'
      })
      .when('/parcours', {
        templateUrl: 'views/parcours/parcours.html',
        controller: 'ParcoursController'
      })
      .when('/parcours/add', {
        templateUrl: 'views/parcours/form-add.html',
        controller: 'ParcoursController'
      })
      .when('/parcours/edit', {
        templateUrl: 'views/parcours/form-edit.html',
        controller: 'ParcoursController'
      })
      .when('/listechansons', {
        templateUrl: 'views/playlist/playlist.html',
        controller: 'PlaylistController'
      })
      .when('/listechansons/add', {
        templateUrl: 'views/playlist/form-add.html',
        controller: 'PlaylistController'
      })
      .when('/listechansons/edit', {
        templateUrl: 'views/playlist/form-edit.html',
        controller: 'PlaylistController'
      })
      .when('/amis', {
        templateUrl: 'views/amis/amis.html',
        controller: 'PersonneController'
      })
      .otherwise({
        redirectTo: '/'
      });
  });


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
