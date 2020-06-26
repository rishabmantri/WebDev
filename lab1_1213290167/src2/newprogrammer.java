import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class newprogrammer extends HttpServlet {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		resp.getWriter().println("<html><body><p>Use " + "POST instead!</p></body></html>");
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		response.setContentType("text/html");
        HttpSession session = request.getSession();

//        String formFName=request.getParameter("fname");
        String formFName= (String) session.getAttribute("fname");
        String formLName= (String) session.getAttribute("lname");
//		String formLName=request.getParameter("lname");
        String lang= (String) session.getAttribute("plang");
//		String lang = request.getParameter("Programming languages");


		Boolean flag=false;
		PrintWriter out = response.getWriter();


		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File tmpDir = new File(xmlFilePath);
		boolean existsFile = tmpDir.exists();
		Element root,child = null;
		Document document = null;
		StreamResult result = null;
		//create new XML file

		if(!existsFile) {

			document = docBuilder.newDocument();
			root = document.createElement("Programmers");
			document.appendChild(root);
			result = new StreamResult(new File(xmlFilePath));
		}
		//append to existing file
		else
		{

			try {
				document = docBuilder.parse(xmlFilePath);
				result = new StreamResult(new File(xmlFilePath));
			} catch (SAXException e) {

				e.printStackTrace();
			}
			root = document.getDocumentElement();
		}
		NodeList nFName= document.getElementsByTagName("FirstName");
		NodeList nLName = document.getElementsByTagName("LastName");
		NodeList nTotal= document.getElementsByTagName("Programmer");
		int totalCount= nTotal.getLength();
		for (int temp1 = 0,temp2=0; (temp1 < nFName.getLength()) && (temp2 < nLName.getLength()); temp1++,temp2++) {

			Element eFElement = (Element)nFName.item(temp1);
			Element eLElement = (Element)nLName.item(temp2);

			Node eNextNode;

			flag=false;


			if((eFElement.getTextContent().matches(formFName)) && (eLElement.getTextContent().matches(formLName)))
			{
				while(eLElement.getNextSibling()!=null) {
					eNextNode=eLElement.getNextSibling();
					eLElement=(Element)eNextNode;


					if ("languages".equals(eNextNode.getNodeName())) {

						while (eNextNode.hasChildNodes()) {
							eNextNode.removeChild(eNextNode.getFirstChild());}
							if((lang.length()/2)>0) {
							for(int x=0;x<(lang.length()/2);x++)
							{
								Element language = document.createElement("language");
								eNextNode.appendChild(language);
								language.appendChild(document.createTextNode(lang.substring(x,x+1)));
							}}
					}

					if("days".equals(eNextNode.getNodeName())) {

						while (eNextNode.hasChildNodes())
							eNextNode.removeChild(eNextNode.getFirstChild());
						String paramValues[] = request.getParameterValues("days");
                        if(paramValues.length>0) {
							for(int x=0;x<paramValues.length;x++)
							{
								Element day = document.createElement("day");

								eNextNode.appendChild(day);
								day.appendChild(document.createTextNode(paramValues[x]));

							} }
					}
//					String formFcolor=request.getParameter("fcolor");
                    String formFcolor= (String) session.getAttribute("fcolor");
                    Element fcolor = document.createElement("color");
					child.appendChild(fcolor);
					fcolor.appendChild(document.createTextNode(formFcolor));

				}

				flag=true;
				break;
			}
		}


		if(!flag)
		{
			child = document.createElement("Programmer");
			root.appendChild(child);
			Element fName = document.createElement("FirstName");
			child.appendChild(fName);
			fName.appendChild(document.createTextNode(formFName));
			Element lName = document.createElement("LastName");
			child.appendChild(lName);
			lName.appendChild(document.createTextNode(formLName));
			Element languages = document.createElement("languages");
			child.appendChild(languages);
			for(int x=0;x<(lang.length()/2);x++)
			{
				Element language = document.createElement("language");
				languages.appendChild(language);
				language.appendChild(document.createTextNode(lang.substring(x,x+1)));
			}

			Element days = document.createElement("days");
			child.appendChild(days);
			String paramDays[] = request.getParameterValues("days");
			for(int x=0;x<paramDays.length;x++)
			{
				Element day = document.createElement("day");

				days.appendChild(day);
				day.appendChild(document.createTextNode(paramDays[x]));
			}

			String formFcolor=request.getParameter("fcolor");
			Element fcolor = document.createElement("color");
			child.appendChild(fcolor);
			fcolor.appendChild(document.createTextNode(formFcolor));
		}
		TransformerFactory factory=TransformerFactory.newInstance();
		Transformer transformer=null;
		try {
			transformer = factory.newTransformer();
		} catch (TransformerConfigurationException ec) {

			out.println("Throwing Exception");
			ec.printStackTrace();
		}
		DOMSource source = new DOMSource(document);
		try {
			transformer.transform(source, result);
		}
		catch (TransformerException e) {
			out.println("Error in Transformation");
			e.printStackTrace();
		}
		out.println("Transaction Successful!\n<br><br>");
		out.println("Total  Programmers = " + (totalCount+1));
//		HttpSession session = request.getSession();
		session.invalidate();
		}

	public void destroy() {

	}


}
