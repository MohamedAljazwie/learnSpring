package spring.core.xml.xmlConfig.classes;

import java.util.List;
import org.springframework.context.ApplicationContext;

public class Reading {

    private ReadingList readingListdc;
    private List<ReadingList> readingLists;
    ApplicationContext context;

    public Reading() {
    }

    Reading(ReadingDb readingList) {
        this.readingListdc = readingList;
    }

    public void init() {
        System.out.println(" INvoking  READING Init Method");
    }

    public void clean() {
        System.out.println("Clean REaingList Object");
    }

    public ReadingList getReadingList() {
        return readingListdc;
    }

    public void setReadingList(ReadingList readingList) {
        this.readingListdc = readingList;
    }

    public List<ReadingList> getReadingLists() {
        return readingLists;
    }

    public void setReadingLists(List<ReadingList> readingLists) {
        this.readingLists = readingLists;
    }

    public void reading() {
        readingListdc.read();
    }

    @Override
    public String toString() {
        return "Reading{" + "readingList=" + readingListdc + ", readingLists=" + readingLists + '}';
    }

    

   
    

}
