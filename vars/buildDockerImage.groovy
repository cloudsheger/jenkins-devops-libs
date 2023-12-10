// vars/buildDockerImage.groovy

def call(Map config) {
    def dockerImage = "${config.DOCKER_REGISTRY}/${config.DOCKER_REPO}/${config.IMAGE_NAME}:${config.BUILD_NUMBER}"
    // Build Docker image
    sh "docker build -f docker/Dockerfile -t ${dockerImage} ."
    //sh "docker build -t ${dockerImage} ."
}