var yogaApp = angular.module('yogaApp',[]);
yogaApp.controller('yogaController',['$scope','$rootScope','yogaService',function($scope,$rootScope,yogaService){
	$scope.getYogaDetails = function(){
		
		var pricingOprions = [];
			
		yogaService.pricingOptions().success(function(result){
			pricingOprions = result;
			console.log(pricingOprions);
		}).error(function(errors){
			console.log(pricingOprions);
		});
		var progeramDetails =[]
		yogaService.programsDetails().success(function(result){
			progeramDetails = result;
			console.log(progeramDetails);
		}).error(function(errors){
			console.log(progeramDetails);
		});
		
	}
}]);