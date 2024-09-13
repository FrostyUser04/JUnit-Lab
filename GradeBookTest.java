import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp() throws Exception {
        // Initialize two GradeBook objects of size 5
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        // Add scores to both GradeBook objects
        g1.addScore(50);
        g1.addScore(75);

        g2.addScore(60);
        g2.addScore(80);
        g2.addScore(90);
    }

    @After
    public void tearDown() throws Exception {
        // Set GradeBook objects to null
        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {
        // Test if the scores were added correctly and if the toString method works
        assertTrue(g1.toString().equals("50.0 75.0 "));
        assertTrue(g2.toString().equals("60.0 80.0 90.0 "));
        
        // Test if the scoreSize is as expected
        assertEquals(2, g1.getScoreSize());
        assertEquals(3, g2.getScoreSize());
    }

    @Test
    public void testSum() {
        // Test the sum of scores for both GradeBook objects
        assertEquals(125, g1.sum(), .0001);
        assertEquals(230, g2.sum(), .0001);
    }

    @Test
    public void testMinimum() {
        // Test the minimum score in both GradeBook objects
        assertEquals(50, g1.minimum(), .001);
        assertEquals(60, g2.minimum(), .001);
    }

    @Test
    public void testFinalScore() {
        // Test the final score (sum minus the minimum) in both GradeBook objects
        assertEquals(75, g1.finalScore(), .0001); // Final score after dropping the lowest score (50)
        assertEquals(170, g2.finalScore(), .0001); // Final score after dropping the lowest score (60)
    }
}
