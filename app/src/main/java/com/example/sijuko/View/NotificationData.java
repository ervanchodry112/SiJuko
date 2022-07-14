package com.example.sijuko.View;

import java.util.ArrayList;

public class NotificationData {

    public static String[][] data = new String[][] {
            {"3 Januari 2022", "Open Recruitment Panitia Diksarkop",
                    "SEMANGAT PAGI! Open Recruitment Panitia Diksarkop Periode 1 tahun 2022,.."},
            {"25 Februari 2022", "Anniversary Kopma Unila ke-40",
                    "SEMANGAT PAGI! Untuk seluruh anggota Kopma Unila diundang untuk mengha.."},
            {"1 Maret 2022", "Kegiatan Ramadhan Kopma Unila 2022",
                    "Halo Coppers, hari sabtu, 22 April nanti kita akan mengadakan kegiatan b.."},
            {"25 Maret 2022", "Buka Puasa Bersama Keluarga Kopma Unila",
                    "Diberitahukan kepada seluruh anggota kopma unila bahwa akan diadakan kegi.."},
            {"25 April 2022", "Lebaran Online",
                    "Minal Aidzin Walfaidzin, mari kita saling maaf memaafkan dengan mengikuti.."}
    };

    public static ArrayList<Notification> getListNotification(){
        Notification notification = null;
        ArrayList<Notification> list = new ArrayList<>();
        for (int i = 0; i<data.length;i++){
            notification = new Notification();
            notification.setDate(data[i][0]);
            notification.setTitle(data[i][1]);
            notification.setDescription(data[i][2]);
            list.add(notification);
        }
        return list;
    }

}
