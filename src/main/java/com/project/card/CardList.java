package com.project.card;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CardList {
    Map<String, Double> cardlist;
    Set<String> cards = null;
    public CardList() {
        cards = new LinkedHashSet<>();
        cardlist = new HashMap<>();
    }

    //using primitives in method body for attacker protection - primitives are immutable
    public void addCharge(String card, double amount) {
        //autoboxing double primitive to Double wrapper
        cardlist.put(card, cardlist.getOrDefault(card, 0.0)+amount);

    }
    public Set<String> getCard(){
        return cards;
    }
    public void setCard(Set<String> cards){
        this.cards = cards;
    }

    public Map<String, Double> getCardlist() {

        return cardlist;
    }
}
