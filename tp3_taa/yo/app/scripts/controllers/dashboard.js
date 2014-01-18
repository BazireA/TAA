'use strict';

angular.module('yoApp')
  .controller('DashboardController', function ($scope) {
    
    $scope.deconnexion = function () {
        localStorage['authentificated'] = false;
        window.location = "#/login";
    }
  });
