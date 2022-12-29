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
          def groupDocker = sh returnStdout:true, script:'getent group docker | cut -d: -f3'
          groupDocker = groupDocker.trim();
          sh "docker network create ${networkName}"
          try {
            docker.image("selenium/standalone-firefox:4").withRun("-e START_XVFB=false --shm-size=2g --name ${seleniumName} --network ${networkName} -v /var/run/docker.sock:/var/run/docker.sock --group-add ${groupDocker}") {
              docker.build('maven').inside("--network ${networkName} -v /var/run/docker.sock:/var/run/docker.sock -e DOCKER_HOST=unix:///var/run/docker.sock --group-add ${groupDocker}") {
                maven cmd: "clean install " +
                  "--settings deploy/single-project-over-http/settings.xml " +
                  "-Divy.engine.list.url=${params.engineListUrl} " +
                  "-Divy.engine.version=[10.0,10.1] " + 
                  "-Dmaven.test.failure.ignore=true " +
                  "-Dselenide.remote=http://${seleniumName}:4444/wd/hub "                
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
