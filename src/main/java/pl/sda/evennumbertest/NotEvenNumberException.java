package pl.sda.evennumbertest;

class NotEvenNumberException extends RuntimeException {
    NotEvenNumberException(int number) {
        super("Given number is not even: " + number);
    }
}
