package com.quantcast.application;

import com.quantcast.application.entity.CookieData;
import com.quantcast.application.entity.CookieFile;
import com.quantcast.application.exception.GenericExeption;
import com.quantcast.application.exception.ParserException;

import java.util.List;

public class CookieFileExecutor {
    public void executeProcess(String[] args) {
        try {
            CookieData cookieData = procesFile(args);
            List<CookieFile> cookieFileList = readData (cookieData);
            List<String> activeDataList = procesData(cookieFileList,cookieData);
            printData(activeDataList);
        } catch (GenericExeption | ParserException e) {
            throw new RuntimeException(e);
        }
    }

    public void printData(List<String> activeDataList) {
        activeDataList.stream().forEach(System.out::println);
    }

    public CookieData procesFile(String[] args) throws ParserException {

        FileReader fileReader = new FileReader();
        return fileReader.parsePath(args);
    }

    public List<String> procesData(List<CookieFile> cookieFileList, CookieData cookieData) throws GenericExeption {

        CookieFinder cookieFinder = new CookieFinder();
        return cookieFinder.findMostActiveCookieByDate(cookieFileList,cookieData);
    }

    public List<CookieFile> readData(CookieData cookieData){
         return  FileReader.read(cookieData.getCookieName());
    }
}
