    try {        // read again from file?        val listMyDealWithMyClient = doReadFromFile(activity)        val timeZoneDate = SimpleDateFormat(&quot;yyyy-MMM-dd_HH-mm-ss&quot;, Locale.getDefault())        val formattedDate = timeZoneDate.format( Date())        val workbook = XSSFWorkbook()        val workSheet = workbook.createSheet(&quot;MyDeals_$formattedDate&quot;)        val colorMap = workbook.stylesSource.indexedColors        val cellStyleHeader = workbook.createCellStyle()        cellStyleHeader.fillForegroundColor = IndexedColors.AQUA.getIndex()        cellStyleHeader.fillPattern = FillPatternType.SOLID_FOREGROUND        cellStyleHeader.font.bold = true        cellStyleHeader.verticalAlignment = VerticalAlignment.CENTER        cellStyleHeader.alignment = HorizontalAlignment.CENTER        cellStyleHeader.setRightBorderColor( XSSFColor(byteArrayOf(0, 0, 0), colorMap))        cellStyleHeader.borderRight = BorderStyle.THIN        val row0 = workSheet.createRow(0)        row0.height = 800