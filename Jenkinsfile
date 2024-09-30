pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'DockerUser456s/repo-for-jenkins'
        KUBECONFIG_CREDENTIALS_ID = 'kubeconfig_1'
        KUBERNETES_NAMESPACE = 'my-app-name'
        CLUSTER_NAME = 'my-cluster'
    }

    stages {
        stage('Checkout Code') {
            steps {
                script {
                    // Get the current branch name
                    def branch = env.BRANCH_NAME

                    // Check if the branch is 'development' or 'release'
                    if (branch.startsWith('develop') || branch.startsWith('release')) {
                        git branch: branch, url: 'https://github.com/Sadheera7Madhushan/NewRepoJ21.git'
                    } else {
                        error("Branch '${branch}' is not supported. Please use 'development' or 'release'.")
                    }
                }
            }
        }

        stage('Build Application') {
            steps {      
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {                   
                    dockerImage = docker.build("${DOCKER_IMAGE_NAME}:${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    withKubeConfig([credentialsId: "${KUBECONFIG_CREDENTIALS_ID}"]) {
                        sh '''
                        kubectl set image deployment/coredns coredns=${DOCKER_IMAGE_NAME}:${env.BUILD_NUMBER} --namespace=${KUBERNETES_NAMESPACE}
                        '''
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
