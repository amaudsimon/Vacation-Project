package com.example.vactionproject.database;

import com.example.vactionproject.entities.Excursion;
import com.example.vactionproject.entities.Vacation;

import java.util.List;

public interface RepositoryInterface {
    List<Vacation> getALLVacations();
    void insert(Vacation vacation);
    void update(Vacation vacation);
    void delete(Vacation vacation);

    List<Excursion> getmAllExcursions();
    List<Excursion> getAssociatedExcursions(int vacationID);
    void insert(Excursion excursion);
    void update(Excursion excursion);
    void delete(Excursion excursion);

    Excursion getExcursionById(int excursionId);
    Vacation getVacationByID(int vacationID);
}
