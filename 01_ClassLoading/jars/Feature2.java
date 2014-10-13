import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Vasyl_Melnychuk on 10/3/2014.
 */

public class Feature2 implements Feature {
    static {
        // log time for class loading
        System.out.println("load Feature2 " + new Timestamp(new Date().getTime()));
		
    }
    @Override
    public void execute() {
        System.out.println("Feature 2: is executing");
    }
}