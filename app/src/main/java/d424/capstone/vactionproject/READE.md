///////////////////////// 1. title and purpose of the application//////////////////////////////////


The title of this app is called "Vacation Project". The purpose of this application is to provide
an minimal viable product for a database that represent a user inputting and tracking vacation and
excursions that go along with the vacation.


//////// 2. Here's information on how to operate the application and access each item from the rubric:////////////// 

                             Task Requirements and Explanations                 

B.  Create an Android mobile application, compatible with Android 8.0 and higher. The application must use the Room Framework as an abstraction layer over the local SQLite database to save the data. The application must include the following functional requirements:

- Located in the 'build.gradle.kts' (Module: app), you will find that the Room Framework has been added.

1.  Create a user option to enter, update and delete vacations.

a.  Allow the user to add as many vacations as desired.
- On the vacation detail page, there is a menu. On the menu, a user can save (add/update) and delete vacations.


b.  Implement validation so that a vacation cannot be deleted if excursions are associated with it.
- In the 'VacationDetail' code, there is validation for not allowing a vacation to be deleted if an excursion
is associated with it. While using the app, a small notification will appear at the bottom of the screen
saying that the excursions must be deleted before deleting a vacation. 

  

2.  Include the following details for each vacation:

•   title (e.g., Bermuda Trip, Spring Break, London Trip)

•   hotel or other place where you will be staying

•   start date

•   end date

- On the 'Vacation Detail' page on the app, the user will find text fields that allow the user to input
information for 'title', 'housing', 'start date', and 'end date'. If a vacation is already inputted,
and the user clicks on a vacation item from the 'vacation list', the user will find that the information
is there to be viewed. 


3.  Include features that allow the user to do the following for each vacation:

a.  Display a detailed view of the vacation, including all vacation details. This view can also be used to add and update the vacation information.
- If a vacation is already inputted, and the user clicks on a vacation item from the 'vacation list', the user will find that the information
  is there to be viewed.

b.  Enter, edit, and delete vacation information.
- By clicking on 'add vacation', the user can add vacation information. Click on delete, and the user can delete vacation information. Click on 
an existing vacation item, and the user can edit the information.

c.  Include validation that the input dates are formatted correctly.
- When inputting the start and end dates for the vacation, a calender will display. When the user clicks
on the respective date, the date will be formatted in MM/dd/yyyy to ensure all dates are properly formatted.

d.  Include validation that the vacation end date is after the start date.
- When a user tries to save a vacation that has a end date that is before the start date, a notification
will arrive stating that the end date is before the start date and the user will not be allowed
to save the vacation until the error is fixed.

e.  Include an alert that the user can set which will trigger on the start and end date, displaying the vacation title and whether it is starting or ending.
- When the user clicks on 'set alert for start date' or 'set alert for end date' from the 
'Vacation Details' menu options, an alert will be set for the dates and a notification will be sent
on the date given.

f.  Include sharing features so the user can share all the vacation details via a sharing feature (either e-mail, clipboard or SMS) that automatically populates with the vacation details.
- When the user clicks on 'share vacation details' from the menu options on the 'Vacation Details' page, 
the user will have the option on how to send the vacation details via text/email/etc. Once an option
is selected, the vacation details will automatically populate in the app.

g.  Display a list of excursions associated with each vacation.
- On the 'Vacation Details' page, a list of associated excursions will populate beneath the vacation
details if an excursion is in fact, associated with the vacation. 

h.  Add, update, and delete as many excursions as needed.
- When a user clicks to add an excursion, the user can add details for the excursion and save it
to the database. Once an excursion is saved by clicking on 'insert new excursion', the user can find it under the vacation the excursion
is associated with. When the user clicks on the excursion, they have the option to update the excursion 
by clicking on 'save old excursion', or delete the excursion by clicking on 'delete excursion'. 


4.  Include the following details for each excursion:

•   The excursion title (e.g., Snorkeling, Hiking, Bus Tour, Cooking Lesson)

•   The excursion date

- On the 'Excursion Details' page, the user will find view fields for 'title' and 'start date' for the excursion.


5.  Include features that allow the user to do the following for each excursion:

a.  Display a detailed view of the excursion, including the title, and date.
- On the 'Vacation Details' page, a list of associated excursions will populate beneath the vacation
details if an excursion is in fact, associated with the vacation. When the user clicks on the excursion, 
the user will find the excursion details populated in the view fields. 

b.  Enter, edit, and delete excursion information.
- When a user clicks to add an excursion, the user can add details for the excursion and save it
  to the database. Once an excursion is saved by clicking on 'insert new excursion', the user can find it under the vacation the excursion
  is associated with. When the user clicks on the excursion, they have the option to update the excursion
  by clicking on 'save old excursion', or delete the excursion by clicking on 'delete excursion'.

c.  Include validation that the input dates are formatted correctly.
- When inputting the start date for the excursion, a calender will display. When the user clicks
  on the date, the date will be formatted in MM/dd/yyyy to ensure all dates are properly formatted.

d.  Include an alert that the user can set that will trigger on the excursion date, stating the excursion title.
- When the user clicks on 'set alert for start date' from the 'Excursion Details' menu options, an alert will be set for the date and a notification will be sent
  on the date given.

e.  Include validation that the excursion date is during the associated vacation.
- When a user tries to save a excursion that has a start date that is before or after the vacation dates, a notification
  will arrive stating that the start date is not within the vacation dates. The user will not be allowed
  to save the excursion until the error is fixed.

/////////////////// 3. To which android version the signed APK is deployed /////////////////////////////

    xmlns:android="http://schemas.android.com/apk/res/android"
    android:versionCode="1"
    android:versionName="1.0"
    android:compileSdkVersion="33"
    android:compileSdkVersionCodename="13"
    package="com.example.vactionproject"
    platformBuildVersionCode="33"
    platformBuildVersionName="13">

    <uses-sdk
        android:minSdkVersion="26"
        android:targetSdkVersion="33" />


/////////////////////////////////4.  link to the git repository/////////////////////////////////////////


https://gitlab.com/wgu-gitlab-environment/student-repos/asimo29/d308-mobile-application-development-android





