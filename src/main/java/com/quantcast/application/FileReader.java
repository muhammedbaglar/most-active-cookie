package com.quantcast.application;

import com.quantcast.application.entity.CookieData;
import com.quantcast.application.entity.CookieFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

    public static final String delimiter = ",";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

    public static List read(String csvFile) {
        List<CookieFile> cookieEntryList = new ArrayList<>();
        try {
            File file = new File(csvFile);
            java.io.FileReader fr = new java.io.FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            br.readLine();
            while ((line = br.readLine()) != null) {
                CookieFile cookieFile = new CookieFile();
                tempArr = line.split(delimiter);
                cookieFile.setCookieFileDate(LocalDateTime.parse(tempArr[1], formatter));
                cookieFile.setCookieFileName(tempArr[0]);
                cookieEntryList.add(cookieFile);
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cookieEntryList;
    }

    public CookieData parsePath(String[] args) {

        CookieData cookieData = new CookieData();
        cookieData.setCookieName(args[1]);
        cookieData.setCookieDate(LocalDate.parse(args[3]));
        return cookieData;
    }

}
