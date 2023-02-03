Feature: User add
  As a user,
  I want to search the information of user
  for id  user information

  @postAddUser
  Scenario Outline:: Successful create user
    Given that "user" wants to list all users
    When add a user with  name, email, gender, status
      | <name> | <email> | <gender> | <status> |
    Then he validates status code get users service is 201
    Then he validates name get user service  "<name>"
    Examples:
      |name | email | gender | status |
      |David | Random | male | active |
      |Alice | Random | female | inactive |

