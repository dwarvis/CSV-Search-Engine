package edu.cis.cisgsearch.Model.GoogleSearch;

import android.content.Context;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.cis.cisgsearch.Model.TConst;
//import java.util.Scanner;

public class Util
{
//    private static ArrayList<TARestProfile> tempList;

    public static ArrayList<TARestProfile> readCSV(Context mainScreen)
    {
        ArrayList<TARestProfile> tempList = new ArrayList<>();
        Iterable<CSVRecord> records = null;

        try
        {
            InputStream data = mainScreen.getAssets().open("TA_restaurants_curated.csv");
//            Scanner sc = new Scanner(data);
//            System.out.println("first line" + sc.nextLine());

            records = CSVFormat.EXCEL.withHeader().parse(new InputStreamReader(data));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        for (CSVRecord rec : records)
        {
            TARestProfile temp = new TARestProfile(rec.get(TConst.name), rec.get(TConst.city),
                    rec.get(TConst.cuisine), rec.get(TConst.rank), rec.get(TConst.rating),
                    rec.get(TConst.priceRange), rec.get(TConst.reviewNumber),
                    rec.get(TConst.reviews), rec.get(TConst.url), rec.get(TConst.id));
            tempList.add(temp);
        }
        return tempList;
    }

    //http://easyonlineconverter.com/codes/java_codes/convert-strin-to-ASCII-value-in-java.html
    public static String toASCII (String s)
    {
        String temp = "";
        int nameLength = s.length();
        for(int i = 0; i < nameLength ; i++){
            char character = s.charAt(i);
            int ascii = (int) character;
            temp = temp + ascii;
        }
        return temp;
    }
}
