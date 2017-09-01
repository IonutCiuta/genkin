'use strict';

genkin
    .service('UserService', function($http) {
        this.signUp = function(user, okCb, errCb) {
            console.log("signUp: " + JSON.stringify(user));
            $http.post('/user/register', user, {}).then(okCb, errCb);
        };

        this.signIn = function(user, okCb, errCb) {
            console.log("signIn: " + JSON.stringify(user));
            $http.post('/user/login', user, {}).then(okCb, errCb)
        };
    });