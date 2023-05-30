    public static void extract7z(File input, File outputDir) throws IOException {    SevenZFile sevenZFile = new SevenZFile(input);    SevenZArchiveEntry entry;    while ((entry = sevenZFile.getNextEntry()) != null) {        if (!entry.isDirectory()) {            File outputFile = new File(outputDir, entry.getName());            outputFile.getParentFile().mkdirs();            FileOutputStream outputStream = new FileOutputStream(outputFile);            IOUtils.copy(sevenZFile.getInputStream(entry), outputStream);            outputStream.close();        }    }    sevenZFile.close();}