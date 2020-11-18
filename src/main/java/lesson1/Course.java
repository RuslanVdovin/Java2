package lesson1;

public class Course {

    Obstacles[] obstacles;

    public Course(Obstacles[] obstacles){
        this.obstacles = obstacles;
    }

    public void overcome(Team team){
        Movement[] teamMembers = team.getMembers();
            for (Movement t: teamMembers){
                for (Obstacles obstacles: obstacles) {
                    obstacles.overcome(t);
                    if (!t.active())break;
                }
            }
        }
    }
