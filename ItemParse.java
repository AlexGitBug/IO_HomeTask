package CollectionLesson.File.IoFiles;

public class ItemParse {
    public static Thing parse(String line) {
        String[] string = line.split(",");
        Thing thing = new Thing(Integer.parseInt(string[0]), string[1], string[2]);
        return thing;
    }
}

