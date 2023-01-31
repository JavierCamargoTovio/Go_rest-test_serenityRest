Feature: Users inquiry
  As a user,
  I want to search the information of all the users
  for list all users information

  @getAllUser
  Scenario: Successful users inquiry through
    Given that "user" wants to list all users
    When he calls get users API service
    Then he validates status code get users service is 200