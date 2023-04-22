package com.example;

import java.util.ArrayList;
import java.util.List;

public class LionAlex extends Lion{

    public LionAlex(Feline feline) {
        super(feline);
    }

    public List<String> getFriends() {
        List<String> listOfFriends = new ArrayList<>();
        listOfFriends.add("зебра Марти");
        listOfFriends.add("бегемотиха Глория");
        listOfFriends.add("жираф Мелман");
        return listOfFriends;
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
