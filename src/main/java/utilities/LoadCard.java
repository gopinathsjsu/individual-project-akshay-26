package utilities;

import com.project.card.CardList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LoadCard {

    public static CardList loadCard(String cardDetails) {
        CardList card = new CardList();
        Set<String> cardNo = new LinkedHashSet<>();
        try (
               // private String cardDetails;
                BufferedReader br = new BufferedReader(new FileReader(cardDetails))) {
            String line = br.readLine();
            System.out.println("Reading card Input File:" + cardDetails);
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (card.getCard() == null) {
                    card.setCard(cardNo);
                    card.getCard().add(data[0].trim());
                } else {
                    card.getCard().add(data[0].trim());
                    //System.out.println("----------" + card.getCard());
                }
            }
        } catch (
                IOException e) {
            System.err.println("File Not Found:" + cardDetails);
            e.printStackTrace();
        }
        return card;
    }
}
