package lesson1;

public class Robot implements Movement{

    private String name;
    private int runDistance;
    private float jumpHeight;
    private boolean active;

    public Robot(String name, int runDistance, float jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        active = true;
    }

    @Override
    public void run(int distance) {
        if(distance <= runDistance)
            System.out.println(name + " ran " + distance + " meters");
        else {
            System.out.println(name + " cannot ran this distance");
            active = false;
        }
    }

    @Override
    public void jump(float height) {
        if(height <= jumpHeight)
            System.out.println(name + " jumped " + height + " meters");
        else {
            System.out.println(name + " cannot jump such a height");
            active = false;
        }
    }

    @Override
    public boolean active() {
        return active;
    }
}