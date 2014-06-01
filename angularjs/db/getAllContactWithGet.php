<?php 
require_once '../db/dbHelper.php';
require_once '../php/FirePHP.class.php';

$db = new DataBaseHelper();

$f = FirePHP::getInstance(true);

if(isset($_GET['getAllContacts']))
{
	$json_response = json_encode($db->getAllContacts());
	print_r($json_response);
}
?>