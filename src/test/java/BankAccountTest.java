import org.junit.jupiter.api.*;
import quiz.BankAccount;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class BankAccountTest {
    public static BankAccount account1;
    public static BankAccount account2;

    // before all BankAccount test
    @BeforeAll
    public static void init() {
        // nothing to do
        System.out.println("Before all BankAccount test");
    }

    @BeforeEach
    public void setUp() {
        // nothing to do
        account1 = new BankAccount("1", 1000000);
        account2 = new BankAccount("2", 200000);

        System.out.println("Saldo dalam akun sebelum test");
        System.out.println("Account 1: " + account1.getBalance());
        System.out.println("Account 2: " + account2.getBalance());
        System.out.println();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Saldo dalam akun sesudah test");
        System.out.println("Account 1: " + account1.getBalance());
        System.out.println("Account 2: " + account2.getBalance());
        account1 = null;
        account2 = null;
        System.out.println("After each setup");
    }

    @AfterAll
    public static void cleanUp() {
        account1 = null;
        account2 = null;
    }


    @Test
    public void testDeposit() {
        // deposit uang 50k ke account1
        account1.deposit(500000);
        Assertions.assertEquals(1500000, account1.getBalance());
    }

    @Test
    public void testDepositNegatif() {
        // deposit uang -50k ke account1
        account1.deposit(-500000);
        Assertions.assertEquals(1000000, account1.getBalance());
    }

    @Test
    public void testWithdraw() {
        // withdraw uang 50k dari account1
        account1.withdraw(499999.9);
        double nilai_uang = 1000000-499999.9;
        System.out.println(nilai_uang);
        Assertions.assertEquals(nilai_uang, account1.getBalance(), "hitungan seharusnya");
        Assertions.assertEquals(499000, account1.getBalance(), 2000, "toleransii 2000");

        //double actual = 5.99999;
        //Assertions.assertEquals(7, actual, 2);
    }
    @Test
    public void testInsufficientWithdraw() {
        // withdraw uang 1500k dari account1
        account1.withdraw(1500000);
        Assertions.assertEquals(-500000, account1.getBalance());
    }

    @Test
    public void testTransfer() {
        // transfer uang 50k dari account1 ke account2
        account1.transferFunds(account2, 500000);
        Assertions.assertEquals(500000, account1.getBalance());
        Assertions.assertEquals(700000, account2.getBalance());
    }

    @Test
    public void testInsufficientTransfer() {
        // transfer uang 1500k dari account1 ke account2
        account1.transferFunds(account2, 1500000);
        Assertions.assertEquals(500000, account1.getBalance());
        Assertions.assertEquals(700000, account2.getBalance());
    }

}
