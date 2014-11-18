angular.module("App", ['mgcrea.ngStrap']).controller("EventoController", function($scope, $http){
    
    angular.extend($scope, {
        form: {
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
    
});