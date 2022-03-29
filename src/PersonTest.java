import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * https://webdev.zaujimave.info/generator-rodneho-cisla/
 */
class PersonTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ageIsOKBefore2K() {
        Person person = new Person("Jmeno Prijmeni", "210101001");
        assertEquals(101, person.getAge());
    }

    @Test
    void ageIsOKBefore2kWithSlash() {
        Person person = new Person("Jmeno Prijmeni", "210101/001");
        assertEquals(101, person.getAge());
    }

    @Test
    void ageIsOkAfter2K() {
        Person person = new Person("Jmeno Prijmeni", "2101010010");
        assertEquals(1, person.getAge());
    }

    @Test
    void ageIsOkAfter2kWithSlash() {
        Person person = new Person("Jmeno Prijmeni", "210101/0010");
        assertEquals(1, person.getAge());
    }

    @Test
    void idIsNotValid() {
        Person person = new Person("Jmeno Prijmeni", "210101/0019");
        assertFalse(person.isIdNumberValid());
    }

    @Test
    void idIsValid() {
        Person person = new Person("Jmeno Prijmeni", "210101/0010");
        assertTrue(person.isIdNumberValid());
    }



    @Test
    void discountForSeniorIsValid() {
        Person person = new Person("Jmeno Prijmeni", "526008022");
        person.assignDiscount(Discount.DiscountType.SENIOR);
        assertEquals(Discount.DiscountType.SENIOR, person.getDiscount());
    }

    @Test
    void discountForSeniorIsNotValid() {
        Person person = new Person("Jmeno Prijmeni", "526008022");

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            person.assignDiscount(Discount.DiscountType.STUDENT);;
        }, "IllegalArgumentException error was expected");

        assertEquals("Cannot use discount!", thrown.getMessage());
    }

    /*
     * Studentovi muze byt prirazen DiscountType.Student + kontrola na věk
     * Studentovi nemuze byt prirazen DiscountType.Senior + kontrola na věk, je ocekavana vyjimka
     * Komukoliv muze byt prirazen DiscountType.NONE
     * Nove vytvoreny objekt Person ma nastaveen DiscountType.NONE
     */

}