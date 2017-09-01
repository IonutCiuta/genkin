const THEME 	= 'genkin-theme';
const PRIMARY 	= 'orange';
const ACCENT 	= 'deep-orange';

genkin
    .config(function ($routeProvider, $mdThemingProvider) {
        console.log("Routing config.");

        $mdThemingProvider
            .theme(THEME)
            .primaryPalette(PRIMARY)
            .accentPalette(ACCENT);

        $mdThemingProvider
            .theme('dark-blue')
            .backgroundPalette('blue')
            .dark();

        $routeProvider
            .when('/', {
                templateUrl: 'template/login.html',
                controller: 'LoginController'
            })
            .when('/register', {
                templateUrl: 'template/register.html',
                controller: 'RegisterController'
            })
            .when('/home', {
                templateUrl: 'template/home.html',
                controller: 'HomeController'
            })
            .when('/expense', {
                templateUrl: 'template/expense.html',
                controller: 'ExpenseController'
            });
    });