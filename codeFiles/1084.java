import org.junit.jupiter.api.Test;import static com.codeborne.selenide.Condition.text;import static com.codeborne.selenide.Selenide.$;import static com.codeborne.selenide.Selenide.open;public class Main {    public static void main(String[] args) {        System.out.println(&quot;Hello world!&quot;);        Selenide.open(&quot;https://www.google.com/&quot;);    }}