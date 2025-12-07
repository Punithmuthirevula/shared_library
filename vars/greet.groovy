def call(tomcatServer, artifact_id) {
   // echo "Welcome ${name}, Welcome to ${location}"
   sshPublisher(
                        publishers: [
                            sshPublisherDesc(
                                configName: '${tomcatServer}   ',
                                transfers: [
                                    sshTransfer(
                                        cleanRemote: false, 
                                        excludes: '', 
                                        execCommand: '''/opt/tomcat11/bin/shutdown.sh /opt/tomcat11/bin/startup.sh''', 
                                        execTimeout: 120000, 
                                        flatten: false, 
                                        makeEmptyDirs: false, 
                                        noDefaultExcludes: false, 
                                        patternSeparator: '[, ]+', 
                                        remoteDirectory: '', 
                                        remoteDirectorySDF: false, 
                                        removePrefix: 'target', 
                                        sourceFiles: 'target/${artifact_id}.war')], 
                                        usePromotionTimestamp: false, 
                                        useWorkspaceInPromotion: false, 
                                        verbose: false)])
}
