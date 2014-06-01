<?php
// Author: Matthieu Chavaillaz
// Date: 26.04.2014

// Model of the application
// Represent a contact person 
class ContactModel
{

	/////////////////
	/// Attributs ///
	/////////////////
	private $contact_id;
	private $firstname;
	private $lastname;
	private $address;
	private $email;
	private $phone;

	///////////////////
	/// Constructor ///
	///////////////////
	public function ContactModel()
	{
		$this->contact_id = "";
		$this->firstname = "";
		$this->lastname = "";
		$this->address = "";
		$this->email = "";
		$this->phone = "";
	}

	///////////////
	/// Getters ///
	///////////////
	public function getContactId()
	{
		return $this->contact_id;
	}
	public function getFirstname()
	{
		return $this->firstname;
	}

	public function getLastname()
	{
		return $this->lastname;
	}

	public function getAddress()
	{
		return $this->address;
	}

	public function getEmail()
	{
		return $this->email;
	}

	public function getPhone()
	{
		return $this->phone;
	}

	///////////////
	/// Setters ///
	///////////////
	public function setContactId($value)
	{
		$this->contact_id = $value;
	}

	public function setFirstname($value)
	{
		$this->firstname = $value;
	}

	public function setLastname($value)
	{
		$this->lastname = $value;
	}

	public function setAddress($value)
	{
		$this->address = $value;
	}

	public function setPhone($value)
	{
		$this->phone = $value;
	}

	public function setEmail($value)
	{
		$this->email = $value;
	}
}
