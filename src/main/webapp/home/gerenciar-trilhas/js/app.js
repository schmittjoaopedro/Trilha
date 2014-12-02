angular.module("App", ['mgcrea.ngStrap']).controller("EventosController", function ($scope, $http) {

    angular.extend($scope, {
        form: {
            id: 0,
            nome: '',
            email: '',
            telefone: '',
            imagems: [
                {
                    url: '',
                }
            ]
        }
    });

    $scope.salvar = function () {
        $http.post("/Trilha/resources/trilheiro", $scope.form).success(function (data) {
            alert("Trilheiro salvo com sucesso!");
            loadData();
            $scope.novo();
        }).error(function (error) {
            window.location = "/Trilha/home";
        });
    };

    $scope.remover = function (evento) {
        $http.delete("/Trilha/resources/trilheiro/" + evento.id).success(function () {
            loadData();
            $scope.novo();
            alert("Trilheiro removido com sucesso!");
        }).error(function () {
            window.location = "/Trilha/home";
        });
    };

    $scope.modificar = function (evento) {
        $scope.form = angular.copy(evento);
    };

    function loadData() {
        $http.get("/Trilha/resources/trilheiro").success(function (data) {
            angular.extend($scope, {
                eventos: data
            });
        }).error(function (error) {
            window.location = "/Trilha/home";
        });
    };

    loadData();

    $scope.novo = function () {
        $scope.form = {
            id: 0,
            nome: '',
            email: '',
            telefone: '',
            imagems: [
                {
                    url: '',
                }
            ],            
        };
    };
    
    $scope.close = function () {
        $http.delete("/Trilha/resources/autenticacao").success(function () {
            window.location = "/Trilha";
        });
    };

});