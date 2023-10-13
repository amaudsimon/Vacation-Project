package com.example.vactionproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.vactionproject.R;
import com.example.vactionproject.database.Repository;
import com.example.vactionproject.entities.Excursion;
import com.example.vactionproject.entities.Vacation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VacationList extends AppCompatActivity {
private Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_list);
        FloatingActionButton fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(VacationList.this, VacationDetails.class);
                startActivity(intent);
            }
        });
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        repository=new Repository(getApplication());
        List<Vacation> allVacations=repository.getALLVacations();
        final VacationAdaptor vacationAdaptor=new VacationAdaptor(this);
        recyclerView.setAdapter(vacationAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        vacationAdaptor.setVacations(allVacations);
        //System.out.println(getIntent().getStringExtra("test"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_vacation_list, menu);
        return true;
    }
    @Override
    protected void onResume(){
        super.onResume();
        List<Vacation> allVacations=repository.getALLVacations();
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        final VacationAdaptor vacationAdaptor=new VacationAdaptor(this);
        recyclerView.setAdapter(vacationAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        vacationAdaptor.setVacations(allVacations);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.addvacation){
            repository=new Repository(getApplication());
            Intent intent = new Intent(VacationList.this, VacationDetails.class);
            startActivity(intent);

            return true;

        }
        if(item.getItemId()==android.R.id.home){
           this.finish();
            //Intent intent = new Intent(VacationList.this, VacationDetails.class);
            //startActivity(intent);
            return true;
        }
        return true;
    }
}