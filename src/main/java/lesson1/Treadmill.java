package lesson1;

public class Treadmill extends Obstacles{
   private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public void overcome(Movement movement) {
        movement.run(distance);
    }
}
