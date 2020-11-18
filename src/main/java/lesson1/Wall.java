package lesson1;

public class Wall extends Obstacles{
    private float height;

    public Wall(float height) {
        this.height = height;
    }


    @Override
    public void overcome(Movement movement) {
        movement.jump(height);
    }
}
