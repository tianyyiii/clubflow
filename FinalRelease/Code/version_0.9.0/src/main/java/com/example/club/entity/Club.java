package com.example.club.entity;

public class Club {
    //社团id，查询所用的关键字
    private int clubId;
    //社团名称
    private String name;
    //社团创建者
    private OfficialAccount manager;

    public int getId() {
        return clubId;
    }

    public void setId(int id) {
        this.clubId = id;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OfficialAccount getManager() {
        return manager;
    }

    public void setManager(OfficialAccount manager) {
        this.manager = manager;
    }


}
