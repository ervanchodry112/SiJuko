package com.example.sijuko;

import java.util.ArrayList;

public class ArticleData {
    public static String[][] data = new String[][] {
            {"25 Februari 2022", "RAT Kopma Unila berlangsung selama 2 hari di Ruang Sidang Graha Kemahasiswaan",
            "Ervan Chodry"},
            {"1 Maret 2022", "Anniversary Kopma Unila berlangsung meriah",
            "Pynka Aryani"},
            {"25 Maret 2022", "Kopma Unila bersiap menyambut bulan Ramadhan dengan bakti Sosial",
            "Ervan Chodry"},
            {"25 April 2022", "Kopma Unila mengadakan kegiatan Ramadhan sebulan penuh",
            "Pynka Aryani"}
    };

    public static ArrayList<Article>getListData(){
        Article article = null;
        ArrayList<Article> list = new ArrayList<>();
        for (int i = 0; i<data.length;i++){
            article = new Article();
            article.setDate(data[i][0]);
            article.setJudul(data[i][1]);
            article.setAuthor(data[i][2]);
            list.add(article);
        }
        return list;
    }

}
