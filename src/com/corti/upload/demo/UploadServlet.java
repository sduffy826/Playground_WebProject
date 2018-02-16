package com.corti.upload.demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.corti.demo.DumpSessionInfo;
import com.corti.utils.DumpPartInfo;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig( 
		fileSizeThreshold=1024*1024*2, // Max size stored in memory
		maxFileSize=1024*1024*10, // Max size to accept
		maxRequestSize=1024*1024*50 // Max of all files
		)     
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static final String SAVE_DIR = "UploadFiles";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String appPath = request.getServletContext().getRealPath("");
      String savePath;
      if (!appPath.trim().endsWith(File.separator)) {
        savePath = appPath + File.separator + SAVE_DIR;
      }
      else {
    	savePath = appPath + SAVE_DIR;
      }
      
      // Setup output page, done here so exception can be written if raised below
      response.setContentType("text/html");
      
      PrintWriter pw = response.getWriter();
	  pw.println("<!Doctype HTML>");		
	  pw.println("<html><head>");
	  pw.println("<title>File Upload Example</title>");
	  pw.println("</head>");
	  pw.println("<body>");
	  pw.println("<h3>File uploaded sucessfully</h3>");
	  pw.println("<p>Files stored at: " + savePath + "</p>");
	  pw.println("<p>App path at: " + appPath + "</p>");
	        
      // If save_dir doesn't exist create it
      try {
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
    	    fileSaveDir.mkdir();
        }
      
        for (Part part : request.getParts()) {
        	DumpPartInfo.toPrintWriter(part, pw);
        	
    	    String fileName = extractFileName(part);
    	    if (fileName.length() > 0) {
    	      pw.println("<p>Will write to: " + savePath + File.separator + fileName + "</p>");
    	      part.write(savePath + File.separator + fileName);
    	    }
        }
      }
      catch (Exception e) {
    	e.printStackTrace(pw);
      }
      
      pw.println("</body></html>");	
	    
	  pw.close();
	}
    private String extractFileName(Part part) {
    	String contentDisp = part.getHeader("content-disposition");
    	String[] lines = contentDisp.split(";");
    	for (String s : lines) {
    		if (s.trim().startsWith("filename")) {
    			return s.substring(s.indexOf("=")+2,s.length()-1);
    		}
    	}
    	return "";
    }
}
