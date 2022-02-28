package com.example.sfychallenge.models;

import java.util.List;

public class PhotoRespuesta {

        private float total;
        private float total_pages;
        private List< Photo > results;

        // Getter Methods
        public List<Photo> getResults(){
        return results;
    }

        public float getTotal() {
            return total;
        }

        public float getTotal_pages() {
            return total_pages;
        }

}
