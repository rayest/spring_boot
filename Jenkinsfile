pipeline {
    agent any

    tools {
        maven 'mvn-3.6.3'
    }
    stages {
        stage('Build'){
            steps {
                sh "mvn clean package spring-boot:repackage"
                sh "printenv"
            }
        }
    }

    post {
        failure {
            mail to: 'rayestonal@gmail.com', subject: 'The project failed'
        }
        success {
            ehcho 'The project build success'
            mail to: 'rayestonal@gmail.com', subject: 'The project build success'
        }
    }
}
