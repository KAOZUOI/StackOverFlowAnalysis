    public static void main(String[] args) {        Scanner sc = new Scanner(System.in);        String input = sc.nextLine();        System.out.println(input);        String[] sentences = input.split(&quot; ?\\. ?&quot;);        for (String sentence : sentences) {            System.out.println(&quot;Number of words is &quot; + countWords(sentence));            System.out.println(&quot;Number of characters is &quot; + sentence.length());            System.out.println(&quot;Reversed is &quot; + new StringBuilder(sentence).reverse());            System.out.println(&quot;Diacritics removed is &quot; + removeDiacritics(sentence));            System.out.println(&quot;Number of vowels is &quot; + countVowels(sentence));            System.out.println(&quot;Number of consonants is &quot; + countConsonants(sentence));        }    }    private static final Map<String, String> DIACRITIC_MAPPINGS = new HashMap<>() {{        put(&quot;ě&quot;, &quot;e&quot;);        put(&quot;š&quot;, &quot;s&quot;);        put(&quot;č&quot;, &quot;c&quot;);        put(&quot;ř&quot;, &quot;r&quot;);        put(&quot;ž&quot;, &quot;z&quot;);        put(&quot;ý&quot;, &quot;y&quot;);        put(&quot;á&quot;, &quot;a&quot;);        put(&quot;í&quot;, &quot;i&quot;);        put(&quot;é&quot;, &quot;e&quot;);        put(&quot;ú&quot;, &quot;u&quot;);        put(&quot;ů&quot;, &quot;u&quot;);        put(&quot;Ě&quot;, &quot;E&quot;);        put(&quot;Š&quot;, &quot;S&quot;);        put(&quot;Č&quot;, &quot;C&quot;);        put(&quot;Ř&quot;, &quot;R&quot;);        put(&quot;Ž&quot;, &quot;Z&quot;);        put(&quot;Ý&quot;, &quot;Y&quot;);        put(&quot;Á&quot;, &quot;A&quot;);        put(&quot;Í&quot;, &quot;I&quot;);        put(&quot;É&quot;, &quot;E&quot;);        put(&quot;Ú&quot;, &quot;U&quot;);        put(&quot;Ů&quot;, &quot;U&quot;);    }};    private static final Pattern DIACRITICS = Pattern.compile('[' + String.join(&quot;&quot;, DIACRITIC_MAPPINGS.keySet()) + ']');    public static int countWords(String str) {        return str.trim().split(&quot; +&quot;).length;    }    public static int countVowels(String str) {        return str.replaceAll(&quot;(?i)[^aeiou]&quot;, &quot;&quot;).length();    }    public static int countConsonants(String str) {        return str.replaceAll(&quot;(?i)[ .aeiou]&quot;, &quot;&quot;).length();    }    public static String removeDiacritics(String str) {        return DIACRITICS.matcher(str).replaceAll(mr -> DIACRITIC_MAPPINGS.get(mr.group()));    }}