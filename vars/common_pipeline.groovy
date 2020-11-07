def call(buildBody = null, testBody=null) {
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    script {
                        print("Quack!")
                        buildBody != null ? buildBody() : DefaultBuildStep()
                    }
                }
            }


            stage('Test') {
                steps {
                    script {
                        print("Quack! Quack! Time for tests!")
                        testBody != null ? testBody() : DefaultTestStep()
                    }
                }
            }
        }
    }
}


def DefaultBuildStep() {
    echo 'Running default build step';
}


def DefaultTestStep() {
    echo 'Running default test step';
}
