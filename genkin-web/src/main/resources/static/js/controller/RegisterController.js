'use strict';

genkin
    .controller('RegisterController', ['$scope', '$rootScope', '$location', '$localStorage', 'UserService', 'Notification', 'Loader',
        function($scope, $rootScope, $location, $localStorage, UserService, Notification, Loader) {
        console.log('Register controller');

        $scope.register = function() {
            if($scope.user && $scope.user.email && $scope.user.username && $scope.user.password) {
                Loader.show();

                UserService.signUp($scope.user, function(response) {
                    Loader.hide();
                    console.log(JSON.stringify(response.data));

                    if(response.data.error) {
                        Notification.error(response.data.error);
                    } else {
                        $location.path('/home');
                        $localStorage.auth = response.data;
                        $rootScope.logoutOn = true;
                    }

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