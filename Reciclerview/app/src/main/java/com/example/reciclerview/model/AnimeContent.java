package com.example.reciclerview.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimeContent {

    //animeDetails static class for data (book) model. Names were changed to english for maintaining
    //coherence in all the application.
    public static class AnimeItem {

        private int id;
        private String name;
        private String description;
        private int rate;

        public AnimeItem (int id, String name, String description, int rate){
            this.id = id;
            this.name = name;
            this.description = description;
            this.rate = rate;
        }

        public String getName(){
            return name;
        }

        public String getDescription() { return description; }

        public int getRate() { return rate; }


    }

    //the data, as animeDetails static arraylist
    public static final List<AnimeItem> ITEMS = new ArrayList<>();
    static {
        AnimeItem anime1 = new AnimeItem(1, "Overlord", "Amaizing fantastic", 10);

        AnimeItem anime2 = new AnimeItem(1, "Kimetsu no yaiba", "Katanas y peleas", 10);

        AnimeItem anime3 = new AnimeItem(1, "Kimi no na wa", "Mushubi", 10);

        AnimeItem anime4 = new AnimeItem(1, "Maou Gakuin no Futekigousha", "Op Op Main caracter, hace pupita", 10);


        ITEMS.add(anime1);
        ITEMS.add(anime2);
        ITEMS.add(anime3);
        ITEMS.add(anime4);

    }


}
