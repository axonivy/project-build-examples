# project-build-examples
Sample projects to demonstrate project CI/CD features of the [`project-build-plugin`](http://axonivy.github.io/project-build-plugin/snapshot).

## Versions and Branches
You are currently on the master branch. Features shown here might still be under development and may not yet be released!

If you are working with a [LTS](https://dev.axonivy.com/release-cycle) or 
[LE](https://dev.axonivy.com/release-cycle) version consider to switch 
to the corresponding [branch](../../branches).

## Prerequisites for all examples
- Install a [Maven runtime](https://maven.apache.org/install.html).
- Download and unpack this branch as [ZIP](https://github.com/axonivy/project-build-examples/archive/master.zip) (or clone it with git).
- Firefox

## compile-test
Simple multi module build with an [ivy project and extra projects](compile-test) to test it.

## deploy
Set of projects that demonstrate [deployment scenarios](deploy) to an Axon Ivy Engine.

## docker
Shows how a full ivy application (based on multiple sub-projects) can be built and packed into an application specific [Docker image](docker).
