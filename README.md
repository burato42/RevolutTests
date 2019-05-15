# Revolut test example

## Description
This project is just a demo project to test some Revolut website scenarios. 
It uses [Selenide](https://selenide.org/) and a [simplified mid-level page object model](https://selenide.org/documentation/page-objects.html). Also, this test inspired by selenide's examples ([1](https://github.com/selenide-examples/gmail), [2](https://github.com/selenide-examples/google))
[Gradle](https://gradle.org/) is used as a build tool.

Currently, these tests work properly with Chrome only. 

## Prerequisites
- Java 8 or newer
- Gradle
- Chrome browser
- [chromedriver](http://chromedriver.chromium.org/)

## How to run the tests

For Windows from the project directory
`gredlew.bat chrome`

For Linux/MasOS from the project directory
`./gredlew chrome`

## How these tests could be improved
This solution is not perfect (obviously).
Possible improvements:
- To divide community forum tests and main website tests in two classes (suites)
- To avoid restarts of the browser after each test
- To add containers (Docker for instance) to run tests in any environments
- To improve the reporting system
- To inject this framework into a CI/CD pipeline.