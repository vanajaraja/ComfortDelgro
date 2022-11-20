#Author : vanajasadasivam@gmail.com

#@Functional
Feature: Validate the SignIn functionality of RealWorld application 

Scenario Outline: validate the signin functionality
Given Sending the signin payload with "<email>" and "<password>"
When signin with post request
Then Should get proper signin response
And Status code should be <statuscode>

Examples:
	|email|password|statuscode|
	|test202201@gmail.com|test@2022|200|
	|test202201@gmail.com|invalidpassword|403|
	|invalidemail@gmail.com|test@2022|403|
	|invalidemail@gmail.com|invalidpassword|403|
	


