pipeline {

    agent {
        label 'java-17-agent'
    }

    options {
        buildDiscarder(logRotator(daysToKeepStr: '14'))
        disableConcurrentBuilds()
    }

    parameters {
        choice(name: 'ENVIRONMENT', description: 'The environment to run the tests against', choices: "sit\ndev\nuat")
        string(name: 'TAGS', description: 'The cucumber test tags you want to run, separate multiple tags using or', defaultValue: "@browserstackTest")
        choice(name: 'PROFILE', description: 'Browser Type profile', choices: "browserstack-chrome\nlocal-chrome")
        booleanParam(name: 'FEATURE_TOGGLE', description: 'Whether this is a feature toggle on build', defaultValue: false)
        string(name: 'PARALLEL_TESTS', description: 'Number of parallel tests', defaultValue: "1")
    }

    environment {
        LOCAL_IDENTIFIER = UUID.randomUUID().toString()
        S3_REPORT_URL = "http://ppe-serenity-bdd-reports-${ENVIRONMENT}.s3-website-eu-west-1.amazonaws.com/${env.BUILD_NUMBER}"
        USER_CREDS = credentials('artifactory-settings-xml')
    }

    stages {

        stage('Preparation') {
            steps {
                checkout scm
            }
        }

        stage('Start config service') {
            steps {
                ensureConfigServerRunning()
            }
        }

        stage('Build') {
            steps {
                script {

                    if (params.PROFILE.contains('browserstack')) {
                        startBrowserStack()
                    }

                   // Run the tests
                   def filterTags = "(${TAGS}) and (not (@ignore or @Manual or @manualKeyboard or @local))"
                   sh "./mvnw --settings $USER_CREDS clean verify -P ${PROFILE} -Dissn.debug=true -Denvironment=${ENVIRONMENT} -Dbrowserstack.video=true -Dbrowserstack.build='Pipeline ${ENVIRONMENT} build ${env.BUILD_NUMBER}' -Dparallel.tests=${PARALLEL_TESTS} -Dfeature.toggle=${FEATURE_TOGGLE} -Dbrowserstack.localIdentifier=${LOCAL_IDENTIFIER} -Dcucumber.filter.tags='${filterTags}'"

                }
            }
        }

    }

    post {

        always {
            junit '**/target/failsafe-reports/TEST-*.xml'
            script {
                sh "/usr/bin/aws s3 sync ${WORKSPACE}/target/site/serenity/ s3://ppe-serenity-bdd-reports-${ENVIRONMENT}/${env.BUILD_NUMBER}"

                if (params.PROFILE.contains('browserstack')) {
                    stopBrowserStack()
                }
            }

            publishHTML(target: [
                    allowMissing         : false,
                    alwaysLinkToLastBuild: false,
                    keepAll              : true,
                    reportDir            : 'target/site/serenity',
                    reportFiles          : 'index.html',
                    reportName           : "Serenity BDD Report"
            ])

        }
        success {
            slackNotifySuccess(currentBuild.getPreviousBuild(), JOB_NAME, BUILD_NUMBER, "${env.S3_REPORT_URL}")
        }
        failure {
            slackNotifyFailure(currentBuild.getPreviousBuild(), JOB_NAME, BUILD_NUMBER, "${env.S3_REPORT_URL}")
        }
    }

}

def startBrowserStack() {
    // Start the connection
    withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
        sh 'nohup src/test/resources/binaries/browserstack/BrowserStackLocal --key browserstackKey --local-identifier=${LOCAL_IDENTIFIER} --force-local > browserstack.log 2>&1 & echo \$! > browserstack.pid'
    }
}

def stopBrowserStack() {
    // Stop the connection
    sh "kill `cat browserstack.pid`"
}
