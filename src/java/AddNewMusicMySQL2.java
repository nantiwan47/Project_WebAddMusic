/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import controller.DBConnection;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Music;

/**
 *
 * @author Mine
 */
@WebServlet(urlPatterns = {"/AddNewMusicMySQL2"})
public class AddNewMusicMySQL2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // get parameters
        String musicName = request.getParameter("musicName");
        String artistName = request.getParameter("artistName");
        String albumName = request.getParameter("albumName");
        String musicType = request.getParameter("musicType");
        String[] lyrics = request.getParameterValues("lyrics");
        int releaseDate = Integer.parseInt(request.getParameter("releaseDate"));
        String likeLevel = request.getParameter("likeLevel");
        String comments = request.getParameter("comments");

        // create an instance of music
        Music music = new Music();
        music.setMusicName(musicName);
        music.setArtistName(artistName);
        music.setAlbumName(albumName);
        music.setMusicType(musicType);
        music.setLyrics(lyrics);
        music.setReleaseDate(releaseDate);
        music.setLikeLevel(likeLevel);
        music.setComments(comments);

        // update into MySQL: table music
        DBConnection dbConnection = new DBConnection();
        if (!dbConnection.updateMusic(music)) {
            System.out.println(">>> AddNewMusicMySQL ERROR");
        }

        // forward to addNewFoodSuccess.jsp
        HttpSession session = request.getSession();
        session.setAttribute("music", music);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/addMusicSuccess.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
