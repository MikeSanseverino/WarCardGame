package warcardgame;

public class Player {

    private String name = " ";
    private int score = 0;

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public void setScore(int score){
        this.score += score;
    }

    public int getScore(){
        return this.score;
    }

    
}