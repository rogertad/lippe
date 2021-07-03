package br.ufsc.lippe;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.ufsc.lippe.data.PautaVideo;
import br.ufsc.lippe.data.PautaVideoDAO;

/**
 * Servlet implementation class EuEstouAqui
 */
@WebServlet("/controlPauta")
public class controlPauta extends HttpServlet {
	/**
	 *
	 */
	private static final String G_I_T_EU_ESTOU_AQUI = "====== OOOOOO===========EU ESTOU AQUI!!!";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controlPauta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String descr = request.getParameter("pautaDescr");
		String tema = request.getParameter("pautaTema");

		if (descr == null || tema == null) {
			// a = "...sem parametros...";
			out.print("NAO RECEBI PARAMS");
		} else {

			PautaVideoDAO dao = new PautaVideoDAO();

			// Add new user
			PautaVideo pauta = new PautaVideo();
			pauta.setDescricao(descr);
			pauta.setTema(tema);
			dao.addPauta(pauta);

			// JSONObject pautaObj = new JSONObject();
			// JSONArray userList = new JSONArray();
			// userList.add(pautaObj);

			// Get all users
			for (PautaVideo iter : dao.getAllPautas()) {
				out.println(iter);
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(iter);
				out.println(jsonString);
			}

			// Get user by id
			out.println("retornei: " + dao.getPautaById(11).toString());

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
