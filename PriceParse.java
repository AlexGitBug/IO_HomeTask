package CollectionLesson.File.IoFiles;

public class PriceParse {

    public static Price parse(String line) {
        String[] string = line.split(",");
        Price price= new Price(Integer.parseInt(string[0]), Double.parseDouble(string[1]));
        return price;
    }
}

