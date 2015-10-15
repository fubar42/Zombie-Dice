import java.io.Serializable;

/**
 * Created by s213391244 on 10/15/2015.
 */
public class Player implements Serializable {
    private String userHandle;
    private int score;
    private int rank;

    public Player(String userHandle) {
        this.userHandle = userHandle;
        this.score = 0;
        this.rank = 0;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public String getScore() {
        return String.format("%d", score);
    }

    public String getRank() {
        return String.format("%d", rank);
    }

    public void incrementScore(int brains) {
        this.score = +brains;
    }

    public void resetScore() {
        this.score = 0;
    }
}
