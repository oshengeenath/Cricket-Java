package coursework;

public class Teams {
    private String name;
    private int matchOneTotalRuns = 0;
    private String matchOneSummary;
    private int matchOneWicketsLoss = 0;
    private static String previousTournament;

    public Teams(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchOneTotalRuns() {
        return matchOneTotalRuns;
    }

    public void setMatchOneTotalRuns(int matchOneTotalRuns) {
        this.matchOneTotalRuns = this.matchOneTotalRuns + matchOneTotalRuns;
    }

    public void resetMatchOneTotalRuns(){
        this.matchOneTotalRuns = 0;
    }

    public String getMatchOneSummary() {
        return matchOneSummary;
    }

    public void setMatchOneSummary(String matchOneSummary) {
        this.matchOneSummary = matchOneSummary;
    }

    public void resetMatchOneSummary(){
        this.matchOneSummary = null;
    }

    public static String getPreviousTournament() {
        return previousTournament;
    }

    public static void setPreviousTournament() {
        previousTournament = "Sri Lanka won the Tournament\nThe best Batsmen was Kusal Mendis - " +
                "88(runs) - 30(balls)\nThe best Bowler was Lasith Malinga - 6(wickets)";
    }

    public int getMatchOneWicketsLoss() {
        return matchOneWicketsLoss;
    }

    public void setMatchOneWicketsLoss(int matchOneWicketsLoss) {
        this.matchOneWicketsLoss = this.matchOneWicketsLoss + matchOneWicketsLoss;
    }

   public void resetMatchOneWicketsLoss(){
        this.matchOneWicketsLoss = 0;
   }
}
