package br.ufsc.lippe;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EuEstouAqui
 */
@WebServlet("/EuEstouAqui2")
public class EuEstouAqui2 extends HttpServlet {
	/**
	 *
	 */
	private static final String G_I_T_EU_ESTOU_AQUI = "====== rvr===========EU ESTOU AQUI!!!";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EuEstouAqui2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out =  response.getWriter();
		
		String a = "nada";
		
		
		a = request.getParameter("nome");
		
		if (a==null) {
			
			a = "NAO DEU!";
			
		}
				
		out.print(G_I_T_EU_ESTOU_AQUI + " " + a);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
