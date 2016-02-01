# project-build-examples
example use cases for the latest unofficial [`com.axonivy.ivy.ci:project-build-plugin:6.1.0-SNAPSHOT`](https://github.com/axonivy/project-build-plugin)

## compile-test
Simple multi module build with an ivy project and extra project to test it. To build the ivy project and run its tests proceed as follows:
- install a maven runtime https://maven.apache.org/install.html
- download and unpack this branch as ZIP (or clone it with git) https://github.com/axonivy/project-build-examples/archive/6.1.zip
- open a command line and navigate into the unpacked compile-test folder
- run `mvn clean package` to build the ivy project and run its tests.
