package com.stc.audio.storage;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.Mixer.Info;
import javax.sound.sampled.spi.AudioFileWriter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioStream;

import com.sun.media.sound.WaveFileWriter;

/**
 * Servlet implementation class AudioStorage
 */
public class AudioStorage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AudioStorage() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Servlet#init(ServletConfig)
//	 */
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//	}
//
//	/**
//	 * @see Servlet#destroy()
//	 */
//	public void destroy() {
//		super.destroy();
//	}
//
//	/**
//	 * @see Servlet#getServletConfig()
//	 */
//	public ServletConfig getServletConfig() {
//		return super.getServletConfig();
//	}
//
//	/**
//	 * @see Servlet#getServletInfo()
//	 */
//	public String getServletInfo() {
//		// TODO Auto-generated method stub
//		return null; 
//	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		 WaveFileWriter wfw = new WaveFileWriter();
//		 Info[] info = javax.sound.sampled.AudioSystem.getMixerInfo();
//		 for(Info i : info){System.out.println(i.getName()+"\r\n"+i.getDescription()+"\r\n"+i.getVendor()+"\r\n\r\n");}
//		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		 ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
//		 BufferedReader reqReader = new BufferedReader( request.getReader() );
//		 String fullRequest = "";
//		 String tmp = reqReader.readLine();
//		 while(tmp!=null)
//		 {
//			 fullRequest+=tmp;
//			 tmp=reqReader.readLine();
//		 }
//		 String resp1 = "<fullrequest>"+fullRequest+"</fullrequest>";
//		 response.setContentType("text/plain");
//		 response.getWriter().write(resp1);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");
		pw.write("start\r\n");
		DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(4096096);
        // the location for saving data that is larger than getSizeThreshold()
        factory.setRepository(new File(request.getSession().getServletContext().getRealPath("audio")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum size before a FileUploadException will be thrown
        upload.setSizeMax(100000000);

        List fileItems=null;
		try {
			fileItems = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
        // assume we know there are two files. The first file is a small
        // text file, the second is unknown and is written to a file on
        // the server
		
        Iterator i = fileItems.iterator();
        while(i.hasNext())
        {
        FileItem fi = (FileItem)i.next();
        // filename on the client
        String fileName = fi.getName();
        // save comment and filename to database
        
        // write the file
        try {
        	String fpath = request.getSession().getServletContext().getRealPath("audio"+File.separator+new File(fileName).getName());
			fi.write(new File(fpath));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        pw.write("end\r\n");
		
        if("".equals(""))return;
		 
		 
		 
		 
		 
		 
		 
		 
		 /////////////////////////////////////////////////
		 AudioData ad = new AudioData(new byte[]{0,0,0,0,0,0,0,0});
		 AudioDataStream ads = new AudioDataStream(ad);
		 AudioFormat af = new AudioFormat(44100, 16, 1, true, false);
		 AudioInputStream ais;
		 byte[] bdata = new byte[]{};
		 AudioInputStream ais1 = new AudioInputStream(new ByteArrayInputStream(bdata), af, bdata.length);
		
		 //new WaveFileWriter().write(ais1, AudioFileFormat.Type.WAVE, baos2);
		 
	}

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doTrace(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}
