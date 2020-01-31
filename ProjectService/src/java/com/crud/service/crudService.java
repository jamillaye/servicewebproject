/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.service;

import dao.CrudDAO;
import dao.PersonneDB;
import interfaces.IPersonne;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import model.Personne;

/**
 *
 * @author jams9
 */
@WebService(serviceName = "crudService")
public class crudService {
    
 

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "nom") String nom,@WebParam(name = "prenom") String prenom,@WebParam(name = "adresse") String adresse,@WebParam(name = "tel") String tel) {
        IPersonne ip = new PersonneDB();
        Personne personne = new Personne();
        personne.setNom(nom);
        personne.setPrenom(prenom);
        personne.setAdresse(adresse);
        personne.setTel(tel);
        ip.addP(personne);
        return "user added";
    }
     
    @WebMethod(operationName = "liste")
    public List<Personne> liste(){
        IPersonne ip = new PersonneDB();
        return ip.liste();
    }
    
     @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "id") int id) throws Exception {
        IPersonne ip = new PersonneDB();
        ip.deletePers(id);
        if(ip.deletePers(id)){
            System.out.println("ok");
        }
         System.out.println("ko");
        return "user deleted";
    }
    
    @WebMethod(operationName = "update")
    public String update(@WebParam(name = "id") int id,@WebParam(name = "nom") String nom,@WebParam(name = "prenom") String prenom,@WebParam(name = "adresse") String adresse,@WebParam(name = "tel") String tel){
        IPersonne ip = new PersonneDB();
        Personne p = new Personne();
        p.setId(id);
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setAdresse(adresse);
        p.setTel(tel);
        int ok=ip.updateP(p);
        if(ok>0){
            System.out.println("ok");
        }else{
            System.out.println("ko");
        }
        return "user updated";
    }
    
}
