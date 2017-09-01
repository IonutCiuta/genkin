const THEME 	= 'genkin-theme';
const PRIMARY 	= 'orange';
const ACCENT 	= 'deep-orange';

genkin
    .config(['$mdThemingProvider', function ($mdThemingProvider) {
        console.log("Theme config.");

        $mdThemingProvider
            .theme(THEME)
            .primaryPalette(PRIMARY)
            .accentPalette(ACCENT)

        $mdThemingProvider
            .theme('dark-blue')
            .backgroundPalette('blue')
            .dark();
    }]);