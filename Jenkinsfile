pipeline {
  agent {
    dockerfile true
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '60', artifactNumToKeepStr: '10'))
  }

  triggers {
    cron '@midnight'
  }

  parameters {
    choice(name: 'engineListUrl',
      description: 'Engine to use for build',
      choices: ['http://zugprojenkins/job/ivy-core_product/job/master/lastSuccessfulBuild/'])
  }

  stages {
    stage('build') {
      steps {
          script {
            def mavenParameters = "-Divy.engine.list.url=${params.engineListUrl} " +
              "-Divy.engine.version=[6.1.1,]"

            maven cmd: "clean install " + mavenParameters

            maven cmd: "-f deploy/application/pom.xml clean deploy " + mavenParameters
          }
      }
      post {
        always {
          junit '**/**/target/surefire-reports/**/*.xml'
        }
      }
    }
  }
}
