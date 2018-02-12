/**
 *
 */
package com.cnLive.common.webSocket.Service;

import com.cnLive.common.webSocket.pojo.Users;

import java.io.Serializable;
import java.util.List;

/**
 * @author zc
 */
public class UserService  {

     //添加用户
    public boolean save(Users entity) {

        return false;
    }

     //删除用户
    public boolean delete(Users entity) {

        return false;
    }

     //更新用户
    public boolean update(Users entity) {

        return false;
    }

    //找到用户
    public Users get(Serializable id) {

        return null;
    }


    //判断用户名是否存在
    public boolean exit_userName(String username) {
      /*  Transaction tx = null;
        Boolean exit = false;
        try {
            Session session = HibernateUtils.getCurrentSession();
            tx = session.beginTransaction();
            exit = userDao.exist_user(username, 2);
            tx.commit();
        } catch (Exception ce) {
            if (tx != null) {
                tx.rollback();
            }
            ce.printStackTrace();
        }
        return exit;*/
        return  false;
    }


    //判断用户id(手机号)是否存在
    public boolean exit_userId(String userid) {
//        Transaction tx = null;
//        Boolean exit = false;
//        try {
//            Session session = HibernateUtils.getCurrentSession();
//            tx = session.beginTransaction();
//            exit = userDao.exist_user(userid, 1);
//            tx.commit();
//        } catch (Exception ce) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            ce.printStackTrace();
//        }
//        return exit;
        return false;
    }


    //登录业务逻辑
    public Users loginservice(Users user) {
      /*  Transaction tx = null;
        try {
            Session session = HibernateUtils.getCurrentSession();
            tx = session.beginTransaction();
            String hql =
                    " from Users where (userId=? or userName=?)and userPassword=?";
            Object[] params = {user.getUserId(), user.getUserId(), user.getUserPassword()};
            List<Users> list = userDao.findList(hql, params);
            tx.commit();
            if (list != null && !list.isEmpty()) {

                Users login_user = list.get(0);
                login_user.setUserPassword("");
                login_user.setUserPicPath(PropertiesUtil.getProperty("cos.server.http.prefix") + login_user.getUserPicPath());
                return login_user;
            }
        } catch (Exception ce) {
            if (tx != null) {
                tx.rollback();
            }
            ce.printStackTrace();
        }*/

        return null;
    }


    public Users getUserbyRoomId(Integer roomId) {
  /*      Transaction tx = null;
        try {
            Session session = HibernateUtils.getCurrentSession();
            tx = session.beginTransaction();
            String hql =
                    "from Users where roomId=?";
            Object[] params = {roomId};
            List<Users> list = userDao.findList(hql, params);
            tx.commit();
            if (list != null && !list.isEmpty()) {
                Users liver = list.get(0);
                liver.setUserPassword("");
                liver.setUserPicPath(PropertiesUtil.getProperty("cos.server.http.prefix") + liver.getUserPicPath());
                return liver;
            }
        } catch (Exception ce) {
            if (tx != null) {
                tx.rollback();
            }
            ce.printStackTrace();
        }*/

        return null;
    }


}
