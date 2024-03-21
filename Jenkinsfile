pipeline {
    agent any
    stages {
        stage('Checking Maven Version') {
            steps {
                script {
                    bat 'mvn -v'
                }
            }
        }
        stage('Repo Cloning') {
            steps {
                git branch: 'main', credentialsId: '929fa78a7726', url: 'https://github.com/hakankara75/Cucumber_Practice.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    bat 'mvn clean test'
                }
            }
        }
    }
}