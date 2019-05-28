# deploy-project-over-http
Single module build with one ivy project. This example shows how to deploy a single ivy project to the 'remote' engine using HTTP protocol.

- Run `mvn clean deploy --settings settings.xml` to build the ivy project and deploy it to the engine.

Note, that the user name and password used to authenticate to the remote Axon.ivy Engine is configured in the [settings.xml](settings.xml) file.
