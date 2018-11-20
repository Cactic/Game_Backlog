package com.example.prive.game_backlog;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity (tableName = "game")
public class Game implements Serializable{
    @PrimaryKey
    @NonNull
    private String name;
    private String platform;
    private String status;
    private String date;

    public Game(String name, String platform, String status, String date) {
        this.name = name;
        this.platform = platform;
        this.status = status;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
