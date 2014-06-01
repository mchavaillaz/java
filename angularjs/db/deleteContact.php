<?php 
require_once '../db/dbHelper.php';
require_once '../db/contactModel.php';
require_once '../php/FirePHP.class.php';

$db = new DataBaseHelper();

$f = FirePHP::getInstance(true);

$data = json_decode(file_get_contents("php://input"));

if(!empty($data))
{
	$db->deleteContact($data->{'contact_id'});
}
?>