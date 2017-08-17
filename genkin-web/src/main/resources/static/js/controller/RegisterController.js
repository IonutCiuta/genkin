'use strict';

genkin
    .controller('RegisterController', ['$scope', '$mdToast', 'Notification', function($scope, $mdToast, Notification) {
        console.log('Register controller');

        $scope.register = function() {
            console.log('Register: ' + JSON.stringify($scope.user));
            Notification.error('Register');
        };
    }]);