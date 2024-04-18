package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "positions")
@NamedQueries({
      @NamedQuery(name = "Position.findByNameAndSalary",
            query = "SELECT p FROM Position p WHERE p.name LIKE :name AND p.salary BETWEEN :salaryFrom AND :salaryTo")
})
public class Position implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "position_id")
   private String id;

   private String name;

   private String description;

   private double salary;

   private int number;

   @OneToMany(mappedBy = "position")
   @ToString.Exclude
   private Set<Candidate> candidates;

   @OneToMany(mappedBy = "position")
   @ToString.Exclude
   private Set<Experience> experiences;

   public Position(String id, String name, String description, double salary, int number) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.salary = salary;
      this.number = number;
   }
}