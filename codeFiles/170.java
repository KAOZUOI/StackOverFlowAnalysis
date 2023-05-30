import io.delta.standalone.DeltaLog;import io.delta.standalone.DeltaScan;import io.delta.standalone.OptimisticTransaction;import io.delta.standalone.actions.AddFile;import io.delta.standalone.data.CloseableIterator;import io.delta.standalone.expressions.And;import io.delta.standalone.expressions.EqualTo;import io.delta.standalone.expressions.Literal;import io.delta.standalone.internal.util.{ConversionUtils, FileNames, JsonUtils}import io.delta.standalone.internal.data.CloseableParquetDataIterator    val deltaLog = DeltaLog.forTable(configuration, DELTA_TABLE_LOCATION)    val snapshot = deltaLog.snapshot()import scala.collection.JavaConverters;var allFiles = snapshot.scan(new EqualTo(snapshot.getMetadata().getSchema.column(&quot;partitioned_col_1&quot;), Literal.of(partition_val_1))).getFilesimport scala.collection.JavaConverters._;    var rowIterator = Class.forName(&quot;io.delta.standalone.internal.data.CloseableParquetDataIterator&quot;).getConstructor(classOf[Seq[(String, Map[String, String])]], snapshot.getMetadata.getSchema.getClass, classOf[java.util.TimeZone], classOf[org.apache.hadoop.conf.Configuration]).newInstance(JavaConverters.asScalaIteratorConverter(allFiles).asScala.toSeq.map {add => (DELTA_TABLE_LOCATION + &quot;/&quot; + add.getPath , add.getPartitionValues.asScala.toMap)}, snapshot.getMetadata.getSchema, null, new org.apache.hadoop.conf.Configuration()).asInstanceOf[CloseableIterator[io.delta.standalone.data.RowRecord]]// your result here    rowIterator.next