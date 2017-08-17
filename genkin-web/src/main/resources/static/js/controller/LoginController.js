'user strict';

genkin
    .controller('LoginController', ['$scope', function($scope) {
        console.log('LoginController');

        $scope.login = function(user) {
            console.log(JSON.stringify($scope.user));
        }
    }]);