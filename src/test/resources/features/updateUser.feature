Feature: User update
  As a user,
  I want to update the information of user
  for id  user information

  @putUpdateUser
  Scenario Outline:: Successful update user
    Given that "user" wants to list all users
    When uptade the information user with the data id "<id>", name, email, gender, status
      | <name> | <email> | <gender> | <status> |
    Then he validates status code get users service is 200
    Then he validates name get user service  "<name>"
    Examples:
      |name | email | gender | status |id|
      |David | Random | male | active |241307|
      |Alice | Random | female | inactive |241698|
