package dao.impl;

import dao.CandidateService;
import entities.Candidate;
import entities.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public class CandidateImpl extends UnicastRemoteObject implements CandidateService {
   EntityManager em = null;

   public CandidateImpl() throws RemoteException {
      em = Persistence.createEntityManagerFactory("MariaDB Company").createEntityManager();
   }

   @Override
   public Map<Candidate, Long> listCadidatesByCompanies() throws RemoteException {
      return em.createNamedQuery("Candidate.findByCompany", Object[].class)
                   .getResultStream()
                   .collect(Collectors.toMap(
                         o -> (Candidate) o[0],
                         o -> (Long) o[1]
                   ));
   }

   @Override
   public Map<Candidate, Position> listCandidatesWithLongestWorking() throws RemoteException {
      return em.createNamedQuery("Candidate.findLongestWorking", Object[].class)
                   .getResultStream()
                   .collect(Collectors.toMap(
                         o -> (Candidate) o[0],
                         o -> (Position) o[1],
                         (a, b) -> a,
                         LinkedHashMap::new
                   ));
   }
}
