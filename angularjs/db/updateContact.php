<?php 
require_once '../db/dbHelper.php';
require_once '../php/FirePHP.class.php';
require_once '../db/ContactModel.php';

$db = new DataBaseHelper();

$f = FirePHP::getInstance(true);

$data = json_decode(file_get_contents("php://input"));

if(!empty($data))
{
	$contact = new ContactModel();

	$contact->setContactId($data->{'contact_id'});
	$contact->setFirstname($data->{'firstname'});
	$contact->setLastname($data->{'lastname'});
	$contact->setAddress($data->{'address'});
	$contact->setPhone($data->{'phone'});
	$contact->setEmail($data->{'email'});

	$db->updateContact($contact);
}
?>