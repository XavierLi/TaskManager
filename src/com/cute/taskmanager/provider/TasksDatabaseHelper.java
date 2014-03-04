package com.cute.taskmanager.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TasksDatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tasks.db";

    public interface Tables {
        public static final String USERS = "users";
        public static final String PROJECTS = "projects";
        public static final String SCHEDULES = "schedules";
        public static final String CUSTOMERS = "customers";
        public static final String CONTACTS = "contacts";
    }

    public interface UsersColumns {
        public static final String ACCOUNT = "account";
        public static final String USER_NAME = "user_name";
        public static final String ANNUAL_TARGET = "annual_target";
        public static final String COMPLETED = "completed";
    }

    public interface ProjectsColumns {
        public static final String PROJECT_NAME = "project_name";
        public static final String PRIORITY = "priority";
    }

    public interface SchedulesColumns {
        public static final String START_TIME = "start_time";
        public static final String PROJECT_ID = "project_id";
        public static final String CUSTOMER_ID = "customer_id";
        public static final String STATUS = "status";
        public static final String NOTE = "note";
    }

    public interface CustomersColumns {
        public static final String CUSTOMER_NAME = "customer_name";
        public static final String BUSINESS_DESCRIPTION = "business_description";
        public static final String COMPANY_ADDRESS = "company_address";
        public static final String CUSTOMER_CATEGORY = "customer_category";

        public static final int CATEGORY_HOST_MANUFACTURER = 0;
        public static final int CATEGORY_INSTITUTE_OF_DESIGN = 1;
        public static final int CATEGORY_GENERAL_CONTRACTOR = 2;
        public static final int CATEGORY_DIRECT_OWNER = 3;
        public static final int CATEGORY_OTHERS = 4;
    }

    public interface ContactsColumns {
        public static final String CONTACT_NAME = "contact_name";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String EMAIL = "email";
        public static final String OFFICE_ADDRESS = "office_address";
        public static final String CHARACTERS = "characters";
    }

    public TasksDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Tables.USERS + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UsersColumns.ACCOUNT + " TEXT," +
                UsersColumns.USER_NAME + " TEXT," +
                UsersColumns.ANNUAL_TARGET + " INTEGER NOT NULL DEFAULT 0," +
                UsersColumns.COMPLETED + " INTEGER NOT NULL DEFAULT 0");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
