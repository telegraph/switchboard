pipeline {
  agent any

  options {
    ansiColor('xterm')
    disableConcurrentBuilds()
  }

  tools {
    jdk 'openjdk-11'
  }

  stages {
    stage('Install and clean') {
      steps {
        sh './gradlew clean'
      }
    }

    stage('Quality Assurance') {
      parallel {
//         stage('Static code analysis') {
//           steps {
//             sh './gradlew clean'
//           }
//           post {
//             always {
//               recordIssues aggregatingResults: true, sourceCodeEncoding: 'UTF-8',
//                 referenceJobName: 'Dashboard/switchboard-client/1.x.x', tools: [
//                   esLint(pattern: 'client/reports/eslint.xml'),
//                   cpd(pattern: 'client/reports/cpd/jscpd-report.xml')
//                 ]
//             }
//           }
//         }

        stage('Unit testing') {
          steps {
            sh './gradlew check'
          }
//           post {
//             always {
//               junit 'client/reports/junit.xml'
//             }
//             success {
//               step([
//                 $class: 'CloverPublisher',
//                 cloverReportDir: 'client/reports/coverage',
//                 cloverReportFileName: 'clover.xml'
//               ])
//             }
//           }
        }
      }
    }
  }
}
