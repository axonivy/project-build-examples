# Deploy a full Application ZIP
`requires project-build-plugin 7.2.0 and Axon.ivy Engine 7.2.0 RC or newer` 

This build example demonstrates how a full ivy application (based on one single sub-project) can be built and deployed to a running Axon.ivy Engine.
The example will provide an app.yaml file. With this file you can override application specific configurations. 
For more information about the configurations consult the engine guide: https://developer.axonivy.com/doc/7.2.latest/EngineGuideHtml/configuration.html#configuration-file-ref-app-yaml
The overridden configs can be seen in the configViewer user dialog or the adminUI.

By running `mvn clean install` you will see how:
1. one ivy project are built as ivy archive (IAR).
1. the module build packs these one project into a single (ZIP) archive.
1. the module build deploys the full application (ZIP) to a running engine.

## About the sample app
The sample application is divided into one sub project:
- [configViewer](configViewer/pom.xml): provide a user dialog with information about configs

## Module to define the app
The root [pom.xml](pom.xml) within this directory is the module that references all sub-projects that belong the ivy application.
```xml
<modules>
  <module>configViewer</module>
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
In addition the assembly.xml will add a app.yaml file to the application zip folder.
```xml
<id>app</id>
<formats><format>zip</format></formats>
<includeBaseDirectory>false</includeBaseDirectory>

<files>
  <file>
    <source>app.yaml</source>
    <outputDirectory>/</outputDirectory> 
  </file>
</files>

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
  <version>8.0.7-SNAPSHOT</version>
  <executions>
    <execution>
      <id>deploy.to.staging</id>
      <phase>pre-integration-test</phase>
      <goals><goal>deploy-to-engine</goal></goals>
      <configuration>
        <deployFile>${project.build.directory}/${project.artifactId}-${project.version}-app.zip</deployFile>
        <deployToEngineApplication>MyApplication</deployToEngineApplication>
        <deployEngineDirectory>\\myStagingSrv\ivyEngine72\deploy</deployEngineDirectory>
      </configuration>
    </execution>
  </executions>
</plugin>
```
