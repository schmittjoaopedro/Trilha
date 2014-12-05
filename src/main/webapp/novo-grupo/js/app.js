angular.module("App", ['mgcrea.ngStrap']).controller("NewUserController", function ($scope, $window, $http) {

    angular.extend($scope, {
        estados: [],
        cidades: [],
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

    $scope.logar = function () {
        $http({
            method: 'POST',
            url: '/Trilha/resources/autenticacao',
            data: $.param({login: $scope.login, senha: $scope.password}),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function () {
            $window.location.href = "/Trilha/home";
        }).error(function () {
            alert("Usuário ou senha inválidos!");
        });
    };

    $scope.newUser = function () {
        $window.location.href = "/Trilha/new-user";
    };
    
    $scope.getCidades = function () {                
        if($scope.validarEstado() == false){                                   
            return $scope.cidades[$scope.form.estado.valor].cidades;
        }
        return [];
    };

    $scope.validar = function () {                
        var passou = true;
        var _for = $scope.cidades[$scope.form.estado.valor].cidades;
        if (!angular.isObject($scope.form.estado)) {            
            alert("Selecione um estado!");
            return false;
        }                            
        for(var i = 0; i < _for.length; i++){            
            if($scope.form.cidade == _for[i]){                
                passou = false;
                i = _for.length;                             
            }
        }
        if (passou){
            alert("Selecione uma cidade!");
            return false;
        }        
        return true;
    };
    
    $scope.validarEstado = function () {
        if (angular.isObject($scope.form.estado)) {                        
            return false;
        }
        $scope.form.cidade = "";
        return true;
    };        
    
    $http.get("/Trilha/json/estados.json").success(function(data){
        angular.extend($scope, {
            estados: data
        });
    });
    
    $http.get("/Trilha/json/cidades.json").success(function(data){
        angular.extend($scope, {
            cidades: data
        });
    });
    
    $scope.save = function () {
        if ($scope.validar()) {            
            $http({
                url: '/Trilha/resources/grupodetrilheiros',
                method: 'POST',
                data: {
                    nome: $scope.form.name,
                    login: $scope.form.login,
                    senha: $scope.form.password,
                    cidade: $scope.form.cidade,
                    estado: $scope.form.estado.nome
                },
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8',
                    'Accept': 'application/json; charset=UTF-8'
                }
            }).success(function () {
                alert('Conta criada com sucess com successo');
                $window.location.href = '/Trilha';
            }).error(function () {
                alert('Falha ao criar conta');
            });
        }
        ;
    };

});