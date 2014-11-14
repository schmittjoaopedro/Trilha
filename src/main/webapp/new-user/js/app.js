var app = angular.module("NewUserApp", []);

app.controller("NewUserController", function($scope, $window){
    
    angular.extend($scope, {
        form: {
            name: "",
            cidade: "",
            estado: "",
            email: "",
            password: ""            
        },        
        email: "",
        password: "",        
    });
    
    $scope.login = function(){
        alert("Login");
    };
    
    $scope.newUser = function(){
        $window.location.href = "/Trilha/new-user";
    };
    
    $scope.save = function(){
        alert("Save");
        $scope.clear();
    };
    
    $scope.clear = function(){
        angular.extend($scope, {
            form: {
                name: "",
                cidade: "",
                estado: "",
                email: "",
                password: ""
            }        
        });
    };
    
      
});