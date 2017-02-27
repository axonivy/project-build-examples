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

## deploy-project
Single module build with one ivy project. This example shows how to deploy a single ivy project to the engine.

Attention: As prerequisites before each deployment the defined application must already exist on the engine and the engine must run.

- Open a command line and navigate into the unpacked `deploy-project` folder.
- Run `mvn clean deploy` to build the ivy project and deploy it to the engine.

We recommend to work with maven profiles:
- As default: Deploy to a Axon.ivy engine, which is just used for development. In the example `env-dev` is the default profile.
- To deploy to a productive engine configure a non-default profile. In the example `env-prd` is a profile like that.

To run a maven build with a specific profile you must add `-P[profile_name]` as command line argument: `mvn clean deploy -Penv-prd`
