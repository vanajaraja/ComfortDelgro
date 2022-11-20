#Author : vanajasadasivam@gmail.com
#@Functional

Feature: Validate the create post functionality of RealWorld application 

Scenario: validate the create post functionality

Given Sending the signin post request with "email" and "password"
And Get token from signin response
And Sending the create post payload with token
	|title|description|body|tagList|
	|Test|Testing a post|Article for posting it in Conduit|test|
When create a new post with post request
Then Should get proper create post response
And Create Post Status code should be 200

