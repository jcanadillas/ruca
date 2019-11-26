package com.model.dao;

import com.model.Gallery;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class GaleriaDAO
{

    public GaleriaDAO()
    {
    }

    public static Gallery getGaleria(PersistenceManager pm, long id)
        throws Exception
    {
        return (Gallery)pm.getObjectById(Gallery.class, Long.valueOf(id));
    }

    public static void updateGaleria(PersistenceManager pm, Gallery gallery)
        throws Exception
    {
        pm.makePersistent(gallery);
    }

    public static void deleteOrder(PersistenceManager pm, Gallery galeria)
    {
        pm.deletePersistent(galeria);
    }

    public static Gallery createGallery(PersistenceManager pm, String nombre)
        throws Exception
    {
        Gallery galeria = new Gallery(nombre);
        pm.makePersistent(galeria);
        return galeria;
    }

    public static Gallery getGalleryByName(PersistenceManager pm, String nombre)
        throws Exception
    {
        String query = (new StringBuilder("select from ")).append(Gallery.class.getName()).append(" where name == '").append(nombre).append("'").toString();
        List galerias = (List)pm.newQuery(query).execute();
        if(galerias.size() > 0)
        {
            return (Gallery)galerias.get(0);
        } else
        {
            return null;
        }
    }

    public static List getGalerias(PersistenceManager pm)
        throws Exception
    {
        String query = (new StringBuilder("select from ")).append(Gallery.class.getName()).append(" where name != 'Principal'").toString();
        return (List)pm.newQuery(query).execute();
    }

    public static List getAllGalerias(PersistenceManager pm)
        throws Exception
    {
        Query query = pm.newQuery(Gallery.class);
        return (List)query.execute();
    }
}
