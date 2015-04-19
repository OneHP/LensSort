angular.module('services')
    .factory('DriveAnalysisModel', function(){
        var driveAnalysisModel = {metadataCounts:null,photos:[]};
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

        service.getFilteredPhotos = function(filterRequest){
            $http.post('/filtered-photos',filterRequest)
                .success(function(data, status, headers, config){
                    DriveAnalysisModel.photos = data;
                })
                .error(function(data, status, headers, config){

                });
        }

        return service;
    }]);