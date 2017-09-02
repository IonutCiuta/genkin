'use strict';

genkin
    .controller('HomeController', ['$scope', '$rootScope', '$localStorage', '$location', '$http',
        function($scope, $rootScope, $localStorage, $location, $http) {
        console.log('HomeController');

        $rootScope.showLogout();

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

        $http.get(
            '/chart/doughnut',
            { headers: {
                'Content-Type': 'application/json',
                'Authorization': $localStorage.auth.accessToken}
            }
        ).then(function(response) {
            console.log(JSON.stringify(response.data));
            $scope.labels = response.data.labels;
            $scope.data = response.data.data;
            $scope.colors = response.data.colors;
        }, function(error) {
            console.error(JSON.stringify(error));
        });


        $http.get(
            '/chart/monthlybar',
            { headers: {
                'Content-Type': 'application/json',
                'Authorization': $localStorage.auth.accessToken}
            }
        ).then(function(response) {
            console.log(JSON.stringify(response.data));
            $scope.barLabels = response.data.labels;
            $scope.barData = response.data.data;
        }, function(error) {
            console.error(JSON.stringify(error));
        });

        $scope.addExpense = function() {
            $location.path('/expense');
        };

        $scope.formatDate = function(expense) {
            return new Date(expense.date).toLocaleDateString();
        }
    }]);