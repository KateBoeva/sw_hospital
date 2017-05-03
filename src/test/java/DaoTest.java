import org.junit.Test;
import ru.itis.sw.hospital.dao.UserDataSecurityImpl;
import ru.itis.sw.hospital.repository.UserDataSecurity;
import static org.junit.Assert.*;

public class DaoTest {

    @Test
    public void testIsEmpty() throws Exception {
        UserDataSecurity security = new UserDataSecurityImpl();
        assertTrue(security.isEmpty(""));
    }

    @Test
    public void testIsNotEmpty() throws Exception {
        UserDataSecurity security = new UserDataSecurityImpl();
        assertFalse(security.isEmpty("1"));
    }
}
