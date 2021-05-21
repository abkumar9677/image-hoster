package com.upgrad.technical.service.business;


import com.upgrad.technical.service.dao.UserDao;
import com.upgrad.technical.service.entity.UserAuthTokenEntity;
import com.upgrad.technical.service.entity.UserEntity;
import com.upgrad.technical.service.exception.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.upgrad.technical.service.business.JwtTokenProvider;
import java.time.ZonedDateTime;

@Service
public class AuthenticationService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider CryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserAuthTokenEntity authenticate(final String username, final String password) throws AuthenticationFailedException {
        UserEntity userEntity = userDao.getUserByEmail(username);

        final String encryptedPassword = CryptographyProvider.encrypt(password, userEntity.getSalt());

        // Checking password encryption match
        if(!encryptedPassword.equals(userEntity.getPassword())){
            return null;
        }
        UserAuthTokenEntity userAuthTokenEntity = new UserAuthTokenEntity();
        userAuthTokenEntity.setUser(userEntity);
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(encryptedPassword);
        final ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime expiresat = now.plusHours(8);
        userAuthTokenEntity.setLoginAt(now);
        userAuthTokenEntity.setExpiresAt(expiresat);
        userAuthTokenEntity.setAccessToken(jwtTokenProvider.generateToken(userEntity.getUuid(),now,expiresat));
        userEntity.setLastLoginAt(now);
        userDao.updateUser(userEntity);
        userDao.createAuthToken(userAuthTokenEntity);

        // Returning userAuthToken
        return userAuthTokenEntity;
    }
}


