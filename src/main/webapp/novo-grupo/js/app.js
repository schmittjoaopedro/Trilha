angular.module("App", ['mgcrea.ngStrap']).controller("NewUserController", function ($scope, $window, $http) {

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

    $scope.$watch('form.cidade', function (newValue, oldValue) {
        if (angular.isObject(newValue)) {
            $scope.form.estado = newValue.address_components[newValue.address_components.length - 2].short_name;
        } else {
            $scope.form.estado = '';
        }
    });

    $scope.getAddress = function (viewValue) {
        var params = {address: viewValue, sensor: false};
        return $http.get('http://maps.googleapis.com/maps/api/geocode/json', {params: params})
                .then(function (res) {
                    angular.forEach(res.data.results, function (o) {
                        o.label = o.address_components[0].short_name;
                    });
                    return res.data.results;
                });
    };

    $scope.validarCidade = function (obj) {
        if (!angular.isObject(obj)) {
            alert("Selecione uma cidade!");
            return false;
        }
        return true;
    };

    $scope.save = function () {
        if ($scope.validarCidade($scope.form.cidade)) {
            $http({
                url: '/Trilha/resources/grupodetrilheiros',
                method: 'POST',
                data: {
                    nome: $scope.form.name,
                    login: $scope.form.login,
                    senha: $scope.form.password,
                    cidade: $scope.form.cidade.address_components[0].short_name,
                    estado: $scope.form.estado
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