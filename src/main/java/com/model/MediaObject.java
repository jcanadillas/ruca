/* Copyright (c) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION) 
public class MediaObject{
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Key key;

  @Persistent
  private User owner;

  @Persistent
  private BlobKey blob;

  @Persistent
  private Date creation;

  @Persistent
  private String contentType;

  @Persistent
  private String filename;

  @Persistent
  private long size;

  @Persistent
  private String title;

  @Persistent
  private String description;

  @Persistent
  private boolean isPublic;
  
  @Persistent
  private boolean isPrincipal;
  
  @Persistent
  private Gallery gallery;
  
  @Persistent
  private String textAntes;

  @Persistent
  private String textDespues; 

  private static final List<String> IMAGE_TYPES = Arrays.asList("image/png",
    "image/jpeg", "image/tiff", "image/gif", "image/bmp");


public MediaObject(User owner, BlobKey blob, Date creationTime, String contentType, String filename, long size, 
          String title, String description, boolean isPublic, Gallery gallery, boolean isPrincipal, String textAntes, String testDespues)
  {
      this.blob = blob;
      this.owner = owner;
      this.creation = creationTime;
      this.contentType = contentType;
      this.filename = filename;
      this.size = size;
      this.title = title;
      this.description = description;
      this.isPublic = isPublic;
      this.isPrincipal = isPrincipal;
      this.gallery = gallery;
      this.textAntes = textAntes;
      this.textDespues = testDespues;
  }


  public Key getKey() {
    return key;
  }

  public User getOwner() {
    return owner;
  }

  public Date getCreationTime() {
    return creation;
  }

  public boolean isPublic() {
    return isPublic;
  }

  public String getDescription() {
    return description;
  }

  public String getTitle() {
    return title;
  }

  public String getFilename() {
    return filename;
  }

  public long getSize() {
    return size;
  }

  public String getContentType() {
    if (contentType ==  null) {
      return "text/plain";
    }
    return contentType;
  }

  public String getURLPath() {
    String key = blob.getKeyString();
    return "/resource?key=" + key;
  }

  public String getDisplayURL() {
    String key = blob.getKeyString();
    return "/display?key=" + key;
  }

  public boolean isImage() {
    return IMAGE_TYPES.contains(getContentType());
  }

public BlobKey getBlob() {
	return blob;
}

public void setBlob(BlobKey blob) {
	this.blob = blob;
}

public Date getCreation() {
	return creation;
}

public void setCreation(Date creation) {
	this.creation = creation;
}

public boolean isPrincipal() {
	return isPrincipal;
}

public void setPrincipal(boolean isPrincipal) {
	this.isPrincipal = isPrincipal;
}

public Gallery getGallery() {
	return gallery;
}

public void setGallery(Gallery gallery) {
	this.gallery = gallery;
}


public String getTextAntes() {
	return textAntes;
}

public void setTextAntes(String textAntes) {
	this.textAntes = textAntes;
}

public String getTextDespues() {
	return textDespues;
}

public void setTextDespues(String textDespues) {
	this.textDespues = textDespues;
}

public static List<String> getImageTypes() {
	return IMAGE_TYPES;
}

public void setKey(Key key) {
	this.key = key;
}

public void setOwner(User owner) {
	this.owner = owner;
}

public void setContentType(String contentType) {
	this.contentType = contentType;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public void setSize(long size) {
	this.size = size;
}

public void setTitle(String title) {
	this.title = title;
}

public void setDescription(String description) {
	this.description = description;
}

public void setPublic(boolean isPublic) {
	this.isPublic = isPublic;
}

}