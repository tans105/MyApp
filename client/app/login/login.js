'use strict';

angular.module('myApp.login', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {
    templateUrl: 'login/login.html',
    controller: 'LoginCtrl'
  });
}])

.controller('LoginCtrl', function($scope,$log, LoginService, $location, $http) {



    /*$scope.data = [
        {name:"Gold", price:"10$",summary:"I am Gold"},
        {name:"Silver", price:"20$", summary:"I am Silver"},
        {name:"Platinum", price:"30$", summary: "I am Platinum"},
    ];*/

    $http.get("http://localhost:8080/auth-service/rest/auth/data")
        .then(function(response) {
            console.log(response);
            $scope.data=response.data;
            $scope.selectedCard=$scope.data[0];
        });



    $scope.modifySummary=function(card){
      $scope.selectedCard=card;
    }

});