ppdmapp.controller('createNewalgorithmController', function($scope, $http, $location,
	$route) {

	$scope.submitAlgorithmForm = function() {
		$http({
			method: 'POST',
			url: 'http://localhost:8080/api/ppdmalgorithms/',
			data: $scope.algorithm,
		}).then(function(response) {
			$location.path("/list-all-algorithms");
			$route.reload();
		}, function(errResponse) {
			$scope.errorMessage = errResponse.data.errorMessage;
		});
	}

	$scope.resetForm = function() {
		$scope.algorithm = null;
	};
});

ppdmapp.controller(	'listAlgorithmsController',function($scope, $http, $location, $route) {

		$http({
			method: 'GET',
			url: 'http://localhost:8080/api/ppdmalgorithms/'
		}).then(function(response) {
			$scope.algorithms = response.data;
		});

		$scope.editAlgorithm = function(algorithmId) {
			$location.path("/update-algorithm/" + algorithmId);
		}

		$scope.deleteAlgorithm = function(algorithmId) {
			$http({
				method: 'DELETE',
				url: 'http://localhost:8080/api/ppdmalgorithms/' + algorithmId
			})
				.then(
					function(response) {
						$location.path("/list-all-algorithms");
						$route.reload();
					});
		}
	});
	
ppdmapp.controller('updateAlgorithmController',function($scope, $http, $location, $routeParams, $route) {

			$scope.AlgorithmId = $routeParams.algorithmId;

			$http({
				method: 'GET',
				url: 'http://localhost:8080/api/ppdmalgorithms/' + $scope.AlgorithmId
			}).then(function(response) {
				$scope.algorithm = response.data;
			});

			$scope.updateAlgorithmForm = function() {
				$http({
					method: 'PUT',
					url: 'http://localhost:8080/api/ppdmalgorithms/'+ $scope.AlgorithmId,
					data: $scope.algorithm,
				})
					.then(
						function(response) {
							$location.path("/list-all-algorithms");
							$route.reload();
						},
						function(errResponse) {
							$scope.errorMessage = "Error while updating Algorithm - Error Message: '"
								+ errResponse.data.errorMessage;
						});
			}
		$scope.resetForm = function() {
		$scope.algorithm = null;
	};
		});	
