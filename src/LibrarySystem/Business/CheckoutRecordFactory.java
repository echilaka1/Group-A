package LibrarySystem.Business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import LibrarySystem.DataAccess.DataAccessFacade;
import LibrarySystem.DataAccess.StorageManager;
import LibrarySystem.Model.BookCopy;
import LibrarySystem.Model.CheckoutEntry;
import LibrarySystem.Model.CheckoutRecord;
import LibrarySystem.Model.LibraryMember;


public class CheckoutRecordFactory {
    public static String addCheckoutEntry(int memberId, CheckoutEntry entry) {
    	StorageManager manager = new DataAccessFacade();
        Map<Integer, CheckoutRecord> recordsMap = manager.readCheckoutRecordsFromStorage();

        CheckoutRecord record = recordsMap.getOrDefault(memberId, new CheckoutRecord());
        record.addCheckoutEntry(entry);
        
        recordsMap.put(memberId, record);
        manager.saveCheckoutRecordsToStorage(recordsMap);

        return  "checked out successfully";
    }

    
    public static Map<Integer, CheckoutRecord> getAllCheckoutRecords() {
    	StorageManager manager = new DataAccessFacade();
        Map<Integer, CheckoutRecord> recordsMap = manager.readCheckoutRecordsFromStorage();
        if (recordsMap.isEmpty()) {
            throw new IllegalStateException("No checkout records found.");
        }
        return Collections.unmodifiableMap(recordsMap);
    }

}
