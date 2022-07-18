package com.kopmaul.sijuko;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.kopmaul.sijuko.Model.DataAnggota;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGED_IN = "isLogedIn";
    public static final String NPM = "npm";
    public static final String NAMA = "nama";
    public static final String NOMOR_ANGGOTA = "nomor_anggota";
    public static final String EMAIL = "email";
    public static final String NO_HANDPHONE = "noHandphone";
    public static final String REFERAL = "referal";

    public SessionManager(Context _context) {
        this._context = _context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(_context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(DataAnggota user){
        editor.putBoolean(IS_LOGED_IN, true);
        editor.putString(NPM, user.getNpm());
        editor.putString(NAMA, user.getNamaLengkap());
        editor.putString(NOMOR_ANGGOTA, user.getNomorAnggota());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(NO_HANDPHONE, user.getNomorHp());
        editor.putString(REFERAL, user.getNamaLengkap().substring(0,3).toUpperCase()+user.getNomorAnggota().substring(0,4));
        editor.commit();
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(NPM, sharedPreferences.getString(NPM, null));
        user.put(NAMA, sharedPreferences.getString(NAMA, null));
        user.put(NOMOR_ANGGOTA, sharedPreferences.getString(NOMOR_ANGGOTA, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(NO_HANDPHONE, sharedPreferences.getString(NO_HANDPHONE, null));
        user.put(REFERAL, sharedPreferences.getString(REFERAL, null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.putBoolean(IS_LOGED_IN, false);
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGED_IN, false);
    }
}
