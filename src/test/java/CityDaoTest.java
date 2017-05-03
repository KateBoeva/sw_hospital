import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.sw.hospital.dao.ArgumentsVerifierDaoImpl;
import ru.itis.sw.hospital.dao.CityDaoImpl;
import ru.itis.sw.hospital.repository.ArgumentsVerifierDao;
import ru.itis.sw.hospital.repository.CityDao;

import static org.junit.Assert.*;

public class CityDaoTest {

//    @Test
    public void testGetCity() throws Exception {
        CityDao cityDao = new CityDaoImpl();
        assertTrue(cityDao.getCity(2) != null);
    }

//    @Test
    public void testUnknownGetCity() throws Exception {
        CityDao cityDao = new CityDaoImpl();
        assertTrue(cityDao.getCity(-1) == null);
    }

//    @Test
    public void testGetCities() throws Exception {
        CityDao cityDao = new CityDaoImpl();
        assertTrue(cityDao.getCities().size() != 0);
    }
}
