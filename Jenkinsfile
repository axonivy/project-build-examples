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
      defaultValue: 'https://jenkins.ivyteam.io/job/ivy-core_product/job/master/lastSuccessfulBuild/')
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
                  "-Divy.engine.version=[9.3.0,] " + 
                  "-Dmaven.test.failure.ignore=true " +
                  "-Dtest.engine.url=http://${ivyName}:8080 " +
                  "-Dselenide.remote=http://${seleniumName}:4444/wd/hub "
                checkVersions()
              }
            }
          } finally {
            sh "docker network rm ${networkName}"
          }          
          recordIssues tools: [mavenConsole()], unstableTotalAll: 1, filters: [
            excludeMessage('The system property test.engine.url is configured twice!.*')
          ]
          junit '**/**/target/*-reports/**/*.xml'
        }
      }
    }
  }
}
