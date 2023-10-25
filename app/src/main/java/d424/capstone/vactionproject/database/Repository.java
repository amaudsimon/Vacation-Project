package d424.capstone.vactionproject.database;

import static java.util.concurrent.Executors.newFixedThreadPool;

import android.app.Application;

import d424.capstone.vactionproject.dao.ExcursionDAO;
import d424.capstone.vactionproject.dao.VacationDAO;
import d424.capstone.vactionproject.entities.Excursion;
import d424.capstone.vactionproject.entities.Vacation;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class Repository {
    private ExcursionDAO mExcursionDAO;
    private VacationDAO mVacationDAO;

    private List<Vacation> mALLVacations;
    private List<Excursion> mAllExcursions;

    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor=newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        VacationDatabaseBuilder db=VacationDatabaseBuilder.getDatabase(application);
        mExcursionDAO=db.excursionDAO();
        mVacationDAO=db.vacationDAO();
    }
    ///////////////////////////VACATIONS//////////////////////////////////
    public List<Vacation>getALLVacations(){
        databaseExecutor.execute(()->{
            mALLVacations=mVacationDAO.getALLVacations();
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mALLVacations;
    }
////////////////////////////////////////////////////////////
    public void insert(Vacation vacation){
        databaseExecutor.execute(()->{
            mVacationDAO.insert(vacation);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////
    public void update(Vacation vacation){
        databaseExecutor.execute(()->{
            mVacationDAO.update(vacation);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////
    public void delete(Vacation vacation){
        databaseExecutor.execute(()->{
            mVacationDAO.delete(vacation);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    ///////////////////////EXCURSIONS////////////////////////////////
    public List<Excursion>getmAllExcursions(){
        databaseExecutor.execute(()->{
            mAllExcursions=mExcursionDAO.getALLExcursion();
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllExcursions;
    }
    ////////////////////////////////////////////////////////////////
    public List<Excursion>getAssociatedExcursions(int vacationID){
        databaseExecutor.execute(()->{
            mAllExcursions=mExcursionDAO.getAssociatedExcursions(vacationID);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllExcursions;
    }
    ////////////////////////////////////////////////////////////////
    public void insert (Excursion excursion){
        databaseExecutor.execute(()->{
            mExcursionDAO.insert(excursion);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////
    public void update (Excursion excursion){
        databaseExecutor.execute(()->{
            mExcursionDAO.update(excursion);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////
    public void delete (Excursion excursion){
        databaseExecutor.execute(()->{
            mExcursionDAO.delete(excursion);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////
    public Excursion getExcursionById(int excursionId) {
        return mExcursionDAO.getExcursionById(excursionId);
    }

    public Vacation getVacationByID(int vacationID) {
        return mVacationDAO.getVacationByID(vacationID);
    }
}
