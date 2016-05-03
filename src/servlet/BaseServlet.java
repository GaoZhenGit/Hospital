package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BaseServlet() {
        super();
    }

    protected boolean isEmpty(String... strings){
    	for(String s:strings){
	    	if(s == null || s.length() == 0){
	    		return true;
	    	}
    	}
    	return false;
    }
    
    protected boolean isNull(Object... objects){
    	for(Object o:objects){
	    	if(o==null){
	    		return true;
	    	}
    	}
    	return false;
    }
    
    protected void back(HttpServletResponse response){
    	
    }
}
