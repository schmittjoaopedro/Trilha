var app = angular.module("IndexApp", []);

app.controller("IndexController", function($scope, $window, $http){
    
    angular.extend($scope, {
        email: "",
        password: "",
        idDetalhes: 0
    });
    
    $scope.login = function(){
        $http({
            method: 'POST',
            url: '/Trilha/resources/autenticacao',
            data: $.param({ login: $scope.email, senha: $scope.password }),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
    };
    
    $scope.newUser = function(){
        $window.location.href = "/Trilha/new-user";
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