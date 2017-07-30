package Web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//username=null
		String username = request.getParameter("username");
		System.out.println("username:" + username);
		
		//1、创建一个DiskFileItemFactory对象，该对象为解析器提供解析时的缺省的配置
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		
		//2、创建解析器
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		
		//3、使用解析器来解析，解析器会调用request.getInputStream获得一个流
		//	然后分析这个流，并且将分析的结果封装到FileItem对象里面。
		try {
			//一个FileItem对象封装了一个表单域中所有的数据
			List<FileItem> items = sfu.parseRequest(request);
			//遍历items集合，就可以访问表单中每个表单域的数据
			for (FileItem fileItem : items) {
				if(fileItem.isFormField()){
					//普通表单域：除上传文件之外的都属于普通表单域
					//获取每个表单域的name属性值
					String fieldName = fileItem.getFieldName();
					System.out.println(fieldName);//
					
					//每个表单域的value值
					String user = fileItem.getString();
					System.out.println(user);
				}else{
					//上传表单域：上传文件的表单
					ServletContext sc = getServletContext();
					String path = sc.getRealPath("File");
					System.out.println(path);
					
					//获得上传文件名
					String fileName = fileItem.getName();
					
					File file = new File(path + File.separator + fileName);
					try {
						fileItem.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
