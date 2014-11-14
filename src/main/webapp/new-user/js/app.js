var app = angular.module("NewUserApp", []);

app.controller("NewUserController", function($scope, $window, $http){
    
    angular.extend($scope, {
        form: {
            name: "",
            cidade: "",
            estado: "",
            email: "",
            password: ""            
        },        
        email: "",
        password: "",        
    });
    
    $scope.logar = function(){
        alert("Login");
    };      
    
    $scope.save = function(){
        $http({
        	url: '/Trilha/grupodetrilheiros',
        	method: 'POST',
        	data: {
        		nome: $scope.nome,
        		login: $scope.login,
        		senha: $scope.senha,
        		cidade: $scope.cidade,
        		estado: $scope.estado
        	},
        	headers: {
        		'Content-Type': 'application/json; charset=UTF-8',
        		'Accept': 'application/json; charset=UTF-8'
        	}
        }).success(function() {
        	alert('Conta criada com sucess com successo');
        	window.href = '/Trilha';
        }).error(function() {
        	alert('Falha ao criar conta');
        });
    };
    
    $scope.clear = function(){
        angular.extend($scope, {
            form: {
                name: "",
                cidade: "",
                estado: "",
                email: "",
                password: ""
            }        
        });
    };
    
      
});