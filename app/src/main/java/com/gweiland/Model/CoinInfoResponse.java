package com.gweiland.Model;



import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class CoinInfoResponse {

    @SerializedName("data")
    private Map<String, CoinData> data;

    public Map<String, CoinData> getData() {
        return data;
    }

    public class CoinData {

        @SerializedName("urls")
        private CoinUrls urls;

        @SerializedName("logo")
        private String logo;

        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("symbol")
        private String symbol;

        public CoinUrls getUrls() {
            return urls;
        }

        public String getLogo() {
            return logo;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public class CoinUrls {

        @SerializedName("logo")
        private String logo;

        public String getLogo() {
            return logo;
        }
    }

    public class CoinStatus {

        @SerializedName("timestamp")
        private String timestamp;

        @SerializedName("error_code")
        private int errorCode;

        @SerializedName("error_message")
        private String errorMessage;

        @SerializedName("elapsed")
        private int elapsed;

        @SerializedName("credit_count")
        private int creditCount;

        @SerializedName("notice")
        private String notice;

        public String getTimestamp() {
            return timestamp;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public int getElapsed() {
            return elapsed;
        }

        public int getCreditCount() {
            return creditCount;
        }

        public String getNotice() {
            return notice;
        }
    }
}
