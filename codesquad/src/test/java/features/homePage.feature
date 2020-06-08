Feature: codesquad home page options
 
Background: User should be able to land on codesquad home page
 Given User is having the codesquad home page URL
 When User hit  the codeSquad homme page URL
 Then User should see home page title as CodeSquad
 
Scenario: User should be able to navigate to the login page
Given User search for login button
When User click on login button
Then User should navigate to the login page

Scenario: User should be able to navigate to the registration page
Given User search for registration button
When User click on registration button
Then User should navigate to the registration page