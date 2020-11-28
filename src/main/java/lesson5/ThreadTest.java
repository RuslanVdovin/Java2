package lesson5;

import java.util.Arrays;

public class ThreadTest{

    static final int size = 10000000;
    static final int h = size / 2;

    private void firstMethod() {

        float[] arr = new float[size];
        Arrays.fill(arr, 1f);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end1 = System.currentTimeMillis();
        System.out.printf("Время выполнения первого метода: %d", (end1 - start1));
    }

    private void secondMethod() {

        float[] arr = new float[size];
        Arrays.fill(arr, 1f);

        float[]arr1 = new float[h];
        float[] arr2 = new float[h];
        long start2 = System.currentTimeMillis();

        System.arraycopy(arr, 0,arr1,0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread thread1 = new Thread(() -> { calculated(arr1, 1);
        });
        Thread thread2 = new Thread(() -> {calculated(arr2, 2);
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long end2 = System.currentTimeMillis();

        System.out.printf("\nВремя выполнения второго метода: %d", (end2 - start2));
    }

    private void calculated(float[] arr, int number){
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.printf("\nВремя выполнения потока %d равно %s", number, (end - start));
    }

    public static void main(String[] args) {

        ThreadTest test = new ThreadTest();

        test.firstMethod();
        test.secondMethod();

    }
}
