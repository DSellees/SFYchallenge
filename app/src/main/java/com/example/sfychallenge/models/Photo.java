package com.example.sfychallenge.models;

import java.io.Serializable;

public class Photo implements Serializable {

        private String id;
        private String created_at;
        private String updated_at;
        private String promoted_at;
        private float width;
        private float height;
        private String color;
        private String blur_hash;
        private String description = null;
        private String alt_description;
        private UrlModel urls;

        // Getter Methods
        public UrlModel getUrlModel() {
            return urls;
        }

        public String getId() {
            return id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getPromoted_at() {
            return promoted_at;
        }

        public float getWidth() {
            return width;
        }

        public float getHeight() {
            return height;
        }

        public String getColor() {
            return color;
        }

        public String getBlur_hash() {
            return blur_hash;
        }

        public String getDescription() {
            return description;
        }

        public String getAlt_description() {
            return alt_description;
        }

        public UrlModel getUrls() {
            return urls;
        }

    }