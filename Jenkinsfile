pipeline {
  agent any

  options {
    ansiColor('xterm')
    disableConcurrentBuilds()
  }

  environment {
    PROJECT_NAME = 'switchboard'
    PROJECT_GROUP = 'Editorial Dashboard'
    CLOUD_BILLING = 'newsroom'
    MAIN_BRANCH = '1.x.x'
    BUILD_VERSION = "${env.TAG_NAME ? env.TAG_NAME : 'commit-' + env.GIT_COMMIT.substring(0, 7)}"
    GRADLE_OPTS = '-Dorg.gradle.daemon=false'
  }

  tools {
    jdk 'openjdk-11'
    nodejs 'NodeJS-12.16'
  }

  stages {
    stage('Install and Clean') {
      steps {
        sh './gradlew clean'
      }
    }

    stage('Quality Assurance') {
      parallel {
        stage('Vulnerabilities Analysis') {
          when {
            branch "${env.MAIN_BRANCH}"
          }
          tools {
            snyk 'snyk-latest'
          }
          environment {
            SNYK_TOKEN = credentials('snyk-newsroom')
          }
          steps {
            sh 'snyk monitor --org=newsroom'
          }
        }

        stage('Unit Testing and Static Code Analysis') {
          steps {
            sh './gradlew check'
          }
          post {
            always {
              junit 'client/reports/junit.xml,server/build/test-results/test/binary/*.xml'
            }
            success {
              step([
                $class: 'CloverPublisher',
                cloverReportDir: 'client/reports/coverage',
                cloverReportFileName: 'clover.xml'
              ])
              jacoco()
            }
          }
        }
      }
    }
  }
}
