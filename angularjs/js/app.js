angular.module('contactApp', 
	[
	'ngRoute',
	'contactApp.controllers',
	'contactApp.factories',
	'contactApp.services',
	'contactApp.directives'
	]
).config(function($routeProvider)
{
	$routeProvider.when('/addContact',
	{
		templateUrl: './partials/add_contact.html',
		controller: 'AddContactCtrl'
	})
	.when('/allContact', 
	{
		templateUrl: './partials/all_contact.html',
		controller: 'AllContactCtrl'
	})
	.when('/editContact/:contactId',
	{
		templateUrl: './partials/add_contact.html',
		controller: 'EditContactCtrl'
	})
	.when('/deleteContact/:contactId',
	{
		templateUrl: './partials/delete_contact.html',
		controller: 'DeleteContactCtrl'
	})
	.otherwise(
	{
		redirectTo: '/allContact'
	});
});