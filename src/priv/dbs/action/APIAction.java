package priv.dbs.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import priv.dbs.service.APIService;

public class APIAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private APIService apiService;
	
	private HttpServletRequest	request;
	private HttpServletResponse response;
	private HttpSession 		sesssion;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this);
		return super.execute();
	}
	
	private void outputJSON(String json) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void getMovie() {
//		String basepath = "http://localhost:8080/DBS_Server/movie/";
		String basepath = "http://alanice.cn/DBS_Server/movie/";
		String path = new String(request.getRequestURL());
		String json = "";
		try {
			int id = Integer.parseInt(path.replace(basepath, ""));
			json = apiService.getMovie(id);
		} catch (java.lang.NumberFormatException e) {
			e.printStackTrace();
			json = "{\"result\":\"fail\", \"msg\":\"URL is not illegal\"}";
		} catch (Exception e) {
			json = "{\"result\":\"fail\", \"msg\":\"Unknown reason\"}";
		} finally {
			System.out.println(json);
			outputJSON(json);
		}
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request  = arg0;
		sesssion = request.getSession();		
	}

	public APIService getApiService() {
		return apiService;
	}

	public void setApiService(APIService apiService) {
		this.apiService = apiService;
	}
}
