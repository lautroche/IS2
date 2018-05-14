package controlador;

import com.control.beans.Login;
import com.control.beans.SessionUtils;
import com.control.dao.LoginDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ValidarServlet", urlPatterns = {"/ValidarServlet"})
public class ValidarServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nombre, pass;
        
        nombre = request.getParameter("txtNombre");
        pass = request.getParameter("txtPass");       
              
        
        boolean valid = LoginDAO.validate(nombre, pass);
        if(valid){           
                /*OK, usuario correcto*/
                Login usu = new Login(nombre, pass);
                  HttpSession session = request.getSession();
                session.setAttribute("usuario", usu);
              
	       session.setAttribute("username", nombre);                
               request.getRequestDispatcher("OkServlet").forward(request, response);
            
        }else{
            /*Usuario incorrecto*/
            request.getRequestDispatcher("ErrorServlet").forward(request, response);
        }
        
        
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
