package blkjak;

class Card {

  enum Suit { Spade, Club,
              Heart, Diamond };
  enum Rank { Ace, Two, Three,
              Four, Five, Six,
              Seven, Eight, Nine,
              Ten, Jack, Queen,
              King, Joker };

  Suit suit_;
  Rank rank_;
  int points_;

  Card(Suit s, Rank r, int p) {
    suit_ = s;
    rank_ = r;
    points_ = p;
  }

  boolean setPoints(int p) {
    if (rank_ != Rank.Ace )
      return false;
    if (p != 1 && p != 11)
      return false;
    points_ = p;
    return true;
  }

  void setSuit(Suit s) {
    suit_ = s;
  }

  void setRank(Rank r) {
    rank_ = r;
  }

  Suit getSuit() {
    return suit_;
  }

  Rank getRank() {
    return rank_;
  }

  int getPoints() {
    return points_;
  }

  public String toString() {
    return String.valueOf(
      rank_+" of "+suit_+"s, "
      +points_+" points");
  }
}

