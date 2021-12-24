# Create a docker image with a full Application ZIP
`requires project-build-plugin 9.3.0 and Axon Ivy Engine 9.3.0 or newer` 

## Prerequisites
Install [Docker](https://docs.docker.com/) and [Docker Compose](https://docs.docker.com/compose/). 

## Introduction

This build example demonstrates how a full ivy application (based on multiple sub-projects) can be built and packed into a application specific Docker image.
The Docker image will contain an Axon Ivy Engine and the deployed application.

By running `mvn clean install` you will see how:
1. three ivy projects are built as ivy archive (IAR).
1. the module build packs these three projects into a single (ZIP) archive.
1. the module build creates a Docker image based on the [image/Dockerfile](image/Dockerfile)

## About the sample app
The sample application is divided into three sub projects:
- [base](base/pom.xml): the domain model plus its database integration layer
- [solution](solution/pom.xml): the user dialogs that provide a solution
- [customer](customer/pom.xml): customizes the solution for a specific customer

## Module to define the app
The root [pom.xml](pom.xml) within this directory is the module that references all sub-projects that belong the ivy application.
```xml
<modules>
  <module>base</module>
  <module>solution</module>
  <module>customer</module>
</modules>
```

It packs all sub-projects (archived as IAR) into a single application zip by using the maven-assembly plugin. 
```xml
<plugin>
  <artifactId>maven-assembly-plugin</artifactId>
  <version>3.1.0</version>
  <configuration>
    <descriptors><descriptor>assembly.xml</descriptor></descriptors>
  </configuration>
  <executions>
    <execution>
      <id>create.app</id>
      <goals><goal>single</goal></goals>
      <phase>generate-resources</phase>
    </execution>
  </executions>
</plugin>
```

The content of the application zip is defined in the [assembly.xml](assembly.xml).
```xml
<id>app</id>
<formats><format>zip</format></formats>
<includeBaseDirectory>false</includeBaseDirectory>

<moduleSets>
  <moduleSet>
    <includeSubModules>true</includeSubModules>
    <binaries><unpack>false</unpack></binaries>
  </moduleSet>
</moduleSets>
```

## Docker Image

The [docker-maven-plugin](https://github.com/fabric8io/docker-maven-plugin) creates a new Docker image called ivy-application. 
This docker image is based on our [axonivy/axonivy-engine](https://hub.docker.com/r/axonivy/axonivy-engine) image and contains the previously ivy-application.
Have a look at [image/Dockerfile](image/Dockerfile) to see how the Docker image is built.
```xml
<!-- plugin to build the Docker Image ivy-application -->
<plugin>
  <groupId>io.fabric8</groupId>
  <artifactId>docker-maven-plugin</artifactId>
  <version>0.38.0</version>
  <configuration>
	<images>
	  <image>
		<name>%a:%v</name> <!-- ivy-application:9.3.0-SNAPSHOT -->
		<build>
		  <contextDir>${project.basedir}</contextDir>
		  <dockerFile>${project.basedir}/image/Dockerfile</dockerFile> <!-- Contains the receipt how to build the ivy-application image -->
		</build>
	  </image>
	</images>
  </configuration>
  <executions>
	<execution>
	  <!-- build image in generate-resources phase -->
	  <id>create-docker-image</id>
	  <goals><goal>build</goal></goals>
	  <phase>generate-resources</phase>
	</execution>
   </executions>
</plugin>
```

By running `docker-compose up` you can start an infrastructure that contains a loadbalancer, system database, elasticsearch and two Axon Ivy Engine nodes with the deployed ivy-application.
Open a browser and navigate to [http://localhost](http:localhost) to play with the ivy-application.
