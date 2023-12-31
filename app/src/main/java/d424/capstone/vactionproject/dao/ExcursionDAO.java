package d424.capstone.vactionproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import d424.capstone.vactionproject.entities.Excursion;

import java.util.List;

@Dao
public interface ExcursionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Excursion excursion);

    @Update
    void update(Excursion excursion);

    @Delete
    void delete(Excursion excursion);

    @Query("SELECT * FROM excursion ORDER BY excursionId ASC")
    List<Excursion> getALLExcursion();

    @Query("SELECT * FROM excursion WHERE vacationID=:vac ORDER BY excursionId ASC")
    List<Excursion> getAssociatedExcursions(int vac);

    @Query("SELECT * FROM excursion WHERE excursionId = :excursionId")
    Excursion getExcursionById(int excursionId);

}
