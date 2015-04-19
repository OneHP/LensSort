angular.module('controllers')
    .controller('LoginCallbackController',['$scope','DriveAnalysisService','DriveAnalysisModel',
    function($scope,DriveAnalysisService,DriveAnalysisModel){

        $scope.driveAnalysisModel = DriveAnalysisModel;
        $scope.filterModel = {cameraMake:[],cameraModel:[],lens:[],aperture:[],focalLength:[],
            isoSpeed:[],exposureTime:[]};

        $scope.refreshMetadataCounts = function(){
            DriveAnalysisService.getMetadataCounts();
            DriveAnalysisService.getFilteredPhotos($scope.filterModel);
        }

        $scope.$watch('filterModel',function(newValue,oldValue){
            DriveAnalysisService.getFilteredPhotos(newValue);
        },true);

    }]);