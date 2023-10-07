package org.premium;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class PremiumTest {
    public static List<String[]> columnValues = new ArrayList<String[]>();
    public static ArrayList<String> statusTest = new ArrayList<String>();
    public static ArrayList<String> listPremium = new ArrayList<String>();

    @BeforeAll
    public static void init(){
        try {
            Scanner scanner = new Scanner(new File("Testcase_20.csv"));
            while(scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(",");
                columnValues.add(values);
            }
            statusTest.add(columnValues.get(11)[0]);
            statusTest.add("");
            listPremium.add(columnValues.get(9)[0]);
            listPremium.add(columnValues.get(9)[1]);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPremium() {
        try {
            for(int x = 2; x < columnValues.get(0).length; x++) {

                String coverType = columnValues.get(1)[x];
                boolean winScreenRepair = columnValues.get(2)[x].equals("Select") ? true: false;
                int numOfAcc = Integer.parseInt(columnValues.get(3)[x]);
                int tolMileage = Integer.parseInt(columnValues.get(4)[x]);
                int estimate = Integer.parseInt(columnValues.get(5)[x]);
                String parkingLocation = columnValues.get(6)[x];
                Input input = new Input(coverType, winScreenRepair, numOfAcc, tolMileage, estimate, parkingLocation);

                RequestQuotation requestQuotation = new RequestQuotation();

               try {
                   double premium = requestQuotation.calPremium(input);
                   listPremium.add(String.valueOf(premium));
                   if(premium == Double.parseDouble(columnValues.get(10)[x])){
                       System.out.println("Testcase " + (x-1) + " passed - premium: " + premium + ", actual: " + columnValues.get(10)[x]);
                       statusTest.add("PASS");
                   } else {
                       System.out.println("Testcase " + (x-1) + " failed - premium: " + premium + ", actual: " + columnValues.get(10)[x]);
                       statusTest.add("FAIL");
                   }

               } catch (Exception e) {
                    e.printStackTrace();
                   statusTest.add("");
                   listPremium.add(null);
               }
                //test values here
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @AfterAll
    public static void end() {
        columnValues.set(11, statusTest.toArray(new String[statusTest.size()]));
        columnValues.set(9, listPremium.toArray(new String[listPremium.size()]));

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("Testcase_20.csv");
            Iterator iter = columnValues.iterator();
            while (iter.hasNext()) {
                String[] str = (String[]) iter.next();
                for (int i = 0; i < str.length; i++) {
                    fileWriter.append(str[i]);
                    if(i != str.length - 1) {
                        fileWriter.append(",");
                    }
                }
                fileWriter.append("\n");
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }


        System.out.println("Test finished");
    }


}
