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
      defaultValue: 'https://jenkins.ivyteam.io/job/ivy-core_product/job/master/lastSuccessfulBuild/')
  }

  stages {
    stage('build') {
      steps {
          script {
            def mavenParameters = "-Divy.engine.list.url=${params.engineListUrl} " +
              "-Divy.engine.version=[8.0.0,] "

            def versionCheck = "org.codehaus.mojo:versions-maven-plugin:RELEASE:display-plugin-updates " +
              "-Dversions.outputFile=versions.log"

            maven cmd: "clean install " + mavenParameters + versionCheck

            maven cmd: "-f deploy/application/pom.xml clean deploy " + mavenParameters + versionCheck
          }
      }
      post {
        always {
          recordIssues tools: [mavenConsole()], unstableTotalAll: 1
          recordIssues tools: [groovyScript(parserId: 'maven-version-update-parser', pattern: 'versions.log')], unstableTotalAll: 1
          junit '**/**/target/surefire-reports/**/*.xml'
          archiveArtifacts 'versions.log'
        }
      }
    }
  }
}
