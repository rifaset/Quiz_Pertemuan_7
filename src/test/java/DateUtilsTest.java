import org.junit.jupiter.api.*;
import quiz.DateUtils;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class DateUtilsTest {
    public static DateUtils date;

    // before all BankAccount test
    @BeforeAll
    public static void init() {
        // nothing to do
        date = new DateUtils();
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each setup");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each setup");
    }

    @AfterAll
    public static void cleanUp() {
        date = null;
    }

    @Test
    public void testNotLeapYear() {
        Assertions.assertFalse(date.isLeapYear(2025));
    }

    @Test
    public void testLeapYear() {
        Assertions.assertTrue(date.isLeapYear(2024));
    }

    @Test
    public void testLeapYear100() {
        Assertions.assertTrue(date.isLeapYear(1800));
    }

    @Test
    public void testLeapYear400() {
        Assertions.assertTrue(date.isLeapYear(2000));
    }

    @Test
    public void testDaysInMonth() {
        Assertions.assertEquals(29, date.getDaysInMonth(2020, 2), "tanggal hanya kabisat");
        Assertions.assertEquals(30, date.getDaysInMonth(2024, 4));
    }
    @Test
    public void testDaysNotExist(){
        Assertions.assertEquals(29, date.getDaysInMonth(2021, 2), "tanggal hanya kabisat");
    }

}
