package TrainsSystem;

import TrainsSystem.Exception.NoSuchRouteException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class InformationSystemTest {
    private InformationSystem informationSystem;

    @Before
    public void setUp() throws Exception {
        informationSystem = new InformationSystem("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
    }

    @Test
    public void test_should_return_distance_for_route_A_B_C() throws Exception {
        int distance = informationSystem.getDistanceForRoute("A-B-C");

        assertEquals(9,distance);
    }

    @Test
    public void test_should_return_distance_for_route_A_D() throws Exception {
        int distance = informationSystem.getDistanceForRoute("A-D");

        assertEquals(5,distance);
    }

    @Test
    public void test_should_return_distance_for_route_A_D_C() throws Exception {
        int distance = informationSystem.getDistanceForRoute("A-D-C");

        assertEquals(13,distance);
    }

    @Test
    public void test_should_return_distance_for_route_A_E_B_C_D() throws Exception {
        int distance = informationSystem.getDistanceForRoute("A-E-B-C-D");

        assertEquals(22,distance);
    }

    @Test(expected = NoSuchRouteException.class)
    public void test_should_return_distance_for_route_A_E_D() throws Exception {
        informationSystem.getDistanceForRoute("A-E-D");
    }

    @Test
    public void test_should_return_number_of_trips_within_maximum_stops() throws Exception {
        int numberOfTrips = informationSystem.getNumberOfTripsWithinMaxStops('C', 'C', 3);

        assertEquals(2,numberOfTrips);
    }
}
