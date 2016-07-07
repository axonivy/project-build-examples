# project-build-examples 6.2
sample projects to demonstrate project CI/CD features of the [`project-build-plugin`](http://axonivy.github.io/project-build-plugin/snapshot).

## compile-test
Simple multi module build with an ivy project and extra projects to test it. 

### prerequisites
- install a [Maven runtime](https://maven.apache.org/install.html)
- download and unpack this branch as [ZIP](https://github.com/axonivy/project-build-examples/archive/master.zip) (or clone it with git) 

### compile and run unit tests
- open a command line and navigate into the unpacked `compile-test` folder
- run `mvn clean package` to build the ivy project and run its unit tests

### run integration-tests
- open a command line and navigate into the unpacked `compile-test` folder
- run `mvn clean verify` to build the ivy project, run its unit test and web integration tests
