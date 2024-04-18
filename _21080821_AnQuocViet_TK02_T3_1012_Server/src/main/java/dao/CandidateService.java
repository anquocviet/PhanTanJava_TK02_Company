package dao;

import entities.Candidate;
import entities.Position;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface CandidateService extends Remote {
   public Map<Candidate, Long> listCadidatesByCompanies() throws RemoteException;
   public Map<Candidate, Position> listCandidatesWithLongestWorking() throws RemoteException;
}
