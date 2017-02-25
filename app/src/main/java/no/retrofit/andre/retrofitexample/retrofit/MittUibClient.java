package no.retrofit.andre.retrofitexample.retrofit;

import java.util.List;

import no.retrofit.andre.retrofitexample.retrofit.model.Course;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by andre on 25.02.17.
 */
public interface MittUibClient {

    @GET("courses")
    Call<List<Course>> listCourses(@Header("Authorization") String accessToken);

    @GET("courses/{id}")
    Call<Course> listCourse(@Path("id") int id, @Header("Authorization") String accessToken);

}
