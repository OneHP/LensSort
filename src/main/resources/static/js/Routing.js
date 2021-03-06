angular.module('lenssort').config(['$routeProvider',
    function($routeProvider) {
      $routeProvider.
        when('/login',{
            templateUrl: 'partials/Login.html',
            controller: 'LoginController'
        }).
        when('/login-callback', {
          templateUrl: 'partials/LoginCallback.html',
          controller: 'LoginCallbackController'
        }).
        when('/login-error', {
          templateUrl: 'partials/LoginError.html',
          controller: 'LoginErrorController'
        }).
        otherwise({
          redirectTo: '/login'
        });
    }
]);