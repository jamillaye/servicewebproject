/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IPersonne;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Personne;

/**
 *
 * @author jams9
 */
public class PersonneDB implements IPersonne{
    private Db db;
	private int ok; 
	private ResultSet rs;
	private boolean trouve;
	
	public PersonneDB() {
		db = new Db();

	}
        
        public int addP(Personne p) {
		String sql = "INSERT INTO personne VALUES(null,?,?,?,?)";
		
		try {
			db.initPrepare(sql);
			db.getPstmt().setString(1, p.getNom());
			db.getPstmt().setString(2, p.getPrenom());
                        db.getPstmt().setString(3, p.getAdresse());
                        db.getPstmt().setString(4, p.getTel());
			ok = db.executeMaj();
			rs = db.getPstmt().getGeneratedKeys();
			while(rs.next()) {
				ok = rs.getInt(1);
			}
			rs.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
        
        public List<Personne> liste(){
		// TODO Auto-generated method stub
		List<Personne> liste = new ArrayList<Personne>();
                Personne p = null;
		String sql="SELECT * FROM personne";
		db.initPrepare(sql);
		db.getPstmt();
		rs=db.executeSELECT();
		try {
			while(rs.next()) {
                                p =new Personne();
				p.setId(Integer.parseInt(rs.getString("id")));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
                                p.setAdresse(rs.getString("adresse"));
                                p.setTel(rs.getString("tel"));
                                //String s = new String(p.getId(),p.getPrenom(),p.getPrenom());
                                
//                                liste.add(rs.getString("id"));
//                                liste.add(p.getNom());
//                                liste.add(p.getPrenom());
                                liste.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
		
	}
        
        public boolean deletePers(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql="DELETE FROM personne WHERE id=?";
		trouve=false;
		try {
			db.initPrepare(sql);
			db.getPstmt().setInt(1, id);
			ok = db.executeMaj();
			if(ok!=0) {
				trouve=true;
			}
		} catch (Exception e) {
			trouve = false;
			e.printStackTrace();
		}
		return trouve;
	}
	
         public int updateP(Personne p) {
		String sql = "UPDATE personne set nom = ?, prenom = ?,adresse= ?,tel= ? WHERE id= ?";
                ok= 0;
		try {
			db.initPrepare(sql);
			db.getPstmt().setString(1, p.getNom());
			db.getPstmt().setString(2, p.getPrenom());
                        db.getPstmt().setString(3, p.getAdresse());
                        db.getPstmt().setString(4, p.getTel());
                        db.getPstmt().setInt(5, p.getId());
			ok = db.executeMaj();
			rs = db.getPstmt().getGeneratedKeys();
			ok= db.executeMaj();
			rs.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
}
