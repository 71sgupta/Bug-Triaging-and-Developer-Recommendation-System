

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

public class Split {
     
   public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException 
    {   
       
        int i;
        int numline=0;
       
      
 
FileInputStream fstream = new FileInputStream("C:\\Users\\HP\\Desktop\\Book3.csv");
               DataInputStream in = new DataInputStream(fstream);
                   String str;
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    File file = new File("C:\\Users\\HP\\Desktop\\Book6.csv");  
               if ( !file.exists() ) {
                     boolean createNewFile = file.createNewFile();
            }

           
               
        FileWriter fw = new FileWriter(file);
     BufferedWriter writer = new BufferedWriter(fw); 
                           
                          while ((str = br.readLine()) != null)	
                          {  String REGEX, R1;
                             REGEX = "\\s*(\\s|,)\\s*";
                             R1=",";
                             numline++;
                           //   System.out.println(numline);
                             
                                    //System.out.println (str);
                                    final Pattern p = Pattern.compile(REGEX);
                                    // final Pattern p1 = Pattern.compile(R1);
                                    final String[] items = p.split(str);
                                  //  final String[] items1=p1.split(items[1]);
                                    
                                
            
                                   //  String h="B";
                                    String h="";
                   
                                    
                                                 h=h.concat(items[0]);
                                                 
                                  for(i=1;i<items.length;i++)
                                   {   
                                       System.out.print(items[i]+",");
                                       System.out.print(h);
                                        System.out.println(); 
                                    }
                                         
                                                 
                                                 
                                   for(i=1;i<items.length;i++)
                                   {   
                                       writer.write(items[i]);
                                       writer.write(","); 
                          
                                         writer.write(h);
                           
                                        writer.newLine();
                                    
                                              
                 
                                 
                                    }
                                       
                               
                          }
                        
                        

      
        writer.flush();
        writer.close();
        fw.close();
     
    }}


    
     


	

    
     



    


    



