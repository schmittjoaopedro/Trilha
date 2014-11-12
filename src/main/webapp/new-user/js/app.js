var app = angular.module("NewUserApp", []);

app.controller("NewUserController", function($scope){
    
    angular.extend($scope, {
        email: "",
        password: "",
        idDetalhes: 0
    });
    
    $scope.login = function(){
        alert("Login");
    };
    
    $scope.show = function(idDetalhado){
        if(idDetalhado == $scope.idDetalhes){
           $scope.idDetalhes = 0; 
        }else{
           $scope.idDetalhes = idDetalhado; 
        }
    };
    
    $scope.showDetalhes = function(idDetalhado){
        if(idDetalhado == $scope.idDetalhes){
            return true;            
        }
        return false;
    };
});