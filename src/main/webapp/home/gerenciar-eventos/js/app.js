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
	    $http.get("/Trilha/resources/evento", $scope.form).success(function(data){
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
            window.location = "/Trilha/home";
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
    	console.info(evento);
    };
    
    $scope.modificar = function(evento) {
    	$scope.form = angular.copy(evento);
    };
    
});