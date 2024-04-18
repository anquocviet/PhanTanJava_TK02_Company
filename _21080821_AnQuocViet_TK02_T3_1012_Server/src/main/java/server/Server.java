package server;

import dao.impl.CandidateImpl;
import dao.impl.PositionImpl;
import lombok.SneakyThrows;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public class Server {
   private static final String URL = "rmi://VIE:8080/CompanyService/";

   @SneakyThrows
   public static void main(String[] args) {
      Context context = new InitialContext();
      LocateRegistry.createRegistry(8080);

      context.bind(URL + "CandidateService", new CandidateImpl());
      context.bind(URL + "PositionService", new PositionImpl());

      System.out.println("Server is running...");
   }
}
