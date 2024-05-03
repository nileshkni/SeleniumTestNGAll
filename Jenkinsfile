pipeline {
    agent any

    stages {
        stage('run-docker-compose-test') {
            steps {
                bat "docker compose up --abort-on-container-exit"
            }
        }
        
    }
    post{
        always{
            echo 'doing cleanup'
            bat "docker system prune -f"

        }
    }
}