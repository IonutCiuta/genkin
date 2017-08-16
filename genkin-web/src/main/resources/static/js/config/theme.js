const THEME 	= 'genking-theme';
const PRIMARY 	= 'orange';
const ACCENT 	= 'deep-orange';

genkin
    .config(function ($mdThemingProvider) {
        console.log("Theme config.");

        $mdThemingProvider
            .theme(THEME)
            .primaryPalette(PRIMARY)
            .accentPalette(ACCENT)
    });