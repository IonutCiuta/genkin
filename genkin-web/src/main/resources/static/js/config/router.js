genkin
    .config(function ($routeProvider) {
        console.log("Routing config.");

        $routeProvider
            .when('/', {
                templateUrl: 'template/login.html',
                controller: 'LoginController'
            })
            .when('/register', {
                templateUrl: 'template/register.html',
                controller: 'RegisterController'
            });
            .when('/home', {
                templateUrl: 'template/home.html',
                controller: 'HomeController'
            });
    });