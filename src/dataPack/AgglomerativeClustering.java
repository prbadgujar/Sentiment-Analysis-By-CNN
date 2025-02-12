package dataPack;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class AgglomerativeClustering {
                String path=System.getProperty("user.dir");
    FileInputStream fstream;
    DataInputStream in;
	//Number of Clusters. This metric should be related to the number of points
    private int NUM_CLUSTERS ;    
    //Number of Points
    private int NUM_POINTS = 15;
    //Min and Max X and Y
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 10;
    
    private List points;
    private List clusters;
    Cluster cluster ;
    Point point ;
    static int count;
    public AgglomerativeClustering() {
    	this.points = new ArrayList();
    	//this.clusters = Arrays.asList(KMeans.cent);    	
    }
    public AgglomerativeClustering(int num) {
        this.NUM_CLUSTERS=num;
//    	this.clusters = Arrays.asList(KMeans.cent);   
        System.out.println("Centroid Length==="+clusters.size());
    }
    
    public static void main(String[] args) {
    	
    	AgglomerativeClustering Agglo = new AgglomerativeClustering();
    	Agglo.init();
    	Agglo.calculate();
    }
    
    //Initializes the process
    public void init() {
    	//Create Points
    	points = Point.createRandomPoints(MIN_COORDINATE,MAX_COORDINATE,NUM_POINTS);     
    }
 
    
	
    public void calculate() {
        try {
            StringTokenizer st;
                FileInputStream fstream;
                DataInputStream in;
                FileOutputStream stout,stout1;
                PrintStream stp,stp1;
            boolean finish = false;
            int iteration = 0;
            
            // Add in new data, one at a time, recalculating centroids with each new one. 
                while(!finish) {
                    //Clear cluster state
                    count=iteration;
                    List lastCentroids = getCentroids();
                    System.out.println(iteration+"===lastCentroids==="+lastCentroids.size());
                    //Assign points to the closer cluster
                    assignCluster();
                
                //Calculate new centroids.
                    calculateCentroids();
                    
                    iteration++;
                    
                    List currentCentroids = getCentroids();
                    
                    //Calculates total distance between new and old Centroids
                    double distance = 0;
                    for(int i = 0; i < lastCentroids.size(); i++) {
                            distance += Point.distance((Point)lastCentroids.get(i),(Point)currentCentroids.get(i));
                    }
                    System.out.println("#################");
                    System.out.println("Iteration: " + iteration);
                    System.out.println("Centroid distances: " + distance);
                    //plotClusters();
                                    
                    if(clusters.size() == 10) {
                            finish = true;
                    }
                }
                String file1="output/final.txt";//copy clusterwise documents in this
                stout1 = new FileOutputStream(file1);
                stp1 = new PrintStream(stout1);
                //Final Centroids...
                List finalCentroids = getCentroids();
                System.out.println(finalCentroids.size());
                for(int i=0;i<finalCentroids.size();i++){
                    //MainFrame.vc.add(finalCentroids.get(i));
                    //System.out.println(finalCentroids.get(i));
                    stp1.println(finalCentroids.get(i));
                }
                 
               // System.out.println(MainFrame.cv.size());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AgglomerativeClustering.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
    
    private List getCentroids() {
                List centroids = new ArrayList(NUM_CLUSTERS);
                cluster=new Cluster(count);
    		Point aux = cluster.getCentroid();
    		Point point = new Point(aux.getX(),aux.getY());
    		centroids.add(point);
    	 
    	return centroids;
    }
    
    private void assignCluster() {
        double max = Double.MAX_VALUE;
        double min = max; 
        int cluster = 0;                 
        double distance = 0.0; 
        
         
        	min = max;
            for(int i = 0; i < NUM_CLUSTERS; i++) {
            	Cluster c = (Cluster) clusters.get(i);
                distance = Point.distance(point, c.getCentroid());
                if(distance < min){
                    min = distance;
                    cluster = i;
                }
            }
            point.setCluster(cluster);
        
    }
    
    private void calculateCentroids() {
         
            double sumX = 0;
            double sumY = 0;
            List list = cluster.getPoints();
            int n_points = list.size();
            	sumX += point.getX();
                sumY += point.getY();
            
            Point centroid = cluster.getCentroid();
            if(n_points > 0) {
            	double newX = sumX / n_points;
            	double newY = sumY / n_points;
                centroid.setX(newX);
                centroid.setY(newY);
            }
        }
     public static void  copydoc()
    {
            int clustno=1; 
            String str,s;
            int n;
            StringTokenizer st;
            FileInputStream fstream;
            DataInputStream in;
            FileOutputStream stout,stout1;
            PrintStream stp,stp1;
            try
            {
                
            String file2="output/final.txt";
            fstream = new FileInputStream(file2);
            in = new DataInputStream(fstream);
            String file1="output/newdocAssignment.txt";//copy clusterwise documents in this
            stout1 = new FileOutputStream(file1);
            stp1 = new PrintStream(stout1); 

            while (in.available() !=0)
            {
                            stp1.println("CLUSTER"+ clustno+":");
                            clustno++;
                            str=in.readLine();
//                            if(MainFrame.dis1.equals("")){
//                                MainFrame.dis1=str;
//                            }else{
//                            MainFrame.dis1=MainFrame.dis1+" "+str;
//                            }
                            stp1.println(str);
                            st = new StringTokenizer(str);
                            s=st.nextToken();
                            //str=in.readLine();

            }

            }

    catch(Exception e)
            {
                            e.printStackTrace();
                    //System.out.println("\n\nError in main function");
            }
    }
	
}