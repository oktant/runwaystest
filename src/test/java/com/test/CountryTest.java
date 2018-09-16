package com.test;

import com.runways.RunwaysRunner;
import com.runways.exceptions.EmptyCodeOrNameException;
import com.runways.model.QueryTypeDao;
import com.runways.repositories.QueryRepository;
import com.runways.repositories.QueryRepositoryImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * CountryTest clss for testing application logic
 * @author oalizada
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RunwaysRunner.class)
public class CountryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;


    QueryRepository queryRepository;

    @Mock
    QueryRepository queryRepositoryMock;

    @Rule
    public ExpectedException thrownTest = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        queryRepository=new QueryRepositoryImpl(jdbcTemplate);
    }


    /**
     * getCountryAirportsAndRunwaysWithNullShouldThrowException test executes method with
     * null
     *
     *
     * @throws Exception
     */
    @Test
    public void getCountryAirportsAndRunwaysWithNullShouldThrowException() throws Exception {
        this.thrownTest.expect(EmptyCodeOrNameException.class);
        this.queryRepository.getQueryByCountryCodeOrName(null);
    }

    /**
     * getCountryAirportsAndRunwaysWithNullShouldThrowException test executes method with
     * emptyString
     *
     *
     * @throws Exception
     */
    @Test
    public void getCountryAirportsAndRunwaysWithEmptyStringShouldThrowException() throws Exception {
        this.thrownTest.expect(EmptyCodeOrNameException.class);
        this.queryRepository.getQueryByCountryCodeOrName("");
    }

    /**
     * getCountryAirportsAndRunwaysWithNullShouldThrowException test executes method with
     * String with Spaces
     *
     *
     * @throws Exception
     */

    @Test
    public void getCountryAirportsAndRunwaysWithStringSpacesShouldThrowException() throws Exception {
        this.thrownTest.expect(EmptyCodeOrNameException.class);
        this.queryRepository.getQueryByCountryCodeOrName("");
    }

    /**
     * getCountryAirportsAndRunwaysWithAndorra test executes method with
     * String with Andorra
     *
     *
     * @throws Exception
     */
    @Test
    public void getCountryAirportsAndRunwaysWithAndorra() throws Exception {

        QueryTypeDao expected = new QueryTypeDao("ANDORRA", "AD", "heliport", "Andorra la Vella Heliport",
                "42.5005", "1.51712", "3450", "Andorra La Vella",
                null, null, null);
        QueryTypeDao actual = queryRepository.getQueryByCountryCodeOrName("Andorra").get(0);

        assertEquals(expected, actual);
    }
    /**
     * getCountryAirportsAndRunwaysWithAnd test executes method with
     * String with And
     *
     *
     * @throws Exception
     */
    @Test
    public void getCountryAirportsAndRunwaysWithAnd() throws Exception {

        QueryTypeDao expected = new QueryTypeDao("ANDORRA", "AD", "heliport", "Andorra la Vella Heliport",
                "42.5005", "1.51712", "3450", "Andorra La Vella",
                null, null, null);
        QueryTypeDao actual = queryRepository.getQueryByCountryCodeOrName("Andorra").get(0);

        assertEquals(expected, actual);
    }

    /**
     * getCountryAirportsAndRunwaysWithAnd test executes method with
     * String with CX country Code
     *
     *
     * @throws Exception
     */
    @Test
    public void getCountryAirportsAndRunwaysWithCX() throws Exception {

        QueryTypeDao expected = new QueryTypeDao("CHRISTMAS ISLAND", "CX",
                "medium_airport", "Christmas Island Airport",
                "-10.4506", "105.69", "916", "Christmas Island",
                "ASP", "18", "0");
        QueryTypeDao actual = queryRepository.getQueryByCountryCodeOrName("CX").get(0);

        assertEquals(expected, actual);
    }

    /**
     * getCountryAirportsAndRunwaysWithAnd test executes method with
     * String with GM country Code
     *
     *
     * @throws Exception
     */
    @Test
    public void getCountryAirportsAndRunwaysWithGMMock() throws Exception {
        QueryTypeDao expected = new QueryTypeDao("GAMBIA", "GM",
                "medium_airport", "Banjul International Airport",
                "13.338", "-16.6522", "95", "Banjul",
                "ASP", "14", "0");
        List<QueryTypeDao> ex=new ArrayList<>();
        ex.add(expected);
        given(queryRepositoryMock.getQueryByCountryCodeOrName("GM")).willReturn(ex);
        QueryTypeDao expect=queryRepositoryMock.getQueryByCountryCodeOrName("GM").get(0);
        QueryTypeDao actual = queryRepository.getQueryByCountryCodeOrName("GM").get(0);

        assertEquals(expect, actual);
    }

    /**
     * getCountryAirportsAndRunwaysWithAnd test executes method with
     * String with AB country Code
     *
     * @throws Exception
     */
    @Test
    public void getCountryAirportAndRunwaysWithABMock() throws Exception{
        List<QueryTypeDao> ex=new ArrayList<>();
        given(queryRepositoryMock.getQueryByCountryCodeOrName("AB")).willReturn(ex);
        List<QueryTypeDao> expect=queryRepositoryMock.getQueryByCountryCodeOrName("AB");
        List<QueryTypeDao> actual = queryRepository.getQueryByCountryCodeOrName("AB");

        assertEquals(expect.size(), actual.size());
    }
    /**
     * getCountryAirportsAndRunwaysWithAnd test executes method with
     * String with AZ country Code
     *
     * @throws Exception
     */
    @Test
    public void getCountryAirportAndRunwaysWithAZMock() throws Exception{
        List<QueryTypeDao> stmock=mock(queryRepositoryMock.getQueryByCountryCodeOrName("AZ").getClass());
        given(stmock.size()).willReturn(37);
        int expect=stmock.size();
       int actual = queryRepository.getQueryByCountryCodeOrName("AZ").size();

        assertEquals(expect, actual);
    }

    /**
     * getCountryAirportsAndRunwaysWithUS test executes method with
     * String with AZ country Code
     *
     * @throws Exception
     */
    @Test
    public void getCountryAirportAndRunwaysWithUSMock() throws Exception{
        List<QueryTypeDao> stmock=mock(queryRepositoryMock.getQueryByCountryCodeOrName("US").getClass());
        given(stmock.size()).willReturn(25336);
        int expect=stmock.size();
        int actual = queryRepository.getQueryByCountryCodeOrName("US").size();

        assertEquals(expect, actual);
    }
}
