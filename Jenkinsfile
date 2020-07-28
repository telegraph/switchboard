pipeline {
  agent any

  options {
    ansiColor('xterm')
    disableConcurrentBuilds()
  }

  tools {
    nodejs 'NodeJS-12.16'
  }

  stages {
    stage('Install and clean') {
      steps {
        dir("${WORKSPACE}/client") {
          sh '''
            npm ci
            npm run clean
          '''
        }
      }
    }

    stage('Quality Assurance') {
      parallel {
        stage('Static code analysis') {
          steps {
            dir("${WORKSPACE}/client") {
              sh '''
                npm run cpd | true
                npm run lint -- -f checkstyle > reports/eslint.xml | true
              '''
            }
          }
          post {
            always {
              recordIssues aggregatingResults: true, sourceCodeEncoding: 'UTF-8',
                referenceJobName: 'Dashboard/switchboard-client/1.x.x', tools: [
                  esLint(pattern: 'client/reports/eslint.xml'),
                  cpd(pattern: 'client/reports/cpd/jscpd-report.xml')
                ]
            }
          }
        }

        stage('Unit testing') {
          steps {
            dir("${WORKSPACE}/client") {
              sh '''
                npm test
              '''
            }
          }
          post {
            always {
              junit 'client/reports/junit.xml'
            }
            success {
              step([
                $class: 'CloverPublisher',
                cloverReportDir: 'client/reports/coverage',
                cloverReportFileName: 'clover.xml'
              ])
            }
          }
        }
      }
    }
  }
}