<?php
// Author: Matthieu Chavaillaz
// Date: 26.04.2014

// Offer methods to open/close connection to a DataBase and CRUD on the DataBase
class DataBaseHelper
{ 

	/////////////////
	/// Attributs ///
	/////////////////
	private $username;
	private $password;
	private $hostname;
	private $dbname;
	private $link;

	///////////////////
	/// Constructor ///
	///////////////////
	public function DataBaseHelper()
	{
		$this->hostname = "localhost";
		$this->username = "root";
		$this->password = "";
		$this->dbname = 'exercise';
	}

	////////////////////////
	/// Public Functions ///
	////////////////////////

	// Get all the contacts in the database
	// Return: array with query results
	public function getAllContacts()
	{
		$this->openConnection();

		$arr = [];

		$sql = "SELECT * FROM contact";
		$query = mysqli_query($this->link, $sql);

		while($obj = mysqli_fetch_object($query))
		{
			$arr[] = $obj;
		}

		$this->closeConnection();

		return $arr;
	}

	// Get a single contact using his contact_id
	// Params: $contact_id
	// Return object with query result
	public function getContact($contact_id)
	{
		$this->openConnection();

		$sql = "SELECT * FROM contact WHERE contact_id = '" . $contact_id . "'";
		$query = mysqli_query($this->link, $sql);

		$this->closeConnection();

		return mysqli_fetch_object($query);
	}

	// Open connection with the database
	// Escape the string value for security using mysqlli_real_escape_string
	// Save ContactModel into the database
	// Close the connection
	// Params: ContactModel Object $contact 
	public function saveContact($contact)
	{
		$this->openConnection();

		$firstname = mysqli_real_escape_string($this->link, $contact->getFirstname());
		$lastname = mysqli_real_escape_string($this->link, $contact->getLastname());
		$address = mysqli_real_escape_string($this->link, $contact->getAddress());
		$email = mysqli_real_escape_string($this->link, $contact->getEmail());
		$phone = mysqli_real_escape_string($this->link, $contact->getPhone());

		$sql = "INSERT INTO contact (firstname, lastname, address, email, phone) VALUES ('$firstname', '$lastname', '$address', '$email', '$phone')";

		if(!mysqli_query($this->link, $sql))
		{
			die('Error: ' . mysqli_error($this->link));
		}

		$this->closeConnection();
	}

	// Update a contact
	// Params: ContactModel Object $contact
	public function updateContact($contact)
	{
		$this->openConnection();

		$contact_id = mysqli_real_escape_string($this->link, $contact->getContactId());
		$firstname = mysqli_real_escape_string($this->link, $contact->getFirstname());
		$lastname = mysqli_real_escape_string($this->link, $contact->getLastname());
		$address = mysqli_real_escape_string($this->link, $contact->getAddress());
		$email = mysqli_real_escape_string($this->link, $contact->getEmail());
		$phone = mysqli_real_escape_string($this->link, $contact->getPhone());

		$sql = "UPDATE contact SET firstname = '$firstname',
				lastname = '$lastname',
				address = '$address',
				email = '$email',
				phone = '$phone'
				WHERE contact.contact_id = '$contact_id'";

		if(!mysqli_query($this->link, $sql))
		{
			die('Error: ' . mysqli_error($this->link));
		}

		$this->closeConnection();
	}

	// Delete a contact using his id
	// Params: $contact_id
	public function deleteContact($contact_id)
	{
		$this->openConnection();

		$sql = "DELETE FROM contact WHERE contact_id = '$contact_id'";

		if(!mysqli_query($this->link, $sql))
		{
			die('Error: ' . mysqli_error($this->link));
		}

		$this->closeConnection();
	}

	/////////////////////////
	/// Private Functions ///
	/////////////////////////

	// Open the connection to the DataBase
	private function openConnection()
	{
		$this->link = mysqli_connect($this->hostname, $this->username, $this->password, $this->dbname);
		if(!$this->link)
		{
			die('Not connected: ' . mysqli_connect_error());
		}
	}

	// Close the connection to the DataBase
	private function closeConnection()
	{
		mysqli_close($this->link);
	}
}
?>