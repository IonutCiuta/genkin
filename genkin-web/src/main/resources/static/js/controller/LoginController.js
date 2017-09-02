'use strict';

genkin
    .controller('LoginController', ['$scope', '$rootScope', '$location', '$localStorage', 'UserService', 'Notification', 'Loader',
        function($scope, $rootScope, $location, $localStorage, UserService, Notification, Loader) {
        console.log('LoginController');

        $rootScope.showRegister();

        if($localStorage.auth) {
            $location.path('/home');
            $rootScope.showLogout();
        }

        $scope.login = function(user) {
            UserService.signIn($scope.user, function(response) {
                Loader.hide();
                console.log(JSON.stringify(response.data));

                if(response.data.error) {
                    Notification.error(response.data.error);
                } else {
                    $location.path('/home');
                    $localStorage.auth = response.data;
                }

            }, function(error) {
                Loader.hide();
                console.log(JSON.stringify(error));
                Notification.error("Unable to sign in!");
            });
        };
    }]);