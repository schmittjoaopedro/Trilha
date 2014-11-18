angular.module("App").controller("IndexController", function($scope, $window, $http){
    
    angular.extend($scope, {
        login: "",
        password: "",
        idDetalhes: 0,
        eventos: []
    });
         
    $http.get("/Trilha/resources/evento", $scope.form).success(function(data){
        angular.extend($scope, {
            eventos: data
        });
    }).error(function(error){
        alert("Ocorrou algum erro!");
    });
    
    $scope.getDate = function(date){                
        date = new Date(date);
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear();                
    };
    
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