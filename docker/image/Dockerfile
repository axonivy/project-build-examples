# Base Image contains the Axon Ivy Engine
FROM axonivy/axonivy-engine:dev

# Add your application to the image
ADD --chown=ivy:ivy target/ivy-application-11.3.0-SNAPSHOT.zip /var/lib/axonivy-engine/deploy/ivy-application.zip

# Add your license to the image
ADD --chown=ivy:ivy image/demo-enterprise-licence.lic /etc/axonivy-engine/enterprise-licence.lic

# Add your configuration ivy.yaml to the image
ADD --chown=ivy:ivy image/ivy.yaml /etc/axonivy-engine/ivy.yaml

# Set owner of the files directory
RUN mkdir -p /var/lib/axonivy-engine/files && chown -R ivy /var/lib/axonivy-engine/files
