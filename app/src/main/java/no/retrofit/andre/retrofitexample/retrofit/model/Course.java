package no.retrofit.andre.retrofitexample.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andre on 25.02.17.
 */
public class Course {

    private int id;
    private String name;
    @SerializedName("course_code")
    private String courseCode;

    public Course(int id, String name, String courseCode) {
        this.id = id;
        this.name = name;
        this.courseCode = courseCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourseCode() {
        return courseCode;
    }
}
