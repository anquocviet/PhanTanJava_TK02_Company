package fit.se;

import dao.CandidateService;

import java.rmi.Naming;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   private static final String URL = "rmi://VIE:8080/CompanyService/";

   public static void main(String[] args) {
      try {
         CandidateService candidateService = (CandidateService) Naming.lookup(URL + "CandidateService");
         candidateService.listCadidatesByCompanies().forEach((k, v) -> {
            System.out.println(k.getFullName() + " : " + v);
         });
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}