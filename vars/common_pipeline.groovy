//def call(buildBody = null, testBody=null) {
//    pipeline {
//        agent any
//        stages {
//            stage('Build') {
//                steps {
//                    script {
//                        print("Quack!")
//                        buildBody != null ? buildBody() : DefaultBuildStep()
//                    }
//                }
//            }
//
//
//            stage('Test') {
//                steps {
//                    script {
//                        print("Quack! Quack! Time for tests!")
//                        print(testBody)
//                        testBody != null ? testBody() : DefaultTestStep()
//                    }
//                }
//            }
//        }
//    }
//}
def call(Map params) {
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    script {
                        print("Quack!")
                        params.buildBody != null ? params.buildBody() : DefaultBuildStep()
                    }
                }
            }


            stage('Test') {
                steps {
                    script {
                        print("Quack! Quack! Time for tests!")
                        params.testBody != null ? params.testBody() : DefaultTestStep()
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
