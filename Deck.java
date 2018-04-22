package blkjak;

import java.util.Stack;
import java.lang.Math;
import blkjak.Card;
import blkjak.Card.Suit;
import blkjak.Card.Rank;

class Deck extends Stack<Card> {

  Deck() {
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        if (r == Rank.Joker)
          continue;
        int p = r.ordinal()+1;
        if (p > 10 ) p = 10;
        Card c = new Card(s,r,p);
        push(c);
      }
    }
    shuffle();
  }

  void shuffle() {
    Stack<Card> tmp = new Stack<Card>();
    Card joker = new
        Card(Suit.Spade,Rank.Joker,0);
    for (int i = 0; i < 52; i++ )
      tmp.push(joker);
    int cap = 0;
    while (true) {
      double d = Math.random()*52;
      Double D = new Double(d);
      int pos = D.intValue();
      Card c = tmp.get(pos);
      Rank r = c.getRank();
      if (r == Rank.Joker) {
        tmp.set(pos,pop());
        if (++cap == 52 ) break;
      }
    }
    clear();
    for( Card c : tmp )
      push(c);
  }

  Card deal() { return pop(); }
}

