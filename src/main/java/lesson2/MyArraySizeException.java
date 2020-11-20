package lesson2;

public class MyArraySizeException extends RuntimeException{

    public MyArraySizeException() {

        super("Массив должен быть размером 4х4!");
    }
}

