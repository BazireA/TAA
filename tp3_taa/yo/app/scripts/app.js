'use strict';

angular.module('yoApp', ['ngCookies', 'ngResource', 'ngSanitize'])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/dashboard.html',
        controller: 'DashboardController'
      })
      .when('/seances', {
        templateUrl: 'views/seance.html',
        controller: 'SeanceController'
      })
      .when('/seances/add', {
        templateUrl: 'views/seance-form.html',
        controller: 'SeanceController'
      })
      .when('/seances/edit', {
        templateUrl: 'views/seance-form.html',
        controller: 'SeanceController'
      })
      .when('/parcours', {
        templateUrl: 'views/parcours.html',
        controller: 'ParcoursController'
      })
      .when('/parcours/add', {
        templateUrl: 'views/parcours-form.html',
        controller: 'ParcoursController'
      })
      .when('/parcours/edit', {
        templateUrl: 'views/parcours-form.html',
        controller: 'ParcoursController'
      })
      .when('/listechansons', {
        templateUrl: 'views/playlist.html',
        controller: 'PlaylistController'
      })
      .when('/listechansons/add', {
        templateUrl: 'views/playlist-form.html',
        controller: 'PlaylistController'
      })
      .when('/listechansons/edit', {
        templateUrl: 'views/playlist-form.html',
        controller: 'PlaylistController'
      })
      .when('/amis', {
        templateUrl: 'views/amis.html',
        controller: 'AmisController'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
  //.service('sportService', function() {
  //  this.userData = {};
  //
  //  this.user = function() {
  //        return this.userData;
  //  };
  //
  //  this.setSports = function(sports) {
  //        this.userData.sports = sports;
  //  };
  //
  //  this.getSports = function() {
  //        return this.userData.sports;
  //  };
  //});
