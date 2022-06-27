var ppdmapp = angular.module('ppdmapplication', [ 'ngRoute', 'ngResource' ]);

ppdmapp.config(function($routeProvider) {
	$routeProvider.when('/list-all-algorithms', {
		templateUrl : '/template/listalgorithms.html',
		controller : 'listAlgorithmsController'
	}).when('/create-new-algorithm',{
		templateUrl : '/template/createnewalgorithm.html',
		controller : 'createNewalgorithmController'
	}).when('/update-algorithm/:algorithmId',{
		templateUrl : '/template/updatealgorithm.html' ,
		controller : 'updateAlgorithmController'
	}).otherwise({
		redirectTo : '/main',
		templateUrl : '/template/main.html',
	});
});