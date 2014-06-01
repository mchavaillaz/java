<?php 
require_once '../db/dbHelper.php';
require_once '../php/FirePHP.class.php';

$db = new DataBaseHelper();

$f = FirePHP::getInstance(true);

if(isset($_GET['contactId']))
{
	$f->info($_GET['contactId'], "getContact.php contactId");
	
	$json_response = json_encode($db->getContact($_GET['contactId']));
	print_r($json_response);
}
?>