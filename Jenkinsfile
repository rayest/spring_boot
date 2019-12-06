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
            echo 'The project build failure'
        }
        success {
            echo 'The project build success'
        }

        script{
            allure ([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'always',
                results: [[path: 'target/allure-results']]
            )}
        }
    }
}
