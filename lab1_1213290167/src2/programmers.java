import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/programmers")
public class programmers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String _filename=null;
	private static String path=null;
	private static String xmlFilePath=null; 
	public void init(ServletConfig config) throws ServletException {
			super.init(config);
			_filename="/bin/programmer.xml";
			path=System.getProperty("catalina.home");
			xmlFilePath=path+_filename;
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public programmers() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document document = null;
		try {
			document = docBuilder.parse(xmlFilePath);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browser=request.getHeader("User-Agent");

		if (browser.contains("Chrome"))
			out.println("<html><body><p>Welcome google user</p><table border='1'>");
		else
			out.println("<html><body><table border='1'>");
		String URL=request.getQueryString();
		if(URL==null) {
			NodeList allData=(document.getElementsByTagName("Programmer"));
			out.print("<tr><td>First Name</td><td>Last Name</td><td>Languages</td><td>Days</td><td>Fav color</td></tr>");
			for(int d=0;d<allData.getLength();d++) {
				Node nNode = allData.item(d);
				out.print("<tr>");
				if(nNode.hasChildNodes()) {
					NodeList allChild=nNode.getChildNodes();
					for(int child=0;child<allChild.getLength();child++)
					{
						out.print("<td>");
						out.print(allChild.item(child).getTextContent());
						out.print("</td>");
					}
				}
				else {
					out.print("<td>"+nNode.getTextContent()+"</td>");
				}
				out.print("</tr>");
			}
			out.print("</table></body></html>");
		}
		else {


			String fname=request.getParameter("FirstName");
			String lname=request.getParameter("LastName");
			String languages1=request.getParameter("languages");
			String days1=request.getParameter("days");
			String fcolor=request.getParameter("color");
			NodeList nList=document.getElementsByTagName("Programmer");
			for(int i=0;i<nList.getLength();i++)
			{
				Node n=nList.item(i);
				Boolean isExist=false;
				if((n.getNodeType()==Node.ELEMENT_NODE) && n!=null)
				{
					Element element=(Element) n;
					if(fname!=null) {
						if (!element.getElementsByTagName("FirstName").item(0).getTextContent().contains(fname))
							continue;
					}
					if(lname!=null) {
						if (!element.getElementsByTagName("LastName").item(0).getTextContent().contains(lname))
							continue;
					}

					if(languages1!=null) {
						String[] languages=languages1.split(",");
						NodeList langList = element.getElementsByTagName("languages").item(0).getChildNodes();
						List<String> llist = new ArrayList<String>();
						for (int j = 0; j < langList.getLength(); j++) {
							llist.add(langList.item(j).getTextContent());
						}
						for (int j = 0; j < languages.length; j++) {
							if (llist.contains(languages[j])) {
								isExist = true;
								break;
							}
						}
						if (!isExist)
							continue;
					}

					if(days1!=null) {
						String[] days=days1.split(",");
						NodeList daysList = element.getElementsByTagName("days").item(0).getChildNodes();
						List<String> dlist = new ArrayList<String>();
						for (int j = 0; j < daysList.getLength(); j++) {
							dlist.add(daysList.item(j).getTextContent());
						}
						isExist = false;
						if (days != null) {
							for (int j = 0; j < days.length; j++) {
								if (dlist.contains(days[j])) {
									isExist = true;
									break;
								}
							}
							if (!isExist) continue;
						}
					}
					if(fcolor!=null) {
						if (!element.getElementsByTagName("color").item(0).getTextContent().contains(fcolor))
							continue;
					}
					out.println("First name: ");
					out.println(element.getElementsByTagName("FirstName").item(0).getTextContent());
					out.println("<br>");
					out.println("Last name: ");
				out.println(element.getElementsByTagName("LastName").item(0).getTextContent());
					out.println("<br>");
					out.println("languages: ");
				NodeList langList = element.getElementsByTagName("languages").item(0).getChildNodes();
				for (int j = 0; j < langList.getLength(); j++) {
					out.print(langList.item(j).getTextContent()+" ");
					}

					out.println("<br>");
					out.println("available days: ");
					NodeList daysList = element.getElementsByTagName("days").item(0).getChildNodes();
				for (int j = 0; j < daysList.getLength(); j++) {
					out.print(daysList.item(j).getTextContent()+" ");
					}
					out.println("<br>");
					out.println("fav color:");
				out.println(element.getElementsByTagName("color").item(0).getTextContent());


				}

			}

		}

	}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	response.getWriter().println("<html><body><p>Use " + "GET instead!</p></body></html>");

}
}