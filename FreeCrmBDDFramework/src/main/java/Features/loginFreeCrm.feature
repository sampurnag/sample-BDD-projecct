Feature: Free CRM login feature

Scenario Outline: login to free CRM

Given user is on login page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then user moves to new contact page
Then user enters  contact"<firstname>" and "<lastname>" and "<position>"
Then close the browser 

Examples:
 | username| password| firstname| lastname|position|
 | naveenk | test@123| purna    | gadipudi|lead    |
 | tom     | test212 | ram      | bolla   |manager |
