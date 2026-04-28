pipeline {
    agent any

    environment {
        IMAGE_NAME="gowthamihn/springthymeleafproject"
        IMAGE_TAG="v1"
    }

    stages {

        stage("Pull the source") {
            steps {
                git branch: "main", url:"https://github.com/GowthamiHN/thymeleafProject.git"
            }
        }
        stage("Build the project") {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage("Build the image") {
            steps {
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }
        stage("Login Docker") {
            steps {
                sh 'docker login -u gowthamihn -p Gowthami@123'
            }
        }
        stage("Push Image to DockerHub") {
            steps {
                sh 'docker push $IMAGE_NAME:$IMAGE_TAG'
            }
        }
        stage("remove old image") {
            steps {
                sh 'docker rm -f spring-project'
            }
        }
        stage("Run the new image") {
            steps {
                sh 'docker run  -d -p 8080:8080 --name $IMAGE_NAME:$IMAGE_TAG'
            }
        }
    }
    post{
        success{
            echo "dockerised successfully"
        }
        failure {
            echo "dockerised failed"
        }
    }
}