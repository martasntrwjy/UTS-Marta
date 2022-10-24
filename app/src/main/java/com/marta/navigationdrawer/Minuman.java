package com.marta.navigationdrawer;

import android.os.Parcel;
import android.os.Parcelable;

public class Minuman implements Parcelable {
    private String name;
    private String description;
    private Integer photo;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPhoto() {
        return photo;
    }
    public void setPhoto(Integer photo) {
        this.photo = photo;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.photo);
    }
    Minuman() {
    }
    private Minuman(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.photo = in.readInt();
    }

    public static final Creator<Minuman> CREATOR = new
            Creator<Minuman>() {
                @Override
                public Minuman createFromParcel(Parcel source) {
                    return new Minuman(source);
                }
                @Override
                public Minuman[] newArray(int size) {
                    return new Minuman[size];
                }
            };
}
