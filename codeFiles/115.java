RuntimeError: java.lang.RuntimeException: Failed to build transform beam:transform:org.apache.beam:schemaio_jdbc_read:v1 from spec urn: &quot;beam:transform:org.apache.beam:schemaio_jdbc_read:v1&quot;payload: &quot;\nD\n\016\n\blocation\032\002\020\a\n\f\n\006config\032\002\020\t\022$a19f3f60-6fc8-41db-b221-dcf28077e554\022\220\001\002\000\nmigrations\201\001\v\002\260\006\025com.mysql.jdbc.Driver#jdbc:mysql://localhost:3306/database\004user\021pass*select id, migration from bob1.migrations;\001&quot;        at org.apache.beam.sdk.expansion.service.ExpansionService$ExternalTransformRegistrarLoader$1.getTransform(ExpansionService.java:147)        at org.apache.beam.sdk.expansion.service.ExpansionService$TransformProvider.apply(ExpansionService.java:396)        at org.apache.beam.sdk.expansion.service.ExpansionService.expand(ExpansionService.java:516)        at org.apache.beam.sdk.expansion.service.ExpansionService.expand(ExpansionService.java:596)        at org.apache.beam.model.expansion.v1.ExpansionServiceGrpc$MethodHandlers.invoke(ExpansionServiceGrpc.java:220)        at org.apache.beam.vendor.grpc.v1p48p1.io.grpc.stub.ServerCalls$UnaryServerCallHandler$UnaryServerCallListener.onHalfClose(ServerCalls.java:182)        at org.apache.beam.vendor.grpc.v1p48p1.io.grpc.internal.ServerCallImpl$ServerStreamListenerImpl.halfClosed(ServerCallImpl.java:354)        at org.apache.beam.vendor.grpc.v1p48p1.io.grpc.internal.ServerImpl$JumpToApplicationThreadServerStreamListener$1HalfClosed.runInContext(ServerImpl.java:866)        at org.apache.beam.vendor.grpc.v1p48p1.io.grpc.internal.ContextRunnable.run(ContextRunnable.java:37)        at org.apache.beam.vendor.grpc.v1p48p1.io.grpc.internal.SerializingExecutor.run(SerializingExecutor.java:133)        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)        at java.lang.Thread.run(Unknown Source)Caused by: java.lang.RuntimeException: Unable to infer configuration row from configuration proto and schema.        at org.apache.beam.sdk.extensions.schemaio.expansion.ExternalSchemaIOTransformRegistrar.translateRow(ExternalSchemaIOTransformRegistrar.java:110)        at org.apache.beam.sdk.extensions.schemaio.expansion.ExternalSchemaIOTransformRegistrar.access$000(ExternalSchemaIOTransformRegistrar.java:49)        at org.apache.beam.sdk.extensions.schemaio.expansion.ExternalSchemaIOTransformRegistrar$ReaderBuilder.buildExternal(ExternalSchemaIOTransformRegistrar.java:129)              at org.apache.beam.sdk.extensions.schemaio.expansion.ExternalSchemaIOTransformRegistrar$ReaderBuilder.buildExternal(ExternalSchemaIOTransformRegistrar.java:115)              at org.apache.beam.sdk.expansion.service.ExpansionService$ExternalTransformRegistrarLoader$1.getTransform(ExpansionService.java:141)        ... 12 moreCaused by: org.apache.beam.sdk.coders.CoderException: java.io.EOFException        at org.apache.beam.sdk.coders.BigEndianShortCoder.decode(BigEndianShortCoder.java:56)        at org.apache.beam.sdk.coders.BigEndianShortCoder.decode(BigEndianShortCoder.java:28)        at org.apache.beam.sdk.coders.RowCoderGenerator$DecodeInstruction.decodeDelegate(RowCoderGenerator.java:431)        at org.apache.beam.sdk.coders.Coder$ByteBuddy$lYYhB38b.decode(Unknown Source)        at org.apache.beam.sdk.coders.Coder$ByteBuddy$lYYhB38b.decode(Unknown Source)        at org.apache.beam.sdk.schemas.SchemaCoder.decode(SchemaCoder.java:129)        at org.apache.beam.sdk.extensions.schemaio.expansion.ExternalSchemaIOTransformRegistrar.translateRow(ExternalSchemaIOTransformRegistrar.java:108)        ... 16 moreCaused by: java.io.EOFException        at org.apache.beam.sdk.coders.BitConverters.readBigEndianShort(BitConverters.java:55)        at org.apache.beam.sdk.coders.BigEndianShortCoder.decode(BigEndianShortCoder.java:52)        ... 22 more