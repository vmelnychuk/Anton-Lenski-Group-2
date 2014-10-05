import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Vasyl_Melnychuk on 10/3/2014.
 */
public class Feature1 implements Feature {
static {
    // log time for class loading
    System.out.println("load Feature1 " + new Timestamp(new Date().getTime()));
}
    @Override
    public void execute() {
        System.out.println("Feature 1: is executing");
    }
}
