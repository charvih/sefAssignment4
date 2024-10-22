package sefAssignment4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class PrescriptionMain {

    @Test
    public void testAddPrescriptionValid() {
        //test case 1: Valid Prescription Data
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. Chirag Gajera");
        assertTrue(p.addPrescription());  //prescription is saved
    }

    @Test
    public void testAddPrescriptionInvalidFirstName() {
        //test case 2: Invalid First Name
        Prescription p = new Prescription("Chi", "Phuong", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. Chirag Gajera");
        assertFalse(p.addPrescription());  //prescription is not saved (short first name)
    }

    @Test
    public void testAddPrescriptionInvalidAddress() {
        //test case 3: Invalid Address
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. Chirag Gajera");
        assertFalse(p.addPrescription());  //prescription is not saved (short address)
    }

    @Test
    public void testAddPrescriptionInvalidSphereValue() {
        //test case 4: Invalid Sphere Value
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           22.00f, -2.50f, 90, new Date(), "Dr. Chirag Gajera");
        assertFalse(p.addPrescription());  //prescription is not saved (invalid sphere value)
    }

    @Test
    public void testAddPrescriptionInvalidOptometristName() {
        //test case 5: Invalid Optometrist Name
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -2.50f, 90, new Date(), "Dr. CG");
        assertFalse(p.addPrescription());  //prescription is not saved (short optometrist name)
    }

    @Test
    public void testAddPrescriptionInvalidCylinderValue() {
        //test case 6: Invalid Cylinder Value
        Prescription p = new Prescription("Charvi", "Hasaliya", "19 Elphin grove, Hawthorn, 3026, Australia", 
                                           1.50f, -6.00f, 90, new Date(), "Dr. Chirag Gajera");
        assertFalse(p.addPrescription());  //prescription is not saved (invalid cylinder value)
    }
}
