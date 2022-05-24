# Example of API tests

This project created to show how we can implement API test automation structure.

## What was used

- Java 11;
- Selenide + TestNG;
- RestAssured;
- HttpURLConnection;
- ExtentReport.

## How to run

To run tests you need to run command:
````
mvn clean test
````

## How to see tests result

After tests finished, you can find result in directory 
````
/test-output/ExtentReport.html
````

## CI integration

For CI integration Jenkinsfile was added (it's example file)