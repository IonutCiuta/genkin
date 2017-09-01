'use strict';

genkin
    .controller('HomeController', ['$scope', '$rootScope', '$localStorage', '$location', '$http',
        function($scope, $rootScope, $localStorage, $location, $http) {
        console.log('HomeController');

        $http.get(
            '/expense/all',
            { headers: {
                'Content-Type': 'application/json',
                'Authorization': $localStorage.auth.accessToken}
            }
        ).then(function(response) {
            console.log(JSON.stringify(response.data));
            $scope.expenses = response.data;
        }, function(error) {
            console.error(JSON.stringify(error));
        });

        $scope.addExpense = function() {
            $location.path('/expense');
        };
    }]);