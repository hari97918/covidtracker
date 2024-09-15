Feature: Launch the covid tracker application and select a Country
Scenario:Launch the covid tracker application and select a Country
Given user navigates to the covid tracker url
When user select "Kerala" state from dropdown
Then user sees covid case details from plot chart
And user closed the driver
