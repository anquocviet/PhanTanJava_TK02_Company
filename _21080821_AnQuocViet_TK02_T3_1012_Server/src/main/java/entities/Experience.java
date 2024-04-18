package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "experiences")
@Entity
public class Experience {
   @ManyToOne
   @JoinColumn(name = "position_id")
   private Position position;

   @ManyToOne
   @JoinColumn(name = "candidate_id")
   private Candidate candidate;

   @Id
   @Column(name = "company_name")
   private String companyName;

   @Column(name = "from_date")
   private LocalDate fromDate;

   @Column(name = "to_date")
   private LocalDate toDate;

   private String description;

   public Experience(Position position, Candidate candidate, String companyName, LocalDate fromDate, LocalDate toDate, String description) {
      this.position = position;
      this.candidate = candidate;
      this.companyName = companyName;
      this.fromDate = fromDate;
      this.toDate = toDate;
      this.description = description;
   }
}