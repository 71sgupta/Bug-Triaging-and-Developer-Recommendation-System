package TokenBugMatrix;

import TokenBugMatrix.dlg;
import TokenBugMatrix.dlg2;
import edu.stanford.nlp.process.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.function.Function;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class test {
     public ArrayList<String> f1(int a1) throws IOException,ClassNotFoundException {
   Stemmer s = new Stemmer();
    
   FileOutputStream fout=new  FileOutputStream("C:\\Users\\HP\\Desktop\\sample1.txt");
     File file2 = new File("C:\\Users\\HP\\Desktop\\sample1.txt");  
               if ( !file2.exists() ) {
                     boolean createNewFile = file2.createNewFile();
            }
               FileWriter fw2 = new FileWriter(file2);
     BufferedWriter writer2 = new BufferedWriter(fw2);
    File file = new File("C:\\Users\\HP\\Desktop\\sample.txt");
    FileInputStream fis = new FileInputStream(file);
     
    String bit = "";
    ArrayList<String> list = new ArrayList<String>();
    Iterator<Word> it = PTBTokenizer.newPTBTokenizer(new InputStreamReader(fis, "utf-8"));
    while (it.hasNext()) {
        Word token = it.next();
        System.out.print(s.stem(token.word()));
        System.out.print(' ');
        list.add(s.stem(token.word()));
        System.out.println("haha");
    } 
     System.out.print("haha");
         StringBuilder sb = new StringBuilder();
for (String s2 : list)
{
    sb.append(s2);
    sb.append("\t");
}

System.out.println(sb.toString());
String s1=sb.toString();
System.out.println(s1);
    for(int i=0;i<list.size();i++)
    {    
        writer2.write(list.get(i));
        writer2.write(",");
         //bit+=list.get(i)+",";
        System.out.println(list.get(i)+",");       
    }
    writer2.flush();
    writer2.close();
    //    byte b[]=bit.getBytes();            
     //   fout.write(b); 
    
    
    //System.out.println();
        // Stemmer1 q= new Stemmer1();
         //q.f3(q);
    File file1 = new File("C:\\Users\\HP\\Desktop\\sample1.txt");
    FileInputStream fis1 = new FileInputStream(file1);
     byte[] data = new byte[(int) file1.length()];
fis1.read(data);
    fis1.close();
     MaxentTagger tagger = new MaxentTagger("tagger/wsj-0-18-bidirectional-nodistsim.tagger");
    //String s1=new String(data, "UTF-8");
    String sample = s1.replaceAll("\\W", " ");
    System.out.println(sample);
    System.out.println("haha");

    String tagged = tagger.tagTokenizedString(sample);

     //System.out.println(tagged);
    String[] x = tagged.split(" ");

    ArrayList<String> list1 = new ArrayList<String>(); 
    System.out.println("haha");
  
 for(int i=0;i<x.length;i++)
    {
        if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("N"))
        {
            list1.add(x[i].split("_")[0]);
            System.out.println("1");
        }
    }
    System.out.println("haha");
    for(int i=0;i<x.length;i++)
    {
        if (x[i].substring(x[i].lastIndexOf("_")+1).endsWith("B"))
        {
            list1.add(x[i].split("_")[0]);
        }
    }
    System.out.println("haha");
    
HashSet<String> hs = new HashSet<String>();
hs.addAll(list1);
list1.clear();
list1.addAll(hs);
 System.out.println("haha");
for(int i=0;i<list1.size();i++)
    {    
        System.out.println(list1.get(i));       
    }
//System.out.println("haha");
     //ArrayList<String> list1=new ArrayList<String>();
     //abc1 a= new abc1();
     //list1=a.f2(list);
String[] arguments = new String[list1.size()];
for(int i=0;i<list1.size();i++)
    {    
        arguments[i]=list1.get(i);       
    }
/*for(int i=0;i<arguments.length;i++)
    {    
        System.out.println(arguments[i]);       
    }*/
ArrayList<String> d=new ArrayList<String>();
if(a1==1)
{
d=dlg.main(arguments);// choice input

}
if(a1==2)
{
d=dlg3.main(arguments);
  }
if(a1==3)
{
d=dlg2.main(arguments);
  }
return d;
     }  

    
}
