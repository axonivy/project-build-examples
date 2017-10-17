# Deploys a full Application
This build example demonstrates how a full ivy application (based on multiple sub-projects) can be built and deployed to a running Axon.ivy Engine.

By running `mvn clean install` you will see how:
1. three ivy projects are built as ivy archive (IAR).
1. the module build packs these three projects into a single (ZIP) archive.
1. the module build deploy the full application (ZIP) to a running engine.

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

Via the deploy-to-engine goal it deploys this zip with all projects to a running Axon.ivy engine.
```xml
<plugin>
  <groupId>com.axonivy.ivy.ci</groupId>
  <artifactId>project-build-plugin</artifactId>
  <version>7.1.0-SNAPSHOT</version>
  <executions>
    <execution>
      <id>test.app.deploy</id>
      <phase>pre-integration-test</phase>
      <goals><goal>deploy-to-engine</goal></goals>
      <configuration>
        <deployFile>${project.build.directory}/${project.artifactId}-${project.version}-app.zip</deployFile>
        <deployToEngineApplication>Portal</deployToEngineApplication>
      </configuration>
    </execution>
  </executions>
</plugin>
```
