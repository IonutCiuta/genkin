'use strict';

genkin
    .controller('RegisterController', ['$scope', '$mdToast', '$location', 'UserService', 'Notification', 'Loader',
        function($scope, $mdToast, $location, UserService, Notification, Loader) {
        console.log('Register controller');

        $scope.register = function() {
            if($scope.user && $scope.user.email && $scope.user.username && $scope.user.password) {
                Loader.show();

                UserService.signUp($scope.user, function(response) {
                    Loader.hide();
                    console.log(JSON.stringify(response.data));
                    $location.path('/home');
                }, function(error) {
                    Loader.hide();
                    console.log(JSON.stringify(error));
                    Notification.error("Unable to register!");
                });

            } else {
                Notification.error('All fields are required!');
            }
        };
    }]);