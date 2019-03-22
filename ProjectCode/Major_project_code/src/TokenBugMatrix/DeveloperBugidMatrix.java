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

public class DeveloperBugidMatrix {
public  ArrayList<String> recommend(ArrayList<String> arg1,int[] c)throws ClassNotFoundException, FileNotFoundException, IOException
{
     FileInputStream fstream = new FileInputStream("C:\\Users\\HP\\Desktop\\book7.csv");
               DataInputStream in = new DataInputStream(fstream);
                  BufferedReader br = new BufferedReader(new InputStreamReader(in));
                  File file = new File("C:\\Users\\HP\\Desktop\\DeveloperM.csv");  
               if ( !file.exists() ) {
                     boolean createNewFile = file.createNewFile();
            }

           
               
     FileWriter fw = new FileWriter(file);
     BufferedWriter writer = new BufferedWriter(fw); 
                  String str1;
                  int len,i,row=0,j,k,l=0,col=1;
                  String s2[][]=new String[100][];
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
                   ArrayList<String> developers = new ArrayList<String>();
              
                 for(j=0;j<row;j++)
                 {
                     
                         for(k=1;k<s2[j].length;k++)
                         {
                             developers.add(s2[j][k]);
                         }
                     }
                  System.out.println(developers.size());
HashSet<String> hs = new HashSet<String>();
hs.addAll(developers);
developers.clear();
developers.addAll(hs);
 int a= developers.size();
 a++;
String s3[][]= new String[a][101];
 System.out.println(a);
                        /* for(k=0;k<developers.size();k++)
                         {
                             System.out.println(developers.get(k));
                         }*/
           for(i=0;i<row;i++)
                 {
                      s3[0][i+1]=s2[i][0];
                 }
                 int m=1;
                 for(k=0;k<developers.size();k++)
                         {
                             s3[m][0]=developers.get(k);
                             m++;
                         }
                  System.out.println(m);
                 for(i=1;i<a;i++)
                 {
                  
                     for(j=0;j<row;j++)
                     {
                         for(k=0;k<s2[j].length;k++)
                         {
                             int n=j+1;
                             if(s3[i][0].equals(s2[j][k]))
                             {
                                 
                                 s3[i][n]="1";
                                 break;
                             }
                             else
                             {
                                 s3[i][n]="0";
                             }
                         }
                     }
                 }
                 s3[0][0]="developer/bug id";
                 
                 //int n=0;
                 for(i=0;i<a;i++)
                 {
                     //int n=0;
                    for(j=0;j<=100;j++)
                     {
                   
                       System.out.print(s3[i][j]+",");
                       //n++;
                     }
                    // System.out.println(n);
                     System.out.println();
                 }
                 System.out.println(a);
                 System.out.println(arg1.size());
                   String s4[][]=new String[arg1.size()+2][102];
               //s4[0][0]="Dev/BugId";
               for(i=0;i<101;i++)
               {
                   s4[0][i]=s3[0][i];
                   //System.out.println("haha");
               }
              /* for(j=0;j<101;j++)
                {
                 System.out.println(s4[0][j]+",");
                 
                }*/
               int n=1;
               for(i=0;i<arg1.size();i++)
               {
                   for(j=1;j<a;j++)
                   {
                       if(s3[j][0].equals(arg1.get(i)))
                       {
                           for(k=0;k<101;k++)
                           {
                               s4[n][k]=s3[j][k];
                           }
                           n++;
                           break;
                       }
                   }
               }
               int sum=0;
               String s5[][]=new String[n][2];
               double[] sorted_cosine=new double[n];
               for(i=1;i<101;i++)
               {
                   sum=sum+(c[i]*c[i]);
               }
               double vector1=Math.sqrt(sum);
                for(i=0;i<n;i++)
             {  
                 for(j=0;j<101;j++)
                {
                 System.out.print(s4[i][j]+",");
                 
                }
             System.out.println();
             }
              
               for(i=1;i<n;i++)
               {
                   int sum1=0;
                   for(j=1;j<101;j++)
                   {
                       int g=Integer.valueOf(s4[i][j]);
                       sum1=sum1+(g*g);
                   }
                   double vector2=Math.sqrt(sum1);
                   int sum2=0;
                   for(j=1;j<101;j++)
                   {
                       int g=Integer.valueOf(s4[i][j]);
                       sum2=sum2+(g*c[j]);
                   }
                   s5[i][0]=s4[i][0];
                   double cosine=sum2/(vector2*vector1);
                   s5[i][1]=Double.toString(cosine);
                   sorted_cosine[i]=cosine;
               }
               Arrays.sort(sorted_cosine);
               ArrayList<String> final_developers= new ArrayList<String>();
               int h=0;
               if(n>10)
               {
                   h=10;
               }
               else
               {
                   h=n-1;
               }
                 for(i=n-1;i>n-1-h;i--)
                 {
                     for(j=1;j<n;j++)
                     {
                         double a1=Double.parseDouble(s5[j][1]);
                         if(a1==sorted_cosine[i])
                         {
                             final_developers.add(s5[j][0]);
                             s5[j][1]="-1";
                             break;
                         }
                     }
                 }
               
               
                
                 for(i=0;i<a;i++)
                                {
                                    for(j=0;j<=100;j++)
                                    { 
                                         writer.write(s3[i][j]);
                                       writer.write(","); 
                                       // System.out.print(s[i][j]+",");
                                       
                                    }
                               writer.newLine();
                          // System.out.println(" ");
                                       
                                }  
                   
                        
   writer.flush();
        writer.close();
        fw.close(); 
              //ArrayList<String> final_developers=new ArrayList<String>();
      return final_developers;       
}
/*public static void main(String[] args) throws IOException,ClassNotFoundException {
    DeveloperBugidMatrix c= new DeveloperBugidMatrix();
        c.recommend();
}*/
}
