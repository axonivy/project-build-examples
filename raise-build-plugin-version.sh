#!/bin/bash

# Updates project-build-plugin versions in all pom.xml files

# Update project-build-plugin version in reactor POM and all modules POMs 
mvn --batch-mode versions:set-property versions:commit -Dproperty=project.build.plugin.version -DnewVersion=${2} -DprocessAllModules -DallowSnapshots=true

# Update project-build-plugin version in parent POMs
mvn -f compile-test/crm.maven/config/pom.xml --batch-mode versions:set-property versions:commit -Dproperty=project.build.plugin.version -DnewVersion=${2} -DallowSnapshots=true
mvn -f deploy/application/maven/config/pom.xml --batch-mode versions:set-property versions:commit -Dproperty=project.build.plugin.version -DnewVersion=${2} -DallowSnapshots=true
mvn -f docker/maven/config/pom.xml --batch-mode versions:set-property versions:commit -Dproperty=project.build.plugin.version -DnewVersion=${2} -DallowSnapshots=true
