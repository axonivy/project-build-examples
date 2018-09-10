pipeline {
  agent {
    dockerfile true
  }

  options {
    buildDiscarder(logRotator(artifactNumToKeepStr: '10'))
  }

  triggers {
    cron '@midnight'
  }

  parameters {
    choice(
      choices: 'Linux_Trunk_DesignerAndServer\nTrunk_All\nTrunk_DesignerAndServer',
      description: 'Engine to use for build',
      name: 'engineSource'
    )
  }

  stages {
    stage('build') {
      steps {
          script {
            def mavenParameters = "-Divy.engine.list.url=http://zugprobldmas/job/${params.engineSource}/lastSuccessfulBuild/ " +              
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
