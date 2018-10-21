package pl.sda.evennumbertest;

class EvenNumber {
    private final int number;

    EvenNumber(int number) throws NotEvenNumberException{
        if(isOdd(number)){
            throw new NotEvenNumberException();
        }
        this.number = number;
    }

    boolean isEven() {
        return number % 2 == 0;
    }

    boolean isOdd(int number){
        return number % 2 != 0;
    }
}