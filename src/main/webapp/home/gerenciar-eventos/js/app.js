angular.module("App", ['mgcrea.ngStrap']).controller("EventosController", function ($scope, $http) {

    angular.extend($scope, {
        form: {
            id: 0,
            nome: '',
            descricao: '',
            custo: '',
            imagems: [
                {
                    url: '',
                }
            ],
            data: new Date()
        }
    });

    function loadData() {
        $http.get("/Trilha/resources/evento").success(function (data) {
            angular.extend($scope, {
                eventos: data
            });
        }).error(function (error) {
            window.location = "/Trilha/home";
        });
    }

    loadData();

    $scope.salvar = function () {
        $http.post("/Trilha/resources/evento", $scope.form).success(function (data) {
            alert("Evento salvo com sucesso!");
            loadData();
            $scope.novo();
        }).error(function (error) {
            window.location = "/Trilha/home";
        });
    };

    $scope.close = function () {
        $http.delete("/Trilha/resources/autenticacao").success(function () {
            window.location = "/Trilha";
        });
    };

    $scope.remover = function (evento) {
        $http.delete("/Trilha/resources/evento/" + evento.id).success(function () {
            loadData();
            $scope.novo();
            alert("Evento removido com sucesso!");
        }).error(function () {
            window.location = "/Trilha/home";
        });
    };

    $scope.modificar = function (evento) {
        $scope.form = angular.copy(evento);
    };

    $scope.novo = function () {
        $scope.form = {
            id: 0,
            nome: '',
            descricao: '',
            custo: '',
            imagems: [
                {
                    url: '',
                }
            ],
            data: new Date()
        };
    };

});