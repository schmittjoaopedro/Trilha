angular.module("App", ['mgcrea.ngStrap']).controller("IndexController", function ($scope, $window, $http) {

    angular.extend($scope, {
        trilhas: [],
        form: {
            estado: ""
        },
        login: "",
        password: "",
        idDetalhes: 0,
        existUser: false
    });

    $http({
        method: 'GET',
        url: '/Trilha/resources/autenticacao',
        headers: {'Content-Type': 'application/json;charset=UTF8'}
    }).success(function (response) {
        angular.extend($scope, {
            existUser: response
        });
    });

    $http.get("/Trilha/resources/trilha").success(function (data) {
        angular.extend($scope, {
            trilhas: data
        });
    }).error(function (error) {
        console.log(error);
    });


    $scope.getDate = function (date) {
        date = new Date(date);
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear();
    };

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

    $scope.close = function () {
        $http.delete("/Trilha/resources/autenticacao").success(function () {
            window.location = "/Trilha";
        });
    };

    $scope.newUser = function () {
        $window.location.href = "/Trilha/novo-grupo";
    };

    $scope.show = function (idDetalhado) {
        if (idDetalhado == $scope.idDetalhes) {
            $scope.idDetalhes = 0;
        } else {
            $scope.idDetalhes = idDetalhado;
        }
    };

    $scope.showDetalhes = function (idDetalhado) {
        if (idDetalhado == $scope.idDetalhes) {
            return true;
        }
        return false;
    };

    $scope.showMap = function (data) {
        lastLine && lastLine.setMap && lastLine.setMap(null);
        processCordenates(data);
    };


    var drawingManager, map, overlayobj, lastLine;

    function initialize() {
        var mapOptions = {
            center: new google.maps.LatLng(-26.397, -49.644),
            zoom: 8
        };

        map = new google.maps.Map(document.getElementById('map'), mapOptions);
    }

    function processCordenates(data) {
        var flightPlanCoordinates = [];
        data.localizacaoGeograficas.forEach(function (items) {
            flightPlanCoordinates.push(new google.maps.LatLng(items.latitude, items.longitude));
        });
        lastLine = new google.maps.Polyline({
            path: flightPlanCoordinates,
            geodesic: true,
            strokeColor: '#FF0000',
            strokeOpacity: 1,
            strokeWeight: 2
        });
        lastLine.setMap(map);
    }

    google.maps.event.addDomListener(window, 'load', initialize);



});