package HWEx7;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PARTTIME")
public class ParttimeEmployee extends AbstactEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    private int hoursWork;

    public int getHoursWork() {
        return hoursWork;
    }

    public void setHoursWork(int hoursWork) {
        this.hoursWork = hoursWork;
    }
}
