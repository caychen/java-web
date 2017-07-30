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
		
		//1������һ��DiskFileItemFactory���󣬸ö���Ϊ�������ṩ����ʱ��ȱʡ������
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		
		//2������������
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		
		//3��ʹ�ý������������������������request.getInputStream���һ����
		//	Ȼ���������������ҽ������Ľ����װ��FileItem�������档
		try {
			//һ��FileItem�����װ��һ�����������е�����
			List<FileItem> items = sfu.parseRequest(request);
			//����items���ϣ��Ϳ��Է��ʱ���ÿ�����������
			for (FileItem fileItem : items) {
				if(fileItem.isFormField()){
					//��ͨ���򣺳��ϴ��ļ�֮��Ķ�������ͨ����
					//��ȡÿ�������name����ֵ
					String fieldName = fileItem.getFieldName();
					System.out.println(fieldName);//
					
					//ÿ�������valueֵ
					String user = fileItem.getString();
					System.out.println(user);
				}else{
					//�ϴ������ϴ��ļ��ı�
					ServletContext sc = getServletContext();
					String path = sc.getRealPath("File");
					System.out.println(path);
					
					//����ϴ��ļ���
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
