package com.example.iiitcontacts.localdb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact_table",
indices = {@Index(value = "email", unique = true)})
public class Contact extends BaseObservable implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    public String name;


    public Contact(String name) {
        this.name = name;
    }

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
    private String extn;
    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("email")
    @Expose
    @ColumnInfo(name = "email")
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
        return extn;
    }

    public void setExtn(String extn) {
        this.extn = extn;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Bindable
    public String getMobile() {
        return mobile;
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

    @NotNull
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