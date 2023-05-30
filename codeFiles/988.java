public void getFileBytes(@RequestBody ZeusRequestVO<String> request, HttpServletResponse response) {    FileInputStream fis = null;    String fileName = null;    try {        fileName = documentService.getFileBytes(request);        fis = new FileInputStream(fileName);        IOUtils.copy(fis, response.getOutputStream());        response.flushBuffer();    } catch (IOException e) {        e.printStackTrace();    } finally {        try {            if(ValidationUtil.isNotNull(fis)) {                fis.close();            }            File file = new File(fileName);            if(file.exists()) {                file.delete();            }        } catch(IOException ioe) {            ioe.printStackTrace();        }    }}