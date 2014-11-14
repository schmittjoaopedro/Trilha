angular.module("App").controller("EventoController", function($scope, $http){
    
    $scope.close = function(){
        $http.delete("/Trilha/resources/autenticacao").success(function(){
            window.location = "/Trilha";
        });
    };
    
});