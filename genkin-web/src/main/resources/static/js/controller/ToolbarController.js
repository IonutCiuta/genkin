'use strict';

genkin
    .controller('ToolbarController', ['$rootScope', '$scope', '$location', '$localStorage',
        function($rootScope, $scope, $location, $localStorage) {
        console.log('ToolbarController');

        $rootScope.showLogin = function () {
            console.log("showLogin");
            $rootScope.loginIsOn = true;
            $rootScope.registerIsOn = false;
            $rootScope.logoutIsOn = false;
        };

        $rootScope.showRegister = function () {
            console.log("showRegister");
            $rootScope.loginIsOn = false;
            $rootScope.registerIsOn = true;
            $rootScope.logoutIsOn = false;
        };

        $rootScope.showLogout = function () {
            console.log("showLogout");
            $rootScope.loginIsOn = false;
            $rootScope.registerIsOn = false;
            $rootScope.logoutIsOn = true;
        };

        $scope.register = function() {
            console.log('Go to register');
            $location.path('/register');
            $rootScope.showLogin();
        };

        $scope.login = function() {
            console.log('Go to login');
            $location.path('/');
            $rootScope.showRegister();
        };

        $scope.logout = function() {
            console.log('Logout');
            $localStorage.$reset();
            $rootScope.showLogin();
            $location.path('/');
        }
    }]);