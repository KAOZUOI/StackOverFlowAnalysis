    Document document = iterator.next();    Integer id = document.containsKey(&quot;id&quot;) ? document.get(&quot;id&quot;, Integer.class) : null;    String key = document.containsKey(&quot;key&quot;) ? document.get(&quot;key&quot;, String.class) : null;    //   after collect each value, you can instantiate your object    YourObject obj = new YourObject();    obj.setId(id);    obj.setKey(key);    //...