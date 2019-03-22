package TokenBugMatrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.lang.*;

public class developerrecommend {
    public ArrayList<String> recommend( ArrayList<String> args ) throws ClassNotFoundException, FileNotFoundException, IOException
    {
          FileInputStream fstream = new FileInputStream("C:\\Users\\HP\\Desktop\\book7.csv");
               DataInputStream in = new DataInputStream(fstream);
                  BufferedReader br = new BufferedReader(new InputStreamReader(in));
                  String str1;
                  int len,i,row=0,j,k,l=0;
                  String s2[][]=new String[100][];
                  String s3[][]=new String[100][];
                  
                  
                                            while((str1=br.readLine())!=null){
                                       
                                     String REGEX1;
                             REGEX1= "\\s*(\\s|,)\\s*";                            
                              
                                    final Pattern p1 = Pattern.compile(REGEX1);
                                    final String[] items2 = p1.split(str1);
                                    len=items2.length;
                                      s2[row]=new String[len];
                             for(i=0;i<items2.length;i++)
                             {
                               
                                    s2[row][i]=items2[i];
                             }
                             row++;
        }
           
            for(i=0;i<row;i++)
            {
                for(j=0;j<s2[i].length;j++)
                {
                    System.out.println(s2[i][j]);
                }
                
            }
              for(i=0;i<args.size();i++)
             {
                 System.out.println(args.get(i));
             }
                                            
             for(i=0;i<args.size();i++)
             {
                 for(j=0;j<row;j++)
                 {
                     if(s2[j][0].equals(args.get(i)))
                     {
                         //int m=0;
                         
                         s3[i]=new String[s2[j].length];
                         
                         for(k=0;k<s2[j].length;k++)
                         {
                           /*  if(s2[j][k].equals("0"))
                             {
                               //  System.out.print("Haha");
                                 continue;
                             }*/
                             //else
                             //{
                             //      System.out.print(s2[j][k]+",");
                             
                             try
                             {
                                
                             s3[l][k]=s2[j][k];
                             }
                             catch(Exception e)
                             {
                                 e.printStackTrace();
                             }
                             //}
                           //  System.out.print(s2[j][k]+",");
                         }
                         l++;
                         
                       break;
                     }
                 }
                // System.out.println();
             }
             for(i=0;i<args.size();i++)
            {
                for(j=0;j<s3[i].length;j++)
                {
                    System.out.print(s3[i][j]+",");
                }
                System.out.println();
            
            }
            System.out.println(l);
             ArrayList<String> developer= new ArrayList<String>();
             for(i=0;i<l;i++)
             {
                 for(j=1;j<s3[i].length;j++)
                 {
                     developer.add(s3[i][j]);
                     //System.out.println(developer.get(i)+",");
                 }
             }
             for( i=0;i<developer.size();i++)
    {    
      
        System.out.println(developer.get(i)+",");       
    }
HashSet<String> hs = new HashSet<String>();
hs.addAll(developer);
developer.clear();
developer.addAll(hs);
developer.remove("0");
             for( i=0;i<developer.size();i++)
    {    
      
        System.out.println(developer.get(i)+",");       
    }
int a= developer.size();
String s4[][]=new String[a][2];
int b[]= new int[a];
//int n=0;
             for(i=0;i<developer.size();i++)
             {
                 
                 int count=0;
                 for(j=0;j<l;j++)
                 {
                    
                         for(k=0;k<s3[j].length;k++)
                         {
                           if(s3[j][k].equals(developer.get(i)))
                            {
                               count++;
                              
                            }  
                         }
                     
                 }
                 b[i]=count;
                 s4[i][0]=developer.get(i);
                 s4[i][1]=Integer.toString(count);
                 
             }
              for(i=0;i<a;i++)
             {
                 for(j=0;j<2;j++)
                 {
                     
                     System.out.print(s4[i][j]+",");
                 }
                 System.out.println();
             }
             Arrays.sort(b);
             for(i=0;i<a;i++)
             {
                 System.out.print(b[i]);
             }
             //System.out.print(b.length);
             ArrayList<String> final_developers=new ArrayList<String>();
             int h=0;
            if(a>10)
             {
                 h=10;
             }
             else
             {
                 h=a-1;
             }
             for(i=a-1;i>a-1-h;i--)
             {
                 for(j=0;j<a;j++)
                 {
                     String n=Integer.toString(b[i]);
                     if(n.equals(s4[j][1]))
                     {
                         final_developers.add(s4[j][0]);
                         s4[j][1]="-1";
                         break;
                     }
                 }
           }
           /*  for( i=0;i<final_developers.size();i++)
    {    
      
        System.out.println(final_developers.get(i)+",");       
    }*/
     //       ArrayList<String> final_developers=new ArrayList<String>();
             
           return final_developers;
    }
    
               
    
}
