/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Calendar;
import dao.Dao_Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import dao.Dao_Curso;
import javax.swing.JOptionPane;

/**
 *
 * @author cristhiandc98
 */
@WebServlet(name = "Srvl_Inicio_Sesion", urlPatterns = {"/ingresar"})
public class Srvl_Inicio_Sesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ResultSet rs;
    byte cont = 1;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //******************************************************************
            try{
                Calendar cal= Calendar.getInstance();
                Dao_Usuario du = new Dao_Usuario();

                String perCod = "",
                       usuUsu = request.getParameter("txtUsu"),
                       usuPas = request.getParameter("txtPas");
                char veriFusu = 'F';
                ResultSet rs = du.select_verif_usuario(usuUsu,usuPas);
                //JOptionPane.showMessageDialog(null, 1);
                while(rs.next()){
                    HttpSession sesion = request.getSession();
                    perCod = rs.getString(1);
                    veriFusu =  perCod.charAt(0);
                    sesion.setAttribute("cod", perCod);
                    sesion.setAttribute("v_nom", rs.getString(4));
                    Dao_Curso dc = new Dao_Curso();
                    switch(veriFusu){
                        case 'A':
                            request.setAttribute("v_nom", rs.getString(4));
                            request.getRequestDispatcher("menu_Principal").forward(request, response);break;
                        case 'P':
                            request.setAttribute("v_nom", rs.getString(4));
                            request.setAttribute("v_listado_cursos",dc.select_aulas_profesor(perCod));
                            request.getRequestDispatcher("Prf_Aulas.jsp").forward(request, response);break;}} 
                if(veriFusu == 'F'){
                    //request.setAttribute("msj", "alertt()");
                    request.getRequestDispatcher("index.jsp").forward(request, response);}}
            catch(SQLException  sql){}
            //******************************************************************
        }}

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
