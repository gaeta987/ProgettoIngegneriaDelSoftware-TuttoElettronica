package it.unisa.control;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayImage
 */
@WebServlet("/DisplayImage")
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "images\\copertine\\";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayImage() {
        super();
    }

    public static void writeJPEG(BufferedImage image, OutputStream out) {
    	try {
    		ImageIO.write(image, "jpg", out);
    	}catch(IOException e) {
    		System.err.println("Error outputing image");
    	}
    }
    
    private BufferedImage createImage(String path, String savePath) throws IOException {
    	
    	File folderInput = new File(savePath + path);
        BufferedImage folderImage = ImageIO.read(folderInput);
        
        
    	Graphics g = folderImage.getGraphics();
		g.drawImage(folderImage, 1800, 1800, null);
		
		return folderImage;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		String path = request.getParameter("url");

		
		writeJPEG(createImage(path, savePath), out);
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
