angular.module('services')
    .factory('DriveAnalysisModel', function(){
        var driveAnalysisModel = {metadataCounts:null};
        return driveAnalysisModel;
    });

angular.module('services')
    .factory('DriveAnalysisService',['$http','DriveAnalysisModel',function($http,DriveAnalysisModel){
        var service = {};

        service.getMetadataCounts = function(){
            $http.get('/metadata-counts')
                .success(function(data, status, headers, config){
                    DriveAnalysisModel.metadataCounts = data;
                })
                .error(function(data, status, headers, config){

                });
        }

        return service;
    }]);