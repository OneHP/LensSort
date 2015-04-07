angular.module('controllers',[])
    .controller('LoginController',function($scope, $window){

        $scope.login = function(){
            $window.location.href = "http://google.com/";
        }
    });