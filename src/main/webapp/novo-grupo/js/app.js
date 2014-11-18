angular.module("App").controller("NewUserController", function($scope, $window, $http){
    
    angular.extend($scope, {
        form: {
            name: "",
            cidade: "",
            estado: "",
            login: "",
            password: ""            
        },        
        login: "",
        password: "",        
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
        $window.location.href = "/Trilha/new-user";
    };
    
    $scope.save = function(){
        $http({
        	url: '/Trilha/resources/grupodetrilheiros',
        	method: 'POST',
        	data: {
        		nome: $scope.form.name,
        		login: $scope.form.login,
        		senha: $scope.form.password,
        		cidade: $scope.form.cidade,
        		estado: $scope.form.estado
        	},
        	headers: {
        		'Content-Type': 'application/json; charset=UTF-8',
        		'Accept': 'application/json; charset=UTF-8'
        	}
        }).success(function() {
        	alert('Conta criada com sucess com successo');
        	$window.location.href = '/Trilha';
        }).error(function() {
        	alert('Falha ao criar conta');
        });
    };         
      
});