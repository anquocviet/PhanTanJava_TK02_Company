package dao;

import entities.Position;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public interface PositionService extends Remote {
   public List<Position> listPositions(String name, double salaryFrom, double salaryTo) throws RemoteException;
}
