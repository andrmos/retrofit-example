package no.retrofit.andre.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import no.retrofit.andre.retrofitexample.retrofit.MittUibClient;
import no.retrofit.andre.retrofitexample.retrofit.model.Course;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final static String accessToken = "Bearer <DIN API NØKKEL HER>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MittUibClient client = createClient();

        Call<List<Course>> call = client.listCourses(accessToken);
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                if (response.isSuccessful()) {
                    List<Course> courses = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Log.i("MainActivity", "onFailure: " + t.getMessage());
            }
        });

        int courseId = 2832;
        Call<Course> call2 = client.listCourse(courseId, accessToken);
        call2.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if (response.isSuccessful()) {
                    Course course = response.body();
                }
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                Log.i("MainActivity", "onFailure: " + t.getMessage());
            }
        });

    }

    private MittUibClient createClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mitt.uib.no/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MittUibClient.class);
    }
}
