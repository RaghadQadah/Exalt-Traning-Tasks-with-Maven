public class ReadFactory {
    public Reader getReader(String readType) {
        if (readType == null) {
            return null;
        }
        if (readType.equalsIgnoreCase("JSON")) {
            return new JsonReader();

        } else if (readType.equalsIgnoreCase("XML")) {
            return new XmlReader();
        } else if (readType.equalsIgnoreCase("TEXT")) {
            return new TextReader();
        }
        return null;
    }
}
