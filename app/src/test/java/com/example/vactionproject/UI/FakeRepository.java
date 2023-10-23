package com.example.vactionproject.UI;

import com.example.vactionproject.database.RepositoryInterface;
import com.example.vactionproject.entities.Excursion;
import com.example.vactionproject.entities.Vacation;

import java.util.ArrayList;
import java.util.List;

public class FakeRepository implements RepositoryInterface {
    private List<Vacation> fakeVacations;
    private List<Excursion> fakeExcursions;

    public FakeRepository() {
        fakeVacations = new ArrayList<>();
        fakeExcursions = new ArrayList<>();
        fakeVacations.add(new Vacation(1, "Fake Vacation 1", "Location 1", "2023-01-01", "2023-01-10"));
        fakeVacations.add(new Vacation(2, "Fake Vacation 2", "Location 2", "2023-02-01", "2023-02-10"));
        fakeExcursions.add(new Excursion(1, "Excursion 1", "Description 1", 1));
        fakeExcursions.add(new Excursion(2, "Excursion 2", "Description 2", 1));
    }

    @Override
    public List<Vacation> getALLVacations() {
        return fakeVacations;
    }

    @Override
    public void insert(Vacation vacation) {
        fakeVacations.add(vacation);
    }

    @Override
    public void update(Vacation vacation) {
        for (int i = 0; i < fakeVacations.size(); i++) {
            if (fakeVacations.get(i).getVacationID() == vacation.getVacationID()) {
                fakeVacations.set(i, vacation);
                break;
            }
        }
    }

    @Override
    public void delete(Vacation vacation) {
        fakeVacations.removeIf(v -> v.getVacationID() == vacation.getVacationID());
    }

    @Override
    public List<Excursion> getmAllExcursions() {
        return fakeExcursions;
    }

    @Override
    public List<Excursion> getAssociatedExcursions(int vacationID) {
        return null;
    }

    @Override
    public void insert(Excursion excursion) {
    }

    @Override
    public void update(Excursion excursion) {
    }

    @Override
    public void delete(Excursion excursion) {
    }

    @Override
    public Excursion getExcursionById(int excursionId) {
        return fakeExcursions.stream()
                .filter(e -> e.getExcursionId() == excursionId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Vacation getVacationByID(int vacationID) {
        return fakeVacations.stream()
                .filter(v -> v.getVacationID() == vacationID)
                .findFirst()
                .orElse(null);
    }
}