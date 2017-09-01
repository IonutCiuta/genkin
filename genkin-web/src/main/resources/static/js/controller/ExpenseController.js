'use strict';

genkin
    .controller('ExpenseController', ['$scope', '$rootScope', '$location', '$localStorage', '$http',
        function($scope, $rootScope, $location, $localStorage, $http) {
        console.log('ExpenseController');

        $http.get(
            '/category/all',
            { headers: {'Authorization': $localStorage.auth.accessToken}}
        ).then(function (response) {
            console.log(JSON.stringify(response.data));
            $scope.categories = response.data;
        }, function(error){
            console.error(JSON.stringify(error));
        });

        $scope.add = function() {
            console.log(JSON.stringify($scope.expense));
            $http.post(
                '/expense/add', $scope.expense,
                { headers: {
                    'Content-Type': 'application/json',
                    'Authorization': $localStorage.auth.accessToken}
                }
            ).then(function(response) {
                console.log(JSON.stringify(response.data));
                $location.path('/home');
            }, function(error) {
                console.error(JSON.stringify(error));
            });
        }
    }]);