'use strict';

genkin
    .controller('RegisterController', ['$scope', '$mdToast', 'UserService', 'Notification', 'Loader', function($scope, $mdToast, UserService, Notification, Loader) {
        console.log('Register controller');

        $scope.register = function() {
            if($scope.user && $scope.user.email && $scope.user.username && $scope.user.password) {
                Loader.show();
                UserService.signUp($scope.user, function(response) {
                    Loader.hide();
                    console.log(JSON.stringify(response.data));
                }, function(error) {
                    Loader.hide();
                    console.log(JSON.stringify(error));
                });
            } else {
                Notification.error('All fields are requiered!');
            }
        };
    }]);