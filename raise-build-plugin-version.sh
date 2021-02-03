#!/bin/bash

mvn --batch-mode versions:set-property versions:commit -Dproperty=project.build.plugin.version -DnewVersion=${1} -DprocessAllModules -DallowSnapshots=true
mvn --batch-mode -f deploy/application/maven/config/pom.xml versions:set-property versions:commit -Dproperty=project.build.plugin.version -DnewVersion=${1} -DprocessAllModules -DallowSnapshots=true
