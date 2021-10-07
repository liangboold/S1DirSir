package com.bawei.s1dirsir.bean;

import android.os.Parcel;
import android.os.Parcelable;

/*
 * @ClassName AddressBean
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/10/6 19:59
 * @Version 1.0
 */
public class AddressBean implements Parcelable {
    private int id;
    private String name;
    private String city;
    private String sdetails;
    private boolean isChoice;


    protected AddressBean(Parcel in) {
        id = in.readInt();
        name = in.readString();
        city = in.readString();
        sdetails = in.readString();
        isChoice = in.readByte() != 0;
    }

    public AddressBean(int id, String name, String city, String sdetails, boolean isChoice) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.sdetails = sdetails;
        this.isChoice = isChoice;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(city);
        dest.writeString(sdetails);
        dest.writeByte((byte) (isChoice ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AddressBean> CREATOR = new Creator<AddressBean>() {
        @Override
        public AddressBean createFromParcel(Parcel in) {
            return new AddressBean(in);
        }

        @Override
        public AddressBean[] newArray(int size) {
            return new AddressBean[size];
        }
    };

    @Override
    public String toString() {
        return "AddressBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", sdetails='" + sdetails + '\'' +
                ", isChoice=" + isChoice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSdetails() {
        return sdetails;
    }

    public void setSdetails(String sdetails) {
        this.sdetails = sdetails;
    }

    public boolean isChoice() {
        return isChoice;
    }

    public void setChoice(boolean choice) {
        isChoice = choice;
    }

    public static Creator<AddressBean> getCREATOR() {
        return CREATOR;
    }
}
