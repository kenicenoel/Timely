package kenice.com.timely.Adaptors;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseAdaptor
{
    private static final String TAG = "DatabaseAdaptor" ;
    DatabaseHelper helper;


    public DatabaseAdaptor(Context context)
    {
        helper = new DatabaseHelper(context);

    }

    // These functions are responsible for getting and selecting data and returning them

//    public void clearOldData()
//    {
//        SQLiteDatabase db = helper.getWritableDatabase();
//            db.delete(DatabaseHelper.TABLE_NAME_PACKAGE, null, null);
//            db.delete(DatabaseHelper.TABLE_NAME_CUSTOMER, null, null);
//            db.delete(DatabaseHelper.TABLE_NAME_INVOICEDETAILS, null, null);
//            db.delete(DatabaseHelper.TABLE_NAME_INVOICEMASTER, null, null);
//            db.delete(DatabaseHelper.TABLE_NAME_INVOICESIGNATURES, null, null);
//            db.delete(DatabaseHelper.TABLE_NAME_MAPPOINTS, null, null);
//            db.delete(DatabaseHelper.TABLE_NAME_PAYMENT, null, null);
//            db.delete(DatabaseHelper.TABLE_NAME_PACKAGEEVENT, null, null);
//            db.delete(DatabaseHelper.TABLE_NAME_CONTACT, null,null);
//            db.delete(DatabaseHelper.TABLE_NAME_DELIVERIES, null, null);
//
//    }
//
//    public long insertPackageData(String packageNumber, String trackingNumber, String supplier, String packageDescription, double totalWeight, String shipper, double packagevalue, int accountNumber, String notes, String packageStatus, String internalStatus)
//    {
//        SQLiteDatabase db = helper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHelper.COLUMN_PACKAGENUMBER, packageNumber);
//        contentValues.put(DatabaseHelper.COLUMN_INTERNATIONALTRACKINGNUMBER, trackingNumber);
//        contentValues.put(DatabaseHelper.COLUMN_SUPPLIER, supplier);
//        contentValues.put(DatabaseHelper.COLUMN_PACKAGEDESCRIPTION, packageDescription);
//        contentValues.put(DatabaseHelper.COLUMN_TOTALWEIGHT, totalWeight);
//        contentValues.put(DatabaseHelper.COLUMN_SHIPPER, shipper);
//        contentValues.put(DatabaseHelper.COLUMN_PACKAGEVALUE, packagevalue);
//        contentValues.put(DatabaseHelper.COLUMN_ACCOUNTNUMBER, accountNumber);
//        contentValues.put(DatabaseHelper.COLUMN_NOTES, notes);
//        contentValues.put(DatabaseHelper.COLUMN_PACKAGESTATUS, packageStatus);
//        contentValues.put(DatabaseHelper.COLUMN_INTERNALSTATUS, internalStatus);
//
//       long id =  db.insert(DatabaseHelper.TABLE_NAME_PACKAGE, null, contentValues);
//
//        return id;
//    }
//
//
//
//
//
//    public int updatePackagePackageStatus(String packageNumber, String status)
//
//    {
//        SQLiteDatabase db = helper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(DatabaseHelper.COLUMN_PACKAGESTATUS, status);
//        values.put(DatabaseHelper.COLUMN_MODIFIED, "TRUE");
//        String where = DatabaseHelper.COLUMN_PACKAGENUMBER + " = ?";
//        String[] whereArgs = {packageNumber};
//
//        int numberRowsUpdated = db.update(DatabaseHelper.TABLE_NAME_PACKAGE, values, where, whereArgs);
//        Log.d(TAG, numberRowsUpdated+" rows were affected.");
//
//        return numberRowsUpdated;
//    }
//
//
//    public int getCountOfTheTotalCustomersDueDelivery()
//    {
//        SQLiteDatabase db = helper.getWritableDatabase();
//        final String query = "SELECT "+ DatabaseHelper.COLUMN_FIRSTNAME+", " +
//                ""+ DatabaseHelper.COLUMN_LASTNAME+", " +
//                ""+ DatabaseHelper.TABLE_NAME_PACKAGE+"."+ DatabaseHelper.COLUMN_ACCOUNTNUMBER+", " +
//                ""+ DatabaseHelper.TABLE_NAME_CUSTOMER+"."+ DatabaseHelper.COLUMN_PRIMARYDELIVERYSTREET1+", " +
//                ""+ DatabaseHelper.TABLE_NAME_CUSTOMER+"."+ DatabaseHelper.COLUMN_PRIMARYDELIVERYSTREET2+", " +
//                ""+ DatabaseHelper.TABLE_NAME_CUSTOMER+"."+ DatabaseHelper.COLUMN_PRIMARYDELIVERYCITY+", " +
//                ""+ DatabaseHelper.COLUMN_TEL1+", " +
//                "count("+ DatabaseHelper.COLUMN_PACKAGENUMBER+") AS' numberOfPackages' " +
//                "FROM "+ DatabaseHelper.TABLE_NAME_CUSTOMER+" " +
//                "INNER JOIN "+ DatabaseHelper.TABLE_NAME_PACKAGE+" " +
//                "ON "+ DatabaseHelper.TABLE_NAME_CUSTOMER+"."+ DatabaseHelper.COLUMN_ACCOUNTNUMBER+"="+ DatabaseHelper.TABLE_NAME_PACKAGE+"."+ DatabaseHelper.COLUMN_ACCOUNTNUMBER+" " +
//                " WHERE "+ DatabaseHelper.TABLE_NAME_PACKAGE+"."+ DatabaseHelper.COLUMN_PACKAGESTATUS+"='Out for Delivery'"+
//                "GROUP BY "+ DatabaseHelper.TABLE_NAME_PACKAGE+"."+ DatabaseHelper.COLUMN_ACCOUNTNUMBER;
//
//
//        Cursor cursor = db.rawQuery(query, null);
//        int count = cursor.getCount();
//
//        return count;
//
//
//    }



    ////////////////////////////////////////////////////////////////////////////////////




    public class DatabaseHelper extends SQLiteOpenHelper
    {
        // Increment Database Version every time you make changes to trigger onUpgrade
        public static final int DATABASE_VERSION        = 1;
        public static final String DATABASE_NAME        = "courier.db";

        // THE TABLE NAMES DEFINITION
        public static final String TABLE_NAME_COURSE   = "course";
        public static final String TABLE_NAME_COURSE_SCHEDULE  = "schedule";
        public static final String TABLE_NAME_EXAM = "exam";
        public static final String TABLE_NAME_CLASSROOM     = "classroom";
        public static final String TABLE_NAME_LECTURER     = "lecturer";

        // Common Columns
        public static final String COLUMN_COURSE_CODE = "_courseCode";
        public static final String COLUMN_TIME      = "time";
        public static final String COLUMN_DURATION         = "duration";
        public static final String COLUMN_ROOM = "room";
        public static final String COLUMN_LECTURER_ID = "_lecturerId";

        // Course TABLE COLUMNS
        public static final String COLUMN_COURSE_TITLE = "courseTitle";
        public static final String COLUMN_LEVEL     = "courseLevel";



        // EXAM TABLE COLUMNS
        public static final String COLUMN_EXAM_ID = "_examId";
        public static final String COLUMN_EXAM_TITLE        = "examTitle";
        public static final String COLUMN_DATE     = "examDate";
        public static final String COLUMN_NOTES  = "notes";


        // LECTURER TABLE COLUMNS
        public static final String COLUMN_NAME = "name";

        // SCHEDULE TABLE COLUMNS
        public static final String COLUMN_DAY = "day";
        public static final String COLUMN_SCHEDULE_NUMBER = "_scheduleNumber";


        // Room TABLE COLUMNS
        public static final String COLUMN_ROOM_ID = "_roomId";
        public static final String COLUMN_ROOM_NAME = "roomName";
        public static final String COLUMN_LOCATION = "location";





        //CREATE COURSE TABLE SQL
        private static final String CREATE_COURSE_TABLE = "create table " + TABLE_NAME_COURSE + "("
                + COLUMN_COURSE_CODE + " VARCHAR(10) NOT NULL PRIMARY KEY, "
                + COLUMN_COURSE_TITLE + " VARCHAR(60) not null, "
                + COLUMN_LEVEL + " INT(1) not null, "
                + COLUMN_LECTURER_ID + " INT(10) not null) ";

        //CREATE Exam TABLE SQL
        private static final String CREATE_EXAM_TABLE = "CREATE TABLE " + TABLE_NAME_EXAM + "("
                + COLUMN_EXAM_ID + " INTEGER NOT NULL PRIMARY KEY "
                + COLUMN_EXAM_TITLE + " VARCHAR(50) not null, "
                + COLUMN_COURSE_CODE + " VARCHAR(10) not null, "
                + COLUMN_DATE + " DATE not null, "
                + COLUMN_TIME + " DATETIME not null, "
                + COLUMN_DURATION + " INT(2) not null, "
                + COLUMN_NOTES + " VARCHAR(200) not null) ";


        //CREATE CLASSROOM TABLE SQL
        private static final String CREATE_CLASSROOM_TABLE = "CREATE TABLE " +TABLE_NAME_CLASSROOM +"("
                + COLUMN_ROOM_ID +" INTEGER PRIMARY KEY not null, "
                + COLUMN_ROOM_NAME +" VARCHAR(50) not null, "
                + COLUMN_LOCATION +" VARCHAR(50) not null) ";


        //CREATE COURSE SCHEDULE TABLE SQL
        private static final String CREATE_SCHEDULE_TABLE = "CREATE TABLE " +TABLE_NAME_COURSE_SCHEDULE +"("
                + COLUMN_COURSE_CODE + " VARCHAR(10) not null, "
                + COLUMN_DAY +" VARCHAR(10) not null, "
                + COLUMN_TIME + " DATETIME not null, "
                + COLUMN_DURATION + " INT(2) not null, "
                + COLUMN_ROOM_ID +" INTEGER)";

        //CREATE LECTURER TABLE SQL
        private static final String CREATE_LECTURER_TABLE = "CREATE TABLE " +TABLE_NAME_LECTURER +"("
                + COLUMN_LECTURER_ID +" INTEGER not null PRIMARY KEY, "
                + COLUMN_NAME +" VARCHAR(50) not null)";




        // Drop table statement tables
        private static final String DROP_TABLE_COURSE = "DROP TABLE " + TABLE_NAME_COURSE+ " IF EXISTS";
        private static final String DROP_TABLE_EXAM = "DROP TABLE " + TABLE_NAME_EXAM+ " IF EXISTS";
        private static final String DROP_TABLE_COURSE_SCHEDULE= "DROP TABLE " + TABLE_NAME_COURSE_SCHEDULE+ " IF EXISTS";
        private static final String DROP_TABLE_LECTURER = "DROP TABLE " + TABLE_NAME_LECTURER+ " IF EXISTS";
        private static final String DROP_TABLE_CLASSROOM = "DROP TABLE " + TABLE_NAME_CLASSROOM+ " IF EXISTS";





        /* Alter statements for the users who already have the app installed
            ------------------------------------------------------------------
            NB: Alter the create statements that are run inside the onCreate function.
            So, if a column is added as part of an update, add it in the create statement inside the
            onCreate function (for new users) and as an alter statement inside the onUpgrade function
            (for existing users).

            Don't forget to Increment Database Version every time you make changes to trigger onUpgrade
            ---------------------------------------------------------------------------------------- */

            // Example alter statement: (Copy and paste then call inside onUpgrade) copy & modify everything between arrows
                // --> private static final String DATABASE_ALTER = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + COLUMN_NAME + " VARCHAR(30);"; <--

//        private static final String DATABASE_ALTER_MESSAGES = "ALTER TABLE " + DatabaseHelper.TABLE_NAME_MESSAGES + " ADD COLUMN " + DatabaseHelper.COLUMN_SYNCSTATUS + " VARCHAR(5) DEFAULT 'FALSE';";


        public DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }


        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try
            {

                db.execSQL(CREATE_COURSE_TABLE);
                db.execSQL(CREATE_EXAM_TABLE);
                db.execSQL(CREATE_SCHEDULE_TABLE);
                db.execSQL(CREATE_CLASSROOM_TABLE);
                db.execSQL(CREATE_LECTURER_TABLE);

            }

            catch (Exception e)
            {
                e.printStackTrace();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {


            Log.d(TAG, "Database upgrade in progress");

            // if the user's installed database version is older than the current version number
//            if (oldVersion < newVersion)
//            {
//                db.execSQL(DATABASE_ALTER_MESSAGES);
//            }

        }
    }
}
