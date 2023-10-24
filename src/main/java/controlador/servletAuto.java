package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassCrudAutoImp;
import model.TblAuto;

/**
 * Servlet implementation class servletAuto
 */
public class servletAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/GestionarAuto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String color=request.getParameter("color");
		String modelo=request.getParameter("modelo");
		String motor= request.getParameter("motor");
		double precio=Double.parseDouble(request.getParameter("precio"));
		String marca=request.getParameter("marca");
		String fabricacion=request.getParameter("fabricacion");
		//asignamos las respectivas clases..
		TblAuto tbauto = new TblAuto();
		ClassCrudAutoImp crud = new ClassCrudAutoImp();
		//asignamos los respectivos valores
		tbauto.setColor(color);
		tbauto.setModelo(modelo);
		tbauto.setMotor(motor);
		tbauto.setPrecio(precio);
		tbauto.setMarca(marca);
		tbauto.setFabricacion(fabricacion);
		//invocamos al emtodo registrar
		crud.RegitrarAuto(tbauto);
		//recuperamos el listado
		List<TblAuto> listadoauto=crud.ListadoAuto();
		//enviamos a la vista
		request.setAttribute("listado", listadoauto);
		//redireccionamos
		request.getRequestDispatcher("/GestionarAuto.jsp").forward(request, response);

	}

}
