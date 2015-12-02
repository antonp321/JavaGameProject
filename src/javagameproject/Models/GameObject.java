package javagameproject.Models;

import java.awt.*;

public abstract class GameObject {
    private String objectName;
    private int objectWidth;
    private int objectHeight;
    private int objectX;
    private int objectY;
    private Image objectImg;

    protected GameObject(String objectName, int objectWidth, int objectHeight, int objectX, int objectY, Image objectImg){
        this.objectName = objectName;
        this.objectWidth = objectWidth;
        this.objectHeight = objectHeight;
        this.objectX = objectX;
        this.objectY = objectY;
        this.objectImg = objectImg;
    }

    public String getObjectName(){
        return this.objectName;
    }

    public Image getObjectImg(){
        return this.objectImg;
    }

    public void setObjectImg(Image objImg) {
        this.objectImg = objImg;
    }

    public int getObjectWidth(){
        return this.objectWidth;
    }

    public int getObjectHeight(){
        return this.objectHeight;
    }

    public int getObjectX(){
        return this.objectX;
    }

    public int getObjectY(){
        return this.objectY;
    }

    public void setX(int x){
        this.objectX = x;
    }

    public void setY(int y){
        this.objectY = y;
    }

}
