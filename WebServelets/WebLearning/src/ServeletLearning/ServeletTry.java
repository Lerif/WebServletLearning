package ServeletLearning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServeletTry
 */
@WebServlet("/ServeletTry")
public class ServeletTry extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		// Get by name, not the best way REFACTOR
		PrintWriter outOnScreen = response.getWriter();
		outOnScreen.println("<html>");
		outOnScreen.println("<body>");
		
		outOnScreen.println("Nome:" + request.getParameter("name"));
		outOnScreen.println("<br>");
		outOnScreen.println("Sexo:" + request.getParameter("sex"));
		outOnScreen.println("<br>");
		
		outOnScreen.println("Objetivo:\n" + request.getParameter("objective"));
		outOnScreen.println("<br>");
		
		outOnScreen.println("Conhecimento(s)");
		outOnScreen.println("<br>");
		printOnWriteTrueCheckboxes(response, request.getParameter("c"), "C/C++");
		printOnWriteTrueCheckboxes(response, request.getParameter("Java"), "Java");
		printOnWriteTrueCheckboxes(response, request.getParameter("vb"), "Visual Basic");
		printOnWriteTrueCheckboxes(response, request.getParameter("php"), "PHP");
		printOnWriteTrueCheckboxes(response, request.getParameter("html"), "HTML");
		
		outOnScreen.println("/<body>");
		outOnScreen.println("</html>");

	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
            		throws ServletException, IOException {
		
		// Get by name, not the best way REFACTOR
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String objective = request.getParameter("objective");
		String[] linguagens = request.getParameterValues("linguaguem_programacao");
		String sendType = request.getParameter("sendType");
		String linkedin = request.getParameter("linkedin");
		
		System.out.println("name: " + name);
		System.out.println("sex: " + sex);
		System.out.println("objetive: " + objective);
		System.out.println("linkedin: " + linkedin);
		
		System.out.println("Conhecimento nas linguagens");
		
		for (int i=1; i<linguagens.length; i++){
			System.out.println("-> " + linguagens[i]);
		}
		
		doGet(request, response);
		if(sendType.equals("forward")){
			System.out.println("Forwarding");
			performForward(request, response);
		}
		else {
			System.out.println("Redirecting");
			performRedirect(request, response);
		}	
	}
	
	protected void performRedirect(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String redirectPageAddress = "FilledForm.jsp";
		response.sendRedirect(redirectPageAddress);
	}
	
	protected void performForward(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("ForwardedForm.jsp");
		rd.forward(request, response);
		
	}
	
	protected void printOnConsoleTrueCheckboxes(String title, String checkbox){
		if(checkbox != null){
			System.out.println(title);
		}
	}
	
	protected void printOnWriteTrueCheckboxes(HttpServletResponse response, String checkbox, String toPrint)
			throws ServletException, IOException {
		PrintWriter outOnScreen = response.getWriter();
		if(checkbox != null){
			outOnScreen.println("-> " + toPrint + "<br>");
		}
	}
	
}
