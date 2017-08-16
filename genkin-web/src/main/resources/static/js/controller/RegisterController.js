'use strict';

genkin
    .controller('RegisterController', ['$scope', function($scope) {
        console.log('Register controller');

        $scope.register = function() {
            console.log('Register: ' + JSON.stringify($scope.user));
        };
    }]);