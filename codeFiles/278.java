SchemaSpy generates an HTML representation of a database schema's relationships.SchemaSpy comes with ABSOLUTELY NO WARRANTY.SchemaSpy is free software and can be redistributed under the conditions of LGPL version 3 or later.http://www.gnu.org/licenses/INFO  - Starting Main v6.1.0 on DESKTOP-O4DE6AA with PID 10936 (C:\Users\Ascend\Desktop\ATS Codebase\demo\src\main\resources\lib\schemaspy-6.1.0.jar started by Ascend in C:\Users\Ascend\Desktop\ATS Codebase\demo\src\main\resources\lib)INFO  - The following profiles are active: defaultINFO  - Started Main in 1.314 seconds (JVM running for 1.814)INFO  - Starting schema analysisINFO  - Connected to MySQL - 8.0.31INFO  - Gathering schema detailsGathering schema details.........................................(34sec)Connecting relationships.........................................(14sec)Writing/graphing summary.INFO  - Gathered schema details in 14 secondsINFO  - Writing/graphing summaryINFO  - Graphviz rendered set to ''..ERROR - RelationShipDiagramErrorFailed to produce diagram for: \SchemaSpy\diagrams\summary\relationships.implied.compact.dotERROR - RelationShipDiagramErrorFailed to produce diagram for: \SchemaSpy\diagrams\summary\relationships.implied.large.dot.ERROR - Failed to produce diagram for: \SchemaSpy\diagrams\orphans\help_keyword.1degree.dotFailed to generate Orphan diagramERROR - Failed to produce diagram for: \SchemaSpy\diagrams\orphans\help_relation.1degree.dotFailed to generate Orphan diagramERROR - Failed to produce diagram for: \SchemaSpy\diagrams\orphans\plugin.1degree.dotFailed to generate Orphan diagramERROR - Failed to produce diagram for: \SchemaSpy\diagrams\orphans\replication_group_configuration_version.1degree.dotFailed to generate Orphan diagramERROR - Failed to produce diagram for: \SchemaSpy\diagrams\orphans\time_zone.1degree.dotFailed to generate Orphan diagramERROR - Failed to produce diagram for: \SchemaSpy\diagrams\orphans\time_zone_leap_second.1degree.dotFailed to generate Orphan diagramERROR - Failed to produce diagram for: \SchemaSpy\diagrams\orphans\time_zone_name.1degree.dotFailed to generate Orphan diagram.....(1sec)Writing/diagramming detailsINFO  - Completed summary in 1 secondsINFO  - Writing/diagramming details..Exception in thread &quot;main&quot; java.lang.reflect.InvocationTargetException        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)        at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)        at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)        at java.lang.reflect.Method.invoke(Unknown Source)        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:48)        at org.springframework.boot.loader.Launcher.launch(Launcher.java:87)        at org.springframework.boot.loader.Launcher.launch(Launcher.java:50)        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:51)Caused by: org.schemaspy.output.diagram.DiagramException: Failed to generate Table diagram        at org.schemaspy.output.diagram.DiagramFactory.generateTableDiagram(DiagramFactory.java:71)        at org.schemaspy.output.html.mustache.diagrams.MustacheDiagramFactory.generateTableDiagram(MustacheDiagramFactory.java:44)        at org.schemaspy.output.html.mustache.diagrams.MustacheTableDiagramFactory.generateTableDiagrams(MustacheTableDiagramFactory.java:80)        at org.schemaspy.SchemaAnalyzer.generateHtmlDoc(SchemaAnalyzer.java:426)        at org.schemaspy.SchemaAnalyzer.analyze(SchemaAnalyzer.java:260)        at org.schemaspy.SchemaAnalyzer.analyze(SchemaAnalyzer.java:123)        at org.schemaspy.cli.SchemaSpyRunner.runAnalyzer(SchemaSpyRunner.java:98)        at org.schemaspy.cli.SchemaSpyRunner.run(SchemaSpyRunner.java:87)        at org.schemaspy.Main.main(Main.java:55)        ... 8 moreCaused by: org.schemaspy.output.diagram.DiagramException: Dot missing or invalid version        at org.schemaspy.output.diagram.graphviz.GraphvizDot.generateDiagram(GraphvizDot.java:193)        at org.schemaspy.output.diagram.DiagramFactory.generateTableDiagram(DiagramFactory.java:68)        ... 16 more