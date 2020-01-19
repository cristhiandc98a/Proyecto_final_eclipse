package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Ent_Alumno;
import dao.Dao_Alumno;
import dao.Dao_Actividades;
import dao.Dao_Curso;
import dao.Dao_Asistencias;
import dao.Dao_Libreta;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import javax.swing.JOptionPane;

@WebServlet(name = "Srvl_Alm_Menu_Principal", urlPatterns = {
    "/menu_Principal","/perfil_alm","/cerrar_ss","/tareas","/citaciones","/notas","/asistencias",
    "/alm_cursos_t","/alm_cursos_c","/alm_cursos_a","/carga_mes"})
public class Srvl_Alm_Menu_Principal extends HttpServlet {

    Calendar cal= Calendar.getInstance();
    Dao_Alumno da = new Dao_Alumno();
    Dao_Curso dc;
    Dao_Actividades dac;
    Dao_Asistencias das;
    Ent_Alumno ea;
    HttpSession ss;
    ResultSet rs;
    String repetidor = "";
    Dao_Libreta dl;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String dir = request.getServletPath();
            switch(dir){
                case "/menu_Principal":
                    menu_Principal(request, response);
                    break;
                case "/perfil_alm":
                    perfil_alm(request, response);
                    break;
                case "/cerrar_ss":
                    cerrar_ss(request, response);
                    break;
                case "/tareas":
                    tareas(request, response);
                    break;
                case "/citaciones":
                    citaciones(request, response);
                    break;
                case "/notas":
                    notas(request, response);
                    break;
                case "/asistencias":
                    asistencias(request, response);
                    break;
                case "/alm_cursos_t":
                    alm_cursos_t(request, response);
                    break;
                case "/alm_cursos_c":
                    alm_cursos_c(request, response);
                    break;
                case "/carga_mes":
                    carga_mes(request, response);
                    break;
            }}}
    
    protected void alm_cursos_c(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            dac = new Dao_Actividades();
            ss =request.getSession();
            int top = 200;
            rs = dac.select_todas_citaciones_cur_alumn(
                    (String) ss.getAttribute("cod"), request.getParameter("cu"));
            while(rs.next()){
                repetidor = repetidor + dac.pintadorCitaciones(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5),
                        rs.getString(6),
                        top);
                        top = top + 100;}
            repetidor = repetidor + cu(request.getParameter("cu"));
            request.setAttribute("v_tarea", repetidor);
            repetidor = "";
            request.getRequestDispatcher("Alm_Curso.jsp").forward(request, response);}
        catch(Exception e){}}
    
    protected void alm_cursos_t(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            dac = new Dao_Actividades();
            ss =request.getSession();
            int top = 200;
            rs = dac.select_tareas_curso_alum(
                    (String) ss.getAttribute("cod"),
                    request.getParameter("cu"));
            while(rs.next()){
                repetidor =repetidor +  dac.pintadorTareas(
                        request.getParameter("cu"),//request.getParameter("cu"), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        top, 
                        (String) ss.getAttribute("cod"), 
                        rs.getInt(4));
                top = top + 100;}
            repetidor =  cu(request.getParameter("cu")) + repetidor;
            request.setAttribute("v_tarea", repetidor);
            repetidor = "";
            request.getRequestDispatcher("Alm_Curso.jsp").forward(request, response);}
        catch(Exception e){}}
    
    protected void carga_mes(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            int mes = cal.get(Calendar.MONTH) + 1;
            request.getRequestDispatcher("asistencias?cod="+mes).forward(request, response);}
        catch(Exception e){}}
    
    protected void cerrar_ss(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            ss =request.getSession();
            request.getSession().removeAttribute("cod");
            request.getSession().removeAttribute("v_nom");
            ss.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);}
        catch(Exception e){}}
    
    protected void perfil_alm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            ss = request.getSession();
            ea = da.datosAlumnoCod((String) ss.getAttribute("cod"));
            request.setAttribute("pat", ea.perPat);
            request.setAttribute("mat", ea.perMat);
            request.setAttribute("nom", ea.perNom);
            request.setAttribute("usu", ea.usuUsu);
            request.setAttribute("edd", (cal.get(Calendar.YEAR) - Integer.parseInt(ea.fechNaci.substring(0,4))));
            request.setAttribute("sex", ea.perSex);
            request.setAttribute("dni", ea.perDni);
            request.setAttribute("tel", ea.perTel);
            request.setAttribute("dir", ea.perDir);
            request.getRequestDispatcher("Alm_Mi_Perfil.jsp").forward(request, response);}
        catch(Exception e){}}
    
    
    protected void tareas(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            int top = 100;
            dac = new Dao_Actividades();
            ss = request.getSession();
            rs = dac.select_todas_ac((String) ss.getAttribute("cod"));
            while(rs.next()){
                repetidor = repetidor + dac.pintadorTareas(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4),
                        top,
                        (String) ss.getAttribute("cod"),
                        rs.getInt(5)); 
                        top = top + 100;}
            request.setAttribute("v_pintador_tareas", repetidor);
            repetidor = "";
                     
            request.getRequestDispatcher("Alm_Tareas.jsp").forward(request, response);}
        catch(Exception e){}}
    
    protected void menu_Principal(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            dc= new Dao_Curso();
            ss = request.getSession();
            rs = dc.selec_listar_Curso((String) ss.getAttribute("cod"));
            byte cont = 1;
            while(rs.next()){
                request.setAttribute("c"+cont, rs.getString(1));
                request.setAttribute("n"+cont, rs.getString(2));
                cont++;}
            request.setAttribute("v_nom", (String) ss.getAttribute("v_nom"));
            request.getRequestDispatcher("Alm_Menu_Principal.jsp").forward(request, response);}
        catch(Exception e){}}
    
    protected void citaciones(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            int top = 120;
            dac = new Dao_Actividades();
            ss = request.getSession();
            rs = dac.select_todas_citacioness_alumn((String) ss.getAttribute("cod"));
            while(rs.next()){
                repetidor = repetidor + dac.pintadorCitaciones(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5),
                        rs.getString(6),
                        top);
                        top = top + 100;}
            request.setAttribute("v_pintador_citaciones", repetidor);
            repetidor = "";
            request.getRequestDispatcher("Alm_Citaciones.jsp").forward(request, response);
        }catch(Exception e){}}
    
    protected void notas(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            dc = new Dao_Curso();
            ss = request.getSession();
            dl = new Dao_Libreta();
            String perCod = (String) ss.getAttribute("cod");
            String primera_fila = "";
            int cont = 0;
            int contareas = 0;
            int finall = 0;
            if(request.getParameter("tr").equals("T4")){
                primera_fila =  "<tr><td>Area</td><td>Trim.I</td>\n" +
"                                <td>Trim.II</td><td>Trim.III</td><td>Final</td></tr>";
                ResultSet rsc = dc.selec_listar_Curso(perCod);
                while(rsc.next()){
                    int[][] notass = new int[4][4];
                    repetidor = repetidor + "<tr><td>" + rsc.getString(2) + "</td>";
                    for(int i = 1; i <= 3; i++){
                        rs = dl.select_evaluaciones_trim_alum(perCod, i,rsc.getString(1));
                        while(rs.next()){
                            cont++;}
                        if(cont == 3){
                            rs = dl.select_evaluaciones_trim_alum(perCod, i, rsc.getString(1));
                            while(rs.next()){
                                notass[i][1] = notass[i][1] + Integer.parseInt(rs.getString(1));}
                            notass[i][1] = (int) notass[i][1] / 3;
                            rs = dl.select_tareas_trim_alum(perCod, i, rsc.getString(1));
                            while(rs.next()){
                                contareas++;
                                notass[i][2] = notass[i][2] + Integer.parseInt(rs.getString(1));}
                            notass[i][2] = (int) notass[i][2] / contareas;
                            notass[i][3] = (int) ((notass[i][1] + notass[i][2]) / 2);
                            finall = finall + notass[i][3];
                            repetidor = repetidor + "<td>"+"<input type=text size=1 class="+ dl.claseador(notass[i][3])
                                    +" value="+notass[i][3]+" disabled></td>";
                            if(i == 3){//JOptionPane.showMessageDialog(null,2);
                                finall = (int) finall / 3;
                                repetidor = repetidor + "<td>"+"<input type=text size=1 class="+ dl.claseador(finall)
                                    +" value="+finall+" disabled></td>";}}
                        else{
                            repetidor = repetidor + "<td></td>";
                            if(i == 3){
                                repetidor = repetidor + "<td></td>";}}
                        cont = 0;
                        contareas = 0;}
                    repetidor = repetidor + "</tr>";}
                request.setAttribute("todo", primera_fila + repetidor);
                repetidor = "";}
            else{
                rs = dc.selec_listar_Curso(perCod);
                while (rs.next()) {                
                    repetidor = repetidor + dl.pintador_notas_tr(
                            perCod,
                            rs.getString(1),
                            request.getParameter("tr"),
                            rs.getString(2));}
                primera_fila =  "<tr><td colspan=\"6\" align=\"center\">TRIMESTRE I</td></tr>\n" 
                                     +"<tr><td>Area</td><td>Ev.1</td>\n" 
                                     +"<td>Ev.2</td><td>Ev.3</td><td>Tare.</td><td >Prom</td></tr>";
                request.setAttribute("tr1", primera_fila + repetidor);}
            repetidor = "";
            primera_fila = "";
            request.getRequestDispatcher("Alm_Notas.jsp").forward(request, response);}
        catch(Exception e){}}
    
    protected void asistencias(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            ss = request.getSession();
            das = new Dao_Asistencias();
            String codAlm = (String) ss.getAttribute("cod");
            byte codMes = Byte.parseByte(request.getParameter("cod"));
            byte cantidad_dias_mes = das.cantDiaszMes(codMes);
            int ult_Dia_mes_asistido = das.ultimo_Dia_mes_asistido(codAlm,codMes);
            byte inicioMes = das.inicio_Mes(codMes);
            int hr = 0, min = 0, hr1 = 0, min1 = 0;
            String fecha1 = "", fecha2 = "";
            //String direccionador = "Alm_Dias_Asistencias.jsp?cod="+codMes;
            
            //DAR NUMERO Y FORMATO A LOS DIAS DEL MES
            for(byte i = 1; i <= 42; i++){
                if(i <= cantidad_dias_mes){
                    request.setAttribute("d"+(inicioMes+i), i);}
                request.setAttribute("color"+i, "navbar-brand");}
            
            //PINTAR INASISTENCIAS
            for(int i = 1; i<=ult_Dia_mes_asistido; i++){
                if(das.diasSiClases(i, codMes) == true ){
                    request.setAttribute("color"+(inicioMes+i), "btn-danger navbar-brand");}}
            
           //COLOREAR LOS DIAS
            rs = das.select_ingreso_alumno(codAlm,codMes);
            ResultSet rsi;
            while(rs.next()){               
                for(int coloreador = 0; coloreador<=ult_Dia_mes_asistido; coloreador++){ 
                    if(rs.getInt(3) == coloreador){
                        //HORA ENTRADA
                        rsi = das.select_hora__ingreso_dia_asistido_alumno(codAlm, codMes, coloreador);
                        if(rsi.next()){
                            fecha1 = rsi.getString(1).substring(0,5);
                            hr = Integer.parseInt(rsi.getString(1) .substring(0,2));
                            min = Integer.parseInt(rsi.getString(1).substring(3,5));}
                        //HORA SALIDA
                        rsi = das.select_hora__salida_dia_asistido_alumno(codAlm, codMes, coloreador);
                        if(rsi.next()){
                            fecha2 = rsi.getString(1).substring(0,5);
                            hr1 = Integer.parseInt(rsi.getString(1) .substring(0,2));
                            min1 = Integer.parseInt(rsi.getString(1).substring(3,5));}
                        //PINTADOR DE DIAS ASISTIDOS MAS INFORMACION
                        if(hr >= 8 && min > 0){
                            request.setAttribute("color"+(inicioMes + rs.getInt(3)), "btn-warning navbar-brand");}
                        else{
                            request.setAttribute("color"+(inicioMes + rs.getInt(3)), "btn-success navbar-brand");}
                        request.setAttribute("f"+(inicioMes + coloreador), "hora entrada: " + fecha1
                                + " \nhora salida:  " + fecha2 + " ");}}}
            request.getRequestDispatcher("Alm_Dias_Asistencias.jsp").forward(request, response);}
        catch(Exception e){}}
    
    public String cu(String cu){
        cu = "<div style=\"position: absolute; top: 100px; left: 550px\">\n" +
"            <table>\n" +
"                <tr><td><a href=\"alm_cursos_t?cu="+cu+"\" class=\"btn btn-warning text-dark\">\n" +
"                            <strong>Tareas</strong></a></td>\n" +
"                    <td><a href=\"alm_cursos_c?cu="+cu+"\" class=\"btn btn-warning text-dark\">\n" +
"                            <strong>Citaciones</strong></a></td>\n" +
"                    <td><a href=\"alm_cursos_a?cu="+cu+"\" class=\"btn btn-warning text-dark\">\n" +
"                            <strong>Asistencias</strong></a></td>\n" +
"                </tr>\n" +
"            </table>\n" +
"        </div>";
        return cu;}
    
  //****************************************************************************  
  //**************************************************************************** 
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Srvl_Alm_Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Srvl_Alm_Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
