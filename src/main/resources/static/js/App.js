angular.module('services',[])
angular.module('controllers',['services','checklist-model'])
angular.module('lenssort',['ngRoute','services','controllers'])