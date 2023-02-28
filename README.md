# WebAutomation-OrangeHRM-Selenium-TestNG
## Scenario
1. Login to orange hrm demo site
https://opensource-demo.orangehrmlive.com/

2. Create 2 new employees and save it to a JSON list
3. Now go to PIM dashboard and search by 1st user name. Assert that the user is found.
4. Now click on the user from the search table and update id by random userid
5. Now again search the user by new user id from the PIM dashboard menu and assert that the user is found
6. Now logout from admin and login with the 2nd user from your JSON list
7. Now click on My Info menu
8. Select Gender and Blood Type and save it
9. Click on contact details and input address and email
10. Logout the user

## Technology and Tool Used
- Selenium Webdriver
- TestNG
- Java
- Gradle
- intellij idea
- Allure

## How to run this project
- clone this project
- hit the following command into the terminal:
  - gradle clean test
- For generating Report in Allure hit
  - allure generate allure-results --clean -o allure-report
  - allure serve allure-results
  
## Allure Report
![image](https://user-images.githubusercontent.com/78273243/221939694-908554a5-99cf-4758-961f-f6116b1f8ab0.png)
![image](https://user-images.githubusercontent.com/78273243/221940010-435c42de-c686-417e-b814-201c70ab4c39.png)

## Gradle Report
![image](https://user-images.githubusercontent.com/78273243/221940532-add7305a-85ae-4435-994d-9779a106f4c0.png)

## Video Output
https://user-images.githubusercontent.com/78273243/221940647-653fbc65-79ee-49c5-9459-912231fa120c.mp4

