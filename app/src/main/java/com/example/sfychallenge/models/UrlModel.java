package com.example.sfychallenge.models;

import java.io.Serializable;

public class UrlModel implements Serializable {

        private String raw;
        private String full;
        private String regular;
        private String small;
        private String thumb;
        private String small_s3;

        // Getter Methods
        public String getRaw() {
            return raw;
        }

        public String getFull() {
            return full;
        }

        public String getRegular() {
            return regular;
        }

        public String getSmall() {
            return small;
        }

        public String getThumb() {
            return thumb;
        }

        public String getSmall_s3() {
            return small_s3;
        }

}
