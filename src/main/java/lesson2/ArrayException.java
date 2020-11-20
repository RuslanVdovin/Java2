package lesson2;

public class ArrayException {

    public static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;
        int value = 0;

        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (IllegalArgumentException e) {
                    String message = "Некорректные данные, в " + i + " ряду, " + j + " ячейке";
                    throw new MyArrayDataException(message);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int result = 0;

        String[][] array = {{"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}};
        String[][] array1 = {{"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}};
        String[][] array2 = {{"1","1","1","1"}, {"1","1","1","1"}, {"1","k","1","1"}, {"1","1","1","1"}};

        try {
            result = checkArray(array);
        } catch(MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат суммирования элементов массива равна " + result);
        }

        try {
            result = 0;
            result = checkArray(array1);
        } catch(MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат суммирования элементов массива равна " + result);
        }

        try {
            result = 0;
            result = checkArray(array2);
        } catch(MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат суммирования элементов массива равна " + result);
        }
    }
}
