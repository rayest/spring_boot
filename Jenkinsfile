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
        stage('单元测试'){
            steps {
                retry(4){
                    script{
                        allure ([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                        ])
                    }
                }
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
    }
}
