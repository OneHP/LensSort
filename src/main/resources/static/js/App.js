angular.module('services',[])
angular.module('controllers',['services'])
angular.module('lenssort',['ngRoute','services','controllers'])