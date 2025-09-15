pipeline {
    agent any

    tools {
        jdk 'JDK17'          // Matches the JDK name in Tools
        maven 'Maven3'       // Matches the Maven name in Tools
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/SUMITAWADHIYA/OrangeHRM.git',
                    credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo "✅ Build Successful on Java 17 with Maven!"
        }
        failure {
            echo "❌ Build Failed!"
        }
    }
}
