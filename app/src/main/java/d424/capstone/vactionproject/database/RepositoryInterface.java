package d424.capstone.vactionproject.database;

import d424.capstone.vactionproject.entities.Excursion;
import d424.capstone.vactionproject.entities.Vacation;

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
