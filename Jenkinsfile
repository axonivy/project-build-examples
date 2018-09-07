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
            def workspace = pwd()
            maven cmd: '''clean verify 
              -Divy.engine.list.url=http://zugprobldmas/job/${params.engineSource}/lastSuccessfulBuild/
              -Divy.engine.cache.directory=$workspace/target/ivyEngine
              -Divy.engine.version=[6.1.1,]
            '''            
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
