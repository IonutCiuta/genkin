'use strict';

genkin
    .controller('LoginController', ['$scope', '$mdToast', 'Notification', 'Loader', function($scope, $mdToast, Notification, Loader) {
        console.log('LoginController');

        $scope.login = function(user) {
            if($scope.user && $scope.user.name && $scope.user.password) {
                console.log(JSON.stringify($scope.user));
                Loader.show();
            } else {
                Notification.error('Both fields are required!');
            }
        }
    }]);