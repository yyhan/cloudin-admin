package com.cloudin.admin.dao;

import com.cloudin.admin.entity.RolePermission;
import com.cloudin.admin.entity.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author MyBatis Generator
 * @version 1.0.0, 2018-06-06 14:52:53
 */
public interface RolePermissionDAO {
    /**
     * 
     * countByExample
     * 
     * @param example
     * 
     * @return {@link long}
     */
    long countByExample(RolePermissionExample example);

    /**
     * 
     * deleteByExample
     * 
     * @param example
     * 
     * @return {@link int}
     */
    int deleteByExample(RolePermissionExample example);

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
    int insert(RolePermission record);

    /**
     * 
     * insertSelective
     * 
     * @param record
     * 
     * @return {@link int}
     */
    int insertSelective(RolePermission record);

    /**
     * 
     * selectByExample
     * 
     * @param example
     * 
     * @return {@link java.util.List<com.cloudin.admin.entity.RolePermission>}
     */
    List<RolePermission> selectByExample(RolePermissionExample example);

    /**
     * 
     * selectByPrimaryKey
     * 
     * @param id
     * 
     * @return {@link com.cloudin.admin.entity.RolePermission}
     */
    RolePermission selectByPrimaryKey(Integer id);

    /**
     * 
     * updateByExampleSelective
     * 
     * @param record
     * @param example
     * 
     * @return {@link int}
     */
    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * 
     * updateByExample
     * 
     * @param record
     * @param example
     * 
     * @return {@link int}
     */
    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * 
     * updateByPrimaryKeySelective
     * 
     * @param record
     * 
     * @return {@link int}
     */
    int updateByPrimaryKeySelective(RolePermission record);

    /**
     * 
     * updateByPrimaryKey
     * 
     * @param record
     * 
     * @return {@link int}
     */
    int updateByPrimaryKey(RolePermission record);
}