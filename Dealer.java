package blkjak;

class Dealer extends Player {

  Dealer( String s, Deck d ) {
    super(s,d);
  }

  void playHand() {
    trm.println("\nDEALER");
    while (getPoints() <= 16 ) {
      showHand();
      trm.println(uid_+" HITS");
      hand_.push(deck_.deal());
    }
    showHand();
    if (isBusted())
      trm.println(uid_+" BUSTS");
    else
      trm.println(uid_+" STAYS");
  }

  void showTopCard() {
    String s = hand_.peek().toString();
    trm.print("\nDEALER SHOWS: ");
    trm.println(s);
  }
}

