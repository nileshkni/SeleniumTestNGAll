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
            archiveArtifacts artifacts: 'test-output/**', followSymlinks: false
            bat "docker system prune -f"

        }
    }
}