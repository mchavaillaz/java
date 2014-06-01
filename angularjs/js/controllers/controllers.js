angular.module('contactApp.controllers', [])
.controller('AddContactCtrl', ['$scope', 'contactFactory', function($scope, contactFactory)
{
	$scope.viewTitle = 'Add New Contact';

	var defaultFormValues =
	{
		firstname : "",
		lastname : "",
		address : "",
		phone : "",
		email : ""
	};

	$scope.submitContactForm = function(isValid)
	{
		if(isValid)
		{
			$scope.response = contactFactory.addContact($scope.contact);
			$scope.addContactForm.$setPristine();
			$scope.contact = defaultFormValues;

			if($scope.response.status = 200)
			{
				$scope.message = "New contact added! Code Status: " + $scope.response.status;
			}
			else
			{
				$scope.message = "Error while adding new contact! Code Status: " + $scope.response.status;
			}
			
		}
	};
}])

.controller('AllContactCtrl', ['$scope', 'contactFactory', function($scope, contactFactory)
{
	$scope.viewTitle = 'Show All Contacts';
	$scope.contacts = contactFactory.contacts();
	$scope.contactsTest = contactFactory.contactsTest;
}])

.controller('EditContactCtrl', ['$scope', '$routeParams', 'contactFactory', function($scope, $routeParams, contactFactory)
{
	$scope.viewTitle = 'Edit Contact';

	contactFactory.contactPromise($routeParams.contactId)
	.then(function(response)
		{
			$scope.response = response;
			$scope.contact = response.data;
		});

	$scope.submitContactForm = function(isValid)
	{
		if(isValid)
		{
			$scope.response = contactFactory.updateContact($scope.contact);

			if($scope.response.status = 200)
			{
				$scope.message = "Contact Updated! Code Status: " + $scope.response.status;
			}
			else
			{
				$scope.message = "Error while updating contact! Code Status: " + $scope.response.status;
			}
		}
	}
}])

.controller('DeleteContactCtrl', ['$scope', '$routeParams', '$location', 'contactFactory', function($scope, $routeParams, $location, contactFactory){
	$scope.viewTitle = "Delete Contact";
	contactFactory.contactPromise($routeParams.contactId)
	.then(function(response)
		{
			$scope.response = response;
			$scope.contact = response.data;
		});

	$scope.submitContactForm = function()
	{
		$scope.response = contactFactory.deleteContact($scope.contact.contact_id);

		if($scope.response.status = 200)
		{
			$location.url('/allContact'); // Get back to home page
		}
	};
	//TODO $scope.submitContactForm to delete!!!
}]);