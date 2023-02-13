package coursework;

public class Players {
    private String name;
    private int matchOneRunsTaken = 0;
    private int matchOneWicketsTaken = 0;
    private int totalRunsTaken = 0;
    private int totalWicketsTaken = 0;
    private int totalBallsFaced = 0;
    private String matchOneMethodOfDismissal = "not out";
    private int matchOneBallsFaced = 0;
    private String currentBatsmen;

    public Players(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchOneRunsTaken() {
        return matchOneRunsTaken;
    }

    public void setMatchOneRunsTaken(int matchOneRunsTaken) {
        this.matchOneRunsTaken = this.matchOneRunsTaken + matchOneRunsTaken;
    }

    public void resetMatchOneRunsTaken(){
        this.matchOneRunsTaken = 0;
    }

    public int getMatchOneWicketsTaken() {
        return matchOneWicketsTaken;
    }

    public void setMatchOneWicketsTaken(int matchOneWicketsTaken) {
        this.matchOneWicketsTaken = this.matchOneWicketsTaken + matchOneWicketsTaken;
    }

    public void resetMatchOneWicketsTaken(){
        this.matchOneWicketsTaken = 0;
    }

    public int getTotalRunsTaken() {
        return totalRunsTaken;
    }

    public void setTotalRunsTaken(int totalRunsTaken) {
        this.totalRunsTaken = this.totalRunsTaken + totalRunsTaken;
    }

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }

    public void setTotalWicketsTaken(int totalWicketsTaken) {
        this.totalWicketsTaken = this.totalWicketsTaken + totalWicketsTaken;
    }

    public String getMatchOneMethodOfDismissal() {
        return matchOneMethodOfDismissal;
    }

    public void setMatchOneMethodOfDismissal(String matchOneMethodOfDismissal) {
        this.matchOneMethodOfDismissal = matchOneMethodOfDismissal;
    }

    public void resetMatchOneMethodOfDismissal(){
        this.matchOneMethodOfDismissal = "not out";
    }

    public int getMatchOneBallsFaced() {
        return matchOneBallsFaced;
    }

    public void setMatchOneBallsFaced(int matchOneBallsFaced) {
        this.matchOneBallsFaced = this.matchOneBallsFaced + matchOneBallsFaced;
    }

    public void resetMatchOneBallsFaced(){
        this.matchOneBallsFaced = 0;
    }

    public String getCurrentBatsmen() {
        return currentBatsmen;
    }

    public void setCurrentBatsmen(String currentBatsmen) {
        this.currentBatsmen = currentBatsmen;
    }

    public int getTotalBallsFaced() {
        return totalBallsFaced;
    }

    public void setTotalBallsFaced(int totalBallsFaced) {
        this.totalBallsFaced = this.totalBallsFaced + totalBallsFaced;
    }
}
