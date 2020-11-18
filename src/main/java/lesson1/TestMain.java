package lesson1;

public class TestMain {

    public static void main(String[] args) {

        Movement[] human = {new Human("Bob", 1000, 1.4f),
                new Human("Rob", 3000, 1.8f),
                new Human("Kirk", 4500, 2.2f)};

        Movement[] robot = {new Robot("R2D2", 5000, 1.3f),
                new Robot("C-3PO", 2000, 2.5f),
                new Robot("T-1000", 10000, 20f)};

        Movement[] animal = {new Animal("Cat", 2000, 3.5f),
                new Animal("Dog", 5000, 1.5f),
                new Animal("Raccoon", 3000, 2.2f)};

        Obstacles[] obstacles = {new Treadmill(1500), new Wall(1.2f),
                new Treadmill(2000), new Wall(2.1f)};

        Team humans = new Team("Humans", human);
        Team robots = new Team("Robots", robot);
        Team animals = new Team("Animals", animal);

        Course course = new Course(obstacles);

        System.out.println("Team humans goes to course");
        course.overcome(humans);

        System.out.println("\n Team robots goes to course");
        course.overcome(robots);

        System.out.println("\n Team animals goes to course");
        course.overcome(animals);
    }
}
