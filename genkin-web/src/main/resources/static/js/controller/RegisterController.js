'use strict';

genkin
    .controller('RegisterController', ['$scope', '$mdToast', 'Notification', function($scope, $mdToast, Notification) {
        console.log('Register controller');

        $scope.register = function() {
            if($scope.user && $scope.user.email && $scope.user.username && $scope.user.password) {
                console.log('Register: ' + JSON.stringify($scope.user));
            } else {
                Notification.error('All fields are requiered!');
            }
        };
    }]);