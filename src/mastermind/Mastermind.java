package mastermind;

import java.util.Scanner;

public class Mastermind {
  public static String[] availableColors = {"Blau", "Gruen", "Rot", "Gelb"};

  public static final int MAXATTEMPTS = 2;

  public static ColorAttempt colorSolutionAttempt = new ColorAttempt("Blau", "Rot", "Blau", "Gelb");

  public static void main(String[] args) {
    Mastermind mastermind = new Mastermind();

    System.out.println("Willkommen zu Mastermind\n\nBlack=Farbe ok, Position ok\nWhite=Farbe ok, Position Falsch\nZum Beenden bitte Exit schreiben\n");

    while (true) {
      mastermind.run();

      System.out.println("Sie haben Verloren, Lappen!");
    }
  }

  public void run(){
    Scanner scan = new Scanner(System.in);
    for (int versuch = 0; versuch<MAXATTEMPTS; versuch++){

      System.out.println("Bitte geben Sie Ihre Farben für den Versuch " + (versuch+1) + " ein:");

      ColorAttempt attempt = new ColorAttempt();

      for (int j =0; j<colorSolutionAttempt.getAttempt().length; j++){
        String color = scan.next();
        if (color.equals("Exit")){
          System.exit(0);
        }
        attempt.setColorOnPosition(j, color);
      }

      Match[] matches = attempt.compare(colorSolutionAttempt);

      System.out.print("{");
      for ( Match match : matches ){
        System.out.print(match.getMatch() != ""? match.getMatch() + ", " : "" );
      }
      System.out.println("}");

      if (isWin(matches)){
        System.out.println("Sie haben gewonnen!!!!!");
        scan.close();
        System.exit(0);
      }
    }
    scan.close();
  }

  public static boolean isWin(Match[] matches) {
    int anzahlMatches = 0;
    for (Match match : matches) {
      if (match.getMatch().equals("Black")) {
        anzahlMatches++;
      }
    }
    if (anzahlMatches == 4) {
      return true;
    } else {
      return false;
    }
  }
}
