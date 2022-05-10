import com.project.card.CardList;
import com.project.category.CategoryLimit;
import com.project.item.ItemList;
import utilities.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainClass {
    private static final String configFilename = "categoryConfig.json";
    private static final String inventoryFilename = "Dataset - Sheet1.csv";
    private static final String outputFailedFileName = "failedOrders";
    private static final String cardChargedFileName = "cardCharged";
    private static final String cardDetails = "cardNumber.csv";

    public static void main(String[] args) throws FileNotFoundException {

        String orderFilename = CommandLineProcessor.getInstance().getInputFile(args);
        if(orderFilename.equals(null) || !Files.isReadable(Paths.get(orderFilename)) )
        {
            System.out.println("No such readable file exists on project path: "+orderFilename);
            System.exit(1);
        }
        String failedoutput= outputFailedFileName + "_"+ orderFilename;
        String cardCharged= cardChargedFileName + "_"+ orderFilename;

        try {
            Files.deleteIfExists(Paths.get(failedoutput));
            Files.deleteIfExists(Paths.get(cardCharged));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Reading configuration files...");
        // setup categories

        CategoryLimit categoryLimit = LoadCategory.loadCategoryItems(configFilename);
//        CategoryLimit categoryLimit1 = Commons.loadCategories(configFilename);

        //setup inventory
        ItemList itemList = LoadItems.loadItems(inventoryFilename,cardDetails,  categoryLimit.getItemCategory());
//        ItemList itemList1 = Commons.loadItems(inventoryFilename, categoryLimit1.getItemCategory());

        CardList readCard = LoadCard.loadCard(cardDetails);
        System.out.println("get card..." + readCard.getCard());

        System.out.println("Processing Order...");
        System.out.println("Reading File:" + orderFilename);

        // checking order file
        System.out.println("\nWriting failed orders to:" + failedoutput);
        CardList card = LoadOrder.loadOrder(orderFilename, itemList, readCard, categoryLimit.getItemCategory(), failedoutput);
//        CardList card1 = Commons.loadOrder(orderFilename, itemList1, categoryLimit1.getItemCategory(), failedoutput);

        //Output to file
        System.out.println("\nWriting card charged for order to:" + cardCharged);
        WriteTotalAmountCharged.writeTotalAmountCharged(cardCharged, card,itemList);
//        Commons.writeTotalAmountCharged(cardCharged, card1);
    }


}
