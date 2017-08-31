'use strict';

genkin
    .controller('LoginController', ['$scope', '$mdToast', 'Notification', 'Loader', function($scope, $mdToast, Notification, Loader) {
        console.log('LoginController');

        $scope.login = function(user) {
            UserService.signIn($scope.user, function(response) {
                Loader.hide();
                console.log(JSON.stringify(response.data));
                $location.path('/home');
            }, function(error) {
                Loader.hide();
                console.log(JSON.stringify(error));
                Notification.error("Unable to sign in!");
            });
        };
    }]);