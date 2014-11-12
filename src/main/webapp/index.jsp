<!DOCTYPE html>
<html lang="en" ng-app="IndexApp">
    <head>
       <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Trilha Brasil">
        <meta name="author" content="Fabr�cio Ronchi - Jo�o Schimitt">
        <link rel="icon" href="img/icon.svg">
        <link href="libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body ng-controller="IndexController">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/Trilha">Trilha Brasil</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" role="form">
                        <div class="form-group">
                            <input type="text" placeholder="Email" class="form-control" ng-model="email">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Senha" class="form-control" ng-model="password">
                        </div>
                        <button type="button" class="btn btn-success" ng-click="login()">
                            <i class="glyphicon glyphicon-log-in"></i>&nbsp;&nbsp;Entrar
                        </button>
                        <button type="button" class="btn btn-primary btn-cadastrar" ng-click="newUser()">
                            <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;Cadastrar
                        </button>
                    </form>
                </div>
            </div>
        </nav>                   
        <div class="container container-index" class="ng-cloack">
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <a href="#" class="thumbnail">
                                    <img src="img/example.jpg" alt="Imagem do evento">
                                    </a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-9">
                                    <h4>Data: 10/10/2014</h4>
                                    <h4>Local: Massaranduba</h4>
                                </div>
                                <div class="col-sm-3 text-center">
                                    <button type="button" class="btn btn-primary btn-detalhes" ng-click="show(1)">
                                        <i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;Detalhes
                                    </button>
                                </div>
                            </div>
                            <div class="row" ng-show="showDetalhes(1)">
                                <div class="col-sm-12 text-center">
                                    <h4>Detalhes</h4>                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>           
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <a href="#" class="thumbnail">
                                    <img src="img/example.jpg" alt="Imagem do evento">
                                    </a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-9">
                                    <h4>Data: 10/10/2014</h4>
                                    <h4>Local: Massaranduba</h4>
                                </div>
                                <div class="col-sm-3 text-center">
                                    <button type="button" class="btn btn-primary btn-detalhes" ng-click="show(2)">
                                        <i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;Detalhes
                                    </button>
                                </div>
                            </div>
                            <div class="row" ng-show="showDetalhes(2)">
                                <div class="col-sm-12 text-center">
                                    <h4>Detalhes</h4>                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>           
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <a href="#" class="thumbnail">
                                    <img src="img/example.jpg" alt="Imagem do evento">
                                    </a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-9">
                                    <h4>Data: 10/10/2014</h4>
                                    <h4>Local: Massaranduba</h4>
                                </div>
                                <div class="col-sm-3 text-center">
                                    <button type="button" class="btn btn-primary btn-detalhes" ng-click="show(3)">
                                        <i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;Detalhes
                                    </button>
                                </div>
                            </div>
                            <div class="row" ng-show="showDetalhes(3)">
                                <div class="col-sm-12 text-center">
                                    <h4>Detalhes</h4>                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>           
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <a href="#" class="thumbnail">
                                    <img src="img/example.jpg" alt="Imagem do evento">
                                    </a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-9">
                                    <h4>Data: 10/10/2014</h4>
                                    <h4>Local: Massaranduba</h4>
                                </div>
                                <div class="col-sm-3 text-center">
                                    <button type="button" class="btn btn-primary btn-detalhes" ng-click="show(4)">
                                        <i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;Detalhes
                                    </button>
                                </div>
                            </div>
                            <div class="row" ng-show="showDetalhes(4)">
                                <div class="col-sm-12 text-center">
                                    <h4>Detalhes</h4>                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>           
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <a href="#" class="thumbnail">
                                    <img src="img/example.jpg" alt="Imagem do evento">
                                    </a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-9">
                                    <h4>Data: 10/10/2014</h4>
                                    <h4>Local: Massaranduba</h4>
                                </div>
                                <div class="col-sm-3 text-center">
                                    <button type="button" class="btn btn-primary btn-detalhes" ng-click="show(5)">
                                        <i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;Detalhes
                                    </button>
                                </div>
                            </div>
                            <div class="row" ng-show="showDetalhes(5)">
                                <div class="col-sm-12 text-center">
                                    <h4>Detalhes</h4>                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>           
        </div>                          
        <div class="container">
            <hr>
            <footer>
                <p>� Trilha Brasil 2014</p>
            </footer>      
        </div>      
        <br>                
        <script type="text/javascript" src="libs/angularjs/js/angular.min.js"></script>        
        <script type="text/javascript" src="js/app.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    </body>
</html>
