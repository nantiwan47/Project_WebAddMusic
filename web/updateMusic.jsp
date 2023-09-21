<%-- 
    Document   : updateMusic
    Created on : 14 ส.ค. 2566, 21:24:30
    Author     : Mine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Music"%>
<%@page import="java.util.Arrays"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Music</title>
    </head>
    <body>
        <h1>แก้ไขเพลง</h1>
        <%
            Music music = (Music) session.getAttribute("music");
        %>
        <form action="AddNewMusicMySQL2" method="post">
            <table>
                <tr><th align=right>ชื่อเพลง:</th><td><input type="text" name="musicName" value="<%= music.getMusicName()%>"></td></tr>
                <tr><th align=right>ศิลปิน:</th><td><input type="text" name="artistName" value="<%= music.getArtistName()%>"></td></tr>
                <tr><th align=right>อัลบั้ม:</th><td><input type="text" name="albumName" value="<%= music.getAlbumName()%>"></td></tr>
                <tr>
                    <th align=right>แนวเพลง:</th>
                    <td>
                        <select name="musicType">
                            <option value="คลาสสิก" <%= music.getMusicType().equals("คลาสสิก") ? "selected" : "" %>>คลาสสิก</option>
                            <option value="ป๊อป" <%= music.getMusicType().equals("ป๊อป") ? "selected" : "" %>>ป๊อป</option>
                            <option value="แร็พ" <%= music.getMusicType().equals("แร็พ") ? "selected" : "" %>>แร็พ</option>
                            <option value="ฮิปฮอป" <%= music.getMusicType().equals("ฮิปฮอป") ? "selected" : "" %>>ฮิปฮอป</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th align=right>เนื้อหาเพลง:</th>
                    <td>
                        <input type="checkbox" name="lyrics" value="ความรัก"  <%=Arrays.asList(music.getLyrics()).contains("ความรัก") ? "checked" : "" %>>ความรัก
                        <input type="checkbox" name="lyrics" value="ความสัมพันธ์"  <%=Arrays.asList(music.getLyrics()).contains("ความสัมพันธ์") ? "checked" : "" %>>ความสัมพันธ์<br>
                        <input type="checkbox" name="lyrics" value="ความสนุกสนาน"  <%=Arrays.asList(music.getLyrics()).contains("ความสนุกสนาน") ? "checked" : "" %>>ความสนุกสนาน
                        <input type="checkbox" name="lyrics" value="ความหวัง"  <%=Arrays.asList(music.getLyrics()).contains("ความหวัง") ? "checked" : "" %>>ความหวัง<br>
                    </td>
                </tr>
                <tr><th align=right>วางจำหน่าย (พ.ศ.):</th><td><input type="text" name="releaseDate" value="<%= music.getReleaseDate() %>"></td></tr>
                <tr>
                    <th align=right>ระดับความชอบ:</th>
                    <td>
                        <input type="radio" name="likeLevel" value="ไม่ชอบ" <%= music.getLikeLevel().equals("ไม่ชอบ") ? "checked" : "" %>>ไม่ชอบ
                        <input type="radio" name="likeLevel" value="ชอบ" <%= music.getLikeLevel().equals("ชอบ") ? "checked" : "" %>>ชอบ
                        <input type="radio" name="likeLevel" value="ชอบมาก" <%= music.getLikeLevel().equals("ชอบมาก") ? "checked" : "" %>>ชอบมาก
                    </td>                
                </tr>
                <tr><th align=right>ความคิดเห็น:</th><td><textarea name="comments" rows="4" cols="50"><%= music.getComments() %></textarea></td></tr>
                <tr><td>&nbsp;</td><td><input type="submit" value="เพิ่มเพลง"></td></tr>
            </table>
        </form>
    </body>
</html>
<% session.removeAttribute("music");%>