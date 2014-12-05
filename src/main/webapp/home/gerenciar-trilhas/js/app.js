angular.module("App", ['mgcrea.ngStrap']).controller("EventosController", function ($scope, $http) {

    angular.extend($scope, {
        estados: [],
        cidades: [],
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

    $http.get("/Trilha/json/estados.json").success(function (data) {
        angular.extend($scope, {
            estados: data
        });
    });

    $http.get("/Trilha/json/cidades.json").success(function (data) {
        angular.extend($scope, {
            cidades: data
        });
    });
    
    $scope.getCidades = function () {                
        if($scope.validarEstado() == false){                                   
            return $scope.cidades[$scope.map.estado.valor].cidades;
        }
        return [];
    };
    
    $scope.validarEstado = function () {
        if (angular.isObject($scope.map.estado)) {                        
            return false;
        }
        $scope.map.cidade = "";
        return true;
    };

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
    }
    ;

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
        var passou = true;
        var _for = $scope.cidades[$scope.map.estado.valor].cidades;
        for(var i = 0; i < _for.length; i++){            
            if($scope.map.cidade == _for[i]){                
                passou = false;
                i = _for.length;                             
            }
        }
        if (passou){
            alert("Selecione uma cidade!");
            return false;
        }
        var obj = map;
        obj.estado = map.estado.nome;
        $http.post('/Trilha/resources/trilha', obj).success(function () {
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
