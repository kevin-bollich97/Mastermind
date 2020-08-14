package mastermind;

public class Match {
  private boolean colorMatch;
  private boolean positionMatch;

  public boolean isColorMatch() {
    return colorMatch;
  }

  public void setColorMatch(boolean colorMatch) {
    this.colorMatch = colorMatch;
  }

  public boolean isPositionMatch() {
    return positionMatch;
  }

  public void setPositionMatch(boolean positionMatch) {
    this.positionMatch = positionMatch;
  }

  public String getMatch(){
    if (colorMatch && positionMatch){
      return "Black";
    } else if (colorMatch && !positionMatch ){
      return "White";
    } else {
      return "";
    }
  }
}
