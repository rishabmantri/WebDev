import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Page1")
public class Page1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Cookie c = null;
            Cookie[] cs = request.getCookies();
            String fn="",ln="";
            if(cs != null)
            {
                for(int i = 0; i < cs.length; i++){

                    if (cs[i].getName().equals("lab1Cookiefname")) {
                        fn=cs[i].getValue();
                    }
                    if (cs[i].getName().equals("lab1Cookielname")) {
                        ln=cs[i].getValue();
                    }
                }
            }



            response.setContentType("text/html;charset=UTF-8");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"post\" action=\"Page2\">");
            out.println("<h2>Fill details</h2>");
            out.println("<fieldset>");
            out.println("<table border=\"0\">");

            if(cs != null)
                out.println("<tr><td>First Name:</td><td><input type=\"text\" name=\"fname\" value=\""+fn+"\" /></td>");
            else

                out.println("<tr><td>First Name:</td><td><input type=\"text\" name=\"fname\" /></td>");
            if(cs != null)
                out.println("</tr><tr><td>Last Name:</td><td><input type=\"text\" name=\"lname\" value=\""+ln+"\" /></td></tr>");
            else
                out.println("</tr><tr><td>Last Name:</td><td><input type=\"text\" name=\"lname\" /></td></tr>");
            out.println("<input type=\"hidden\" name=\"back\" value=\"Page1\"/>");
            out.println("<tr><td><input type=\"submit\" value=\"Next\"></td></tr></table>");
            out.println("</fieldset></form>");
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
        response.getWriter().println("<html><body><p>Use " + "POST instead!</p></body></html>");
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
