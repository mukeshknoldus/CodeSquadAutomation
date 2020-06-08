Feature: random page tests

@random
Scenario: TC1-Search UHG in fortune 500 list
Given that search Fortune 500 company in google-TC1
Then Search Appear, click on official website-TC1 

@random
Scenario: TC03-Get top ten Fortune 500 Company Name with Rank
Given that search Fortune 500 company in google-TC03
Then Search Appear, click on official website and get top company with Rank-TC03