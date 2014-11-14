angular.module("App").controller("HomeController", function($scope, $window, $http){
    
    $scope.close = function(){
        $http.delete("/Trilha/resources/autenticacao").success(function(){
            $window.location.href = "/Trilha";
        });
    };
    
});