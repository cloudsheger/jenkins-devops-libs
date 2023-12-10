void build(Map config) {
    def dockerImage = "${config.DOCKER_REGISTRY}/${config.DOCKER_REPO}/${config.IMAGE_NAME}:${config.BUILD_NUMBER}"
    // Build Docker image
    sh "docker build -f dockerfiles/Dockerfile.packer -t ${dockerImage} ."
    //sh "docker build -t ${dockerImage} ."
}

void dockerPush(Map config) {
    def imageName = "${config.DOCKER_REGISTRY}/${config.DOCKER_REPO}/${config.IMAGE_NAME}:${config.BUILD_NUMBER}"

    echo "Building Docker image..."

    // Use Docker Pipeline plugin to authenticate with Docker registry
    docker.withRegistry(config.DOCKER_REGISTRY_URL, config.DOCKER_CREDS_ID) {
        sh "docker build -f dockerfiles/Dockerfile.packer -t ${imageName} ."
        sh "docker push ${imageName}"
    }
}
