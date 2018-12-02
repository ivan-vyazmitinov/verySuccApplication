package MongoIntegration;

import com.succApplication.repositories.DefaultContextRepository;
import org.junit.Test;

public class GetContextsTest {

    @Test
    public void testGettingSuck() {
        DefaultContextRepository repo = new DefaultContextRepository();
        repo.getContexts();
    }
}
