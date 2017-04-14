package action.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.Usermanager;
import entity.Student;

public class FileUpAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private File upload;
	private String uploadFileName;
	
	private HttpSession session;
	private HttpServletRequest request;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("文件名："+getUploadFileName());
		String path = ServletActionContext.getServletContext().getRealPath("headimg");
		FileInputStream fis = new FileInputStream(getUpload());
		FileOutputStream fos = new FileOutputStream(path+"/"+getUploadFileName());
		
		try {
			byte[] buffer = new byte[1024];
			int len=0;
			while((len=fis.read(buffer))>0){
				fos.write(buffer, 0, len);
			}
			fos.flush();
			
			//保存文件名到数据库
			session = getSession();
			String sno = (String)session.getAttribute("sno");
			Usermanager um = new Usermanager();
			Student student = um.getStudent1(sno);
			student.setImage(getUploadFileName());
			um.updateStudent(student);
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}finally {
			fis.close();
			fos.close();
		}
		
		
	}
	
	
	private HttpSession getSession() {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return session;

	}
}
