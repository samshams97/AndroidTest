package com.example.myapplication;

public class ModelClass  {


    public  ModelClass(String name,int pic){
        setName(name);
        setPic(pic );

    }
    String name;
    int pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }


}
