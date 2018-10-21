package pl.sda.evennumbertest;

class EvenNumber {
    private final int number;

    EvenNumber(int number) {
        this.number = number;
    }

    boolean isEven() {
        return number % 2 == 0;
    }
}
