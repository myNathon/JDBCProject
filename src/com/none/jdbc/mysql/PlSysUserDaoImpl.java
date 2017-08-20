package com.none.jdbc.mysql;

import com.none.jdbc.mysql.been.PlSysUser;
import com.none.jdbc.mysql.dao.PlSysUserDao;
import com.none.jdbc.mysql.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户值对象操作接口的具体实现
 * @author Nathon
 *
 */
public class PlSysUserDaoImpl implements PlSysUserDao {
	//对应数据库中的表名
	private String tblName = "SysUser";

	@Override
	public void insert(PlSysUser sysu) {
		String sql = "insert into " + tblName + " (acct, passw, type, name, phone) values (?, ?, ?, ?, ?)";
		Connection conn = DBUtil.open();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sysu.getAcct());
			pstmt.setString(2, sysu.getPassw());
			pstmt.setString(3, sysu.getType());
			pstmt.setString(4, sysu.getName());
			pstmt.setString(5, sysu.getPhone());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void insert(String acct, String passw, String type) {
		String sql = "insert into " + tblName + " (acct, passw, type) values (?, ?, ?)";
		Connection conn = DBUtil.open();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acct);
			pstmt.setString(2, passw);
			pstmt.setString(3, type);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void update(PlSysUser sysu) {
		String sql = "update " + tblName + " set passw=?, type=?, name=?, phone=? where acct=?";
		Connection conn = DBUtil.open();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sysu.getPassw());
			pstmt.setString(2, sysu.getType());
			pstmt.setString(3, sysu.getName());
			pstmt.setString(4, sysu.getPhone());
			pstmt.setString(5, sysu.getAcct());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
	@Override
	public void update(String acct, String passw) {
		String sql = "update " + tblName + " set passw=? where acct=?";
		Connection conn = DBUtil.open();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, passw);
			pstmt.setString(2, acct);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void delete(String acct) {
		String sql = "delete from " + tblName + " where acct=?";
		Connection conn = DBUtil.open();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acct);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public PlSysUser getSysUserByAccount(String acct) {
		String sql = "select acct, passw, type, name, phone from " + tblName + " where acct=?";
		Connection conn = DBUtil.open();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acct);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				//String acct = rs.getString(1);
				String passw = rs.getString(2);
				String type = rs.getString(3);
				String name = rs.getString(4);
				String phone = rs.getString(5);
				
				PlSysUser sysu = new PlSysUser();
				sysu.setAcct(acct);
				sysu.setName(name);
				sysu.setPassw(passw);
				sysu.setPhone(phone);
				sysu.setType(type);
				
				return sysu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public List<PlSysUser> query() {
		String sql = "select acct, passw, type, name, phone from " + tblName;
		Connection conn = DBUtil.open();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<PlSysUser> uList = new ArrayList<PlSysUser>();
			while(rs.next()) {
				String acct = rs.getString(1);
				String passw = rs.getString(2);
				String type = rs.getString(3);
				String name = rs.getString(4);
				String phone = rs.getString(5);
				
				PlSysUser sysu = new PlSysUser();
				sysu.setAcct(acct);
				sysu.setName(name);
				sysu.setPassw(passw);
				sysu.setPhone(phone);
				sysu.setType(type);
				
				uList.add(sysu);
			}
			return uList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}

}
