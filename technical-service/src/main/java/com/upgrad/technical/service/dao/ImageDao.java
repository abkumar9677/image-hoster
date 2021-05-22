package com.upgrad.technical.service.dao;

import com.upgrad.technical.service.entity.ImageEntity;
import com.upgrad.technical.service.entity.UserAuthTokenEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class ImageDao {

    @PersistenceContext
    private EntityManager entityManager;

    // Feeding image
    public ImageEntity createImage(ImageEntity imageEntity) {
        entityManager.persist(imageEntity);
        return imageEntity;
    }

    // Getting user details for given access token from table user auth token
    public UserAuthTokenEntity getUserAuthToken(final String accesstoken) {
        try{
            return entityManager.createNamedQuery("userAuthTokenByAccessToken",UserAuthTokenEntity.class).setParameter("accessToken",accesstoken).getSingleResult();
        }
        catch (NoResultException nre){
            return null;
        }
    }

    // Getting image details
    public ImageEntity getImage(final String imageUuid) {
        try {
            return entityManager.createNamedQuery("ImageEntityByUuid",ImageEntity.class).setParameter("uuid",imageUuid).getSingleResult();
        }
        catch (NoResultException nre){
            return null;
        }
    }
    // Getting image details by id
    public ImageEntity getImageById(final long Id) {
        try{
            return entityManager.createNamedQuery("ImageEntityByid",ImageEntity.class).setParameter("id",Id).getSingleResult();
        }
        catch (NoResultException nre){
            return null;
        }
    }
    // Updating image
    public ImageEntity updateImage(final ImageEntity imageEntity) {
        entityManager.persist(imageEntity);
        return imageEntity;
    }
}
