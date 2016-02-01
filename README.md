# project-build-examples
example use cases for the latest unofficial [`com.axonivy.ivy.ci:project-build-plugin:6.1.0-SNAPSHOT`](https://github.com/axonivy/project-build-plugin)

## compile-test
Simple multi module build with an ivy project and extra projects to test it. 

### prerequisites
- install a [Maven runtime](https://maven.apache.org/install.html)
- download and unpack this branch as [ZIP](https://github.com/axonivy/project-build-examples/archive/6.1.zip) (or clone it with git) 

### compile and run unit tests
- open a command line and navigate into the unpacked `compile-test` folder
- run `mvn clean package` to build the ivy project and run its unit tests

### run integration-tests
- open a command line and navigate into the unpacked `compile-test` folder
- run `mvn clean verify` to build the ivy project, run its unit test and web integration tests
