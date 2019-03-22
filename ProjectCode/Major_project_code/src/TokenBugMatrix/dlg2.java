package  TokenBugMatrix;
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


public class dlg2 {
 public static ArrayList<String> main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException 
    {   
           int i,j,l,len;
        
        String s1[]=new String[20];
        String[][] s2 = new String[395][102];
        int row = 0;
        String s3[][]=new String[20][102];
        String s4[][]=new String[2][101];
        String s5[][]=new String[2][101];
             int row1=1,count=1;
        int flag=0;
        int numline=0;
        
        
       // FileInputStream fstream = new FileInputStream("C:\\Users\\HP\\Desktop\\book6.csv");
         //      DataInputStream in = new DataInputStream(fstream);
               FileInputStream fstream2 = new FileInputStream("C:\\Users\\HP\\Desktop\\Matrix1.csv");
               DataInputStream in2 = new DataInputStream(fstream2);
                   String str,str1;
           //         BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));

                    File file = new File("C:\\Users\\HP\\Desktop\\Prob.csv");  
               if ( !file.exists() ) {
                     boolean createNewFile = file.createNewFile();
            }
                                   FileWriter fw = new FileWriter(file);
     BufferedWriter writer = new BufferedWriter(fw);
             /*             while ((str = br.readLine()) != null)	
                          {  String REGEX;
                             REGEX = "\\s*(\\s|,)\\s*";                            
                             
                                    final Pattern p = Pattern.compile(REGEX);
                                    final String[] items = p.split(str);
                                System.out.println(numline);
                                    s1[numline]=items[0];
                                 numline++;
                                       
                               
                          }*/
                         for(int a=0;a<args.length;a++)
                        {
                             s1[numline]=args[a];
                                 numline++;
                                   
                        }
                          System.out.println("No. of tokens generated:"+numline);
        
       
        
                                   while((str1=br2.readLine())!=null){
                                       
                                     String REGEX1;
                             REGEX1= "\\s*(\\s|,)\\s*";                            
                              
                                    final Pattern p1 = Pattern.compile(REGEX1);
                                    final String[] items2 = p1.split(str1);
                                    len=items2.length;
                             for(i=0;i<items2.length;i++)
                             {
                                    s2[row][i]=items2[i];
                                            }
                             row++;
        }
        
            
             
                          
             for(i=0;i<101;i++)
             {
                 s3[0][i]=s2[0][i];
                     s4[0][i]=s2[0][i];
                     s5[0][i]=s2[0][i];
             }
            
             for(i=0;i<numline;i++)
             {
                 flag=0;
                 for(j=1;j<row;j++)
                 {
                        if(s1[i].equals(s2[j][0]))
                        {
                      
                            for(l=0;l<102;l++)
                            {
                               s3[row1][l]=s2[j][l];
                            }
                            flag=1;
                            row1++;
                            break;
                        }
                        
                    
                      
                }
                 if(flag==0)
                        {
                            s3[row1][0]=s1[i];
                            for(l=1;l<102;l++)
                            {
                               s3[row1][l]="0";
                            }
                            row1++;
                 
                        }
                }
             
             for(i=0;i<row1;i++)
             {  
                 for(j=0;j<101;j++)
                {
                 System.out.print(s3[i][j]+",");
                 
                }
             System.out.println();
             }
             
            for(i=1;i<101;i++)
             {
                 count=0;
                 for(j=1;j<row1;j++)
                 {
                     if(s3[j][i].equals("1"))
                     {
                         count++;
                     }
                 }
                 String a=Integer.toString(count);
                 s4[1][i]=a;
             }
            s4[1][0]="Count";
            s5[1][0]="Prob";
            for(i=1;i<101;i++)
            {
                int a=Integer.parseInt(s4[1][i]);
                System.out.println(a);
                float b=(float)a/numline;
                System.out.println(b);
                s5[1][i]=Float.toString(b);
            }
             for(i=0;i<=1;i++)
             {  
                 for(j=0;j<101;j++)
                {
                 System.out.print(s4[i][j]+",");
                 
                }
             System.out.println();
             }
             for(i=0;i<=1;i++)
             {  
                 for(j=0;j<101;j++)
                {
                 System.out.print(s5[i][j]+",");
                 
                }
             System.out.println();
             }
          float s6[]=new float[100];
            // s6[0]=0;
          int k=0;
             for(i=1;i<2;i++)
             {
                 for(j=1;j<101;j++)
                 {
                     float a=Float.parseFloat(s5[i][j]);
                     s6[k++]=a;
                 }
                 
             }
           Arrays.sort(s6);  
                 for(j=0;j<100;j++)
                {
                 System.out.print(s6[j]+",");
                 
                }
                 ArrayList<String> bid= new ArrayList<String>();
                 for(i=99;i>89;i--)
                 {
                     for(j=1;j<101;j++)
                     {
                         float a=Float.parseFloat(s5[1][j]);
                         if(a==s6[i])
                         {
                             bid.add(s5[0][j]);
                             s5[1][j]="-1";
                             break;
                         }
                     }
                 }
                 for( i=0;i<bid.size();i++)
    {    
      
        System.out.println(bid.get(i)+",");       
    }
                 ArrayList<String> result=new ArrayList<String>();
                 developerrecommend d= new developerrecommend();
                 result= d.recommend(bid);
                 for( i=0;i<result.size();i++)
    {    
      
        System.out.println(result.get(i)+",");       
    }
            
          /* float temp,temp1,temp2;
             for(j=1;j<101;j++)
             {
                    for (i = j;i<101;i++) 
                    {       
                        if (s6[1][j] < s6[1][i]) 
                        {
                        temp = s6[1][j];
                        s6[1][j] = s6[1][i];   
                     s6[1][i] = temp;
                        temp1 = s5[0][i]; 
		     s5[0][i] = s5[0][i + 1];   
                     s5[0][i + 1] = temp1;
                        }     
                    }
             }*/
             s5[0][0]="b/prob";
         // to print values         
                            s5[1][0]="prob";       
                           for(i=1;i<101;i++)
                                {
                                    for(j=0;j<2;j++)
                                    { 
                                           //System.out.println(s4[i][j]);
                                        writer.write(s5[j][i]);
                                       writer.write(","); 
                                       // System.out.print(s[i][j]+",");
                                       
                                    }
                               writer.newLine();
                          // System.out.println(" ");
                                       
                                }                   
               
        writer.close();
        fw.close();    
                
return result;

    
}
}
