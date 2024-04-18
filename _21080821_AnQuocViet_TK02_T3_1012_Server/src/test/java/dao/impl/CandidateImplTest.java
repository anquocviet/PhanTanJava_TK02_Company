package dao.impl;

import dao.CandidateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class CandidateImplTest {
   CandidateService candidateService = null;

   @BeforeEach
   void setUp() throws RemoteException {
       candidateService = new CandidateImpl();
   }

   @AfterEach
   void tearDown() {
      candidateService = null;
   }

   @Test
   void listCadidatesByCompanies() throws RemoteException {
      candidateService.listCadidatesByCompanies().forEach((k, v) -> System.out.println(k.getFullName() + " : " + v));
   }

   @Test
   void listCandidatesWithLongestWorking() throws RemoteException {
      candidateService.listCandidatesWithLongestWorking().forEach((k, v) -> System.out.println(k.getFullName() + " : " + v.getName()));
   }
}