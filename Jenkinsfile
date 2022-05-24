#!/usr/bin/env groovy
pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-11-slim'
        }
    }

    environment {
        SLACK_CHANNEL = '#ops-room'
        SLACK_TEAM_DOMAIN = 'MY-SLACK-TEAM'
        SLACK_TOKEN = credentials('slack_token')
    }

    stages {
        stage('Test') {
            steps {
                git branch: 'master',
                    credentialsId: 'username:password',
                    url: 'https://github.com/verymadtester/api_tests_pets.git'
                sh 'mvn clean test'
            }
        }
    }
    post {
        always {
             echo 'Test stage finished'
             // publish html
             publishHTML target: [
                 allowMissing: false,
                 alwaysLinkToLastBuild: false,
                 keepAll: true,
                 reportDir: 'coverage',
                 reportFiles: '/test-output/ExtentReport.html',
                 reportName: 'ExtentReport'
             ]
        }
        success {
             echo 'Test stage finished successfully'
             slackSend teamDomain: '${env.SLACK_TEAM_DOMAIN}',
                       token: '${env.SLACK_TOKEN}',
                       channel: '${env.SLACK_CHANNEL}',
                       color: 'good',
                       message: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
        }
        failure {
             echo 'Test stage failed'
             slackSend teamDomain: '${env.SLACK_TEAM_DOMAIN}',
                       token: '${env.SLACK_TOKEN}',
                       channel: '${env.SLACK_CHANNEL}',
                       color: 'red',
                       message: "The pipeline ${currentBuild.fullDisplayName} failed."
        }
        unstable {
             echo 'Test stage run was marked as unstable'
             slackSend teamDomain: '${env.SLACK_TEAM_DOMAIN}',
                       token: '${env.SLACK_TOKEN}',
                       channel: '${env.SLACK_CHANNEL}',
                       color: 'yellow',
                       message: "The pipeline ${currentBuild.fullDisplayName} was marked as unstable."
        }
    }
}