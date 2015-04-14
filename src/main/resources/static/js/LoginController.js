angular.module('controllers')
    .controller('LoginController',function($scope, $window){

        $scope.login = function(){
            $window.location.href = "https://accounts.google.com/o/oauth2/auth?"+
                                      "scope=email%20profile%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdrive.readonly&"+
                                      "redirect_uri=http%3A%2F%2F127.0.0.1%3A8080%2Foauth2callback&"+
                                      "response_type=code&"+
                                      "client_id=714176515768-mqf76v7i6ju0ob1t02aoki299g4htus7.apps.googleusercontent.com&"+
                                      "approval_prompt=force";
        }
    });