package com.none.jdbc.mysql.dao;

import com.none.jdbc.mysql.been.PlSysUser;

import java.util.List;

/**
 * 系统用户值对象操作接口
 * @author Nathon
 *
 */
public interface PlSysUserDao {
	/**
	 * 新增一个系统用户
	 * @param sysu 系统用户值对象
	 */
	public void insert(PlSysUser sysu);

	/**
	 * 新增一个系统用户
	 * @param acct 用户账号
	 * @param passw 用户密码
	 * @param type 用户类型
	 */
	public void insert(String acct, String passw, String type);
	/**
	 * 系统用户更新
	 * @param sysu 系统用户值对象
	 */
	public void update(PlSysUser sysu);
	/**
	 * 更新系统用户密码
	 * @param acct 用户账号
	 * @param passw 用户密码
	 */
	public void update(String acct, String passw);
	/**
	 * 删除系统用户
	 * @param acct 用户账号
	 */
	public void delete(String acct);
	/**
	 * 通过用户账号获取用户
	 * @param acct 用户账号
	 * @return 系统用户值对象
	 */
	public PlSysUser getSysUserByAccount(String acct);
	/**
	 * 返回所有系统用户
	 * @return 系统用户值对象列表
	 */
	public List<PlSysUser> query();
	
}
