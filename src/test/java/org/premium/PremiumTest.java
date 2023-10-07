package org.premium;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class PremiumTest {
    public static List<String[]> columnValues = new ArrayList<String[]>();

    @BeforeAll
    public static void init(){
        try {
            Scanner scanner = new Scanner(new File("Testcase_20.csv"));
            while(scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(",");
                columnValues.add(values);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPremium() {
        try {
            for(int x = 2; x < columnValues.get(0).length -2; x++) {
                String coverType = columnValues.get(1)[x];
                boolean winScreenRepair = columnValues.get(2)[x].equals("Select") ? true: false;
                int numOfAcc = Integer.parseInt(columnValues.get(3)[x]);
                int tolMileage = Integer.parseInt(columnValues.get(4)[x]);
                int estimate = Integer.parseInt(columnValues.get(5)[x]);
                String parkingLocation = columnValues.get(6)[x];
                Input input = new Input(coverType, winScreenRepair, numOfAcc, tolMileage, estimate, parkingLocation);
                RequestQuotation requestQuotation = new RequestQuotation();
                double premium = requestQuotation.calPremium(input);
                if(premium == Double.parseDouble(columnValues.get(10)[x]))
                    System.out.println("Testcase " + (x-1) + " passed - premium: " + premium + ", actual: " + columnValues.get(10)[x]);
                //test values here
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
