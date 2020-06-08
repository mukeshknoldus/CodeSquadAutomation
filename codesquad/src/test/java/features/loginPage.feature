Feature: codesquad login page options
 
Background: User should be able to land on codesquad login page
 Given User is having the codesquad login page URL
 When User hit  the codeSquad login page URL
 Then User should see login page along with login form and login button
 
 @smoke
Scenario Outline: unsuccesfull login with wrong emailid with wrong password
Given User is on login page
When User enters wrong user <username> and wrong password <password>
Then User should get error message and should not login 

Examples:
| username | password |
| testuser@knoldus.com | 122@wrongpassword |

@regression
Scenario Outline: successful login with normal user role with valid credential 
Given User is already on login page
When User enters correct user <username> and corret password <password>
Then User should navigate to the normal user dashboard page

Examples:
| username | password |
| codesquadteam | knoldus123|