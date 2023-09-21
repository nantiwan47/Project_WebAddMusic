<%-- 
    Document   : addMusicSuccess
    Created on : Jul 13, 2023, 2:03:44 PM
    Author     : SciLab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Music" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>successfully</title>
    </head>
    <body>
        <h1>เพิ่มเพลงสำเร็จ</h1>
        <%
            Music music = (Music) session.getAttribute("music");
        %>
        ชื่อเพลง: <%= music.getMusicName()%><br>
        ศิลปิน: <%= music.getArtistName()%><br>
        อัลบั้ม: <%= music.getAlbumName()%><br>
        แนวเพลง: <%= music.getMusicType()%><br>
        เนื้อหาเพลง: <%
            for (String n : music.getLyrics()) {
                out.print(n + " ");
            }
        %><br/>
        วางจำหน่าย (พ.ศ.): <%= music.getReleaseDate()%><br>
        ระดับความชอบ: <%= music.getLikeLevel()%><br>
        ความคิดเห็น: <%= music.getComments()%><br>          
        <a href="index.html">"Home"</a><br>
        <a href="updateMusic.jsp">"แก้ไข"</a><br>
    </body>
</html>
