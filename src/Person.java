/*
 * identificationNumber je rodne cislo ve tvaru:
 * RRMMDD/XXX
 * RRMMDD/XXXX
 * RRMMDDXXX
 * RRMMDDXXXX
 */

public class Person {
    private String name;
    private String idNumber;
    private Discount.DiscountType discount;

    public Person(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public int getAge() {
        // Zjisti aktualni vek z rodneho cisla vuci dnesnimu datumu
        return -1;
    }

    public Discount.DiscountType getDiscount() {
        return this.discount;
    }

    public void assignDiscount(Discount.DiscountType type) {
        // Umozni nastavit discount na Senior, Student nebo None podle veku
        // Pokud nesedi vek vyhodi IllegalStateException
    }

    public boolean isIdNumberValid() {
        // Validuje rodne cislo vuci kontrolni cislici
        return false;
    }
}
