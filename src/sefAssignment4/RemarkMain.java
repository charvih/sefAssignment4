package sefAssignment4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class RemarkMain {

    @Test
    public void testAddRemarkValid() {
        //test Case 1: Valid Remark
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. Anderson");
        assertTrue(p.addRemark("This is a valid remark I guess.", "Client"));  //remark is saved
    }

    @Test
    public void testAddRemarkInvalidWordCount() {
        //test Case 2: Invalid Word Count (less than 6 words)
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. Anderson");
        assertFalse(p.addRemark("Too short", "Client"));  //remark is not saved (less than 6 words)
    }

    @Test
    public void testAddRemarkInvalidRemarkType() {
        //test Case 3: Invalid Remark Type
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. Anderson");
        assertFalse(p.addRemark("This is a valid remark I guess.", "Doctor"));  //remark is not saved (invalid type)
    }

    @Test
    public void testAddRemarkInvalidFirstCharacter() {
        //test Case 4: Invalid First Character
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. Anderson");
        assertFalse(p.addRemark("this is an invalid remark for sure.", "Optometrist"));  //remark is not saved (lowercase first character)
    }

    @Test
    public void testAddRemarkExceedingLimit() {
        //test Case 5: Exceeding Remark Limit (2 remarks already exist)
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. Anderson");
        p.addRemark("First remark is valid according to the assignment", "Client");
        p.addRemark("Second remark is valid according to the assignment", "Client");
        assertFalse(p.addRemark("This is a third remark, you can count it.", "Client"));  //remark is not saved (exceeds limit)
    }

    @Test
    public void testAddRemarkTooManyWords() {
        //test Case 6: Invalid Word Count (more than 20 words)
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. Anderson");
        assertFalse(p.addRemark("This remark exceeds the twenty word limit that is not allowed for remarks. The patient should look after their eyes everyday. Keep away from sharp objects", "Optometrist"));
    }
}
