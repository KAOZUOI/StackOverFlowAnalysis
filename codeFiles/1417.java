import java.io.*;import java.util.*;public class StateCovidStats extends State {    private int cases, deaths;        //default    public StateCovidStats()     {            }        //constructor    public StateCovidStats(String theName, int caseCount, int deathCount)     {        super(theName);        cases=caseCount;        deaths=deathCount;    }        public void displayStats()     {        System.out.println(&quot;----------------------------------------&quot;);        System.out.println(this.getName()+&quot; Stats:&quot;);        System.out.println(&quot;Cases: &quot;+this.getCases());        System.out.println(&quot;Deaths: &quot;+this.getDeaths());        System.out.println(&quot;----------------------------------------&quot;);    }        //getters    public String getStateName()     {        return this.getName();    }        public int getCases()     {        return cases;    }        public int getDeaths()     {        return deaths;    }        //setters    public void setStateName(String newName)     {        this.setName(newName);    }        public void setCases(int caseCount)    {        cases=caseCount;    }         public void setDeaths(int deathCount)     {        deaths=deathCount;    }        public String toString()     {        String s=&quot;&quot;;        s+=this.getStateName()+&quot; Cases: &quot;+this.getCases()+&quot; Deaths: &quot;+this.getDeaths();        return s;            }        public static String findMaxCases(ArrayList<StateCovidStats> list)     {                int greatest=Integer.MIN_VALUE;        String nameOfMax=&quot;&quot;;        for(int i=0;i<list.size();i++)         {            if(list.get(i).getCases()>greatest) {                greatest=list.get(i).getCases();                nameOfMax=list.get(i).getName();            }                        }                return nameOfMax;    }        public static String findMaxDeaths(ArrayList<StateCovidStats> list)     {                int greatest=Integer.MIN_VALUE;        String nameOfMax=&quot;&quot;;        for(int i=0;i<list.size();i++)         {            if(list.get(i).getDeaths()>greatest) {                greatest=list.get(i).getDeaths();                nameOfMax=list.get(i).getName();            }                        }                return nameOfMax;    }        public static String findMinCases(ArrayList<StateCovidStats> list)     {                int least=Integer.MAX_VALUE;        String nameOfMin=&quot;&quot;;        for(int i=0;i<list.size();i++)         {            if(list.get(i).getCases()<least) {                least=list.get(i).getCases();                nameOfMin=list.get(i).getName();            }                        }                return nameOfMin;    }        public static String findMinDeaths(ArrayList<StateCovidStats> list)     {                int least=Integer.MAX_VALUE;        String nameOfMin=&quot;&quot;;        for(int i=0;i<list.size();i++)         {            if(list.get(i).getDeaths()<least) {                least=list.get(i).getDeaths();                nameOfMin=list.get(i).getName();            }                        }                return nameOfMin;    }                public static void main(String[] args)     {                    //us-states-Jan-2020-through-March-2023        //sampleDataOld2021                                String line=&quot;&quot;;        String start=&quot;&quot;;                long totDeath=0;        long totCase=0;                                ArrayList<StateCovidStats> states=new ArrayList<StateCovidStats>();                try           {                   BufferedReader br = new BufferedReader(new FileReader(&quot;.\\src\\/us-states-Jan-2020-through-March-2023.txt&quot;));                  while ((line = br.readLine()) != null )              {                    String[] covid = line.split(&quot;,&quot;);    // use comma as separator                                    totDeath+=Integer.parseInt(covid[4]);        totCase+=Integer.parseInt(covid[3]);                StateCovidStats temp=new StateCovidStats(covid[1],Integer.parseInt(covid[3]),Integer.parseInt(covid[4]));                    for(int i=0; i<=states.size();i++)             {                try                {                if((states.get(i).getName().equalsIgnoreCase(temp.getName())))                 {                                        break;                }                                } //end of  2nd try                catch(IndexOutOfBoundsException e)                 {                    states.add(temp);                                        break;                }            }//end of for                                    } //end of while                        br.close();        }   //end of try        catch (IOException e)           {          e.printStackTrace();          }  //end of catch                            /*              for(int i=0; i<states.size();i++)    {            System.out.println(states.get(i).getName());            System.out.println(&quot;Cases: &quot;+states.get(i).getCases());            System.out.println(&quot;Deaths: &quot;+states.get(i).getDeaths());            System.out.println(&quot;------------------------------------&quot;);                        }    */        //output        String maxCase=findMaxCases(states);        String minCase=findMinCases(states);        String maxDeath=findMaxDeaths(states);        String minDeath=findMinDeaths(states);        int maxCaseNum=0;        int minCaseNum=0;        int maxDeathNum=0;        int minDeathNum=0;                for(int i=0; i<states.size();i++)         {            if(states.get(i).getName().equals(&quot;New Jersey&quot;))             {                states.get(i).displayStats();            }            if(states.get(i).getName().equals(maxCase))             {                maxCaseNum=states.get(i).getCases();            }                        if(states.get(i).getName().equals(minCase))             {                 minCaseNum=states.get(i).getCases();            }                        if(states.get(i).getName().equals(maxDeath))             {                 maxDeathNum=states.get(i).getDeaths();            }                        if(states.get(i).getName().equals(minDeath))             {                 minDeathNum=states.get(i).getDeaths();            }                                            }        System.out.println(&quot;State With Most Cases: &quot;+maxCase+&quot;, &quot;+maxCaseNum+&quot; Cases&quot;);        System.out.println(&quot;State With Least Cases: &quot;+minCase+&quot;, &quot;+minCaseNum+&quot; Cases&quot;);        System.out.println(&quot;State With Most Deaths: &quot;+maxDeath+&quot;, &quot;+maxDeathNum+&quot; Deaths&quot;);        System.out.println(&quot;State With Least Deaths: &quot;+minDeath+&quot;, &quot;+minDeathNum+&quot; Deaths&quot;);                    System.out.println(&quot;Total US Cases: &quot;+totCase);        System.out.println(&quot;Total US Deaths: &quot;+totDeath);        System.out.println(&quot;------------------------------------&quot;);        System.out.println(&quot;AVG State Cases: &quot;+totCase/55);        System.out.println(&quot;AVG State Deaths: &quot;+totDeath/55);                for(int i=0; i<states.size();i++)         {            if(states.get(i).getName().equals(&quot;New Jersey&quot;))             {                states.get(i).displayStats();            }                                }                    }   //end of main} //end of class