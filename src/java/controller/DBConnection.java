/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import model.Music;

public class DBConnection {

    public boolean insertNewMusic(Music music) {
        boolean result = false;
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projectMusic",
                    "my_root", "UBU_12345678");

            Statement statement;
            statement = connection.createStatement();

            // สร้าง String lyrics คั่นด้วย ;
            String lyrics = "";
            int nl = music.getLyrics().length;

            // วนลูปสร้างแค่ music.getLyrics().length ลบ 1 เพื่อไม่ให้มี ; ปิดท้าย String
            for (int i = 0; i < nl - 1; i++) {
                lyrics = lyrics + music.getLyrics()[i] + ";";
            }
            // เพิ่มค่า lyrics ตำแหน่งสุดท้ายเข้าไป
            lyrics = lyrics + music.getLyrics()[nl - 1];

            String query = "INSERT INTO music "
                    + "( musicName, artistName, albumName, musicType, lyrics, releaseDate, likeLevel, comments)"
                    + "VALUES('"
                    + music.getMusicName() + "','"
                    + music.getArtistName() + "','"
                    + music.getAlbumName() + "','"
                    + music.getMusicType() + "','"
                    + lyrics + "',"
                    + music.getReleaseDate() + ",'"
                    + music.getLikeLevel() + "','"
                    + music.getComments() + "')";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);	// executeUpdate returns row count ****
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return result;
    }

    public boolean updateMusic(Music music) {
        boolean result = false;
        Connection connection = null;
        try {
            // บรรทัดด้านล่างใช้สำหรับเชื่อมต่อ
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projectMusic",
                    "my_root", "UBU_12345678");

            Statement statement;
            statement = connection.createStatement();
            
             // สร้าง String lyrics คั่นด้วย ;
            String lyrics = "";
            int nl = music.getLyrics().length;

            // วนลูปสร้างแค่ music.getLyrics().length ลบ 1 เพื่อไม่ให้มี ; ปิดท้าย String
            for (int i = 0; i < nl - 1; i++) {
                lyrics = lyrics + music.getLyrics()[i] + ";";
            }
            // เพิ่มค่า lyrics ตำแหน่งสุดท้ายเข้าไป
            lyrics = lyrics + music.getLyrics()[nl - 1];

            // ใช้คำสั่ง SQL สำหรับ update ข้อมูลที่ตรงกับเงื่อนไขที่ต้องการ
            String query = "UPDATE music SET "
                    + "artistName='" + music.getArtistName() + "', "
                    + "albumName='" + music.getAlbumName() + "', "
                    + "musicType='" + music.getMusicType() + "', "
                    + "lyrics='" + lyrics + "', "
                    + "releaseDate=" + music.getReleaseDate() + ", "
                    + "likeLevel='" + music.getLikeLevel() + "', "
                    + "comments='" + music.getComments() + "' "
                    + "WHERE musicName='" + music.getMusicName() + "'";

            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);    // executeUpdate คืนค่าจำนวนแถวที่ถูกแก้ไข ****
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return result;
    }
}
