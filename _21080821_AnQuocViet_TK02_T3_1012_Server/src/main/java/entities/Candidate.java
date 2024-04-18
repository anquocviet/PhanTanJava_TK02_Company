package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "candidates")
@NamedQueries({
      @NamedQuery(name = "Candidate.findByCompany",
            query = "SELECT c, COUNT(e) FROM Candidate c JOIN c.experiences e GROUP BY c"),
      @NamedQuery(name = "Candidate.findLongestWorking",
            query = "SELECT c, p FROM Candidate c JOIN c.experiences e JOIN e.position p ORDER BY e.toDate - e.fromDate DESC"),
})
public class Candidate implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "candidate_id")
   private String id;

   @Column(name = "full_name")
   private String fullName;

   @Column(name = "year_of_birthday")
   private int yearOfBirthday;

   private String gender;

   private String email;

   private String phone;

   private String description;

   public Candidate(String id, String fullName, int yearOfBirthday, String gender, String email, String phone, String description) {
      this.id = id;
      this.fullName = fullName;
      this.yearOfBirthday = yearOfBirthday;
      this.gender = gender;
      this.email = email;
      this.phone = phone;
      this.description = description;
   }

   @ManyToOne
   @JoinColumn(name = "position_id")
   private Position position;

   @OneToMany(mappedBy = "candidate")
   @ToString.Exclude
   private Set<Experience> experiences;

   @OneToMany(mappedBy = "candidate")
   @ToString.Exclude
   private Set<Certificate> certificates;
}