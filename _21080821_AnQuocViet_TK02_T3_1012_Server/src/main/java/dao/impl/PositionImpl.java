package dao.impl;

import dao.PositionService;
import entities.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public class PositionImpl extends UnicastRemoteObject implements PositionService {
   EntityManager em = null;

   public PositionImpl() throws RemoteException {
      em = Persistence.createEntityManagerFactory("MariaDB Company").createEntityManager();
   }

   @Override
   public List<Position> listPositions(String name, double salaryFrom, double salaryTo) throws RemoteException {
      return em.createNamedQuery("Position.findByNameAndSalary", Position.class)
                   .setParameter("name", "%" + name + "%")
                   .setParameter("salaryFrom", salaryFrom)
                   .setParameter("salaryTo", salaryTo)
                   .getResultList();
   }
}
