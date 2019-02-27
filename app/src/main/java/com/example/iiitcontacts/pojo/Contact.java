package com.example.iiitcontacts.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contact {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("office")
    @Expose
    private String office;
    @SerializedName("extn")
    @Expose
    private List<String> extn = null;
    @SerializedName("mobile")
    @Expose
    private List<String> mobile = null;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("room_no")
    @Expose
    private String roomNo;
    @SerializedName("category")
    @Expose
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public List<String> getExtn() {
        return extn;
    }

    public void setExtn(List<String> extn) {
        this.extn = extn;
    }

    public List<String> getMobile() {
        return mobile;
    }

    public void setMobile(List<String> mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}