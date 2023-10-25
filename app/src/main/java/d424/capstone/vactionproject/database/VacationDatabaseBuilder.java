package d424.capstone.vactionproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import d424.capstone.vactionproject.dao.ExcursionDAO;
import d424.capstone.vactionproject.dao.VacationDAO;
import d424.capstone.vactionproject.entities.Excursion;
import d424.capstone.vactionproject.entities.Vacation;

@Database(entities = {Vacation.class, Excursion.class}, version = 1, exportSchema = false)
public abstract class VacationDatabaseBuilder extends RoomDatabase {
    public abstract VacationDAO vacationDAO();
    public abstract ExcursionDAO excursionDAO();
    private static volatile VacationDatabaseBuilder INSTANCE;

    static VacationDatabaseBuilder getDatabase(final Context context){
        if (INSTANCE==null){
            synchronized (VacationDatabaseBuilder.class){
                INSTANCE= Room.databaseBuilder(context.getApplicationContext(),VacationDatabaseBuilder.class, "MyVacationDatabase.db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}
