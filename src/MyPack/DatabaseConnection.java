package MyPack;
//package Name
//------------------------------------------------------------------------------
import java.sql.*;
//------------------------------------------------------------------------------
 
//------------------------------------------------------------------------------
public class DatabaseConnection{
private static Connection conConnection=null; //database connection
private static Statement stStatement=null;    //Statement object
private static ResultSet rsResultSet=null;    //Resultset object

static String strDriver ="org.gjt.mm.mysql.Driver";
static String strDatabaseName = "jdbc:mysql://localhost:3306/webrecommend";
static String strUname = "root";//"root";
static String strPassword="";// "root";
//------------------------------------------------------------------------------
/**
*	@param strDriver Driver Name
*  @param strDatabaseName Databse Name or DSN name
*  @param strUname User name for databse
*	@param strPassword Password for database
*	@return boolean on success true else false
*  It set & initilise the database Connection
*/
	public static boolean setConnection(String strDriver, String strDatabaseName, String strUname, String strPassword){
		boolean boolFlag=false;
		try {
					Class.forName(strDriver).newInstance();
					conConnection=DriverManager.getConnection(strDatabaseName, strUname, strPassword);
					stStatement = conConnection.createStatement();
					boolFlag=true;
		}
		catch (Exception ex) {
			//ex.printStackTrace();
		}
		return boolFlag;
	}
//------------------------------------------------------------------------------

public static boolean setConnection(){
		boolean boolFlag=false;
		try {
					Class.forName(strDriver).newInstance();
					conConnection=DriverManager.getConnection(strDatabaseName, strUname, strPassword);
					stStatement = conConnection.createStatement();
					boolFlag=true;
		}
		catch (Exception ex) {
			//ex.printStackTrace();
		}
		return boolFlag;
	}
/**
* @param query It takes the string as query
* @return It retuen the ResultSet object
* It set the Connection object
*/
	public static ResultSet executeQuery(String query){
		try {
					if(stStatement==null){
						setConnection();
					stStatement = conConnection.createStatement();
					}
					rsResultSet = stStatement.executeQuery(query);
		}
		catch (Exception ex) {
					 ex.printStackTrace();
		}
		return rsResultSet;
	}
//------------------------------------------------------------------------------
/**
* @param query It takes the string as query
* @return It retuen the ResultSet object
* It set the Connection object
*/
	public static int executeUpdate(String query){
		int iflag=0;
		try {
					if(stStatement==null){
						setConnection();
					stStatement = conConnection.createStatement();
					}
					iflag = stStatement.executeUpdate(query);
		}
		catch (Exception ex) {
				//	ex.printStackTrace();
		}
		return iflag;
	}
//------------------------------------------------------------------------------
/**
*	This method is used to close the database conection
*/
	public static void closeConnection(){
		try {
					stStatement.close();
					conConnection.close();
		}
		catch (Exception ex) {
				//	ex.printStackTrace();
		}
	}
//------------------------------------------------------------------------------
	public static boolean isConnected(){
		if(conConnection==null)
		return false;
		else return true;
	}
//------------------------------------------------------------------------------
	public static void setAutoCommitFalse(){
		try{
					conConnection.setAutoCommit(false);
		}
		catch(Exception e){
				//	e.printStackTrace();
		}
	}
//------------------------------------------------------------------------------
	public static void setAutoCommitTrue(){
		try{
					conConnection.setAutoCommit(true);
		}
		catch(Exception e){
				//	e.printStackTrace();
		}
	}
//------------------------------------------------------------------------------
	public static void commit(){
		try{
					conConnection.commit();
		}
		catch(Exception e){
				//	e.printStackTrace();
		}
	}
}