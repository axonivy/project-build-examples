pipeline {
  agent {
    docker {
      image 'axonivy/build-container:web-1.0'
    }
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
      defaultValue: 'https://jenkins.ivyteam.io/job/ivy-core_product/job/release%252F8.0/lastSuccessfulBuild/')
  }

  stages {
    stage('build') {
      steps {
          script {
            def mavenParameters = "-Divy.engine.list.url=${params.engineListUrl} " +
              "-Divy.engine.version=[8.0.0,] -Dmaven.test.failure.ignore=true"

            maven cmd: "clean install " + mavenParameters
          }
      }
      post {
        always {
          checkVersions onlyProjectBuildPluginWithVersion: "8", additionalVersionArgs: "-DallowSnapshots=true"
          recordIssues tools: [mavenConsole()], unstableTotalAll: 1
          junit '**/**/target/surefire-reports/**/*.xml'
        }
      }
    }
  }
}
