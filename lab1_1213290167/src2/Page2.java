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

@WebServlet("/Page2")
public class Page2 extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");

            if(fname != null &&  lname != null){
                HttpSession session = request.getSession();
                if(session != null)
                {
                    session.setAttribute("fname", fname);
                    session.setAttribute("lname", lname);

                    Cookie lab1cookieFname = new Cookie("lab1Cookiefname", fname);
                    Cookie lab1cookieLname = new Cookie("lab1Cookielname", lname);
                    lab1cookieFname.setMaxAge(60*5);
                    lab1cookieLname.setMaxAge(60*5);
                    response.addCookie(lab1cookieFname);
                    response.addCookie(lab1cookieLname);

                }
            }



            Cookie[] cplangs = request.getCookies();
            String pl="";
            Cookie c = null;
            ArrayList<String> al2 = new ArrayList<String>();
            if(cplangs != null)
            {
                for(int i = 0; i < cplangs.length; i++){
                    if (cplangs[i].getName().equals("lab1Cookieplang")) {
                        pl=cplangs[i].getValue();
                    }
                }
            }





            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"post\" action=\"Page3\" accept-charset=\"ISO-8859-1\">");
            out.println("<fieldset>");
            out.println("<table border=\"0\">");
            if(cplangs != null)
                out.println("<tr><td>Programming Languages Known:</td><td><input type=\"text\" name=\"plang\" value=\""+pl+"\" /></td>");
            else

                out.println("<tr><td>Programming Languages Known:</td><td><input type=\"text\" name=\"plang\" /></td>");
            out.println("<input type=\"hidden\" name=\"back\" value=\"Page2\"/>");
            out.println("</tr><tr><td><input type=\"submit\" value=\"Next\"></td></tr><table>");
            out.println("</fieldset></form>");
            out.println("<form method=\"post\" action=\"Page1\">");
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
        response.getWriter().println("<html><body><p>Use " + "POST!</p></body></html>");    }

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
