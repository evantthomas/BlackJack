package blkjak;

import java.util.Stack;
import java.io.IOException;
import java.io.PrintStream;

class Player {

  Stack<Card> hand_;
  Deck deck_;
  String uid_;
  static PrintStream trm = System.out;
	
  Player( String s, Deck d ) {
    uid_ = s;
    deck_ = d;
    hand_ = new Stack<Card>();
    hand_.push(deck_.deal());
    hand_.push(deck_.deal());
  }

  enum Call { Hit, Stay };

  public String toString() {
    return uid_;
  }

  Stack<Card> getHand() {
    return hand_;
  }

  void playHand() {
    trm.println("\nNEXT PLAYER:");
    while (true) {
      Call c = makeCall();
      if (c == Call.Stay) break;
      if (c == Call.Hit) {
        hand_.push(deck_.deal());
        if (isBusted()) {
          showHand();
          trm.println(uid_+" BUSTS!");
          break;
        }
      }
    }
  }

  int getPoints() {
    int p = 0;
    for( Card c : hand_ )
      p += c.getPoints();
    return p;
  }

  boolean isBusted() {
    return (getPoints() > 21);
  }

  void showHand() {
    trm.println("\n"+uid_);
    for( Card c : hand_ )
      trm.println(c);
    trm.println(getPoints()+" points");
  }

  Call makeCall() {
    int c = 0;
    while (true) {
      try {
        showHand();
        trm.print("(H)it or (S)tay? ");
        c = System.in.read();
        System.in.read();
        break;
      } catch (IOException e) {
        trm.println("ERROR");
        continue;
      }
    }
    switch (c) {
      case 'H':
      case 'h':
        trm.println(uid_+" HITS");
        return Call.Hit;
      case 'S':
      case 's':
      default:
        trm.println(uid_+" STAYS");
        return Call.Stay;
    }
  }
}

