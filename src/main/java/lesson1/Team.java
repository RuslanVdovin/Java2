package lesson1;

public class Team {
    String teamName;
    Movement[] teamMembers = new Movement[4];


    public Team(String teamName, Movement[] teamMembers){
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public String getTeamName(){
        return "Team name: "+teamName;
    }

    public Movement[] getMembers(){
        return teamMembers;
    }
}
