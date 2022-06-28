package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;

import service.MemberCheckService;
import service.MemberRegService;
import service.MemberService;


@WebServlet(urlPatterns = {"/member-reg","/email-check","/member-list"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, MemberService> services= new Hashtable<String, MemberService>();
	//map key&value로 쌍으로 입력한다.
	//key 중복허용되지 않는다. : set 계열의 특징을 갖고있다.
	//key & MemberService 객체 : 
	//synchronized 
	
	/*
	@Override
	public void init(ServletConfig config) throws ServletException {
		conn=(Connection) config.getServletContext().getAttribute("oracleDB");
	}
	//*/
	//*
	@Override
	public void init(ServletConfig config) throws ServletException {
		Properties prop;//=new Properties();
		try {
			prop=Resources.getResourceAsProperties("service/className.properties");
			
			Set<Object> keys= prop.keySet();
			for(Object obj : keys) {
				String key=(String)obj;
				//prop.get(key) : value를 읽어올수있다.
				String className=(String) prop.get(key);
				//문자열로된 클래스이름으로 객체생성
				try {
					Class<?> clazz=Class.forName(className);
					MemberService service=(MemberService) clazz.getDeclaredConstructor().newInstance();
					//Map콜렉션에 저장(문자열key, MemberService객체)
					services.put(key, service);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("로딩완료! : "+prop.size());			
		} catch (FileNotFoundException e) {
			System.out.println("해당하는 경로에는 파일이 존재하지 안습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	//*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//인코딩
		String uri=request.getRequestURI();
		String[] strs=uri.split("/");
		String key=strs[strs.length-1];
		
		MemberService service=null;
		//map에 저장된 서비스 클래스중 key와 일치하는 클래스
		service=services.get(key);
		String path=null;		
		
		//서비스 실행
		if(service!=null)
			path=service.execute(request, response);
		
		//페이지 이동
		if(path!=null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}