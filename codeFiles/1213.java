        File file = new File(exportFilePath);        if (file.length() == 0) fileWriter.append(String.join(&quot;,&quot;, headers)).append(&quot;\n&quot;);        fileWriter.append(String.join(&quot;,&quot;, currentLine)).append(&quot;\n&quot;).close();