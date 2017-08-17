'user strict';

const ERROR_DELAY = 2000;
const ERROR_POSITION = 'bottom right';

genkin
    .service('Notification', function($mdToast) {
        this.error = function(message) {
            console.log("NotificationService.error");
            $mdToast.show($mdToast
                .simple()
                .textContent(message)
                .position(ERROR_POSITION)
                .hideDelay(ERROR_DELAY)
            );
        };
    });