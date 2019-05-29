package com.example.day_02_zuoye2;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DataDb {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String title;
    @Generated(hash = 850558707)
    public DataDb(Long id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }
    @Generated(hash = 149697833)
    public DataDb() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
