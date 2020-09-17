package com.adeskmath.lesson8;

public class Goat implements Speaking, Eating{
    @Override
    public String say(){
        return "Мее";
    }
    @Override
    public String eat(){
        return "Сено";
    }
}
