Selenium Test Automation Framework
This repository provides a test automation framework for web applications using Selenium WebDriver and TestNG.

The framework is designed for easy setup and extension, with a focus on login functionality testing.

Technologies Used
Selenium WebDriver: For browser automation.
TestNG: For running tests and managing test reports.
Java: The programming language for writing tests.
Maven: For managing dependencies.
Setup Instructions
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/SeleniumTestAutomationFramework.git
Navigate to the project folder:

bash
Copy
Edit
cd SeleniumTestAutomationFramework
Install dependencies:

bash
Copy
Edit
mvn clean install
Open the project in your IDE (e.g., IntelliJ IDEA, Eclipse).

Ensure WebDriver (e.g., ChromeDriver) is set up on your machine.

How to Run Tests
Run all tests:

bash
Copy
Edit
mvn test
Run a specific test case:

bash
Copy
Edit
mvn -Dtest=LoginTest test


Test Cases


Valid Login: Tests a successful login.


Without Any Credentials: Tests that the user cannot log in without credentials.


With Wrong Password: Tests login with incorrect password.


Login with Locked-out User: Tests login with a locked-out user.




