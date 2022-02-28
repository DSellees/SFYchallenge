package com.example.sfychallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sfychallenge.Adapter.CustomAdapter;
import com.example.sfychallenge.api.UnsplashApiService;
import com.example.sfychallenge.models.Photo;
import com.example.sfychallenge.models.PhotoRespuesta;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.SplashTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();
        
        UnsplashApiService service = RetrofitClientInstance.getRetrofitInstance().create(UnsplashApiService.class);
        Call<PhotoRespuesta> call = service.obtenerListaPhotos("flowers", "XkoDy8Y-amAm3Hu_55Pb8XACya-ipGsFGJnqBzuGZNg", 30);
        
        call.enqueue(new Callback<PhotoRespuesta>() {
            @Override
            public void onResponse(Call<PhotoRespuesta> call, Response<PhotoRespuesta> response) {

                progressDialog.dismiss();
                genereteList(response.body().getResults());
                
            }

            @Override
            public void onFailure(Call<PhotoRespuesta> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,"Error de conexion", Toast.LENGTH_SHORT).show();

            }

        });

    }

    private void genereteList(List<Photo> photo) {

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CustomAdapter(photo);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Photo selectPhoto = photo.get(recyclerView.getChildAdapterPosition(view));
                Intent intent = new Intent(MainActivity.this,PhotoDetails.class);

                intent.putExtra(PhotoDetails.PHOTO,selectPhoto);
                startActivity(intent);

            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }

}