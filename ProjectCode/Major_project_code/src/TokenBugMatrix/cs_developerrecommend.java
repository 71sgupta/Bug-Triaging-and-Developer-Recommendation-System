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
public class cs_developerrecommend  {
    public void recommend(ArrayList<String> arg1)throws ClassNotFoundException, FileNotFoundException, IOException 
    {
         FileInputStream fstream2 = new FileInputStream("C:\\Users\\HP\\Desktop\\DeveloperMatrix.csv");
               DataInputStream in2 = new DataInputStream(fstream2);
               BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
               String str1;
               int i,j,len,row=0,k;
               String s2[][]=new String[93][102];
               while((str1=br2.readLine())!=null){
                                       
                                     String REGEX1;
                             REGEX1= "\\s*(\\s|,)\\s*";                            
                              
                                    final Pattern p1 = Pattern.compile(REGEX1);
                                    final String[] items2 = p1.split(str1);
                                    len=items2.length;
                                    
                             for(i=0;i<items2.length;i++)
                             {
                                 System.out.println(len);
                                    //s2[row][i]=items2[i];
                             }
                             row++;
        }
               System.out.print(row);
             /*  String s3[][]=new String[arg1.size()+1][101];
               s3[0][0]="Dev/BugId";
               for(i=1;i<101;i++)
               {
                   s3[0][i]=s2[0][i];
               }
               int l=0;
               for(i=0;i<arg1.size();i++)
               {
                   for(j=1;j<row;j++)
                   {
                       if(s2[j][0].equals(arg1.get(i)))
                       {
                           for(k=0;k<101;k++)
                           {
                               s3[l][k]=s2[j][k];
                           }
                           l++;
                           break;
                       }
                   }
               }
                for(i=0;i<l;i++)
             {  
                 for(j=0;j<101;j++)
                {
                 System.out.print(s3[i][j]+",");
                 
                }
             System.out.println();
             }*/
        
    }
    
}
