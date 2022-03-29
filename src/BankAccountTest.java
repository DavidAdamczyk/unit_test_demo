import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {
    BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        this.bankAccount = new BankAccount("David", 100);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void withdraw() {
        bankAccount.withdraw(10);
        assertEquals(90, bankAccount.getBalance());
    }

    @Test
    void withdrawThrowException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
                bankAccount.withdraw(110);
            }, "IllegalArgumentException error was expected");

        assertEquals("Withdrawal exceeds balance!", thrown.getMessage());
    }
}