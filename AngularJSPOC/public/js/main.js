angular.module('angularjspoc',['ngAnimate', 'ngRoute'])
.config(function($routeProvider, $locationProvider) {

        $locationProvider.html5Mode(true);

        $routeProvider.when('/enderecopedido', {
            templateUrl: 'partials/principal.html',
            controller: 'FotosController'
        });

		$routeProvider.when('/enderecopedido/new', {
            templateUrl: 'partials/foto.html',
			controller: 'FotoController'
        });

		$routeProvider.when('/enderecopedido/edit/:fotoId', {
            templateUrl: 'partials/foto.html',
			controller: 'FotoController'
        });

        $routeProvider.otherwise({redirectTo: '/enderecopedido'});

    });