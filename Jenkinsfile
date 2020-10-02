pipeline{
    agent any
    stages{
        stage('Git checkout'){
            steps{
                git 'https://github.com/arkham02/selenium_and_grid_in_docker.git'
            }
        }
        stage('Spin up grid container'){
            steps{
                bat 'docker-compose up -d --scale chromenode=3'
            }
        }
        stage('Build'){
            steps{
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Clean up grid containers'){
            steps{
                bat 'docker-compose down'
            }
        }
    }
}