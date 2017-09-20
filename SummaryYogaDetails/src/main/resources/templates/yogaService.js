yogaApp.factory('yogaService',['$http',function($http){
	return {
		pricingOptions:function(){ 
			return $http({
			 method : 'GET',
			 url :"http://api.myjson.com/bins/47axv"
			});
		},programsDetails:function(){ 
						return $http({
						 method : 'GET',
						 url :"https://api.myjson.com/bins/5bdb3"
						});
					}
	};
}]);