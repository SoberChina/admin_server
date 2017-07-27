node {
    def img='registry.wepiao.com/maven:3.3.9-jdk-8'
    def cmd='mvn clean checkstyle:checkstyle pmd:pmd compile findbugs:findbugs  -Dmaven.test.failure.ignore=true package'
    stage('Checkout.') {
        checkout scm
        sh 'checkout'
    }

    stage('Running Test.') {
        sh "build \"${img}\" \"${cmd}\""
    }

    stage("Build image.") {
        sh 'build_image'
        def tag = readFile('tag').trim()
        if (tag != 'no') {currentBuild.displayName=tag}
    }
    stage('Publish result') {
        step([$class: 'CheckStylePublisher', pattern: 'target/checkstyle-result.xml'])
        step([$class: 'FindBugsPublisher', pattern: 'target/findbugsXml.xml'])
        step([$class: 'PmdPublisher', pattern: 'target/pmd.xml'])
        step([$class: 'JacocoPublisher', execPattern: 'target/jacoco.exec', exclusionPattern: '**/Messages.class'])
        step([$class: 'JUnitResultArchiver', testResults: 'target/surefire-reports/*.xml'])
    }
}