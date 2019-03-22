package cti;

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

public class TokenBugMatrix {
    
public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException 
    {   
       
        int i,j;
        String s[][]=new String[393][101]; 
        
        int numline=0, numline1=0;
        
        for(i=1;i<393;i++)
        {
            for(j=1;j<101;j++)
            {
                s[i][j]="0";
            }
        }
       
      
 
FileInputStream fstream = new FileInputStream("C:\\Users\\HP\\Desktop\\book5.csv");
               DataInputStream in = new DataInputStream(fstream);
               FileInputStream fstream1 = new FileInputStream("C:\\Users\\HP\\Desktop\\book3.csv");
               DataInputStream in1 = new DataInputStream(fstream1);
               FileInputStream fstream2 = new FileInputStream("C:\\Users\\HP\\Desktop\\book4.csv");
               DataInputStream in2 = new DataInputStream(fstream2);
                   String str,str1,str2;
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
                    File file = new File("C:\\Users\\HP\\Desktop\\Matrix1.csv");  
               if ( !file.exists() ) {
                     boolean createNewFile = file.createNewFile();
            }

           
               
     FileWriter fw = new FileWriter(file);
     BufferedWriter writer = new BufferedWriter(fw); 
                            // read entire file for i and j
     
  // create rows for tokens
                          while ((str = br.readLine()) != null)	
                          {  String REGEX;
                             REGEX = "\\s*(\\s|,)\\s*";                            
                               numline++;
                                    final Pattern p = Pattern.compile(REGEX);
                                    final String[] items = p.split(str);
                                
                                s[numline][0]=items[0];
                                 
                                       
                               
                          }
   // create columns of bugId
                           while ((str1 = br1.readLine()) != null)	
                          {  String REGEX;
                             REGEX = "\\s*(\\s|,)\\s*";
                       
                            numline1++;
                        
                                    final Pattern p1 = Pattern.compile(REGEX);
                                    final String[] items1 = p1.split(str1);
                                
                                s[0][numline1]=items1[0];
                           
                                       
                               
                          }
                           System.out.println(numline);
                           System.out.println(numline1);
                           
       // to insert values               
                           while ((str2 = br2.readLine()) != null)	
                          {  
                             String REGEX;
                             REGEX = "\\s*(\\s|,)\\s*";
                     
                                    final Pattern p2 = Pattern.compile(REGEX);
                                    final String[] items2 = p2.split(str2);
                                    System.out.println(items2[0]+","+items2[1]);
                                for(i=1;i<=numline;i++)
                                {  
                                    for(j=1;j<=numline1;j++)
                                    {  //System.out.println(i+","+j);
                                        if((s[i][0].equals(items2[0]))&&(s[0][j].equals(items2[1])))
                                      {   
                                          s[i][j]="1";
                                        // System.out.println(s[i][j]+",");
                                      }
                                   
                                    
                                    }
                              
                           
                                       
                                }  
                          
                          }
                           s[0][0]="T/B";
         // to print values                  
                           for(i=0;i<=numline;i++)
                                {
                                    for(j=0;j<=numline1;j++)
                                    { 
                                         writer.write(s[i][j]);
                                       writer.write(","); 
                                       // System.out.print(s[i][j]+",");
                                       
                                    }
                               writer.newLine();
                          // System.out.println(" ");
                                       
                                }  
                        
                            /*for(i=0;i<=numline;i++)
                                {
                                    for(j=0;j<=numline1;j++)
                                    {  
                                         writeFile(file,s[i][j]);
                                       
                                    }
                             
                                       
                                }*/  
      
        writer.flush();
        writer.close();
        fw.close();
     
    }
   /* private static void writeFile(File file, String data)
{
   try
   { 

      //write the data

      BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
      out.newLine();
      out.write(data);
      out.close();
      out=null;
   }
   catch(Exception e)   //catch and report any errors
   {
      System.out.println(""+e);
   }
}*/
}


    
     


	

    
     



    


    





