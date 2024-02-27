pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '3'))
  }

  triggers {
    cron '@midnight'
  }

  parameters {
    string(name: 'engineListUrl',
      description: 'Engine to use for build',
      defaultValue: 'https://product.ivyteam.io')
  }

  stages {
    stage('build') {
      steps {
        script {
          def random = (new Random()).nextInt(10000000)
          def networkName = "build-" + random
          def seleniumName = "selenium-" + random
          def ivyName = "ivy-" + random
          sh "docker network create ${networkName}"
          try {
            docker.image("selenium/standalone-firefox:3").withRun("-e START_XVFB=false --shm-size=2g --name ${seleniumName} --network ${networkName}") {
              docker.build('maven').inside("--name ${ivyName} --network ${networkName}") {
                maven cmd: "clean install " +
                  "-Divy.engine.list.url=${params.engineListUrl} " +
                  "-Divy.engine.version=[8.0.0,8.1.0] " + 
                  "-Dmaven.test.failure.ignore=true " +
                  "-Dtest.engine.url=http://${ivyName}:8080/ivy " +
                  "-Dselenide.remote=http://${seleniumName}:4444/wd/hub "
              }
            }
          } finally {
            sh "docker network rm ${networkName}"
          }          
          recordIssues tools: [mavenConsole()], qualityGates: [[threshold: 1, type: 'TOTAL']], filters: [
            excludeMessage('The system property test.engine.url is configured twice!.*')
          ]
          junit '**/**/target/*-reports/**/*.xml'
        }
      }
    }
  }
}
