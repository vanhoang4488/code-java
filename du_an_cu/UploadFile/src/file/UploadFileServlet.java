package file;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadFileServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 50, // 50MB
    maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadFileServlet extends HttpServlet {
	
	 public static final String SAVE_DIRECTORY = "picture";
  private static final long serialVersionUID = 1L;
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
	  String appPath = request.getServletContext().getRealPath("/picture");System.out.println(appPath);
      appPath = appPath.replace('\\', '/');
      System.out.println(appPath);

      // Tạo thư mục nếu nó không tồn tại.
      File fileSaveDir = new File(appPath);
      if (!fileSaveDir.exists()) {
          fileSaveDir.mkdir();
      }
      Part part = request.getPart("file") ;
          String fileName = extractFileName(part);
          if (fileName != null && fileName.length() > 0) {
              String filePath = appPath + File.separator + "17020769.png";
              System.out.println("Write attachment to file: " + filePath);

              // Ghi vào file.
              part.write(filePath);
       
      }
         
          request.setAttribute("message", "Upload File Success!");
          getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
  }
  
  
  
  private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
   
    int location = contentDisp.lastIndexOf("\\");
    if(location == -1) location = contentDisp.lastIndexOf("/");
    return contentDisp.substring(location, contentDisp.length() - 1);        
   
  }
  
  public File getFolderUpload() {
	    File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
	    if (!folderUpload.exists()) {
	      folderUpload.mkdirs();
	    }
	    return folderUpload;
	  }
}
