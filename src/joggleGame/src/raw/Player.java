public class Player implements Comparable<Player> {
    private Integer score;
    private String name;

    public Player() {

    }
    public Player(String pName,Integer pScore){

        name = pName;
        score = pScore;

    }

    public Integer getScore() {
        return score;
    }

    public String getName(){
        return name;
    }
    @Override
    public int compareTo(Player player) {
        return score.compareTo(player.score);
    }


}
