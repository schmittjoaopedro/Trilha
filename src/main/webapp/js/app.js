angular.module("App").controller("IndexController", function($scope, $window, $http){
    
    angular.extend($scope, {
        login: "",
        password: "",
        idDetalhes: 0
    });
    
    $scope.logar = function(){        
        $http({
            method: 'POST',
            url: '/Trilha/resources/autenticacao',
            data: $.param({ login: $scope.login, senha: $scope.password }),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function(){
            $window.location.href = "/Trilha/home";
        }).error(function(){
            alert("Usuário ou senha inválidos!");
        });
    };
    
    $scope.newUser = function(){
        $window.location.href = "/Trilha/novo-grupo";
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