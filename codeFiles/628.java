@GetMapping(&quot;/genpdf/{fileName}&quot;)HttpEntity<byte[]> createPdf(        @PathVariable(&quot;fileName&quot;) String fileName) throws IOException {    /* first, get and initialize an engine */    VelocityEngine ve = new VelocityEngine();    /* next, get the Template */    ve.setProperty(RuntimeConstants.RESOURCE_LOADER, &quot;classpath&quot;);    ve.setProperty(&quot;classpath.resource.loader.class&quot;,            ClasspathResourceLoader.class.getName());    ve.init();    Template t = ve.getTemplate(&quot;templates/helloworld.vm&quot;);    /* create a context and add data */    VelocityContext context = new VelocityContext();    context.put(&quot;name&quot;, &quot;World&quot;);    context.put(&quot;genDateTime&quot;, LocalDateTime.now().toString());    /* now render the template into a StringWriter */    StringWriter writer = new StringWriter();    t.merge(context, writer);    /* show the World */    System.out.println(writer.toString());    ByteArrayOutputStream baos = new ByteArrayOutputStream();    baos = generatePdf(writer.toString());    HttpHeaders header = new HttpHeaders();    header.setContentType(MediaType.APPLICATION_PDF);    header.set(HttpHeaders.CONTENT_DISPOSITION,            &quot;attachment; filename=&quot; + fileName.replace(&quot; &quot;, &quot;_&quot;));    header.setContentLength(baos.toByteArray().length);    return new HttpEntity<byte[]>(baos.toByteArray(), header);}public ByteArrayOutputStream generatePdf(String html) {    String pdfFilePath = &quot;&quot;;    PdfWriter pdfWriter = null;    // create a new document    Document document = new Document();    try {        document = new Document();        // document header attributes        document.addCreationDate();        document.addTitle(&quot;HTML to PDF using itext&quot;);        document.setPageCount(1);        document.addLanguage(&quot;tr&quot;);        ByteArrayOutputStream baos = new ByteArrayOutputStream();        pdfWriter = PdfWriter.getInstance(document, baos);        // open document        document.open();        pdfWriter.addPageDictEntry(PdfName.PDF, PdfPage.LANDSCAPE);        XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();        xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(                html));        // close the document        document.close();        System.out.println(&quot;PDF generated successfully&quot;);        return baos;    } catch (Exception e) {        e.printStackTrace();        return null;    }}