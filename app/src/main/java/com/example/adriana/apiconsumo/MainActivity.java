package com.example.adriana.apiconsumo;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.adriana.apiconsumo.Api.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.adriana.apiconsumo.MainActivity.httpCodes.OK;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    //Inicializar vistas
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.mi_recicler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //Crear un nuevo registro en el api
        Student s = new Student();
        s.setName("Awita");
        s.setSurname("De uwu");
        s.setAge(20);

        Call<Student> studentCall = Api.instance().createStudent(s);
        studentCall.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                System.out.println("NUEVO REGISTRO:"+response.body().getName());
                System.out.println("NUEVO REGISTRO:"+response.body().getSurname());
                System.out.println("NUEVO REGISTRO:"+response.body().getAge());
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

            }
        });

        //Rellenar el recyclerview con los registros en el api
        Call<List<Student>> call = Api.instance().getStudents();
        call.enqueue(new Callback<List<Student>>() {
                         @Override
                         public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                             if (response.code()==OK){
                                 try {

                                     StudentAdapter adapter = new StudentAdapter(response.body());
                                     recyclerView.setAdapter(adapter);

                                     System.out.println("RESPUESTA: "+response.body().get(0).getName());
                                     System.out.println("RESPUESTA: "+response.body().get(0).getSurname());
                                     System.out.println("RESPUESTA: "+response.body().get(0).getAge());



                                 }catch (IndexOutOfBoundsException exception){
                                     Toast.makeText(getApplicationContext(),"No se encontraron registros", Toast.LENGTH_SHORT).show();
                                 }
                             }else{
                                 Toast.makeText(getApplicationContext(),"No se encontraron registros", Toast.LENGTH_SHORT).show();

                             }

                         }

                         @Override
                         public void onFailure(Call<List<Student>> call, Throwable t) {

                         }

                     });



}

    public static class httpCodes{
        public static final int OK = 200;

    }

}
