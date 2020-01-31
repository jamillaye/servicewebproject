package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Db {
	private Connection cnx;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private int ok;
	
	public void getConnexion() {
		String url="jdbc:mysql://localhost:3306/webservices";
		String user="root";
		String password="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initPrepare(String sql) {
		getConnexion();
		try {
			if(sql.toLowerCase().startsWith("insert")) {
				pstmt = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}else {
				pstmt = cnx.prepareStatement(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int executeMaj() {
		try {
			ok = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	public ResultSet executeSELECT() {
		try {
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public PreparedStatement getPstmt() {
		return this.pstmt; 
	}
	public void closeconnexion() {
		try {
			if(cnx!=null)
			{
				cnx.close();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	public void beginTransaction() throws Exception
    {
        try {
            cnx.setAutoCommit(false);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void endTransaction() throws Exception
    {
        try {
            cnx.setAutoCommit(true);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void myCommit() throws Exception
    {
        try {
            cnx.commit();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void myRollback() throws Exception
    {
        try {
            cnx.rollback();
        } catch (Exception e) {
            throw e;
        }
    }

}
