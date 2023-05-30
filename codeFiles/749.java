task jacocoUiTestReportAllModules(type: JacocoReport, dependsOn: ['testDebugUnitTest', 'createDebugCoverageReport']) {    group &quot;Reports&quot;    description &quot;Generate Jacoco Instrumented Tests coverage reports for all modules&quot;    reports {        xml.enabled = true        html.enabled = true        html.destination file(&quot;${rootProject.buildDir}/coverage-report&quot;)    }    def javaClasses = []    def kotlinClasses = []    def javaSrc = []    def kotlinSrc = []    def execution = []    def fileFilter = ['**/R.class', '**/R$*.class', '**/BuildConfig.*', '**/Manifest*.*', '**/*Test*.*', 'android/**/*.*']    rootProject.subprojects.each { proj ->        javaClasses << fileTree(dir: &quot;$proj.buildDir/intermediates/javac/debug&quot;, excludes: fileFilter)        kotlinClasses << fileTree(dir: &quot;$proj.buildDir/tmp/kotlin-classes/debug&quot;, excludes: fileFilter)        javaSrc << &quot;$proj.projectDir/src/main/java&quot;        kotlinSrc << &quot;$proj.projectDir/src/main/kotlin&quot;        execution << fileTree(dir: proj.buildDir, includes: [    'jacoco/testDebugUnitTest.exec',                'outputs/code_coverage/debugAndroidTest/connected/**/*.ec'])    }    getSourceDirectories().setFrom(files([javaSrc, kotlinSrc]))    getClassDirectories().setFrom(files([javaClasses, kotlinClasses]))    getExecutionData().setFrom(execution)    doLast() {        print &quot;file://${reports.html.destination}/index.html&quot;    }}