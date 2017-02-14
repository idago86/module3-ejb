/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ClientMonitorDao;
import dao.ContMonitorDao;
import dto.ClientDTO;
import dto.ContDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Israel Dago
 */
@Stateless
@LocalBean
public class MonitorService {

    @EJB
    private ClientMonitorDao clientDao;
    @EJB
    private ContMonitorDao contDao;

    public List<ClientDTO> allClienti() {
        return clientDao.findAll().isEmpty() ? new ArrayList<>() : clientDao.findAll().stream()
                .map(c -> new ClientDTO(c.getId(), c.getNume(), c.getPrenume(), c.getCnp()))
                .collect(Collectors.toList());
    }

    public List<ContDTO> allAccounts() {
        return contDao.findAll().isEmpty() ? new ArrayList<>() : contDao.findAll().stream()
                .map(c -> new ContDTO(c.getId(), c.getIban(), c.getDescriere(),
                        c.getSold(), c.getCreationDate(), c.getActive(),
                        new ClientDTO(c.getClient().getId(), c.getClient().getNume(),
                                c.getClient().getPrenume(), c.getClient().getCnp())))
                .collect(Collectors.toList());        
    }

}
