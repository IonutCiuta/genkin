'user strict';

genkin
    .controller('LoginController', ['$scope', '$mdToast', 'Notification', function($scope, $mdToast, Notification) {
        console.log('LoginController');

        $scope.login = function(user) {
            console.log(JSON.stringify($scope.user));
            Notification.error('Login');
        }
    }]);