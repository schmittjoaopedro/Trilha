<!DOCTYPE html>
<html lang="en" ng-app="NewUserApp">
    <head>
       <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Trilha Brasil">
        <meta name="author" content="Fabr�cio Ronchi - Jo�o Schimitt">
        <link rel="icon" href="img/icon.svg">
        <link href="../libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/style.css" rel="stylesheet">
    </head>
    <body ng-controller="NewUserController">
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
        <div class="container container-new-user">
            <div class="row">
                <div class="col-sm-5">
                    <form role="form">
                        <div class="form-group">
                            <label>Nome</label>
                            <input type="text" class="form-control" placeholder="Nome">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label>Senha</label>
                            <input type="password" class="form-control" placeholder="Senha">
                        </div>                                                
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
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
        <script type="text/javascript" src="../libs/angularjs/js/angular.min.js"></script>        
        <script type="text/javascript" src="js/app.js"></script>
    </body>
</html>