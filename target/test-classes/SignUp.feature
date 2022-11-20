#Author : vanajasadasivam@gmail.com


Feature: Validate the SignUp functionality of RealWorld application 
#With all valid test data
Scenario: validate the signup functionality

Given Sending the signup payload
When create user with post request
Then Should get proper response
And Signup Status code should be 200

@Regression
#WWith different combination of invalid test data
Scenario Outline: validate the signup functionality with incorrect test data

Given Sending the signup payload with "<username>","<email>" and "<password>"
When create user with post request
Then Should get proper response
And Signup Status code should be <statuscode> 
And error message should be "<errormessage>"

Examples: 
|username|email|password|statuscode|errormessage|
||||422|email can't be blank|
|test202201|test202201@gmail.com|Test@2022|422|email has already been taken and username has already taken|
|test202201|||422|email can't be blank|
||test202201@gmail.com||422|username can't be blank|
|||Test@2022|422|email can't be blank|
|test202201|test202201@gmail.com||422|password can't be blank|
|test202201||Test@2022|422|email can't be blank|
||test202201@gmail.com|Test@2022|422|username can't be blank|
