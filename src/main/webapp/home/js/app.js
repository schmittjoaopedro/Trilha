angular.module("App").controller("HomeController", function($scope, $window, $http){
    
    $scope.close = function(){
        $http.delete("/Trilha/autenticacao").success(function(){
            alert();
        });
    };
    
});