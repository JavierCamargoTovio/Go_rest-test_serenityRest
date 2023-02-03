Feature: User Delete
  As a user,
  I want to delete the information of user
  for remove user information

  @DeleteUser
  Scenario Outline:: Successful delete user
    Given that "user" wants to list all users
    When delete the information user with the data id "<id>"
    Then he validates status code get users service is 204
    Examples:
      | id  |
      | 712 |
      | 713 |
  # Los id se deben cambiar por cada ejecución, si no fallara el escenario

