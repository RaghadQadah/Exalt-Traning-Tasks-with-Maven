public class WriteFactory {

    public Writer getwriter(String writeType) {
        if (writeType == null) {
            return null;
        }
        if (writeType.equalsIgnoreCase("JSON")) {
            return new JsonWriter();

        } else if (writeType.equalsIgnoreCase("XML")) {
            return new XmlWriter();
        } else if (writeType.equalsIgnoreCase("TEXT")) {
        return new TextWriter();
    }
            return null;
        }

}

