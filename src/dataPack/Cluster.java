/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataPack;

import MyPack.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cluster {
	
	public List points;
	public Point centroid;
	public int id;
        public static Vector summary;
	public static Vector clusters;
	//Creates a new Cluster
	public Cluster(int id) {
		this.id = id;
		this.points = new ArrayList();
		this.centroid = null;
	}

	public List getPoints() {
		return points;
	}
	
	public void addPoint(Point point) {
		points.add(point);
	}

	public void setPoints(List points) {
		this.points = points;
	}

	public Point getCentroid() {
		return centroid;
	}

	public void setCentroid(Point centroid) {
		this.centroid = centroid;
	}

	public int getId() {
		return id;
	}
	public static Vector getWeights(int count){
            int val=(int)Math.floor(Math.sqrt(count));
            Vector v=new Vector();
            int ncount=count;
            for(int i=0;i<val;i++){
                int n=(int)ncount/(val);
                ncount=ncount-n;
                v.add(n);
            }
            clusters=v;
            return v;
        }
	public void clear() {
		points.clear();
	}
	public static Vector getSummary(int count){
            Vector v=new Vector();
            try {
                ResultSet rs=DatabaseConnection.executeQuery("select * from dataset limit "+(count*5));
                int icount=0;
                String str="";
                int i=0;
                while(rs.next()){
                   // System.out.println(icount);
                    if(icount==4){
                        icount=0;
                        
                        str+=". "+rs.getString("col5");
                        str=str.replaceAll("[^a-zA-Z0-9]+"," ");
                        str=str.replaceAll("COACHELLA","Chelsea");
                        str=str.replaceAll("Coachella","Chelsea");
                        str=str.replaceAll("coachella","Chelsea");
                        str=str.replaceAll("coachella2015","Chelsea2015");
                        v.add(str);
                        
                        str="";
                        continue;
                    }
                    str+=". "+rs.getString("col5");
                    icount++;
                }
                
            } catch (Exception ex) {
                //Logger.getLogger(Cluster.class.getName()).log(Level.SEVERE, null, ex);
            }
            return v;
        }
        
        public static Vector getTopics(){
            summary=new Vector();
            try {
                ResultSet rs=DatabaseConnection.executeQuery("select distinct(col4) from dataset ");
                while(rs.next()){
                   String str=rs.getString("col4") ;
                   //str=str.replaceAll("[^a-zA-Z0-9]+"," ");
                        str=str.replaceAll("COACHELLA","Chelsea");
                        str=str.replaceAll("Coachella","Chelsea");
                        str=str.replaceAll("coachella","Chelsea");
                        str=str.replaceAll("coachella2015","Chelsea2015");
                        str=str.replaceAll("tweets","");
                   String sp[]=str.split(" ");
                   for(int i=0;i<sp.length;i++){
                       if(sp[i].contains("#")){
                           System.out.println(sp[i]);
                           summary.add(str);
                           break;
                        }
                   }
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
                //Logger.getLogger(Cluster.class.getName()).log(Level.SEVERE, null, ex);
            }
            return summary;
        }
	public void plotCluster() {
		System.out.println("[Cluster: " + id+"]");
		System.out.println("[Centroid: " + centroid + "]");
		System.out.println("[Points: \n");
		for(Object p : points) {
			System.out.println(p);
		}
		System.out.println("]");
	}

}
