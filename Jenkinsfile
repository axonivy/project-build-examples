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
    string(name: 'engineListUrl',
      description: 'Engine to use for build',
      defaultValue: 'https://jenkins.ivyteam.io/job/ivy-core_product/job/master/lastSuccessfulBuild/')
  }

  stages {
    stage('build') {
      steps {
          script {
            def mavenParameters = "-Divy.engine.list.url=${params.engineListUrl} " +
              "-Divy.engine.version=[8.0.0,]"

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
