# project-build-examples
Sample projects to demonstrate project CI/CD features of the [`project-build-plugin`](http://axonivy.github.io/project-build-plugin/snapshot).

## Prerequisites for all examples
- Install a [Maven runtime](https://maven.apache.org/install.html).
- Download and unpack this branch as [ZIP](https://github.com/axonivy/project-build-examples/archive/master.zip) (or clone it with git).

## compile-test
Simple multi module build with an ivy project and extra projects to test it.

### compile and run unit tests
- Open a command line and navigate into the unpacked `compile-test` folder.
- Run `mvn clean package` to build the ivy project and run its unit tests.

### run integration-tests
- Open a command line and navigate into the unpacked `compile-test` folder.
- Run `mvn clean verify` to build the ivy project, run its unit test and web integration tests.

## deploy
Set of projects that demonstrate [deployment scenarios](deploy) to an Axon.ivy Engine.
