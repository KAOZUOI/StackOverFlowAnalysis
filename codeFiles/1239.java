`private static void buildGUIFile() throws IOException {                List<String> fileLines = Files.readAllLines(fileName);        for (int i = 0; i < (fileLines.size()); i++) {            resNum = i + 1;            int beginIndex = fileLines.indexOf(&quot;<Price>&quot;);            int endIndex = fileLines.indexOf(&quot;</Price>&quot;);            try {price = fileLines.get(i).trim().substring(fileLines.indexOf(<Price>&quot;.trim()) + &quot;<Price>&quot;.trim().length(), fileLines.indexOf(&quot;</Price>&quot;.trim()));            } catch (StringIndexOutOfBoundsException e) {                System.out.println(&quot;endIndex&quot; + endIndex);                e.printStackTrace();            }`This is the code that formats each product in fileName:`public String xmlString() {        String str = &quot;<Index>&quot; + resultNum + &quot;</Index>&quot; + &quot;<Price>&quot; + Price + &quot;</Price>&quot; + &quot;<Product>&quot; + Product                + &quot;</Product>&quot; + &quot;<SoldBy> &quot; + Company + &quot;</SoldBy>&quot; + &quot;<href>&quot; + link + &quot;</href>&quot;;        return str;