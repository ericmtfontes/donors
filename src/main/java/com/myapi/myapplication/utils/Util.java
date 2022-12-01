package com.myapi.myapplication.utils;

import java.util.Calendar;
import java.util.Date;

public abstract class Util {

    public static Float calculateImc(Float weight, Float height){
        return weight / (height * height);
    }

    public static Integer calculateAge(Date d){
        Date date = new Date();
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(date);
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(d);
        int cD = currentDate.get(Calendar.YEAR);
        int bD = birthDate.get(Calendar.YEAR);
        return cD - bD;
    }
}
