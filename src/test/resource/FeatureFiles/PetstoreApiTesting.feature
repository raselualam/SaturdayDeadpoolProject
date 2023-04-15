@regression @api
Feature: Petstore API Testing

Scenario: Pet CRUD API
	
	Given Create pet
	And Get pet
	When Update pet
	Then Delete pet