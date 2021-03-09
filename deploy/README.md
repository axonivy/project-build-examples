# deploy examples
Demonstrates various deployment scenarios to an Axon Ivy Engine.

- [single-project](single-project) shows how to deploy a single ivy project to the engine.
- [single-project-over-http](single-project-over-http) shows how to deploy a single ivy project to a remote engine using HTTP.
- [application](application) shows how a full ivy application (based on multiple sub-projects) can be built and deployed to the engine.


## separating production and staging
We recommend to work with maven profiles:
- As default: Deploy to a Axon Ivy Engine, which is just used for development. In the example `env-dev` is the default profile.
- To deploy to a productive engine configure a non-default profile. In the example `env-prd` is a profile like that.

To run a maven build with a specific profile you must add `-P[profile_name]` as command line argument: `mvn clean deploy -Penv-prd`
