
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
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
public class dlg3 {
    public static ArrayList<String> main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException 
    {   
           int i,j, len,l;
        
        String s1[]=new String[30];
        String s3[][]=new String[20][102];
        
        int numline=0;
        
             
        
        
        //FileInputStream fstream = new FileInputStream("C:\\Users\\HP\\Desktop\\book6.csv");
          //     DataInputStream in = new DataInputStream(fstream);
               FileInputStream fstream2 = new FileInputStream("C:\\Users\\HP\\Desktop\\Matrix1.csv");
               DataInputStream in2 = new DataInputStream(fstream2);
                   String str,str1;
            //        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
                    File file = new File("C:\\Users\\HP\\Desktop\\Matrix2.csv");  
               if ( !file.exists() ) {
                     boolean createNewFile = file.createNewFile();
            }
               File file1 = new File("C:\\Users\\HP\\Desktop\\And.csv");  
               if ( !file1.exists() ) {
                     boolean createNewFile = file1.createNewFile();
            }
               File file2 = new File("C:\\Users\\HP\\Desktop\\Or.csv");  
               if ( !file2.exists() ) {
                     boolean createNewFile = file2.createNewFile();
            }
               FileWriter fw = new FileWriter(file);
        FileWriter fw1 = new FileWriter(file1);
     BufferedWriter writer = new BufferedWriter(fw1);
     FileWriter fw2 = new FileWriter(file2);
     BufferedWriter writer2 = new BufferedWriter(fw2);
        
        BufferedWriter writer1 = new BufferedWriter(fw);
     writer1.flush();
   //  writer1.write("char");
    // writer1.close();
     
                        /*while ((str = br.readLine()) != null)	
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
                      /*  for(i=0;i<args.length;i++)
             {
                 System.out.println(args[i]);
             }*/
                        
                        
        String[][] s2 = new String[395][102];
        int row = 0;
       
        
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
        
             for(i=0;i<row;i++)
             { for(j=0;j<101;j++)
                {
                 System.out.print(s2[i][j]+",");
                 
                }
             System.out.println();
             }
             String s4[][]=new String[2][101];
             String s5[][]=new String[2][101];
             int row1=1;
             for(i=0;i<101;i++)
             {
                 s3[0][i]=s2[0][i];
                     s4[0][i]=s2[0][i];
                     s5[0][i]=s2[0][i];
                     
             }
            
             for(i=0;i<numline;i++)
             {
                 for(j=1;j<row;j++)
                 {
                        if(s1[i].equals(s2[j][0]))
                        {
                      
                            for(l=0;l<102;l++)
                            {
                               s3[row1][l]=s2[j][l];
                            }
                            row1++;
                            break;
                        }
                       
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
             int flag=0;
             for(i=1;i<101;i++)
             {
                 for(j=1;j<row1;j++)
                 {
                     
                        if(s3[j][i].equals("0"))
                        {
                            s4[1][i]="0";
                            break;
                        }
                        else
                        {
                            s4[1][i]="1";
                        }
                        
                 }
                 
             }
             for(i=0;i<2;i++)
             {  
                 for(j=0;j<101;j++)
                {
                 System.out.print(s4[i][j]+",");
                 
                }
             System.out.println();
             }
             for(i=1;i<101;i++)
             {
                 for(j=1;j<row1;j++)
                 {
                     
                        if(s3[j][i].equals("1"))
                        {
                            s5[1][i]="1";
                            break;
                        }
                        else
                        {
                            s5[1][i]="0";
                        }
                        
                 }
                 
             }
             int b[]= new int[101];
             b[0]=0;
             for(i=1;i<101;i++)
             {
                 b[i]=Integer.parseInt(s5[1][i]);
             }
             ArrayList<String> bid = new ArrayList<String>();  
             j=0;
             for(i=1;i<101;i++)
             {
                 if(s5[1][i]=="1")
                 {
                     bid.add(s5[0][i]);
                 }
             }
             for( i=0;i<bid.size();i++)
    {    
      
        System.out.println(bid.get(i)+",");       
    }
          developerrecommend d= new developerrecommend();
           ArrayList<String> result=new ArrayList<String>();
            result=d.recommend(bid);
         /*   System.out.println(result.size()+",");  
             for( i=0;i<result.size();i++)
    {    
      
        System.out.println(result.get(i)+",");       
    }*/
             DeveloperBugidMatrix c=new DeveloperBugidMatrix();
           ArrayList<String> result1=new ArrayList<String>();
            result1=c.recommend(result,b);
            for( i=0;i<result1.size();i++)
    {    
      
        System.out.println(result1.get(i)+",");       
    } 
            
                 s3[0][0]="T/B";
         // to print values                  
                           for(i=0;i<row1;i++)
                                {
                                    for(j=0;j<101;j++)
                                    { 
                                        //System.out.println(" In  write Loop");
                                        try {
                                            //System.out.println(s3[i][j]);
                                         writer1.write(s3[i][j]);
                                       writer1.write(","); 
                                        } catch(Exception e)
                                        {
                                         e.printStackTrace();
                                        }
                                       // System.out.print(s[i][j]+",");
                                       
                                    }
                               writer1.newLine();
                          // System.out.println(" ");
                                       
                                }                   
                    //writer1.flush();
                            s4[0][0]="And/B";
         // to print values         
                            s4[1][0]="And";       
                           for(i=0;i<2;i++)
                                {
                                    for(j=0;j<101;j++)
                                    { 
                                       
                                        try {
                                           //System.out.println(s4[i][j]);
                                        writer.write(s4[i][j]);
                                       writer.write(","); 
                                        } catch(Exception e)
                                        {
                                         e.printStackTrace();
                                        }
                                       // System.out.print(s[i][j]+",");
                                       
                                    }
                               writer.newLine();
                          // System.out.println(" ");
                                       
                                }                   
                s5[0][0]="or/B";
         // to print values         
                            s5[1][0]="or";       
                           for(i=0;i<2;i++)
                                {
                                    for(j=0;j<101;j++)
                                    { 
                                       
                                        try {
                                           //System.out.println(s4[i][j]);
                                        writer2.write(s5[i][j]);
                                       writer2.write(","); 
                                        } catch(Exception e)
                                        {
                                         e.printStackTrace();
                                        }
                                       // System.out.print(s[i][j]+",");
                                       
                                    }
                               writer2.newLine();
                          // System.out.println(" ");
                                       
                                }                   
                
        writer1.close();
        writer.close();
        writer2.close();
        fw.close();    
                              
       return result1; 
        
    }
    
}
