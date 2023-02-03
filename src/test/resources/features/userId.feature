Feature: Users inquiry id
  As a user,
  I want to search the information of user id
  for id  user information

  @getIdUser
  Scenario: Successful user inquiry id
    Given that "user" wants to list all users
    When he calls get user of id "241304" API service
    Then he validates status code get users service is 200
    Then he validates name get user service  "Prof. Bhaanumati Deshpande"