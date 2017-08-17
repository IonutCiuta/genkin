'use strict';

genkin
    .controller('ToolbarController', ['$rootScope', '$scope', '$location', function($rootScope, $scope, $location) {
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
    }]);