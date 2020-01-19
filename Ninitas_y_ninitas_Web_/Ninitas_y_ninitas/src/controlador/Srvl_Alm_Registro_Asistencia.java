package controlador;

import dao.Dao_Alm_Asistecia_General;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//********************************
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import javax.swing.JOptionPane;

/**
 *
 * @author cristhiandc98
 */
@WebServlet(name = "Srvl_Alm_Registro_Asistencia", urlPatterns = {"/Srvl_Alm_Registro_Asistencia"})
public class Srvl_Alm_Registro_Asistencia extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
//******************************************************************
try{Date date = new Date();
    int i = 0;  
    DateFormat fh = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    String txtUsu = request.getParameter("txtUsu");
    String txtpas = request.getParameter("txtPas");
    String fchHr = fh.format(date);
    Dao_Alm_Asistecia_General da = new Dao_Alm_Asistecia_General();
    String cod = da.codd(txtUsu, txtpas);
    if(da.verif_si_asiii(cod, fchHr) == false){
        da.istAsistencia(txtUsu, txtpas, fchHr); 
        i = 1;}
    else{
        if(da.verif_si_sal(cod, fchHr) == false){
            da.istSali(txtUsu, txtpas, fchHr);
            i = 2;}
        else{
            i = 3;}}
    
    request.setAttribute("ml", i);
    request.getRequestDispatcher("Alm_Registro_Asistencia.jsp").forward(request, response);}   
catch(Exception sqle){
    JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto"); 
    request.getRequestDispatcher("Alm_Registro_Asistencia.jsp").forward(request, response);}
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
