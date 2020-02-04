# project-build-examples compile-test

## run tests with designer
- Import `crm`, `crm.tests` and `crm.integration.tests` into designer
- Right-click in test class -> Run As -> JUnit Test

![run test](webtesting-run.gif)

> Maybe disable headless flag on `IvySelenide` annotation

## run tests with maven
- Open a command line and navigate into the unpacked `compile-test` folder.
- Run `mvn clean verify` to build the ivy project, run its web integration tests.

## dependencies

We use our [primeui-tester](https://github.com/ivy-supplements/primeui-tester) for all web tests.