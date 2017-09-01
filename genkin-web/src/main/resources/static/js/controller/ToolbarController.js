'use strict';

genkin
    .controller('ToolbarController', ['$rootScope', '$scope', '$location', '$localStorage',
        function($rootScope, $scope, $location, $localStorage) {
        console.log('ToolbarController');

        $scope.register = function() {
            console.log('Go to register');
            $location.path('/register');
            $rootScope.onLogin = false;
        };

        $scope.login = function() {
            console.log('Go to login');
            $location.path('/');
            $rootScope.onLogin = true;
        };

        $scope.logout = function() {
            console.log('Logout');
            $location.path('/');
            $rootScope.onLogin = true;
            $rootScope.logoutOn = false;
            $localStorage.$reset();
        }
    }]);