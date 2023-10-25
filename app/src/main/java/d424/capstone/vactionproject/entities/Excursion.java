package d424.capstone.vactionproject.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "excursion")
public class Excursion {
    @PrimaryKey(autoGenerate = true)
    private int excursionId;
    private String excursionTitle;
    private String date;
    private int vacationID;

    public Excursion(int excursionId, String excursionTitle, String date, int vacationID) {
        this.excursionId = excursionId;
        this.excursionTitle = excursionTitle;
        this.date = date;
        this.vacationID = vacationID;
    }

    public int getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(int excursionId) {
        this.excursionId = excursionId;
    }

    public String getExcursionTitle() {
        return excursionTitle;
    }

    public void setExcursionTitle(String excursionTitle) {
        this.excursionTitle = excursionTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVacationID() {
        return vacationID;
    }

    public void setVacationID(int vacationID) {
        this.vacationID = vacationID;
    }
}
