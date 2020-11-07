def call(body = null) {
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    script {
                        body != null ? body() : DefaultBuildStep()
                    }
                }
            }
        }
    }
}


def PostBuildStep() {
    echo 'Running default build step';
}
