angular.module('controllers')
    .controller('LoginCallbackController',['$scope','DriveAnalysisService','DriveAnalysisModel',
    function($scope,DriveAnalysisService,DriveAnalysisModel){

        $scope.driveAnalysisModel = DriveAnalysisModel;

        $scope.refreshMetadataCounts = function(){
            DriveAnalysisService.getMetadataCounts();
        }

    }]);