package interfaces;


import java.util.List;
import model.Personne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jams9
 */
public interface IPersonne {
    public int addP(Personne p);
     public int updateP(Personne p);
    public List<Personne> liste();
    public boolean deletePers(int id) throws Exception ;
}
