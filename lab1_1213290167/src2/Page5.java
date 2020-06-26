import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Page5")
public class Page5 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String fcolor =  request.getParameter("fcolor");
            if(fcolor != null){
                HttpSession session = request.getSession();
                if(session != null)
                {
                    session.setAttribute("fcolor", fcolor);
                    Cookie lab1cookiefcolor = new Cookie("lab1Cookiefcolor", fcolor);
                    lab1cookiefcolor.setMaxAge(60*5);

                    response.addCookie(lab1cookiefcolor);
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page5</title>");
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            String days="";

            if(session!=null) {
                out.println("<tr><td>First Name:</td><td><input type=\"text\" name=\"fname\" value=\""+session.getAttribute("fname").toString()+"\" /></td>");
                out.println("<tr><td>Last Name:</td><td><input type=\"text\" name=\"lname\" value=\""+session.getAttribute("lname").toString()+"\" /></td>");
                out.println("<form method=\"post\" action=\"Page1\">");
                out.println("</tr><tr><td><input type=\"submit\" value=\"edit\"></td></tr>");
                out.println("</form>");
                out.println("<tr><td>Programming languages:</td><td><input type=\"text\" name=\"Programming languages\" value=\""+session.getAttribute("plang").toString()+"\" /></td>");
                out.println("<form method=\"post\" action=\"Page2\">");
                out.println("</tr><tr><td><input type=\"submit\" value=\"edit\"></td></tr>");
                out.println("</form>");
                out.println("<tr><td>Available days:</td><td><input type=\"text\" name=\"days\" value=\""+session.getAttribute("days")+"\" /></td>");
                out.println("<form method=\"post\" action=\"Page3\">");
                out.println("</tr><tr><td><input type=\"submit\" value=\"edit\"></td></tr>");
                out.println("</form>");
                out.println("<tr><td>Fav Color:</td><td><input type=\"text\" name=\"fcolor\" value=\""+session.getAttribute("fcolor").toString()+"\" /></td>");
                out.println("</tr><tr><td><input type=\"submit\" value=\"edit\"></td></tr>");
                out.println("</form>");

            }
            out.println("<form method=\"post\" action=\"newprogrammer\">");

            out.println("</tr>"+
                    "<tr>"+
                    "<td><input type=\"submit\" value=\"Next\"></td>"+
                    "</tr>");
            out.println("</table></form>");
            out.println("<form method=\"post\" action=\"Page1\">");
            out.println("</tr><tr><td><input type=\"submit\" value=\"Cancel\"></td></tr><table>");
            out.println("</form>");
            out.println("<br/>");
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
