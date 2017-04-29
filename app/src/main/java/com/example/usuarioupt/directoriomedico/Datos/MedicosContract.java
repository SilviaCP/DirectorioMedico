package com.example.usuarioupt.directoriomedico.Datos;

import android.provider.BaseColumns;

/**
 * Created by USUARIOUPT on 29/04/2017.
 */

public class MedicosContract {

    public static abstract class MedicoEntry implements BaseColumns{

        public static final String TABLE_NAME = "medicos";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SPECIALTY = "specialty";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String BIO = "bio";
        public static final String AVATAR_URI = "avatarUri";
    }

}
