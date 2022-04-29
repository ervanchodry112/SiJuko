package com.example.sijuko;

import java.util.ArrayList;

public class TransactionData {

    public static String[][] data = new String[][] {
            {"3 Januari 2022", "Pembayaran Simpanan",
                    "+Rp10000"},
            {"25 Februari 2022", "Pembayaran Simpanan",
                    "+Rp10000"},
            {"1 Maret 2022", "Pembayaran Simpanan",
                    "+Rp10000"},
            {"25 Maret 2022", "Pembayaran Simpanan",
                    "+Rp10000"},
            {"25 April 2022", "Pembayaran Simpanan",
                    "+Rp10000"}

    };

    public static ArrayList<Transaction>getListTransaction(){
        Transaction transaction = null;
        ArrayList<Transaction> list = new ArrayList<>();
        for (int i = 0; i<data.length;i++){
            transaction = new Transaction();
            transaction.setDate(data[i][0]);
            transaction.setName(data[i][1]);
            transaction.setNominal(data[i][2]);
            list.add(transaction);
        }
        return list;
    }
}
