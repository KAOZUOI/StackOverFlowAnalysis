import java.util.Scanner;public class A2P1 {    public static void main(String[] args) {        int size = Integer.parseInt(args[0]);                String[] str = new String[size];        Scanner sc = new Scanner(System.in);                for (int i=0; i < size; i++) {            str[i] = sc.nextLine().split(&quot; &quot;);              // The error            //str[i] = sc.next();                         This line and the line below throw            //str[i] = sc.nextLine();                    no errors, but also gives no output.        }                String[] longest = new String[size];        String[] temp = new String[size];        longest[0] = str[0];        int numToBeat = str[0].length();        int k = 0;        for (int i=0; i < size; i++) {            if (str[i].length() > numToBeat) {                numToBeat = str[i].length();                k = 0;                longest = temp;                                longest[k] = str[i];                k++;            }            else if (str[i].length() == numToBeat) {                longest[k] = str[i];            }        }                    System.out.println(&quot;The longest input strings are:&quot;);        for (int i=0; i < k; i++) {            System.out.println(longest[i]);        }        sc.close();    }}