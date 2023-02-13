package coursework;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Teams> teams = new ArrayList<>();
    private static ArrayList<Players> players = new ArrayList<>();

    public static void main(String[] args) {
        setTheTeams();
        int checkTournamentSummary = 0;
        int repeat = 1;
        Teams.setPreviousTournament();
        while (repeat==1) {
            System.out.println("Do you want to check the Tournament Summary of the Last Tournament\n1.Yes\n2.No");
            try {
                Scanner newScanner = new Scanner(System.in);
                checkTournamentSummary = newScanner.nextInt();
                if (checkTournamentSummary==1 || checkTournamentSummary==2){
                    repeat=0;
                }else{
                    System.out.println("Invalid Input!");
                }
            }catch (Exception e){
                System.out.println("Invalid Input!");
            }
        }
        if (checkTournamentSummary==1){
            System.out.println(Teams.getPreviousTournament());
        }
        int editTeam = 0;
        repeat = 1;
        while (repeat==1) {
            System.out.println("Do you want to edit a team\n1.Yes\n2.No");
            try {
                Scanner newScanner = new Scanner(System.in);
                editTeam = newScanner.nextInt();
                if (editTeam==1 || editTeam==2){
                    repeat=0;
                }else{
                    System.out.println("Invalid Input!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!");
            }
        }


        if (editTeam == 1) {
            editATeam();
        }
        int editPlayer = 0;
        repeat = 1;
        while (repeat==1) {
            System.out.println("Do you want to edit a player\n1.Yes\n2.No");
            try {
                Scanner newScanner = new Scanner(System.in);
                editPlayer = newScanner.nextInt();
                if (editPlayer==1 || editPlayer==2){
                    repeat=0;
                }else{
                    System.out.println("Invalid Input!");
                }
            }catch (Exception e){
                System.out.println("Invalid Input!");
            }
        }
        if (editPlayer == 1) {
            editAPlayer();
        }
        System.out.println("Tournament is Starting now\n");
        System.out.println("Qualifiers matches are Starting now\n");
        int matchNumber = 1;
        String matchType = "Qualifiers Match ";
        for (int qualifiers = 0; qualifiers < 8; qualifiers += 2) {//4 matches in round 1
            System.out.println("Qualifiers Match " + matchNumber + " is starting now");
            int[] batFirstTossWon = startToss(qualifiers, qualifiers + 1);
            int batFirst = batFirstTossWon[0];
            int tossWon = batFirstTossWon[1];
            int ballFirst;
            if (batFirst == qualifiers) {//since only the firstBat is returned, running a code to find who's ballFirst
                ballFirst = qualifiers + 1;
            } else {
                ballFirst = qualifiers;
            }
            for (int innings = 0; innings < 2; innings++) {
                for (int player = 0; player < 88; player++) {
                    players.get(player).setCurrentBatsmen("");//resetting all the players
                }
                startMatch(batFirst, ballFirst, innings);
                int temporaryHolder = ballFirst;
                ballFirst = batFirst;
                batFirst = temporaryHolder;
            }
            System.out.println("Qualifiers Match " + matchNumber + " ended\n");
            checkSummary(batFirst, ballFirst, tossWon, matchNumber, matchType);
            matchNumber += 1;
            repeat = 1;
            int checkSummary = 0;
            while (repeat==1) {
                System.out.println("Do you want to check the Summary of the Match\n1.Yes\n2.No");
                try {
                    Scanner newScanner = new Scanner(System.in);
                    checkSummary = newScanner.nextInt();
                    if (checkSummary==1 || checkSummary==2){
                        repeat=0;
                    }else{
                        System.out.println("Invalid Input!");
                    }
                }catch (Exception e){
                    System.out.println("Invalid Input!");
                }
            }
            if (checkSummary == 1) {
                System.out.println(teams.get(qualifiers).getMatchOneSummary());
                System.out.println();
            }
        }
        emptyTheObject();
        System.out.println("Semi-finals are Starting now\n");
        matchNumber = 1;
        matchType = "Semi-final Match ";
        for (int semiFinals = 0; semiFinals < 8; semiFinals += 4) {//2 matches in semis
            System.out.println("Semi-finals Match " + matchNumber + " is starting now");
            int[] batFirstTossWon = startToss(semiFinals, semiFinals + 1);
            int batFirst = batFirstTossWon[0];
            int tossWon = batFirstTossWon[1];
            int ballFirst;
            if (batFirst == semiFinals) {
                ballFirst = semiFinals + 1;
            } else {
                ballFirst = semiFinals;
            }
            for (int innings = 0; innings < 2; innings++) {
                for (int player = 0; player < 88; player++) {
                    players.get(player).setCurrentBatsmen("");//resetting all players
                }
                startMatch(batFirst, ballFirst, innings);
                int temporaryHolder = ballFirst;
                ballFirst = batFirst;
                batFirst = temporaryHolder;
            }
            System.out.println("Semi-finals Match" + matchNumber + " ended\n");
            checkSummary(batFirst, ballFirst, tossWon, matchNumber, matchType);
            matchNumber += 1;
            int checkSummary = 0;
            repeat = 1;
            while (repeat==1) {
                System.out.println("Do you want to check the Summary of the Match\n1.Yes\n2.No");
                try {
                    Scanner newScanner = new Scanner(System.in);
                    checkSummary = newScanner.nextInt();
                    if (checkSummary==1 || checkSummary==2){
                        repeat=0;
                    }else{
                        System.out.println("Invalid Input!");
                    }
                }catch (Exception e){
                    System.out.println("Invalid Input!");
                }
            }
            if (checkSummary == 1) {
                System.out.println(teams.get(semiFinals).getMatchOneSummary());
                System.out.println();
            }
        }
        emptyTheObject();
        System.out.println("Finals are Starting now\n");
        matchNumber = 1;
        matchType = "Final Match ";
        for (int finals = 0; finals < 8; finals += 8) {//1 match in finals
            System.out.println("Final Match Starting now");
            int[] batFirstTossWon = startToss(finals, finals + 1);
            int batFirst = batFirstTossWon[0];
            int tossWon = batFirstTossWon[1];
            int ballFirst;
            if (batFirst == finals) {
                ballFirst = finals + 1;
            } else {
                ballFirst = finals;
            }
            for (int innings = 0; innings < 2; innings++) {
                for (int player = 0; player < 88; player++) {
                    players.get(player).setCurrentBatsmen("");
                }
                startMatch(batFirst, ballFirst, innings);
                int temporaryHolder = ballFirst;
                ballFirst = batFirst;
                batFirst = temporaryHolder;
            }
            System.out.println("Final Match ended\n");
            checkSummary(batFirst, ballFirst, tossWon, matchNumber, matchType);
            matchNumber += 1;
            int checkSummary = 0;
            repeat = 1;
            while (repeat==1) {
                System.out.println("Do you want to check the Summary of the Match\n1.Yes\n2.No");
                try {
                    Scanner newScanner = new Scanner(System.in);
                    checkSummary = newScanner.nextInt();
                    if (checkSummary==1 || checkSummary==2){
                        repeat=0;
                    }else{
                        System.out.println("Invalid Input!");
                    }
                }catch (Exception e){
                    System.out.println("Invalid Input!");
                }
            }
            if (checkSummary == 1) {
                System.out.println(teams.get(finals).getMatchOneSummary());
            }
        }
        checkTournamentSummary = 0;
        repeat=1;
        while (repeat==1) {
            System.out.println("Do you want to check the Tournament Summary\n1.Yes\n2.No");
            try {
                Scanner newScanner = new Scanner(System.in);
                checkTournamentSummary = newScanner.nextInt();
                if (checkTournamentSummary==1 || checkTournamentSummary==2){
                    repeat=0;
                }else{
                    System.out.println("Invalid Input!");
                }
            }catch (Exception e){
                System.out.println("Invalid Input!");
            }
        }
        if (checkTournamentSummary == 1) {
            System.out.println(checkTournamentSummary());
        }
    }

    static void setTheTeams(){
        try {
            //create new file instances for players and teams
            File playerFile = new File("files/players.txt");
            File teamFile = new File("files/teams.txt");

            // read the files
            FileReader playerFileReader = new FileReader(playerFile);
            FileReader teamFileReader = new FileReader(teamFile);

            // create buffering character input streams
            BufferedReader playerBuffer = new BufferedReader(playerFileReader);
            BufferedReader teamBuffer = new BufferedReader(teamFileReader);

            String line;
            ArrayList<Players> team_members = new ArrayList<>();
            int count = 0;
            int team_count = 0;
            // loop through players
            while((line=playerBuffer.readLine())!=null) {
                Players player = new Players(line);
                team_members.add(player);
                players.add(player);
                count += 1;
                // 11 players in a team
                if (count >= 11) {
                    count = 0;
                    teams.add(new Teams(teamBuffer.readLine()));
                    team_members = new ArrayList<>();
                    team_count++;
                }
            }
            playerFileReader.close();
            teamFileReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void editATeam(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What team name should you edit?");
        for (int i=0; i<8; i++){
            System.out.println(i+1 + " - " + teams.get(i).getName());
        }
        int teamNumber = 0;
        int repeat = 1;
        while (repeat==1) {
            try {
                Scanner newScanner = new Scanner(System.in);
                System.out.print(">>> ");
                teamNumber = newScanner.nextInt();
                if (teamNumber>0 && teamNumber<9){
                    repeat=0;
                }else{
                    System.out.println("Invalid Input!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!");
            }
        }
        System.out.println("What name should we change it to?");
        System.out.print(">>> ");
        String teamName = scanner.next();
        teams.get(teamNumber-1).setName(teamName);//changes the name
    }

    static void editAPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the team number of the player that you want to replace");
        for (int i=0; i<8; i++){
            System.out.println(i+1 + " - " + teams.get(i).getName());
        }
        int teamNumber = 0;
        int repeat = 1;
        while (repeat==1) {
            try {
                Scanner newScanner = new Scanner(System.in);
                System.out.print(">>> ");
                teamNumber = newScanner.nextInt();
                if (teamNumber>0 && teamNumber<9){
                    repeat=0;
                }else{
                    System.out.println("Invalid Input!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!");
            }
        }
        int startingPlayerNumber = (teamNumber-1)*11;//calculating the position of the players in the list according to the team number
        System.out.println("What player do you want to replace");
        for (int i=0; i<11; i++){
            System.out.println(i+1 + " - " + players.get(startingPlayerNumber+i).getName());
        }
        int playerNumber=0;
        repeat = 1;
        while (repeat==1) {
            try {
                Scanner newScanner = new Scanner(System.in);
                System.out.print(">>> ");
                playerNumber = newScanner.nextInt();
                if (playerNumber>0 && playerNumber<12){
                    repeat=0;
                }else{
                    System.out.println("Invalid Input!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!");
            }
        }
        System.out.println("What player are you going to add?");
        System.out.print(">>> ");
        String playerName = scanner.next();
        players.get(startingPlayerNumber+playerNumber-1).setName(playerName);
    }

    static int[] startToss(int team1, int team2){
        int tossWon;
        int tossLose;
        int batFirst;
        double tossFake = Math.random() * 2;
        int toss = (int) tossFake;
        double decisionFake = Math.random() * 2;
        int decision = (int) decisionFake;
        if (toss == 1){
            tossWon = team1;
            tossLose = team2;
        }else{
            tossWon = team2;
            tossLose = team1;
        }
        if (decision == 1){
            batFirst = tossWon;
        }else{
            batFirst = tossLose;
        }
        return new int[]{batFirst, tossWon};
    }

    static void startMatch(int batFirst, int ballFirst, int innings){
        players.get(batFirst*11).setCurrentBatsmen("true");//setting the opening batsmen
        players.get((batFirst*11)+1).setCurrentBatsmen("false");//setting the other opening batsmen
        int baller = (ballFirst*11)+5;
        int playersOut = 0;
        for (int overs = 0; overs<20; overs++){
            for (int balls=0; balls<6; balls++){
                double ball = Math.random() * 7;
                int score = (int) ball;
                if (score != 5){//score=5 is considered as out
                    for (int i=0; i<88; i++) {
                        if (players.get(i).getCurrentBatsmen().equals("true")){//checks who was batting
                            players.get(i).setMatchOneRunsTaken(score);
                            players.get(i).setMatchOneBallsFaced(1);
                            players.get(i).setTotalRunsTaken(score);
                            players.get(i).setTotalBallsFaced(1);
                            teams.get(batFirst).setMatchOneTotalRuns(score);
                            break;
                        }
                    }
                    if (score==1 || score==3){
                        for (int i=batFirst*11; i<88; i++){//when an odd number is scored, the batsmen changes with the co-batsmen
                            if (players.get(i).getCurrentBatsmen().equals("true")){
                                players.get(i).setCurrentBatsmen("false");
                            }
                            else if (players.get(i).getCurrentBatsmen().equals("false")){
                                players.get(i).setCurrentBatsmen("true");
                            }
                        }
                    }
                }else{
                    players.get(baller).setMatchOneWicketsTaken(1);
                    players.get(baller).setTotalWicketsTaken(1);
                    teams.get(batFirst).setMatchOneWicketsLoss(1);
                    for (int i=batFirst*11; i<88; i++) {
                        if (players.get(i).getCurrentBatsmen().equals("true")){//checks who was batting
                            players.get(i).setMatchOneBallsFaced(1);
                            players.get(i).setTotalBallsFaced(1);
                            double fakeDismissal = Math.random()*4;
                            int dismissal = (int) fakeDismissal;
                            switch (dismissal){//randomly selects how the batsmen got out
                                case 0:
                                    players.get(i).setMatchOneMethodOfDismissal("caught");
                                case 1:
                                    players.get(i).setMatchOneMethodOfDismissal("bowled");
                                case 2:
                                    players.get(i).setMatchOneMethodOfDismissal("LBW");
                                case 3:
                                    players.get(i).setMatchOneMethodOfDismissal("stumped");
                            }
                            players.get(i).setCurrentBatsmen("out");
                        }
                    }
                    for (int i=batFirst*11; i<88; i++){
                        if (players.get(i).getCurrentBatsmen().equals("")){
                            players.get(i).setCurrentBatsmen("true");//brings in the new batsmen
                            break;
                        }
                    }
                    playersOut += 1;
                }
                if (innings>0){
                    if (teams.get(batFirst).getMatchOneTotalRuns()>teams.get(ballFirst).getMatchOneTotalRuns()){
                        break;
                    }
                }
                if (playersOut>=10){
                    break;
                }
            }
            if (innings>0){
                if (teams.get(batFirst).getMatchOneTotalRuns()>teams.get(ballFirst).getMatchOneTotalRuns()){
                    break;
                }
            }
            if (playersOut>=10){
                break;
            }
            baller += 1;
            if (baller>(ballFirst*11)+10){
                baller = (ballFirst*11)+5;
            }
            for (int i=batFirst*11; i<88; i++){// after the over, the batsmen switch
                if (players.get(i).getCurrentBatsmen().equals("true")){
                    players.get(i).setCurrentBatsmen("false");
                }
                else if (players.get(i).getCurrentBatsmen().equals("false")){
                    players.get(i).setCurrentBatsmen("true");
                }
            }
        }
    }

    static void checkSummary(int batFirst, int ballFirst, int tossWon, int matchNumber, String matchType){
        String decision;
        String wonByMessage;
        int bestBatsmen = batFirst*11;
        int bestBaller = ballFirst*11;
        if (tossWon==batFirst){
            decision = " won the toss and chose to bat";
        }else{
            decision = " won the toss and chose to ball";
        }
        if (teams.get(batFirst).getMatchOneTotalRuns()>teams.get(ballFirst).getMatchOneTotalRuns()){
            int wonBy = teams.get(batFirst).getMatchOneTotalRuns() - teams.get(ballFirst).getMatchOneTotalRuns();
            wonByMessage = teams.get(batFirst).getName() + " won the match by " + wonBy + " runs";
        }else{
            int wonBy = 10 - teams.get(ballFirst).getMatchOneWicketsLoss();
            wonByMessage = teams.get(ballFirst).getName() + " won the match by " + wonBy + " wickets";
        }
        if (batFirst>ballFirst){
            for (int i=ballFirst*11; i<(ballFirst*11)+20; i++){
                if (players.get(i).getMatchOneRunsTaken()>players.get(i+1).getMatchOneRunsTaken()){
                    bestBatsmen = i;
                }
                if (players.get(i).getMatchOneWicketsTaken()>players.get(i+1).getMatchOneWicketsTaken()){
                    bestBaller = i;
                }
            }
        }else{
            for (int i=batFirst*11; i<(batFirst*11)+20; i++) {
                if (players.get(i).getMatchOneRunsTaken() > players.get(i + 1).getMatchOneRunsTaken()) {
                    bestBatsmen = i;
                }
                if (players.get(i).getMatchOneWicketsTaken() > players.get(i + 1).getMatchOneWicketsTaken()) {
                    bestBaller = i;
                }
            }
        }
        String summary = matchType + matchNumber + "\n" + teams.get(batFirst).getName() + " vs " +
                teams.get(ballFirst).getName() + "\n" + teams.get(tossWon).getName() + decision +
                "\n" + wonByMessage + "\n" + "Best Batsmen of the match was " + players.get(bestBatsmen).getName() +
                " - " + players.get(bestBatsmen).getMatchOneRunsTaken() + "(runs), " + players.get(bestBatsmen).getMatchOneBallsFaced()
                + "(balls), method of dismissal - " + players.get(bestBatsmen).getMatchOneMethodOfDismissal() + "\n" +
                "Best Bowler of the match was " + players.get(bestBaller).getName() + " - wickets - " +
                players.get(bestBaller).getMatchOneWicketsTaken();
        teams.get(batFirst).setMatchOneSummary(summary);
        teams.get(ballFirst).setMatchOneSummary(summary);
    }

    static void emptyTheObject(){
        for (int i=0; i<88; i++){
            players.get(i).resetMatchOneRunsTaken();
            players.get(i).resetMatchOneBallsFaced();
            players.get(i).resetMatchOneWicketsTaken();
            players.get(i).resetMatchOneMethodOfDismissal();
        }
        for (int i=0; i<8; i++){
            teams.get(i).resetMatchOneTotalRuns();
            teams.get(i).resetMatchOneWicketsLoss();
            teams.get(i).resetMatchOneSummary();
        }
    }

    static String checkTournamentSummary(){
        int bestBatsmen = 0;
        int bestBowler = 0;
        int matchWon;
        String message;
        for (int i=0; i<87; i++){
            if (players.get(i).getTotalRunsTaken()>players.get(i+1).getTotalRunsTaken()){
                bestBatsmen = i;
            }
            if (players.get(i).getTotalWicketsTaken()>players.get(i+1).getTotalWicketsTaken()){
                bestBowler = i;
            }
        }
        if (teams.get(0).getMatchOneTotalRuns()>teams.get(1).getMatchOneTotalRuns()){
            matchWon = 0;
        }else{
            matchWon = 1;
        }
        message = teams.get(matchWon).getName() + " won the Tournament\n" + "The best Batsmen was " +
                players.get(bestBatsmen).getName() + " - " + players.get(bestBatsmen).getTotalRunsTaken() +
                "(runs) - " + players.get(bestBatsmen).getTotalBallsFaced() + "(balls)\n" + "The best Bowler was " +
                players.get(bestBowler).getName() + " - " + players.get(bestBowler).getTotalWicketsTaken() + "(wickets)";
        return message;
    }
}
