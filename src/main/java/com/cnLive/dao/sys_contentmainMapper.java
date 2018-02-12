package com.cnLive.dao;

import com.cnLive.pojo.sys_contentmain;
import com.cnLive.pojo.sys_contentmainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface sys_contentmainMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	int countByExample(sys_contentmainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	int deleteByExample(sys_contentmainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer contentid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	int insert(sys_contentmain record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	int insertSelective(sys_contentmain record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	List<sys_contentmain> selectByExample(sys_contentmainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	sys_contentmain selectByPrimaryKey(Integer contentid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") sys_contentmain record,
			@Param("example") sys_contentmainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") sys_contentmain record,
			@Param("example") sys_contentmainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(sys_contentmain record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_contentmain
	 * @mbggenerated
	 */
	int updateByPrimaryKey(sys_contentmain record);
}