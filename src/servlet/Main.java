package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		List<Mutter> list = (List<Mutter>)application.getAttribute("mutterlist");

		if(list==null){
			list=new ArrayList<Mutter>();
			application.setAttribute("mutterlist",list);
		}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/Main.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		String text=request.getParameter("text");

		if(text!=null&&text.length()!=0){
			ServletContext application = this.getServletContext();
			List<Mutter>  list =  (List<Mutter>)application.getAttribute("mutterlist");

			if(list==null){
				list=new ArrayList<Mutter>();
				application.setAttribute("mutterlist",list);
			}
			//ユーザ名を取得
			HttpSession session=request.getSession();
			User loginuser = (User) session.getAttribute("loginuser");
			session.setAttribute("loginuser",loginuser);

			Mutter mutter=new Mutter(loginuser.GetName(),text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.excute(mutter, list);

			application.setAttribute("mutterlist",list);
		}



		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/Main.jsp");
		dispatcher.forward(request, response);


	}

}
