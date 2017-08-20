package com.none.jdbc.mysql;

import com.none.jdbc.mysql.been.PlSysUser;
import com.none.jdbc.mysql.dao.PlSysUserDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Nathon on 2017/8/21.
 */
class PlSysUserDaoImplTest {
    private PlSysUserDao sysUserDao = new PlSysUserDaoImpl();

    @Test
    void insert() {
        getSysUserByAccount();
    }

    @Test
    void insert1() {
        String acct = "admin2";
        String passw = "123456";
        String type = "0";
        PlSysUser sUser = sysUserDao.getSysUserByAccount("admin2");
        if(sUser != null) {
            sysUserDao.delete(acct);
        }
        sysUserDao.insert(acct, passw, type);

        sUser = sysUserDao.getSysUserByAccount("admin2");
        assertTrue(acct.equals(sUser.getAcct()));
        assertTrue(passw.equals(sUser.getPassw()));
        assertTrue(type.equals(sUser.getType()));
    }

    @Test
    void update() {
        PlSysUser sUser = sysUserDao.getSysUserByAccount("admin");
        if(sUser != null) {
            sysUserDao.delete("admin");
        }

        // insert
        sUser = new PlSysUser();
        sUser.setAcct("admin");
        sUser.setName("UserName");
        sUser.setPassw("123456");
        sUser.setPhone("12345678910");
        sUser.setType("0");
        sysUserDao.insert(sUser);

        // update
        sUser.setAcct("admin");
        sUser.setName("UserName2");
        sUser.setPassw("1234567");
        sUser.setPhone("12345678920");
        sUser.setType("1");
        sysUserDao.update(sUser);

        sUser = sysUserDao.getSysUserByAccount("admin");
        assertTrue(sUser != null);
        assertTrue("UserName2".equals(sUser.getName()));
        assertTrue("1234567".equals(sUser.getPassw()));
        assertTrue("12345678920".equals(sUser.getPhone()));
        assertTrue("1".equals(sUser.getType()));
    }

    @Test
    void update1() {
        String acct = "admin2";
        String passw = "123456";
        String type = "0";
        PlSysUser sUser = sysUserDao.getSysUserByAccount(acct);
        if(sUser != null) {
            sysUserDao.delete(acct);
        }
        sysUserDao.insert(acct, passw, type);

        acct = "admin2";
        passw = "***123456***";
        sysUserDao.update(acct, passw);

        sUser = sysUserDao.getSysUserByAccount(acct);
        assertTrue(acct.equals(sUser.getAcct()));
        assertTrue(passw.equals(sUser.getPassw()));
    }

    @Test
    void delete() {
        sysUserDao.delete("admin2");
        PlSysUser sUser = sysUserDao.getSysUserByAccount("admin2");
        assertTrue(sUser == null);
    }

    @Test
    void getSysUserByAccount() {
        PlSysUser sUser = sysUserDao.getSysUserByAccount("admin");
        if(sUser != null) {
            sysUserDao.delete("admin");
        }

        sUser = new PlSysUser();
        sUser.setAcct("admin");
        sUser.setName("UserName");
        sUser.setPassw("123456");
        sUser.setPhone("12345678910");
        sUser.setType("0");
        sysUserDao.insert(sUser);

        sUser = sysUserDao.getSysUserByAccount("admin");
        assertTrue(sUser != null);
        assertTrue("UserName".equals(sUser.getName()));
        assertTrue("123456".equals(sUser.getPassw()));
        assertTrue("12345678910".equals(sUser.getPhone()));
        assertTrue("0".equals(sUser.getType()));
    }

    @Test
    void query() {
        // 根据上面的操作进行判断
        List<PlSysUser> lists = sysUserDao.query();
        assertTrue(lists.size() != 0);
    }

}