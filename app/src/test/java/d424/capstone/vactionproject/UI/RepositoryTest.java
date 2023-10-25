package d424.capstone.vactionproject.UI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import d424.capstone.vactionproject.entities.Vacation;

import org.junit.Before;
import org.junit.Test;


public class RepositoryTest {
    private FakeRepository fakeRepository;

    @Before
    public void setup() {
        fakeRepository = new FakeRepository();
    }

    @Test
    public void testAddDataToFakeRepository() {
        // Define some test data
        Vacation vacation = new Vacation(1, "Summer Vacation", "Beach House", "2023-07-15", "2023-07-30");

        // Add the test data to the fake repository
        fakeRepository.insert(vacation);

        // Retrieve the data from the fake repository
        Vacation retrievedVacation = fakeRepository.getVacationByID(vacation.getVacationID());

        // Log the retrieved vacation for debugging
        System.out.println("Retrieved Vacation: " + retrievedVacation);

        // Assert that the data was added and retrieved correctly
        assertNotNull(retrievedVacation);
        assertEquals(vacation.getVacationID(), retrievedVacation.getVacationID());
        // You can add more detailed assertions here based on your data structure
    }
}