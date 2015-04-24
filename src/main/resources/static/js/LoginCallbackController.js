angular.module('controllers')
    .controller('LoginCallbackController',['$scope','DriveAnalysisService','DriveAnalysisModel',
    function($scope,DriveAnalysisService,DriveAnalysisModel){

        $scope.pageSize = 500;
        $scope.driveAnalysisModel = DriveAnalysisModel;
        $scope.filterModel = {cameraMake:[],cameraModel:[],lens:[],aperture:[],focalLength:[],
            isoSpeed:[],exposureTime:[]};

        $scope.refreshMetadataCounts = function(){
            DriveAnalysisService.getMetadataCounts($scope.filterModel);
            DriveAnalysisService.getFilteredPhotos($scope.filterModel);
        }

        $scope.$watch('filterModel',function(newValue,oldValue){
            DriveAnalysisService.getMetadataCounts(newValue);
            DriveAnalysisService.getFilteredPhotos(newValue);
        },true);

    }]);