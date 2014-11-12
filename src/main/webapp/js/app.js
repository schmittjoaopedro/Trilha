var app = angular.module("IndexApp", []);

app.controller("IndexController", function($scope, $window){
    
    angular.extend($scope, {
        email: "",
        password: "",
        idDetalhes: 0
    });
    
    $scope.login = function(){
        alert("Login");
    };
    
    $scope.newUser = function(){
        $window.location.href = "new-user";
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