'use strict';

genkin
    .service('Loader', function($rootScope) {
        this.show = function() {
            $rootScope.progress = true;
        };

        this.hide = function() {
            $rootScope.progress = false;
        }
    });