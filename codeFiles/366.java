...        String[] itemID = line.split(&quot;,&quot;, 3); //attempt to use a regex limit        if(itemID[0].equals(test)) {            System.out.println(String.join (&quot;,&quot;, itemID[0],itemID[1]));        }...