

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Page3")
public class Page3 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String plang =  request.getParameter("plang");
            if(plang != null){
                HttpSession session = request.getSession();
                if(session != null)
                {
                    session.setAttribute("plang", plang);
                    Cookie lab1cookiePlang = new Cookie("lab1Cookieplang", plang);
                    lab1cookiePlang.setMaxAge(60*5);

                    response.addCookie(lab1cookiePlang);
                }
            }


            Cookie[] cpdays = request.getCookies();
            String pl="";
            Cookie c = null;
            if(cpdays != null)
            {
                for(int i = 0; i < cpdays.length; i++){
                    if (cpdays[i].getName().equals("lab1CookieDays")) {
                        pl=cpdays[i].getValue();
                    }
                }
            }





            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"POST\" action=\"Page4\">");
            out.println("<fieldset>");
            out.println("<table border=\"0\">");
            if(cpdays != null)
                out.println("<tr><td>Available days:</td><td><input type=\"text\" name=\"days\" value=\""+pl+"\" /></td>");
            else
                out.println("<tr><td>Programming Languages Known::</td><td><input type=\"text\" name=\"days\" /></td>");
            out.println("</tr><tr><td><input type=\"submit\" value=\"Next\"></td></tr><table>");
            out.println("</fieldset></form>");
            out.println("<form method=\"post\" action=\"Page2\">");
            out.println("</tr><tr><td><input type=\"submit\" value=\"Back\"></td></tr><table>");


            out.println("</body>");
            out.println("</html>");
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
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        response.getWriter().println("<html><body><p>Use " + "POST!</p></body></html>");}

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