'use strict';

genkin
    .controller('ToolbarController', ['$rootScope', '$scope', '$location', function($rootScope, $scope, $location) {
        console.log('ToolbarController');

        $scope.register = function() {
            console.log('Go to register');
            $location.path('/register');
        };
    }]);