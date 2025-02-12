package MyPack;


import java.io.*;
import java.sql.ResultSet;
import java.util.*;

public class Weight
{ 
String path=System.getProperty("user.dir");
FileInputStream fstream;
DataInputStream in;
FileInputStream fstream1;
DataInputStream in1;
FileOutputStream stout;
PrintStream stp;
String words[] = new String[50000];
double[] tf,idf,tfidf;
int j=-1,i=0,tnod=0,tnow=0,tnowd=0;
int[] nod,now;

public void begin(int fno, int n)
{
	try
	{
	String str,s,file1,file2;
	StringTokenizer st; 
	int k;
	i=fno; 
	tnod=5;
	ResultSet  rs=DatabaseConnection.executeQuery("select * from dataset ");
     while(rs.next()){
        str=rs.getString("col4");
		//System.out.println("len==="+str.length());
	int len=str.length();
	if(len!=0){
            st = new StringTokenizer(str);
            s=st.nextToken();
            j++;
            words[j]=s; 
	}else
            break;
      }   
    
    // Compare Words 
    int fcount=0;
    rs=DatabaseConnection.executeQuery("select * from dataset ");
     while(rs.next()){
        str=rs.getString("col4");
		//System.out.println("len==="+str.length());
		int len=str.length();
		if(len!=0){
		
                st = new StringTokenizer(str);
                s=st.nextToken();
                //j++;
                if(words[j]==s){

                    if(fcount>0.05){
                        words[j]=s;
                    }
                    fcount++;
                }else{
                    continue;
                } 
                
                        }else
                        break;
            
    }
    tnow=j;
    tf=new double[j];
    idf=new double[j];
    tfidf=new double[j];
    nod=new int[j];
    now=new int[j];
    
    for(j=0;j<tnow;j++)
    {
    	now[j]=0;
    	nod[j]=0;
    	for(k=0;k<tnow;k++)
    	{
    		if(words[j].compareTo(words[k])==0)
    		{
    			now[j]++;
    		}
    	}
    	
    }
    nodForIdf();
    calculate();
        
	}
	catch(Exception e)
	{
			e.printStackTrace();
		System.out.println("\n\nError in begin function");
	}
}

public void calculate()
{
	try
	{
		String file2;
		double d,td,tw,nd,nw;
	    file2=path+"/dupe/"+String.valueOf(i)+".txt";
	    stout = new FileOutputStream(file2);
	    stp = new PrintStream(stout);
	    td=tnod;
	    tw=tnow;
	    for(j=0;j<tnow;j++)
		{
			nw=now[j];
			nd=nod[j];
			if(tw==0)
                          tw=1;
                        tf[j]=nw/tw;
                        if(nd==0)
                            nd=1;
			d=td/nd;
			idf[j]=Math.log(d); 
			tfidf[j]=tf[j]*idf[j];
			stp.println(words[j]+" "+tfidf[j]);
		}
		//Remove duplicates
		DupeRemoval();
		sorting();
	}
	catch(Exception e)
	{
			e.printStackTrace();
		System.out.println("\n\nError in calculate function");
	}
}

public void DupeRemoval()
{
	try
	{
		String str,s1,s2,s,file1,file2;
		StringTokenizer st;
		int f;
			
		file1=path+"/dupe/"+String.valueOf(i)+".txt";
		fstream = new FileInputStream(file1);
	    in = new DataInputStream(fstream);
	    s="";
	    while (in.available() !=0)
    	{
        str=in.readLine();
        st = new StringTokenizer(str);
        s1=st.nextToken();
        s2=st.nextToken();
        s=s+" "+s1+","+s2;
		}
		String[] wDupes=s.split(" ");
		String noDupes = "";
		for (f = 0; f < wDupes.length; f++) 
		{
		if (noDupes.indexOf(wDupes[f]) < 0) 
		{
		// -1 otherwise, if not in noDupes
		noDupes = noDupes+" "+wDupes[f];
		}
		}
		String[] nDupe=noDupes.split(" ");
				
		file2=path+"/weight/"+String.valueOf(i)+".txt";
	    stout = new FileOutputStream(file2);
	    stp = new PrintStream(stout);
	    String nD[] = new String[2];
	    
	    for(f=1;f<nDupe.length;f++)
	    {
	    	nD=nDupe[f].split(",");
	    	tnowd++;
	    	stp.println(nD[0]+" "+nD[1]);
	    	
	    }
	    	
	}
	catch(Exception e)
		{
				e.printStackTrace();
			System.out.println("\n\nError in DupeRemoval function");
		}
		
}  

public void sorting()
{
	try
	{
		String str,s1,s2,file1,file2,t;
		StringTokenizer st;
		int f=0,g;
		String wd[]=new String[tnowd];
		double wt[]=new double[tnowd];
		double tmp;
			
		file1=path+"/weight/"+String.valueOf(i)+".txt";
		fstream = new FileInputStream(file1);
	    in = new DataInputStream(fstream);
	    while (in.available() !=0)
    	{
        str=in.readLine();
        st = new StringTokenizer(str);
        s1=st.nextToken();
        s2=st.nextToken();
        wd[f]=s1;
        wt[f]=Double.parseDouble(s2);
        f++;
		}
		
		for(f=0;f<tnowd;f++)
		{
			for(g=f+1;g<tnowd;g++)
			{
				if(wt[f]<wt[g])
				{
					tmp=wt[f];
					wt[f]=wt[g];
					wt[g]=tmp;
					
					t=wd[f];
					wd[f]=wd[g];
					wd[g]=t;
				}
			}
		}
						
		file2="weight/"+String.valueOf(i)+".txt";
	    stout = new FileOutputStream(file2);
	    stp = new PrintStream(stout);
	    	    
	    for(f=0;f<tnowd;f++)
	    {
	    	stp.println(wd[f]+" "+wt[f]);
	    	
	    }
	}
	catch(Exception e)
		{
				e.printStackTrace();
			System.out.println("\n\nError in sorting function");
		}
}

public static int calculate(int n){return 100;}
public void nodForIdf()
{
		try
		{
		String str,s,file1;
		StringTokenizer st;
		int f;
		for(j=0;j<tnow;j++)
		{
		nod[j]=0;
		for(f=1;f<=tnod;f++)
		{
		file1=path+"/stem/"+String.valueOf(f)+".txt";
		File nf=new File(file1);
                if(!nf.exists()){
                    nf.createNewFile();
                }
                fstream = new FileInputStream(file1);
	    in = new DataInputStream(fstream);
	    
	    while (in.available() !=0)
    	{
        str=in.readLine();
        st = new StringTokenizer(str);
        s=st.nextToken();
      	if(words[j].compareTo(s)==0)
      	{
      		nod[j]++;
      		break;
      	}
        }   	
        }
		}
		}
		catch(Exception e)
		{
				e.printStackTrace();
			System.out.println("\n\nError in nodForIdf function");
		}
		

	
}


}