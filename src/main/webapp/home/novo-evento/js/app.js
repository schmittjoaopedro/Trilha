angular.module("App", ['mgcrea.ngStrap']).controller("EventoController", function($scope, $http){
    
    angular.extend($scope, {
        form: {
            data: new Date()
        }
    });
    
    $scope.salvar = function(){
        alert("");
    }; 
    
    $scope.close = function(){
        $http.delete("/Trilha/resources/autenticacao").success(function(){
            window.location = "/Trilha";
        });
    };
    
});