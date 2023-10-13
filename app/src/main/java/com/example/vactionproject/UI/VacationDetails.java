package com.example.vactionproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vactionproject.entities.Excursion;
import com.example.vactionproject.entities.Vacation;

import com.example.vactionproject.R;
import com.example.vactionproject.database.Repository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class VacationDetails extends AppCompatActivity {
    String title;
    String housing;
    String startDate;
    String endDate;
    int vacationID;
    EditText editTitle;
    EditText editHousing;
    EditText editStartDate;
    EditText editEndDate;
    Repository repository;
    Vacation currentVacation;
    int numExcursions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaction_details);
        FloatingActionButton fab=findViewById(R.id.floatingActionButton2);

        editTitle=findViewById(R.id.titletext);
        title=getIntent().getStringExtra("title");
        editTitle.setText(title);

        editHousing=findViewById(R.id.housingtext);
        housing= getIntent().getStringExtra("housing");
        editHousing.setText(housing);

        editStartDate=findViewById(R.id.startdatetext);
        startDate= getIntent().getStringExtra("startDate");
        editStartDate.setText(startDate);

        editEndDate=findViewById(R.id.enddatetext);
        endDate= getIntent().getStringExtra("endDate");
        editEndDate.setText(endDate);

        vacationID = getIntent().getIntExtra("id", -1);

        //System.out.println(startDate);
        //System.out.println(endDate);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VacationDetails.this, ExcursionDetails.class);
                intent.putExtra("vacationID",vacationID);
                intent.putExtra("startDate", startDate); // Add start date as an extra
                intent.putExtra("endDate", endDate);
                startActivity(intent);
            }
        });
        RecyclerView recyclerView= findViewById(R.id.excursionrecyclerview);
        repository= new Repository(getApplication());
        final ExcursionAdaptor excursionAdaptor = new ExcursionAdaptor(this);
        recyclerView.setAdapter(excursionAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Excursion> filteredExcursions = new ArrayList<>();
        for (Excursion e : repository.getmAllExcursions()){
            if (e.getVacationID()== vacationID) filteredExcursions.add(e);
        }
        excursionAdaptor.setExcursions(filteredExcursions);

        // Add date picker functionality for start and end dates
        editStartDate.setFocusable(false);
        editEndDate.setFocusable(false);

        editStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(editStartDate);
            }
        });

        editEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(editEndDate);
            }
        });
    }

    private void showDatePickerDialog(final EditText dateField) {
        final Calendar currentDate = Calendar.getInstance();
        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH);
        int day = currentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(VacationDetails.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(selectedYear, selectedMonth, selectedDay);

                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                dateField.setText(dateFormat.format(selectedDate.getTime()));
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vacationdetails, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        //1b.a: Allow the user to add as many vacations as desired.
        if(item.getItemId()== android.R.id.home){
            this.finish();
            return true;}
        if (item.getItemId() == R.id.vacationsave) {
            String startDateText = editStartDate.getText().toString();
            String endDateText = editEndDate.getText().toString();

            // Date format validation
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
            try {
                Date startDate = dateFormat.parse(startDateText);
                Date endDate = dateFormat.parse(endDateText);

                // Date comparison validation
                if (startDate.before(endDate)) {
                    System.out.println("start date is before end date");
                    Vacation vacation;

                    if (vacationID == -1) {
                        if (repository.getALLVacations().isEmpty()) {
                            vacationID = 1;
                        } else {
                            vacationID = repository.getALLVacations().get(repository.getALLVacations().size() - 1).getVacationID() + 1;
                        }

                        vacation = new Vacation(vacationID, editTitle.getText().toString(), editHousing.getText().toString(), startDateText, endDateText);
                        repository.insert(vacation);
                        this.finish();
                    } else {
                        vacation = new Vacation(vacationID, editTitle.getText().toString(), editHousing.getText().toString(), startDateText, endDateText);
                        repository.update(vacation);
                        this.finish();
                    }
                } else {
                    System.out.println("End date is before start date");

                    Toast.makeText(VacationDetails.this, "End date must be after the start date", Toast.LENGTH_LONG).show();
                }
            } catch (ParseException e) {
                Toast.makeText(VacationDetails.this, "Invalid date format (MM/dd/yyyy)", Toast.LENGTH_LONG).show();
            }

            return true;
        }
        if(item.getItemId()== R.id.vacationdelete) {
            for (Vacation vacation : repository.getALLVacations()) {
                if (vacation.getVacationID() == vacationID) currentVacation = vacation;
            }

            numExcursions = 0;
            for (Excursion excursion : repository.getmAllExcursions()) {
                if (excursion.getVacationID() == vacationID) ++numExcursions;
            }
            //B1.b:Implement validation so that a vacation cannot be deleted if excursions are associated with it.
            if (numExcursions == 0) {
                repository.delete(currentVacation);
                Toast.makeText(VacationDetails.this, currentVacation.getVacationTitle() + " was deleted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(VacationDetails.this, "Can't delete a vacation with excursions", Toast.LENGTH_LONG).show();
            }
            return true;
        }


        // Date format validation
      /*  SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date startDate = dateFormat.parse(editStartDate.getText().toString());
            Date endDate = dateFormat.parse(editEndDate.getText().toString());

            // Date comparison validation
            if (startDate.after(endDate)) {
                System.out.println("End date must be after the start date");
                Toast.makeText(VacationDetails.this, "End date must be after the start date", Toast.LENGTH_LONG).show();
                return true; // Prevent saving if the end date is before the start date
            }

            // Continue processing if date validation is successful
        } catch (ParseException e) {
            Toast.makeText(VacationDetails.this, "Invalid date format", Toast.LENGTH_LONG).show();
            return true; // Prevent saving if the date format is invalid
        }

       */
        return super.onOptionsItemSelected(item);
    }



}
