package blkjak;

import java.util.ArrayList;
import java.lang.Integer;
import java.io.IOException;
import java.io.PrintStream;

class BlackJack {

  Deck deck_;
  Dealer dealer_;
  ArrayList<Player> players_;
  static PrintStream trm = System.out;

  public static void main(String args[]) {
    Integer a = Integer.valueOf(args[0]);
    int n = a.intValue();
    BlackJack game = new BlackJack(n);
    game.playGame();
    game.results();
  }

  BlackJack(int n) {
    deck_ = new Deck();
    dealer_ = new Dealer("Dealer",deck_);
    players_ = new ArrayList<Player>();
    for (int i = 1; i <= n; i++) {
      Player p = new Player(
        "Player #"+i, deck_);
      players_.add(p);
    }
  }

  void playGame() {
    dealer_.showTopCard();
    for (Player p : players_) 
      p.playHand();
    dealer_.playHand();
  }

  void results() {
    trm.print("\nRESULTS: (enter)");
    try { System.in.read(); }
    catch (IOException e) {}
    dealer_.showHand();
    if (dealer_.isBusted())
      trm.println(dealer_+" LOSES");
    for (Player p : players_) {
      p.showHand();
      if (p.isBusted())
        trm.println(p+" LOSES");
      else if (dealer_.isBusted())
        trm.println(p+" WINS");
      else {
        int x = p.getPoints() -
                dealer_.getPoints();
        if (x > 0 )
          trm.println(p+" WINS");
        else if (x == 0)
          trm.println(p+" PUSHES");
        else if (x < 0 )
          trm.println(p+" LOSES");
      }
    } 
  }
}

