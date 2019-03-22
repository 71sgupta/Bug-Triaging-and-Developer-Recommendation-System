
import java.io.*; 
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.util.ArrayUtils;
import java.util.ArrayList;
import java.util.*;
import static javafx.beans.binding.Bindings.concat;


public class abc {
public static void main(String[] args) throws IOException,
    ClassNotFoundException {
    FileOutputStream fout=new  FileOutputStream("C:\\Users\\HP\\Desktop\\sample2.txt");
    File file = new File("C:\\Users\\HP\\Desktop\\sample1.txt");
    FileInputStream fis = new FileInputStream(file);
    byte[] data = new byte[(int) file.length()];
    int i;
  /*  for(i=0;i<data.length;i++)
    {
        System.out.println(data[i]);
    }*/
    /*
    StringBuilder sb = new StringBuilder();
    ArrayList<String> list1= new ArrayList<String>();
    
         list1.add("Regress");
         list1.add("is");
         list1.add("Text");
         list1.add("seen");
         list1.add("Overlap");
    
   
for (String s2 : list1)
{
    sb.append(s2);
    sb.append("\t");
}

System.out.println(sb.toString());
String s=sb.toString();*/
    fis.read(data);
    fis.close();
    MaxentTagger tagger = new MaxentTagger("tagger/wsj-0-18-bidirectional-nodistsim.tagger");
    String s=new String(data, "UTF-8");
    String sample = s.replaceAll("\\W", " ");

    String tagged = tagger.tagTokenizedString(sample);

    // System.out.println(tagged);
    String[] x = tagged.split(" ");
    //int i;
    for(i=0;i<x.length;i++)
    {
        System.out.println(x[i]);
    }
    ArrayList<String> list = new ArrayList<String>();  

    for(i=0;i<x.length;i++)
    {
        if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("N"))
        {
            list.add(x[i].split("_")[0]);
        }
    }
    for( i=0;i<x.length;i++)
    {
        if (x[i].substring(x[i].lastIndexOf("_")+1).endsWith("B"))
        {
            list.add(x[i].split("_")[0]);
        }
    }
    
HashSet<String> hs = new HashSet<String>();
hs.addAll(list);
list.clear();
list.addAll(hs);
    String bit = "";
    for( i=0;i<list.size();i++)
    {    
         bit+=list.get(i)+",";
        System.out.println(list.get(i));       
    }
        byte b[]=bit.getBytes();            
        fout.write(b); 
}}