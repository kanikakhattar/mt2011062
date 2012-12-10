package org.iiitb.exam.mt2011062.tours.database;

import java.sql.*;


public class ConnectMySql {
	//Connection con = null;
    //Statement stmt = null;
    static String database = "Tours";
    static String user = "root";
    static String pword = "";
	public ConnectMySql(){
	}
	public static Connection getConnection(){
		Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String ConnectionString = "jdbc:mysql://localhost:3306/" +database;
            con = DriverManager.getConnection(ConnectionString,user,pword);
        }catch(SQLException SQLEx) {
            System.out.println("MySQL error: "+SQLEx.getErrorCode()+
                  " SQLSTATE:" +SQLEx.getSQLState());
            System.out.println(SQLEx.getMessage());
        }catch(Exception ex){
        	System.out.println("Exception in getconnection()");
            ex.getStackTrace();
        }
        return con;
	}
	
	public static void close(Connection connection) {
		// return;
		if (connection == null) {
			return;
		}
		try {
			if (connection.isClosed()) {
				connection = null;
			} else {
				try {
					connection.close();
				//	MyLog.log("closing a conn; total conn:" + activeConnections);
					connection = null;
				} catch (SQLException ex) {
					//MyLog.myCatch("/java", 106, ex);
				}
			}
		} catch (SQLException ex) {
			//MyLog.myCatch("/java", 110, ex);
		}
	}
	
	public static ResultSet executeQuery(String query){
		
		ResultSet result = null;
		Connection con = getConnection();
		if(con == null) return result;
		try {
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
		
	}
	
	public static int FunctionCall(String FunCallArg)
	{
		int status=0;
		Connection con = null;
		try{
			con = getConnection();
			if(con == null) return 0;
			CallableStatement PreparedFunc = con.prepareCall(FunCallArg);
			PreparedFunc.registerOutParameter(1, Types.INTEGER); 
			ResultSet rs = PreparedFunc.executeQuery();
			rs.next();
			status = rs.getInt(1);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return status;
	}
	
    public static int update(String sql) {
		System.out.println("Inside db update");
		Connection con = null;
		Statement stmt;
		try{
			con = getConnection();
			System.out.println("Connection: " + con);
			
			stmt = con.createStatement();
			System.out.println("Executing: "+sql);
			stmt.executeUpdate(sql);
		
			System.out.println("Added");
			
			stmt.close();
			close(con);
			
			return 1;
		
		}catch(Exception ex){
		
			System.out.println("ERROR aa gya: ");
			ex.getStackTrace();
			return -1;
		}
	}
    
    public static int UpdateQuery(String query)
    {
    	 Statement stm ;
         ResultSet rs;
         int result = -1;
         Connection conn = null;
         
         try
         {
                 if(conn == null)
                 {
                         getConnection();
                         
                 }
                 
                 stm = conn.createStatement();
                 stm.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
                 rs =stm.getGeneratedKeys();
                 if(rs.next()){
                         result = rs.getInt(1);
                 }                        
                 
                 return result;
                 
         }
         catch(Exception e){
                                 
                 e.printStackTrace();                
         }
         
         return -1;
         
 }


    }



