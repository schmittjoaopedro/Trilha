angular.module("App", ['mgcrea.ngStrap']).controller("EventosController", function($scope, $http){
    
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
	    $http.get("/Trilha/resources/evento").success(function(data){
	        angular.extend($scope, {
	            eventos: data
	        });
	    }).error(function(error){
	        alert("Ocorrou algum erro!");
	    });
    }
    
    loadData();
    
    $scope.salvar = function(){
        $http.post("/Trilha/resources/evento", $scope.form).success(function(data){
            alert("Evento salvo com sucesso!");
            novo();
            loadData();
        }).error(function(error){
            alert("Ocorrou algum erro!");
        });
    };
    
    $scope.close = function(){
        $http.delete("/Trilha/resources/autenticacao").success(function(){
            window.location = "/Trilha";
        });
    };
    
    $scope.remover = function(evento) {
    	$http.delete("/Trilha/resources/evento/" + evento.id).success(function() {
    		loadData();
    		alert("Evento removido com sucesso!");
    	}).error(function() {
    		loadData();
            alert("Ocorrou algum erro!");
    	});
    };
    
    $scope.modificar = function(evento) {
    	$scope.form = angular.copy(evento);
    };
    
    var novo = function() {
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
    $scope.novo = novo;
    
});