# Base Image contains the Axon Ivy Engine
FROM axonivy/axonivy-engine:dev

# Add your application to the image
ADD --chown=ivy:ivy target/ivy-application-13.2.0-SNAPSHOT.zip /ivy/deploy/ivy-application.zip

# Add your license to the image
ADD --chown=ivy:ivy image/demo-enterprise-licence.lic /ivy/configuration/enterprise-licence.lic

# Add your configuration ivy.yaml to the image
ADD --chown=ivy:ivy image/ivy.yaml /ivy/configuration/ivy.yaml

# Set owner of the files directory
RUN mkdir -p /ivy/data && chown -R ivy /ivy/data
