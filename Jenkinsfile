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
      defaultValue: 'https://jenkins.ivyteam.io/job/ivy-core_product/job/release%252F9.3/lastSuccessfulBuild/')
  }

  stages {
    stage('build') {
      steps {
        script {
          def random = (new Random()).nextInt(10000000)
          def networkName = "build-" + random
          def seleniumName = "selenium-" + random
          def ivyName = "ivy-" + random
          def ivyParams = "-Divy.engine.list.url=${params.engineListUrl} " +
                          "-Divy.engine.version=[9.3.0,9.4.0\\) "
          def groupDocker = sh returnStdout:true, script:'getent group docker | cut -d: -f3'
          groupDocker = groupDocker.trim();
          sh "docker network create ${networkName}"
          try {
            docker.image("selenium/standalone-firefox:3").withRun("-e START_XVFB=false --shm-size=2g --name ${seleniumName} --network ${networkName} -v /var/run/docker.sock:/var/run/docker.sock --group-add ${groupDocker}") {
              docker.build('maven').inside("--name ${ivyName} --network ${networkName} -v /var/run/docker.sock:/var/run/docker.sock -e DOCKER_HOST=unix:///var/run/docker.sock --group-add ${groupDocker}") {
                maven cmd: "clean install " +
                  "-Dmaven.test.failure.ignore=true " +
                  "-Dtest.engine.url=http://${ivyName}:8080 " +
                  "-Dselenide.remote=http://${seleniumName}:4444/wd/hub " +
                  ivyParams
                checkVersions()
              }
            }
          } finally {
            sh "docker network rm ${networkName}"
          }
          docker.build('maven').inside() {
                maven cmd: "-f deploy/single-project/pom.xml clean install " +
                           ivyParams
          }          
          docker.build('maven').inside() {
                maven cmd: "-f deploy/single-project-over-http/pom.xml clean install " +
                  "--settings deploy/single-project-over-http/settings.xml " +
                  ivyParams
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
