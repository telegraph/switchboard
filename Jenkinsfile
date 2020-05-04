pipeline {
  agent any

  stages {
    stage('Client') {
      steps {
        load('client/Jenkinsfile')
      }
    }

    stage('Server') {
      steps {
        load('server/Jenkinsfile')
      }
    }
  }
}
