var app = angular.module('myLogin', []);
app.controller('LoginController', function($scope,$http,$location) {
	$scope.account='';
	$scope.password='';
    $scope.login = function login() {
         $http({  
         url:'loginPost',          
         method:'POST',     
         headers : {
							'Content-Type' : 'application/x-www-form-urlencoded'
						},
						data : 'account=' + $scope.account + '&password='
								+ $scope.password
					}).then(function successCallback(response) {
                     console.log(response.data);
                     if(response.data.success==false){
                    	 console.log(response.data.message)
                    	 alert(response.data.message);
                    	 return ;
                     }
                     
               window.location.href = 'index';
                    
        }, function errorCallback(response) {
            // 请求失败执行代码
    });
}
});