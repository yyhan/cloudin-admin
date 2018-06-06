package com.cloudin.admin.dao;

import com.cloudin.admin.entity.AdministratorRole;
import com.cloudin.admin.entity.AdministratorRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author MyBatis Generator
 * @version 1.0.0, 2018-06-06 14:52:53
 */
public interface AdministratorRoleDAO {
    /**
     * 
     * countByExample
     * 
     * @param example
     * 
     * @return {@link long}
     */
    long countByExample(AdministratorRoleExample example);

    /**
     * 
     * deleteByExample
     * 
     * @param example
     * 
     * @return {@link int}
     */
    int deleteByExample(AdministratorRoleExample example);

    /**
     * 
     * deleteByPrimaryKey
     * 
     * @param id
     * 
     * @return {@link int}
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 
     * insert
     * 
     * @param record
     * 
     * @return {@link int}
     */
    int insert(AdministratorRole record);

    /**
     * 
     * insertSelective
     * 
     * @param record
     * 
     * @return {@link int}
     */
    int insertSelective(AdministratorRole record);

    /**
     * 
     * selectByExample
     * 
     * @param example
     * 
     * @return {@link java.util.List<com.cloudin.admin.entity.AdministratorRole>}
     */
    List<AdministratorRole> selectByExample(AdministratorRoleExample example);

    /**
     * 
     * selectByPrimaryKey
     * 
     * @param id
     * 
     * @return {@link com.cloudin.admin.entity.AdministratorRole}
     */
    AdministratorRole selectByPrimaryKey(Integer id);

    /**
     * 
     * updateByExampleSelective
     * 
     * @param record
     * @param example
     * 
     * @return {@link int}
     */
    int updateByExampleSelective(@Param("record") AdministratorRole record, @Param("example") AdministratorRoleExample example);

    /**
     * 
     * updateByExample
     * 
     * @param record
     * @param example
     * 
     * @return {@link int}
     */
    int updateByExample(@Param("record") AdministratorRole record, @Param("example") AdministratorRoleExample example);

    /**
     * 
     * updateByPrimaryKeySelective
     * 
     * @param record
     * 
     * @return {@link int}
     */
    int updateByPrimaryKeySelective(AdministratorRole record);

    /**
     * 
     * updateByPrimaryKey
     * 
     * @param record
     * 
     * @return {@link int}
     */
    int updateByPrimaryKey(AdministratorRole record);
	
	List<String> listRoles(@Param("administratorId") Integer administratorId);
}