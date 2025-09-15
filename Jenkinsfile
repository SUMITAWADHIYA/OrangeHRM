pipeline {
    agent any

    tools {
        jdk 'JDK11'          // Name of JDK installed in Jenkins (Manage Jenkins → Global Tool Config)
        maven 'Maven3'       // Name of Maven installed in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/SUMITAWADHIYA/OrangeHRM',
                    credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
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
            echo "✅ Build Successful!"
        }
        failure {
            echo "❌ Build Failed!"
        }
    }
}
