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
        },
        map: {
            nome: '',
            estado: '',
            cidade: '',
            localizacaoGeograficas: []
        }
    });

    $scope.salvar = function () {
        $http.post("/Trilha/resources/trilha", $scope.form).success(function (data) {
            alert("Trilheiro salvo com sucesso!");
            loadData();
            $scope.novo();
        }).error(function (error) {
            window.location = "/Trilha/home";
        });
    };

    $scope.remover = function (evento) {
        $http.delete("/Trilha/resources/trilha/" + evento.id).success(function () {
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
        $http.get("/Trilha/resources/trilha").success(function (data) {
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

    $scope.salvarTrilha = function (map) {
        $http.post('/Trilha/resources/trilha', map).success(function () {
            alert('Sucesso ao salvar trilha');
            loadData();
        }).error(function () {
            alert('Erro ao salvar trilha');
        });
    };


    var drawingManager, mapGoogle, overlayobj;

    function initialize() {

        var mapOptions = {
            center: new google.maps.LatLng(-26.397, -49.644),
            zoom: 8
        };

        mapGoogle = new google.maps.Map(document.getElementById('map'), mapOptions);

        drawingManager = new google.maps.drawing.DrawingManager({
            drawingMode: google.maps.drawing.OverlayType.MARKER,
            drawingControl: true,
            drawingControlOptions: {
                position: google.maps.ControlPosition.TOP_CENTER,
                drawingModes: [
                    google.maps.drawing.OverlayType.POLYLINE
                ]
            }
        });
        drawingManager.setMap(mapGoogle);

        google.maps.event.addListener(drawingManager, 'overlaycomplete', function (event) {
            overlayobj = event;
            console.log(overlayobj.overlay.getPath().getArray());
            $scope.map.localizacaoGeograficas = [];
            overlayobj.overlay.getPath().getArray().forEach(function (item) {
                $scope.map.localizacaoGeograficas.push({
                    latitude: item.k,
                    longitude: item.B
                });
            });
        });
    }

    google.maps.event.addDomListener(window, 'load', initialize);

});
