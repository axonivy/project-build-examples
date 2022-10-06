#!/bin/bash

mvn -f compile-test/crm.maven/config/pom.xml --batch-mode versions:set-property versions:commit -Dproperty=web.tester.version -DnewVersion=${2} -DallowSnapshots=true
