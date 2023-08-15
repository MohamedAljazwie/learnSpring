package spring.core.xml.xmlConfig.classes;

public class ReadingDb implements ReadingList {
String readingDb;
    @Override
    public void read() {
        System.out.println(readingDb);

    }

    public String getReadingDb() {
        return readingDb;
    }

    public void setReadingDb(String readingDb) {
        this.readingDb = readingDb;
    }

    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return readingDb;
    }
}
