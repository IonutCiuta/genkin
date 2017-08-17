'user strict';

genkin
    .controller('LoginController', ['$scope', '$mdToast', 'Notification', function($scope, $mdToast, Notification) {
        console.log('LoginController');

        $scope.login = function(user) {
            if($scope.user && $scope.user.name && $scope.user.password) {
                console.log(JSON.stringify($scope.user));
            } else {
                Notification.error('Both fields are required!');
            }
        }
    }]);