package com.quantcast.application;

import com.quantcast.application.entity.CookieData;
import com.quantcast.application.entity.CookieFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.stream.Collectors;

public class CookieFinder {
    public List<String> findMostActiveCookieByDate(List<CookieFile> cookieFileList, CookieData cookieData) {

        Map<String, Long> groupCookieByDate = cookieFileList.stream().filter(cookieFile -> cookieData.getCookieDate().isEqual(cookieFile.getCookieFileDate().toLocalDate())).collect(Collectors.groupingBy(CookieFile::getCookieFileName, Collectors.counting()));

        OptionalLong mostActiveCookieCnt = groupCookieByDate.values().stream().mapToLong(cnt -> cnt).max();

        List<String> mostActiveCookieList = new ArrayList<>();

        if (mostActiveCookieCnt.isPresent()) {
            mostActiveCookieList = groupCookieByDate.entrySet().stream().filter(x -> x.getValue().equals(mostActiveCookieCnt.getAsLong())).map(Map.Entry::getKey).collect(Collectors.toList());
        }

        return mostActiveCookieList;
    }

}
