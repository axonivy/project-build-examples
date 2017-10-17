# Deploys a full Application
This build example demonstrates how a full ivy application (based on multiple sub-projects) can be built and deployed to a running Axon.ivy Engine.

## About the sample app
The sample application is divided into three sub projects:
- [base](base/pom.xml): the domain model plus its database integration layer
- [solution](solution/pom.xml): the user dialogs that provide a solution
- [customer](customer/pom.xml): customizations for a specific customer
