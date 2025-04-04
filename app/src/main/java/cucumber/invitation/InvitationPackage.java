package cucumber.invitation;

import java.util.ArrayList;
import java.util.List;

public class InvitationPackage {
  private List<InvitationCard> cards;

  public InvitationPackage() {
    cards = new ArrayList<>();
  }

  public boolean contains(InvitationCard card) {
    return cards.contains(card);
  }

  public boolean containsCardName(String name) {
    for (InvitationCard card: cards) {
      if (card.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public boolean containsCardId(Integer id) {
    for (InvitationCard card: cards) {
      if (card.getId() == id) {
        return true;
      }
    }
    return false;
  }

  public void add(InvitationCard card)  {
    if (containsCardName(card.getName())) {
      throw new IllegalArgumentException("Duplicate Name");
    }

    if (containsCardId(card.getId())) {
      throw new IllegalArgumentException("Duplicate Id");
    }

    cards.add(card);
  }

  public void remove(String name) {
    for (InvitationCard card: cards) {
      if (card.getName().equals(name)) {
        cards.remove(card);
        return;
      }
    }
    throw new IllegalArgumentException("Name not found");
  }

  public void updateCardName(String name, String newName) {
    for (InvitationCard card: cards) {
      if (card.getName().equals(name)) {
        card.setName(newName);
        return;
      }
    }
    throw new IllegalArgumentException("Name not found");
  }

  public int getSize() {
    return cards.size();
  }
}
