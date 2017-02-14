/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dto.ClientDTO;
import dto.ContDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import service.MonitorService;

/**
 *
 * @author Israel Dago
 */
@WebService(serviceName = "MonitorWS")
@Stateless()
public class MonitorWS {

    @EJB
    private MonitorService ejbRef;

    @WebMethod(operationName = "allClienti")
    public List<ClientDTO> allClienti() {
        return ejbRef.allClienti();
    }
    
    @WebMethod(operationName = "allAccounts")
    public List<ContDTO> allAccounts() {
        return ejbRef.allAccounts();
    }
    
    
    
}
