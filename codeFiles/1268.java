ZappyDataFrame correctedSaleIdToTotalCost = ...;ZappyDataFrame invalidSales = ZappyReader.readParquet(filteredFiles);ZappyDataFrame correctedSales = invalidSales.join(correctedSaleIdToTotalCost, &quot;id&quot;)ZappyWriteResult dataWriteResult = ZappyWritter.writeParquet(&quot;/data/sales&quot;, correctedSales);