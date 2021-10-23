package HWEx7;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FULLTIME")
public class FulltimeEmployee extends AbstactEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    private int Salary;

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
}
