var app = angular.module("HomeApp", []);

app.controller("HomeController", function($scope, $window, $http){
    
    $scope.close = function(){
        $http.delete("/Trilha/resources/autenticacao").success(function(){
            alert();
        });
    };
    
});