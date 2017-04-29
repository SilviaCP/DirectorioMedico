package com.example.usuarioupt.directoriomedico.Datos;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

/**
 * Created by USUARIOUPT on 29/04/2017.
 */

public class Medicos {

    private String id;
    private String name;
    private String speciality;
    private String phoneNumber;
    private String bio;
    private String avatarUri;


    public ContentValues toContentValues(){

        ContentValues contentValues = new ContentValues();
        contentValues.put(MedicosContract.MedicoEntry.ID,id);
        contentValues.put(MedicosContract.MedicoEntry.NAME,name);
        contentValues.put(MedicosContract.MedicoEntry.SPECIALTY,speciality);
        contentValues.put(MedicosContract.MedicoEntry.PHONE_NUMBER,phoneNumber);
        contentValues.put(MedicosContract.MedicoEntry.BIO,bio);
        contentValues.put(MedicosContract.MedicoEntry.AVATAR_URI,avatarUri);

        return contentValues;
    }

    public Medicos(Cursor c){
        id = c.getString(c.getColumnIndex(MedicosContract.MedicoEntry.ID));
        name = c.getString(c.getColumnIndex(MedicosContract.MedicoEntry.NAME));
        speciality = c.getString(c.getColumnIndex(MedicosContract.MedicoEntry.SPECIALTY));
        phoneNumber = c.getString(c.getColumnIndex(MedicosContract.MedicoEntry.PHONE_NUMBER));
        bio = c.getString(c.getColumnIndex(MedicosContract.MedicoEntry.BIO));
        avatarUri = c.getString(c.getColumnIndex(MedicosContract.MedicoEntry.AVATAR_URI));
    }

    public Medicos(String name, String speciality, String phoneNumber, String bio, String avatarUri) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.avatarUri = avatarUri;
    }

    public Medicos(String id, String name, String speciality, String phoneNumber, String bio, String avatarUri) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.avatarUri = avatarUri;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public String getAvatarUri() {
        return avatarUri;
    }
}
