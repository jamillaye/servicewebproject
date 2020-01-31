
package service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "crudService", targetNamespace = "http://service.crud.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CrudService {


    /**
     * 
     * @param adresse
     * @param tel
     * @param nom
     * @param prenom
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://service.crud.com/", className = "service.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://service.crud.com/", className = "service.AddResponse")
    @Action(input = "http://service.crud.com/crudService/addRequest", output = "http://service.crud.com/crudService/addResponse")
    public String add(
        @WebParam(name = "nom", targetNamespace = "")
        String nom,
        @WebParam(name = "prenom", targetNamespace = "")
        String prenom,
        @WebParam(name = "adresse", targetNamespace = "")
        String adresse,
        @WebParam(name = "tel", targetNamespace = "")
        String tel);

    /**
     * 
     * @param adresse
     * @param tel
     * @param id
     * @param nom
     * @param prenom
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "update", targetNamespace = "http://service.crud.com/", className = "service.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://service.crud.com/", className = "service.UpdateResponse")
    @Action(input = "http://service.crud.com/crudService/updateRequest", output = "http://service.crud.com/crudService/updateResponse")
    public String update(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "nom", targetNamespace = "")
        String nom,
        @WebParam(name = "prenom", targetNamespace = "")
        String prenom,
        @WebParam(name = "adresse", targetNamespace = "")
        String adresse,
        @WebParam(name = "tel", targetNamespace = "")
        String tel);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delete", targetNamespace = "http://service.crud.com/", className = "service.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://service.crud.com/", className = "service.DeleteResponse")
    @Action(input = "http://service.crud.com/crudService/deleteRequest", output = "http://service.crud.com/crudService/deleteResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://service.crud.com/crudService/delete/Fault/Exception")
    })
    public String delete(
        @WebParam(name = "id", targetNamespace = "")
        int id)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<service.Personne>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "liste", targetNamespace = "http://service.crud.com/", className = "service.Liste")
    @ResponseWrapper(localName = "listeResponse", targetNamespace = "http://service.crud.com/", className = "service.ListeResponse")
    @Action(input = "http://service.crud.com/crudService/listeRequest", output = "http://service.crud.com/crudService/listeResponse")
    public List<Personne> liste();

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://service.crud.com/", className = "service.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://service.crud.com/", className = "service.HelloResponse")
    @Action(input = "http://service.crud.com/crudService/helloRequest", output = "http://service.crud.com/crudService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}