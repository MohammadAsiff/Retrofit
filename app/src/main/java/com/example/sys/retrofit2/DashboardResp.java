package com.example.sys.retrofit2;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class DashboardResp {

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }

    public ArrayList<Details> getDetailsList() {
        return detailsList;
    }

    @SerializedName("Email")
    private String email;
    @SerializedName("Status")
    private String status;
    @SerializedName("Remarks")
    private String remarks;
    @SerializedName("Details")
    private ArrayList<Details> detailsList = new ArrayList<>();

    class Details {
        public String getName() {
            return name;
        }

        public String getImage() {
            return image;
        }

        public String getLat() {
            return lat;
        }

        public String getLon() {
            return lon;
        }

        @SerializedName("Name")
        String name;
        @SerializedName("Image")
        String image;
        @SerializedName("Lat")
        String lat;
        @SerializedName("Long")
        String lon;

    }
}
