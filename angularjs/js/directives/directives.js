angular.module('contactApp.directives', [])
.directive('btnEditContact', function()
{
	return {
		restrict: 'E',
		template: "<a class='btn btn-primary' ng-href='#editContact/{{contact.contact_id}}'>Edit</a>"
	};
})
.directive('btnDeleteContact', function(){
	return {
		restrict: 'E',
		template: "<a class='btn btn-danger' ng-href='#deleteContact/{{contact.contact_id}}'>Delete</a>"
	};
});