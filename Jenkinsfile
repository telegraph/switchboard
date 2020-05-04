pipeline {
  agent any
  stages {
    stage('Client') {
      load('client/Jenkinsfile')
    }

    stage('Server') {
      load('server/Jenkinsfile')
    }
  }
}
