package mastermind;

public class ColorAttempt {
  private Ball[] attempt;

  public ColorAttempt(){
    attempt = new Ball[4];
  }
  public ColorAttempt(String firstColor, String secondColor, String thirdColor, String fourthColor){
    attempt = new Ball[4];
    this.attempt[0] = new Ball(firstColor);
    this.attempt[1] = new Ball(secondColor);
    this.attempt[2] = new Ball(thirdColor);
    this.attempt[3] = new Ball(fourthColor);
  }

  public Match[] compare(ColorAttempt arrayToCompare){
    Match[] matches = {new Match(), new Match(), new Match(), new Match()};

    for (int i = 0; i < matches.length; i++) {
      if (this.attempt[i].getColor().equals(arrayToCompare.attempt[i].getColor())) {
        matches[i].setColorMatch(true);
        matches[i].setPositionMatch(true);
      }
      for (int j = 0; j < arrayToCompare.attempt.length; j++) {
        if (this.attempt[i].getColor().equals(arrayToCompare.attempt[j].getColor())
            && matches[j].isColorMatch() != true) {
          matches[j].setColorMatch(true);
        }
      }
    }

    return matches;
  }

  public Ball[] getAttempt() {
    return attempt;
  }

  public void setAttempt(Ball[] attempt) {
    this.attempt = attempt;
  }

  public void setColorOnPosition(int arrayPosition, String color){
    attempt[arrayPosition] = new Ball(color);
  }
}
