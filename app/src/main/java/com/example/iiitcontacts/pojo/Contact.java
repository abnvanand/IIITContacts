package com.example.iiitcontacts.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Contact extends BaseObservable implements Serializable {

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

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Bindable
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Bindable
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Bindable
    public String getExtn() {
        StringBuilder sb = new StringBuilder();
        for (String item : extn) {
            sb.append(item);
            sb.append("; ");
        }
        return sb.toString();
    }

    public void setExtn(List<String> extn) {
        this.extn = extn;
    }

    @Bindable
    public List<String> getMobile() {
        return mobile;
    }

    public void setMobile(List<String> mobile) {
        this.mobile = mobile;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Bindable
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", designation='" + designation + '\'' +
                ", office='" + office + '\'' +
                ", extn=" + extn +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}