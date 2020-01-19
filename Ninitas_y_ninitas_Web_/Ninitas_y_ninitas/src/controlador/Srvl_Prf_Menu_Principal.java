/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.Dao_Curso;
import entidad.Ent_Actividades;
import java.util.Calendar;
import dao.Dao_Actividades;
import dao.Dao_Aula;
import dao.Dao_Libreta;

/**
 *
 * @author cristhiandc98
 */
@WebServlet(name = "Srvl_Prf_Menu_Principal", urlPatterns = {"/p_menu_principal","/aula","/p_tarea",
    "/p_n_tarea","/p_a_tarea","/b_tarea","/puntuar_tarea","/inser_nota","/newjsp","/p_citaciones","/inser_citacion",
    "/p_registrar_asistencia","/p_insert_asistencia","/p_libreta"})
public class Srvl_Prf_Menu_Principal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Dao_Curso dc;
    HttpSession ss;
    ResultSet rs;
    Ent_Actividades ea;
    Dao_Actividades da;
    Calendar cal= Calendar.getInstance();
    Dao_Aula dau;
    Dao_Libreta dl;
    
    String repetidor = "";
    String ss_ac = "";
    int numAlu = 0;
    String libreta = "";
    
    public String fechaActual(){
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes= cal.get(Calendar.MONTH) + 1;
        int anio = cal.get(Calendar.YEAR);
        String fechaStriniada = anio + "-" + mes + "-" + dia;
        return fechaStriniada;}
    
    public String fechaActual2(){
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes= cal.get(Calendar.MONTH) + 1;
        int anio = cal.get(Calendar.YEAR);
        String dias = ""+dia,mess  = ""+mes, anios = ""+anio;
        if(dia < 10){
            dias = "0"+dia;}
        if(mes < 10){
            mess = "0"+mes;}
        String fechaStriniada = anios + "-" + mess + "-" + dias;
        return fechaStriniada;}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String dir = request.getServletPath();
            switch(dir){
                case "/p_menu_principal":
                    p_menu_principal(request, response);
                    break;
                case "/aula":
                    aula(request, response);
                    break;
                case "/p_tarea":
                    p_tarea(request, response);
                    break;
                case "/p_a_tarea":
                    p_a_tarea(request, response);
                    break;
                case "/b_tarea":
                    b_tarea(request, response);
                    break;
                case "/p_n_tarea":
                    p_n_tarea(request, response);
                    break;
                case "/puntuar_tarea":
                    puntuar_tarea(request, response);
                    break;
                case "/inser_nota":
                    inser_nota(request, response);
                    break;
                case "/p_citaciones":
                    p_citaciones(request, response);
                    break;
                case "/inser_citacion":
                    inser_citacion(request, response);
                    break;
                case "/p_registrar_asistencia":
                    p_registrar_asistencia(request, response);
                    break;
                case "/p_insert_asistencia":
                    p_insert_asistencia(request, response);
                    break;
                case "/p_libreta":
                    p_libreta(request, response);
                    break;
            }}}
    
    protected void b_tarea(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            ss = request.getSession();
            int codConnt = Integer.parseInt((String) ss.getAttribute("codCont"));
            String codAula = (String) ss.getAttribute("codAu");
            da = new Dao_Actividades();
            da.delete_actividades(codAula, codConnt, Integer.parseInt(request.getParameter("ac")));
            request.getRequestDispatcher("p_tarea").forward(request, response);}
        catch(Exception e){}}
                    
    protected void p_a_tarea(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            ss = request.getSession();
            int codConnt = Integer.parseInt((String) ss.getAttribute("codCont"));
            String codAula = (String) ss.getAttribute("codAu");
            da = new Dao_Actividades();
            entidad.Ent_Actividades ea  = new entidad.Ent_Actividades((String) ss.getAttribute("codAu"), 
                    Integer.parseInt(request.getParameter("ac")), 
                    Integer.parseInt((String) ss.getAttribute("codCont")),
                    request.getParameter("txt_Conte"),
                    request.getParameter("txt_F_Entrega"));
            da.update_actividad(ea);
            request.getRequestDispatcher("p_tarea").forward(request, response);}
        catch(Exception e){}}
   
    protected void p_libreta(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{ 
            dau = new Dao_Aula();
            da = new Dao_Actividades();
            ss = request.getSession();
            int cont = 1;
            String codAula = (String) ss.getAttribute("codAu");
            String pcCod = (String) ss.getAttribute("codPc");
            int contCu = Integer.parseInt((String) ss.getAttribute("codCont"));
            int cantAc = da.select_ultima_actividad_curso(codAula, contCu);            
            rs = dau.select_alumnos_aul(codAula, pcCod);
            repetidor  = repetidor + dau.pintador_cabecera_libretas_Alumnos(cantAc,codAula,contCu);
            while(rs.next()){
                repetidor = repetidor + dau.pintador_libretas_Alumnos(
                        cantAc,                        
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        cont,
                        dau.select_cur_de_pccursod(pcCod));
                cont++;}
            request.setAttribute("v_libreta", repetidor);
            repetidor = "";
            request.getRequestDispatcher("Prf_Libreta.jsp").forward(request, response);}
        catch(Exception e){}}
    
    protected void p_insert_asistencia(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{      
            dau = new Dao_Aula();
            dl = new Dao_Libreta();   
            String alu = "";
            numAlu = dau.numero_alumnos_aula(
                    (String) ss.getAttribute("codAu"), 
                    (String) ss.getAttribute("codPc"));
            for(int i=1;i<=numAlu;i++){
                if(request.getParameter(String.valueOf(i))!=null){
                   ss = request.getSession();
                   alu = dau.select_alumnos_aulXNum((String) ss.getAttribute("codAu"), 
                            (String) ss.getAttribute("codPc"), i);
                   if(dl.select_si_asistio_clase_curs(alu, 
                           Integer.parseInt((String) ss.getAttribute("codCont"))) == true){
                      dl.delete_si_asistio_clase_curso(alu, fechaActual2());}
                   else{
                       libreta = dau.citacion_porNumero_alumnos_aula(
                                (String) ss.getAttribute("codAu"), 
                                (String) ss.getAttribute("codPc"),
                                i);      
                        dl = new Dao_Libreta(
                                libreta, 
                                (String) ss.getAttribute("codAu"), 
                                Integer.parseInt((String) ss.getAttribute("codCont")),    
                                fechaActual(),
                                "A");
                        dl.insert_asistencia_curso(dl);}}}
            request.getRequestDispatcher("p_registrar_asistencia").forward(request, response);}
        catch(Exception e){}}
    
    protected void p_registrar_asistencia(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            dau = new Dao_Aula();
            String codAula = (String) ss.getAttribute("codAu");
            String pcCod = (String) ss.getAttribute("codPc");
            rs = dau.select_alumnos_aul(codAula, pcCod);
            int cont = 1;
            while(rs.next()){
                repetidor = repetidor + dau.pintador_asistencia_Alumnos(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        cont,
                        rs.getString(6),
                        Integer.parseInt((String) ss.getAttribute("codCont")));
                        cont++;}
            ss.setAttribute("ss_ac", request.getParameter("ac"));
            request.setAttribute("v_pintador_r_asistencias", repetidor);
            repetidor = "";
            request.getRequestDispatcher("Prf_Registrar_Asistencia.jsp").forward(request, response);}
        catch(Exception e){}}
    
    protected void inser_citacion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{      
            dau = new Dao_Aula();
            numAlu = dau.numero_alumnos_aula(
                    (String) ss.getAttribute("codAu"), 
                    (String) ss.getAttribute("codPc"));
            for(int i=1;i<=numAlu;i++){
                if(request.getParameter(String.valueOf(i))!=null){
                   ss = request.getSession();
                   libreta = dau.citacion_porNumero_alumnos_aula(
                        (String) ss.getAttribute("codAu"), 
                        (String) ss.getAttribute("codPc"),
                        i);      
                    dl = new Dao_Libreta(
                        libreta, 
                        (String) ss.getAttribute("codAu"), 
                        Integer.parseInt((String) ss.getAttribute("codCont")),    
                        fechaActual(),
                        request.getParameter("txt_"+libreta));
                    dl.inser_citacion(dl);}}
            request.getRequestDispatcher("p_citaciones").forward(request, response);}
        catch(Exception e){}}
    
    protected void p_citaciones(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            dau = new Dao_Aula();
            String codAula = (String) ss.getAttribute("codAu");
            String pcCod = (String) ss.getAttribute("codPc");
             
            rs = dau.select_alumnos_aul(codAula, pcCod);
            int cont = 1;
            while(rs.next()){
                repetidor = repetidor + dau.pintador_citaciones_Alumnos(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5),
                        cont);
                        cont++;}
            ss.setAttribute("ss_ac", request.getParameter("ac"));
            request.setAttribute("v_pintador_citaciones", repetidor);
            repetidor = "";
            request.getRequestDispatcher("Prf_nueva_citacion.jsp").forward(request, response);}
        catch(Exception e){}}
            
    protected void inser_nota(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{      
            ss = request.getSession();
            dau = new Dao_Aula();
            numAlu = dau.numero_alumnos_aula(
                    (String) ss.getAttribute("codAu"), 
                    (String) ss.getAttribute("codPc"));
            for(int i=1;i<=numAlu;i++){
                if(request.getParameter(String.valueOf(i))!=null){
                   libreta = dau.libreta_porNumero_alumnos_aula(
                            (String) ss.getAttribute("codAu"), 
                            (String) ss.getAttribute("codPc"),
                            i);  
                    dl = new Dao_Libreta(
                            libreta, 
                            Integer.parseInt((String) ss.getAttribute("codCont")),
                            (String) ss.getAttribute("codAu"), 
                            Integer.parseInt((String) ss.getAttribute("ss_ac")),
                            "presentado", 
                            request.getParameter("txt_"+libreta));
                   dl.inser_nota(dl);}}
            request.getRequestDispatcher(
                    "puntuar_tarea?ac="+(String) ss.getAttribute("ss_ac")).forward(request, response);}
        catch(Exception e){}}
                    
        protected void puntuar_tarea(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            ss = request.getSession();
            dau = new Dao_Aula();
            String codAula = (String) ss.getAttribute("codAu");
            String pcCod = (String) ss.getAttribute("codPc");
             
            rs = dau.select_alumnos_aul(codAula, pcCod);
            int cont = 1;
            while(rs.next()){
                repetidor = repetidor + dau.pintadorAlumnos(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        cont);
                        cont++;}
            ss.setAttribute("ss_ac", request.getParameter("ac"));
            request.setAttribute("v_listar_alumno", repetidor);
            repetidor = "";
            request.getRequestDispatcher("Prf_Puntuar_Tarea.jsp").forward(request, response);}
        catch(Exception e){}}
    
        protected void p_n_tarea(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            if(request.getParameter("txt") != null){
            ss = request.getSession();
            int codConnt = Integer.parseInt((String) ss.getAttribute("codCont"));
            String codAula = (String) ss.getAttribute("codAu");
            da = new Dao_Actividades();
                ea = new Ent_Actividades(
                    codAula, 
                    codConnt,
                    fechaActual(),
                    request.getParameter("txt_F_Entrega"),
                    request.getParameter("txt_Conte"),
                    "T1");
                da.insert_tareas(ea);
            request.getRequestDispatcher("p_tarea").forward(request, response);}
            else{
                rs = da.select_actividad_especifi((String) ss.getAttribute("codAu"),Integer.parseInt((String) ss.getAttribute("codCont")));
                while(rs.next()){
                    if(request.getParameter("ac_"+rs.getString(1)) != null){
                        request.getRequestDispatcher("p_a_tarea?ac="+rs.getString(1)).forward(request, response);}}}}
        catch(Exception e){}}
                    
        protected void p_tarea(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            int top = 200;
            ss = request.getSession();
            String codAula = (String) ss.getAttribute("codAu");
            String pcCod = (String) ss.getAttribute("codPc");
            da = new Dao_Actividades();
            rs = da.select_todas_actividades_del_curso(codAula, pcCod);
            while(rs.next()){
                repetidor = repetidor + da.pintadorTareasProf(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        top,
                        codAula,
                        Integer.parseInt((String)ss.getAttribute("codCont")));
                top = top + 120;}
            request.setAttribute("v_tareas", repetidor);
            repetidor = "";
            request.getRequestDispatcher("Prf_Nueva_tarea.jsp").forward(request, response);}
        catch(Exception e){}}
    
    
        protected void p_menu_principal(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            dc = new Dao_Curso();
            ss = request.getSession();
            dau = new Dao_Aula();
            String codAula = (String) ss.getAttribute("codAu");
            String pcCod = (String) ss.getAttribute("codPc");
             
            rs = dau.select_alumnos_aul(codAula, pcCod);
            int cont = 1;
            while(rs.next()){
                repetidor = repetidor + dau.pintadorAlumnosMNP(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        cont);
                        cont++;}
            request.setAttribute("alums", repetidor);
            repetidor = "";
            request.getRequestDispatcher("Prf_Menu_Principal.jsp").forward(request, response);}
        catch(Exception e){}}
    
        protected void aula(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            ss = request.getSession();
            ss.setAttribute("codAu", request.getParameter("cbop").substring(0,4));
            ss.setAttribute("codPc", request.getParameter("cbop").substring(4,8));
            ss.setAttribute("codCont", request.getParameter("cbop").substring(8));
            request.getRequestDispatcher("Prf_Menu_Principal.jsp").forward(request, response);}
        catch(Exception e){}}
    
    
    

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
