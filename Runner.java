package CollectionLesson.File.IoFiles;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) throws IOException {

        Map<Integer, Thing> itemById = new HashMap<>();
        File fileThings = Path.of("resources", "items-name.csv").toFile();
        try (BufferedReader br = new BufferedReader(new FileReader(fileThings))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                Thing thing = ItemParse.parse(line);
                itemById.put(thing.getId(), thing);
            }
        } catch (IOException exception) {
            try {
                throw new ThingIoException("Failed to read things from file: " + fileThings);
            } catch (ThingIoException e) {
                throw new RuntimeException(e);
            }
        }

        Map<Integer, Price> priceById = new HashMap<>();
        File filePrice = Path.of("resources", "items-price.csv").toFile();
        try (BufferedReader br = new BufferedReader(new FileReader(filePrice))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                Price price = PriceParse.parse(line);
                priceById.put(price.getId(), price);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<ItemPrice> result = new ArrayList<>();
        for (Thing thing : itemById.values()) {
            Price price = priceById.get(thing.getId());
            if (price != null) {
                result.add(new ItemPrice(thing.getId(), thing.getName(), price.getPrice()));
            }
        }

        File file = Path.of("resources", "result.csv").toFile();
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {
            fileWriter.append("ID,NAME,PRICE");
            fileWriter.newLine();
            for (ItemPrice thingFull : result) {
                fileWriter.append(thingFull.getId() + ", " + thingFull.getName() + ", " + thingFull.getPrice());
                fileWriter.newLine();
            }
        }
    }
}
