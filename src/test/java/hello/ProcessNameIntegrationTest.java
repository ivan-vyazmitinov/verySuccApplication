package hello;

import com.succApplication.entities.Sucker;
import com.succApplication.services.DefaultSuccService;
import com.succApplication.services.SuccService;
import org.junit.Test;

public class ProcessNameIntegrationTest {

    @Test
    public void testGettingSuck() {
        SuccService cc = new DefaultSuccService();

        Sucker sucker = new Sucker("Antoneh", false);
        Sucker sucker2 = cc.processSuccName("Antoneh");

        assert sucker.equals(sucker2);
    }
}
