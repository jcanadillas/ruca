package com.model;

import com.google.appengine.api.blobstore.*;
import com.google.appengine.api.users.*;
import com.model.dao.GaleriaDAO;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;
import javax.jdo.*;
import javax.servlet.http.*;

// Referenced classes of package com.model:
//            PMF, MediaObject, Gallery

public class UploadPost extends HttpServlet {

	private BlobstoreService blobstoreService;

	public UploadPost() {
		blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User user;
		BlobKey blobKey;
		String contentType;
		long size;
		Date creation;
		String fileName;
		String op;
		String title;
		String description;
		boolean bPrincipal;
		UserService userService = UserServiceFactory.getUserService();
		user = userService.getCurrentUser();
		//Map blobs = blobstoreService.getUploadedBlobs(req);
		
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
	     
		
		if (blobs.keySet().isEmpty()) {
			resp.sendRedirect(
					(new StringBuilder("/?error=")).append(URLEncoder.encode("No file uploaded", "UTF-8")).toString());
			return;
		}
		
		Iterator names = blobs.keySet().iterator();
		String blobName = (String) names.next();
		blobKey =  blobs.get(blobName).get(0);
		if (user == null) {
			blobstoreService.delete(new BlobKey[] { blobKey });
			resp.sendRedirect((new StringBuilder("/?error="))
					.append(URLEncoder.encode("Must be logged in to upload", "UTF-8")).toString());
			return;
		}
		BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
		BlobInfo blobInfo = blobInfoFactory.loadBlobInfo(blobKey);
		contentType = blobInfo.getContentType();
		size = blobInfo.getSize();
		creation = blobInfo.getCreation();
		fileName = blobInfo.getFilename();
		op = req.getParameter("op");
		title = req.getParameter("title");
		description = req.getParameter("description");
		String sPrincipal = req.getParameter("principal");
		bPrincipal = false;
		if (sPrincipal != null && sPrincipal.equalsIgnoreCase("yes")) {
			bPrincipal = true;
		}
		String anterior = req.getParameter("anterior");
		if(anterior==null) anterior="";
		
		PersistenceManager pm;
		Transaction tx;
		GaleriaDAO galleryDao = new GaleriaDAO();
		pm = PMF.get().getPersistenceManager();
		tx = pm.currentTransaction();
		tx.begin();

		Gallery gallery = null;
		try {
			gallery = GaleriaDAO.getGalleryByName(pm, op);
			if (gallery == null) {
				gallery = GaleriaDAO.createGallery(pm, op);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		MediaObject mediaObj = new MediaObject(user, blobKey, creation, contentType, fileName, size, title, description,
				true, gallery, bPrincipal, anterior, ""); 
		
		gallery.addPhoto(mediaObj);
		tx.commit();
		pm.close();

		if (op.equals("obraNueva")) {
			resp.sendRedirect("/upload?galeria=obraNueva");
		} else if (op.equals("decoracion")) {
			resp.sendRedirect("/upload?galeria=decoracion");
		} else if (op.equals("oficinas")) {
			resp.sendRedirect("/upload?galeria=oficinas");
		} else if (op.equals("reformas")) {
			resp.sendRedirect("/upload?galeria=reformas");
		} else {
			resp.sendRedirect("/upload");
		}

	}
}