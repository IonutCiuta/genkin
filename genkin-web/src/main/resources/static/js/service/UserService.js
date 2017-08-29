'use strict';

genkin
    .service('UserService', function($http) {
        var signUp = function(user, okCb, errCb) {
            console.log("signUp: " + JSON.stringify(user));
        };

        var signIn = function(user, okCb, errCb) {
            console.log("signIn: " + JSON.stringify(user));
        };
    });