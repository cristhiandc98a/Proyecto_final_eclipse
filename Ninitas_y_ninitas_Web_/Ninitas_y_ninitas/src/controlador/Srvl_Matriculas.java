package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Level;
import java.util.logging.Logger;
import dao.Dao_Matriculas;
import entidad.Ent_Alumno;
import entidad.Ent_Apoderado;
import dao.Dao_Usuario;
import dao.Dao_Codigoneador;
import dao.Dao_Persona;
import dao.Dao_Alumno;
import dao.Dao_Apoderado;
import java.util.Calendar;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet(name = "Srvl_Matriculas", urlPatterns = {"/nueva_matricula"})
public class Srvl_Matriculas extends HttpServlet {

    String codA,usuA,claA,codT,fechA,fechT,patA,matA,nomA,dniA,telA,dirA,mtr,patT,matT,nomT,dniT,sexT;
    static int acciT = 0, acciA = 0, msgeador = 2;
    int anio;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            
            String opcion = request.getServletPath();
            switch(opcion){
                case "/nueva_matricula": 
                    matricular(request, response);break;}}}
    
    
    protected void matricular(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        try{
            Dao_Matriculas dm = new Dao_Matriculas();
            Calendar cal= Calendar.getInstance();
            Dao_Usuario du = new Dao_Usuario();
            Dao_Codigoneador dc =  new Dao_Codigoneador();
            Dao_Persona dp = new Dao_Persona();
            Ent_Alumno a;
            Ent_Apoderado t;
            
            if(acciA == 0){
                fechA = request.getParameter("cboFechNaciAA")+"-"+request.getParameter("cboFechNaciAM")+"-"+request.getParameter("cboFechNaciAD");}
            if(acciT == 0){
                fechT = request.getParameter("cboFechNaciTA")+"-"+request.getParameter("cboFechNaciTM")+"-"+request.getParameter("cboFechNaciTD");}
            patA = request.getParameter("txtPatAlu").toUpperCase();
            matA = request.getParameter("txtMatAlu").toUpperCase(); 
            nomA = request.getParameter("txtNomAlu").toUpperCase(); 
            dniA = request.getParameter("txtDniAlu").toUpperCase();
            telA = request.getParameter("txtTelApo").toUpperCase();
            dirA = request.getParameter("txtDirAlu").toUpperCase();
            mtr = request.getParameter("txtMatricula").toUpperCase();
            patT = request.getParameter("txtPatApo").toUpperCase();
            matT = request.getParameter("txtMatApo").toUpperCase();
            nomT = request.getParameter("txtNomApo").toUpperCase();
            dniT = request.getParameter("txtDniApo").toUpperCase();
            anio = cal.get(Calendar.YEAR);
            codA = dc.autoincrementador(dp.ultimoCodigoPersona("A"), 1);
            usuA = dc.autoincrementador(du.ultimoUsuario("A"), 6);
            claA = dc.autoincrementador(du.ultimaContrasenia(), 1);
            if(acciT == 0){
                codT = dc.autoincrementador(dp.ultimoCodigoPersona("T"), 1);}
            
            //VERIFICAR POR DNI
            if(request.getParameter("btnDniA")!=null){
                Dao_Alumno dard = new Dao_Alumno();
                a = dard.datosAlumnoDni(dniA);
                request.setAttribute("v_mtr", mtr);
                request.setAttribute("v_dniA", dniA);
                request.setAttribute("v_dniT", dniT);
                request.setAttribute("v_patT", patT);
                request.setAttribute("v_matT", matT);
                request.setAttribute("v_nomT", nomT);
                request.setAttribute("v_telA", telA);
                request.setAttribute("v_dirA", dirA);
                if(a!=null){
                    fechA = a.fechNaci;
                    request.setAttribute("v_patA", a.perPat);
                    request.setAttribute("v_matA", a.perMat);
                    request.setAttribute("v_nomA", a.perNom);
                    request.setAttribute("v_telA", a.perTel);
                    request.setAttribute("v_dirA", a.perDir); 
                    //request.setAttribute("v_crgA", "disabled");
                    acciA = 1;}
                request.getRequestDispatcher("Matricular.jsp").forward(request, response);}
            else{
                if(request.getParameter("btnDniT")!=null){
                    Dao_Apoderado dtrd = new Dao_Apoderado();
                    t = dtrd.datosApoderado(dniT);
                    request.setAttribute("v_mtr", mtr);
                    request.setAttribute("v_dniA", dniA);
                    request.setAttribute("v_dniT", dniT);
                    request.setAttribute("v_patA", patA);
                    request.setAttribute("v_matA", matA);
                    request.setAttribute("v_nomA", nomA);
                    request.setAttribute("v_telA", telA);
                    request.setAttribute("v_dirA", dirA);
                    if(t!=null){
                        fechT = t.fechNaci;
                        sexT = t.perSex;
                        codT = t.perCod;
                        request.setAttribute("v_patT", t.perPat);
                        request.setAttribute("v_matT", t.perMat);
                        request.setAttribute("v_nomT", t.perNom);
                        request.setAttribute("v_telA", t.perTel);
                        request.setAttribute("v_dirA", t.perDir);
                        //request.setAttribute("v_crgT", "disabled");
                        acciT = 1;}
                    request.getRequestDispatcher("Matricular.jsp").forward(request, response);}}
            
            //REGISTRAR FINAL
            if(request.getParameter("btnRegistrar")!=null){
                
                if(acciT == 0){
                    sexT = request.getParameter("rdSexApo").toUpperCase();
                    a = new Ent_Alumno(codA,anio,patA,matA,nomA,fechA,dniA,telA,"F", dirA,usuA,claA,mtr);
                    t = new Ent_Apoderado(codT,patT,matT,nomT,fechT,dniT,sexT);
                    msgeador = dm.insert_new_alumno_apoderado(a,t);
                    JOptionPane.showMessageDialog(null, msgeador);
                }
                else{
                    if(acciT == 1){
                        a = new Ent_Alumno(codA,anio,patA,matA,nomA,fechA,dniA,telA,"F", dirA,usuA,claA,mtr);
                        t = new Ent_Apoderado(codT,dniT);
                        msgeador = dm.insert_new_alumno_antiguo_apoderado(a, t);
                        acciA = 0;
                        acciT = 0;}}
                HttpSession ss = request.getSession();
                ss.setAttribute("cod", codA);
                request.setAttribute("primer_inicio_sesion", alerta());
                request.setAttribute("msgg", "alertas()");
                request.getRequestDispatcher("perfil_alm").forward(request, response);
                if(msgeador == 1){
                    request.setAttribute("msg", "alert()");}}
            else{
                if(request.getParameter("btnLimpiar")!=null){
                    codA = "";
                    usuA = "";
                    claA = "";
                    codT = "";
                    fechA = "";
                    fechT = "";
                    patA = "";
                    matA = "";
                    nomA = "";
                    dniA = "";
                    telA = "";
                    dirA = "";
                    mtr = "";
                    patT = "";
                    matT = "";
                    nomT = "";
                    dniT = "";
                    sexT = "";
                    acciT = 0; 
                    acciA = 0; 
                    msgeador = 2;
                    request.getRequestDispatcher("Matricular.jsp").forward(request, response);}
                else{
                    if(request.getParameter("btnRetornar")!=null){
                        request.getRequestDispatcher("index.jsp").forward(request, response);}}}}
        catch(Exception e){
            request.setAttribute("msg", "0");
            request.getRequestDispatcher("Matricular.jsp").forward(request, response);}}
    
    public String alerta(){
        String a = "<div class=\"alert alert-success\" role=\"alert\">\n"
                        +"<h4 class=\"alert-heading\">¡Importante recuerda estos datos para tu proximo inicio de sesion!</h4>"
                        +"NOMBRE DE USUARIO:  \n" + usuA +"CLAVE DE USUARIO: "+claA+"</div>";
        return a;}

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
            Logger.getLogger(Srvl_Matriculas.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Srvl_Matriculas.class.getName()).log(Level.SEVERE, null, ex);
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
