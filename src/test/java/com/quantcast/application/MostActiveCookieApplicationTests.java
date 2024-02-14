package com.quantcast.application;

import com.quantcast.application.entity.CookieData;
import com.quantcast.application.entity.CookieFile;
import com.quantcast.application.exception.GenericExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.time.LocalDate.parse;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class MostActiveCookieApplicationTests {

    private CookieFileExecutor cookieFileExecutor;


    @BeforeEach
    public void setUp() {
        cookieFileExecutor = new CookieFileExecutor();
    }

    @Test
    public void findMostActiveData() throws GenericExeption {
        CookieData cookieData = new CookieData("src/log/cookie.csv", parse("2018-12-09"));
        List<CookieFile> cookieFileList = cookieFileExecutor.readData(cookieData);
        List<String> mostActiveDataList = cookieFileExecutor.procesData(cookieFileList, cookieData);
        cookieFileExecutor.printData(mostActiveDataList);
        assertTrue(mostActiveDataList.contains("AtY0laUfhglK3lC7"));
        assertFalse(mostActiveDataList.contains("SAZuXPGUrfbcn5UA"));
        assertFalse(mostActiveDataList.contains("5UAVanZf6UtGyKVS"));

    }
}



