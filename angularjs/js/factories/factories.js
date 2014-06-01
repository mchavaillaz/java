angular.module('contactApp.factories', [])
.factory('contactFactory', ['$http', function($http)
{
	var getContactsWithPost = function()
	{
		var result = {};

		$http.post('./db/getAllContact.php', {'getAllContacts': 'all'})
		.success(function(data, status, header, config)
		{
			if(data != '')
			{
				result.data = data;
			}
			else
			{
				console.log("data is null...");
			}
		})
		.error(function(data, status)
		{
			result.data = data;
		});

		return result;
	};

	var getContactsWithGet = function()
	{
		var result = {};

		$http(
		{
			method: 'GET',
			url: './db/getAllContactWithGet.php',
			params: {getAllContacts: "all"}
		})
		.success(function(data, status)
		{
			result.data = data;
		})
		.error(function(data, status)
		{
			result.data = data;
		});

		return result;
	};

	var getContactWithGet = function(contactId)
	{
		var result = {};

		$http(
		{
			method: 'GET',
			url: './db/getContact.php',
			params: {contactId: contactId}
		})
		.success(function(data, status)
		{
			result.data = data;
		})
		.error(function(data, status)
		{
			result.data = data;
		})

		return result;
	};

	var getContactWithGetPromise = function(contactId)
	{
		return $http(
		{
			method: 'GET',
			url: './db/getContact.php',
			params: {contactId: contactId}
		});
	};

	var addContact = function(contact)
	{
		var response = {};
		var dataContact = {
			'firstname': contact.firstname,
			'lastname': contact.lastname,
			'address': contact.address,
			'phone': contact.phone,
			'email': contact.email
		};
		
		$http.post('./db/createContact.php', dataContact)
		.success(function(data, status, header, config)
		{
			response.data = data;
			response.status = status;
			response.header = header;
			response.config = config;
		}).error(function(data, status)
		{
			response.data = data;
			response.status = status;
		});

		return response;
	};

	var deleteContact = function(contactId)
	{
		var response = {};

		$http.post('./db/deleteContact.php', {'contact_id': contactId})
		.success(function(data, status, header, config)
		{
			response.data = data;
			response.status = status;
			response.header = header;
			response.config = config;
		}).error(function(data, status)
		{
			response.data = data;
			response.status = status;
		});
		
		return response;
	};

	var updateContact = function(contact)
	{
		var response = {};
		var dataContact = {
				'contact_id': contact.contact_id,
				'firstname': contact.firstname,
				'lastname': contact.lastname,
				'address': contact.address,
				'phone': contact.phone,
				'email': contact.email
		};

		$http(
		{
			method: 'PUT',
			url: './db/updateContact.php',
			data: dataContact

		}).success(function(data, status, header, config)
		{
			response.data = data;
			response.status = status;
			response.header = header;
			response.config = config;
		}).error(function(data, status)
		{
			response.data = data;
			response.status = status;
		});

		return response;
	};

	var contactsTest =[
		{
			contact_id: "-1",
			firstname: "Matthieu",
			lastname: "Chavaillaz",
			email: "123@abc.de",
			phone: "1234567890",
			address: "Rue de la saucisse 12"
		},
		{
			contact_id: "-2",
			firstname: "Thomas",
			lastname: "Lang",
			email: "456@fgh.ij",
			phone: "1112223344",
			address: "Rue de la tartine 13"
		},
		{
			contact_id: "-3",
			firstname: "Christian",
			lastname: "Schaerrer",
			email: "012@pqr.st",
			phone: "9990001122",
			address: "Rue de la courgette 15"
		},
		{
			contact_id: "-4",
			firstname: "Matthias",
			lastname: "Brun",
			email: "345@uvw.xy",
			phone: "3334445566",
			address: "Rue de la moutarde 15"
		},
		{
			contact_id: "-5",
			firstname: "Jonathan",
			lastname: "Schelling",
			email: "978@132.fr",
			phone: "098765432",
			address: "Rue de la pizza trop cuite 88"
		}
	];

	return(
	{
		contactsTest: contactsTest,
		contacts: getContactsWithGet,
		contact: getContactWithGet,
		deleteContact: deleteContact,
		addContact: addContact,
		updateContact: updateContact,
		contactPromise: getContactWithGetPromise
	});
}]);