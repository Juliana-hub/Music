package cn.edu.scujcc.music;

import android.os.Build;


import java.io.Serializable;
import java.util.Objects;

public class Singer implements Serializable {
    private static Singer INSTANCE =null ;
    private String id;

    private String name;
    private Singer(){};
    public static Singer getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new Singer();

        }
        return INSTANCE;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Singer)) return false;
        Singer singer = (Singer) o;
        return fans == singer.fans &&
                Objects.equals(name, singer.name) &&
                Objects.equals(gender, singer.gender) &&
                Objects.equals(area, singer.area) &&
                Objects.equals(style, singer.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, area, style, fans);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    private String gender;
    private String area;
    private String style;
    private int fans;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", area='" + area + '\'' +
                ", style='" + style + '\'' +
                ", fans=" + fans +
                '}';
    }
}
