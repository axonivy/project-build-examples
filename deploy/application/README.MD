# Deploys a full Application
This build example demonstrates how a full ivy application (based on multiple sub-projects) can be built and deployed to a running Axon.ivy Engine.

## About the sample app
The sample application is divided into three sub projects:
- [base](base/pom.xml): the domain model plus its database integration layer
- [solution](solution/pom.xml): the user dialogs that provide a solution
- [customer](customer/pom.xml): customizations for a specific customer

## Module to define the app
The root [pom.xml](pom.xml) within this directory is module that references all sub-projects that belong the ivy application.
It packs all sub-projects (archived as IAR) into a single application zip by using the maven-assembly plugin.
Via the deploy-to-engine goal it deploys this zip with all projects to a running Axon.ivy engine.
