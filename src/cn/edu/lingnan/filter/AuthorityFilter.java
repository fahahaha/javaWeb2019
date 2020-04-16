package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		//如果登陆用户的权限为1（管理用户）你可以访问你想要访问的页面
		//若果登陆用户的权限不为1，某些页面不能访问，给一个不能访问的页面admin/admin.html
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse) arg1;
		HttpSession s=req.getSession();
		Integer flag=(Integer)s.getAttribute("cSuper");
		if(flag!=null){
			if(flag==1){
			arg2.doFilter(arg0, arg1);
			}
			else{
				resp.sendRedirect(req.getContextPath()+"/authority.html");
				}
			}
		else{
			resp.sendRedirect(req.getContextPath()+"/login.html");
			}
		}
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
