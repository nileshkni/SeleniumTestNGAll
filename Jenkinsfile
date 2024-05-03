pipeline {
    agent any

    environment{
        NUMBER = 3
    }

    stages {
        stage('stage-1') {
            steps {
                echo "doing mvn clean"
                echo "NUMEBR IS = ${NUMBER}"
            }
        }
        stage('stage-2') {
            environment{
                NUMBER = 6
            }
            steps {
                echo "NUMEBR IS = ${NUMBER}"
            }
        }
        stage('stage-3') {
            steps {
                echo "push docker image"
                echo "NUMEBR IS = ${NUMBER}"
            }
        }
    }
    post{
        always{
            echo 'doing cleanup'
        }
    }
}
