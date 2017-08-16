genkin
    .config(function ($routeProvider) {
        console.log("Routing config.");

        $routeProvider.
        when('/', {
            templateUrl: 'template/login.html',
            controller: 'LoginController'
        });
    });