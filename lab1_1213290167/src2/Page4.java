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

@WebServlet("/Page4")
public class Page4 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String days =  request.getParameter("days");
            if(days != null){
                HttpSession session = request.getSession();
                if(session != null)
                {
                    session.setAttribute("days", days);
                    Cookie lab1cookiedays = new Cookie("lab1CookieDays", days);
                    lab1cookiedays.setMaxAge(60*5);

                    response.addCookie(lab1cookiedays);
                }
            }


            Cookie[] cfcolor = request.getCookies();

            Cookie c = null;
            String cfc="";
            if(cfcolor != null)
            {
                for(int i = 0; i < cfcolor.length; i++){
                    if (cfcolor[i].getName().equals("lab1Cookiefcolor")) {
                        cfc = cfcolor[i].getValue();
                    }
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page4</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"post\" action=\"Page5\">");
            out.println("<fieldset>");
            if(cfcolor != null)
                out.println("<tr><td>Fav Color:</td><td><input type=\"text\" name=\"fcolor\" value=\""+cfc+"\" /></td>");
            else

                out.println("<tr><td>Fav Color:</td><td><input type=\"text\" name=\"fcolor\" /></td>");

            out.println("</tr>"+
                    "<tr>"+
                    "<td><input type=\"submit\" value=\"Next\"></td>"+
                    "</tr>");
            out.println("<form method=\"post\" action=\"Page3\">");
            out.println("</tr><tr><td><input type=\"submit\" value=\"Back\"></td></tr><table>");
            out.println("</table></fieldset></form></body>");
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
        response.getWriter().println("<html><body><p>Use " + "POST! </p></body></html>");

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
