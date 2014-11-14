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
        alert("Login");
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