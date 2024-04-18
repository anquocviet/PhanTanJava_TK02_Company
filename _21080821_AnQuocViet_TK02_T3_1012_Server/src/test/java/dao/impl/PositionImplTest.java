package dao.impl;

import dao.PositionService;
import entities.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PositionImplTest {
   PositionService positionService = null;

   @BeforeEach
   void setUp() throws RemoteException {
      positionService = new PositionImpl();
   }

   @AfterEach
   void tearDown() {
      positionService = null;
   }

   @Test
   void listPositions() throws RemoteException {
      List<Position> positions = positionService.listPositions("Software", 40000, 90000);
      assertEquals(2, positions.size());
      positions.forEach(System.out::println);
   }
}