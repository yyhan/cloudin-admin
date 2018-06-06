package com.cloudin.admin.entity;

import com.cloudin.commons.langs.entity.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author MyBatis Generator
 * @version 1.0.0, 2018-06-06 18:01:51
 */
public class PermissionExample extends PageInfo {
	protected String orderByClause;
	
	protected boolean distinct;
	
	protected List<Criteria> oredCriteria;
	
	public PermissionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}
	
	/**
	 *
	 * setOrderByClause
	 *
	 * @param orderByClause
	 *
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	
	/**
	 *
	 * getOrderByClause
	 *
	 * @return {@link java.lang.String}
	 */
	public String getOrderByClause() {
		return orderByClause;
	}
	
	/**
	 *
	 * setDistinct
	 *
	 * @param distinct
	 *
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	
	/**
	 *
	 * isDistinct
	 *
	 * @return {@link boolean}
	 */
	public boolean isDistinct() {
		return distinct;
	}
	
	/**
	 *
	 * getOredCriteria
	 *
	 * @return {@link java.util.List<Criteria>}
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}
	
	/**
	 *
	 * or
	 *
	 * @param criteria
	 *
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}
	
	/**
	 *
	 * or
	 *
	 * @return {@link Criteria}
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}
	
	/**
	 *
	 * createCriteria
	 *
	 * @return {@link Criteria}
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}
	
	/**
	 *
	 * createCriteriaInternal
	 *
	 * @return {@link Criteria}
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}
	
	/**
	 *
	 * clear
	 *
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	
	/**
	 * @author MyBatis Generator
	 * @version 1.0.0, 2018-06-06 18:01:51
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;
		
		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}
		
		public boolean isValid() {
			return criteria.size() > 0;
		}
		
		public List<Criterion> getAllCriteria() {
			return criteria;
		}
		
		public List<Criterion> getCriteria() {
			return criteria;
		}
		
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}
		
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}
		
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		
		public Criteria andIdIsNull() {
			addCriterion("`id` is null");
			return (Criteria) this;
		}
		
		public Criteria andIdIsNotNull() {
			addCriterion("`id` is not null");
			return (Criteria) this;
		}
		
		public Criteria andIdEqualTo(Integer value) {
			addCriterion("`id` =", value, "id");
			return (Criteria) this;
		}
		
		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("`id` <>", value, "id");
			return (Criteria) this;
		}
		
		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("`id` >", value, "id");
			return (Criteria) this;
		}
		
		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("`id` >=", value, "id");
			return (Criteria) this;
		}
		
		public Criteria andIdLessThan(Integer value) {
			addCriterion("`id` <", value, "id");
			return (Criteria) this;
		}
		
		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("`id` <=", value, "id");
			return (Criteria) this;
		}
		
		public Criteria andIdIn(List<Integer> values) {
			addCriterion("`id` in", values, "id");
			return (Criteria) this;
		}
		
		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("`id` not in", values, "id");
			return (Criteria) this;
		}
		
		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("`id` between", value1, value2, "id");
			return (Criteria) this;
		}
		
		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("`id` not between", value1, value2, "id");
			return (Criteria) this;
		}
		
		public Criteria andNameIsNull() {
			addCriterion("`name` is null");
			return (Criteria) this;
		}
		
		public Criteria andNameIsNotNull() {
			addCriterion("`name` is not null");
			return (Criteria) this;
		}
		
		public Criteria andNameEqualTo(String value) {
			addCriterion("`name` =", value, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameNotEqualTo(String value) {
			addCriterion("`name` <>", value, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameGreaterThan(String value) {
			addCriterion("`name` >", value, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("`name` >=", value, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameLessThan(String value) {
			addCriterion("`name` <", value, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("`name` <=", value, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameLike(String value) {
			addCriterion("`name` like", value, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameNotLike(String value) {
			addCriterion("`name` not like", value, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameIn(List<String> values) {
			addCriterion("`name` in", values, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameNotIn(List<String> values) {
			addCriterion("`name` not in", values, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("`name` between", value1, value2, "name");
			return (Criteria) this;
		}
		
		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("`name` not between", value1, value2, "name");
			return (Criteria) this;
		}
		
		public Criteria andContentIsNull() {
			addCriterion("`content` is null");
			return (Criteria) this;
		}
		
		public Criteria andContentIsNotNull() {
			addCriterion("`content` is not null");
			return (Criteria) this;
		}
		
		public Criteria andContentEqualTo(String value) {
			addCriterion("`content` =", value, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentNotEqualTo(String value) {
			addCriterion("`content` <>", value, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentGreaterThan(String value) {
			addCriterion("`content` >", value, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("`content` >=", value, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentLessThan(String value) {
			addCriterion("`content` <", value, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("`content` <=", value, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentLike(String value) {
			addCriterion("`content` like", value, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentNotLike(String value) {
			addCriterion("`content` not like", value, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentIn(List<String> values) {
			addCriterion("`content` in", values, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentNotIn(List<String> values) {
			addCriterion("`content` not in", values, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("`content` between", value1, value2, "content");
			return (Criteria) this;
		}
		
		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("`content` not between", value1, value2, "content");
			return (Criteria) this;
		}
		
		public Criteria andIconIsNull() {
			addCriterion("`icon` is null");
			return (Criteria) this;
		}
		
		public Criteria andIconIsNotNull() {
			addCriterion("`icon` is not null");
			return (Criteria) this;
		}
		
		public Criteria andIconEqualTo(String value) {
			addCriterion("`icon` =", value, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconNotEqualTo(String value) {
			addCriterion("`icon` <>", value, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconGreaterThan(String value) {
			addCriterion("`icon` >", value, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconGreaterThanOrEqualTo(String value) {
			addCriterion("`icon` >=", value, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconLessThan(String value) {
			addCriterion("`icon` <", value, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconLessThanOrEqualTo(String value) {
			addCriterion("`icon` <=", value, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconLike(String value) {
			addCriterion("`icon` like", value, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconNotLike(String value) {
			addCriterion("`icon` not like", value, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconIn(List<String> values) {
			addCriterion("`icon` in", values, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconNotIn(List<String> values) {
			addCriterion("`icon` not in", values, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconBetween(String value1, String value2) {
			addCriterion("`icon` between", value1, value2, "icon");
			return (Criteria) this;
		}
		
		public Criteria andIconNotBetween(String value1, String value2) {
			addCriterion("`icon` not between", value1, value2, "icon");
			return (Criteria) this;
		}
		
		public Criteria andCategoryIsNull() {
			addCriterion("`category` is null");
			return (Criteria) this;
		}
		
		public Criteria andCategoryIsNotNull() {
			addCriterion("`category` is not null");
			return (Criteria) this;
		}
		
		public Criteria andCategoryEqualTo(Integer value) {
			addCriterion("`category` =", value, "category");
			return (Criteria) this;
		}
		
		public Criteria andCategoryNotEqualTo(Integer value) {
			addCriterion("`category` <>", value, "category");
			return (Criteria) this;
		}
		
		public Criteria andCategoryGreaterThan(Integer value) {
			addCriterion("`category` >", value, "category");
			return (Criteria) this;
		}
		
		public Criteria andCategoryGreaterThanOrEqualTo(Integer value) {
			addCriterion("`category` >=", value, "category");
			return (Criteria) this;
		}
		
		public Criteria andCategoryLessThan(Integer value) {
			addCriterion("`category` <", value, "category");
			return (Criteria) this;
		}
		
		public Criteria andCategoryLessThanOrEqualTo(Integer value) {
			addCriterion("`category` <=", value, "category");
			return (Criteria) this;
		}
		
		public Criteria andCategoryIn(List<Integer> values) {
			addCriterion("`category` in", values, "category");
			return (Criteria) this;
		}
		
		public Criteria andCategoryNotIn(List<Integer> values) {
			addCriterion("`category` not in", values, "category");
			return (Criteria) this;
		}
		
		public Criteria andCategoryBetween(Integer value1, Integer value2) {
			addCriterion("`category` between", value1, value2, "category");
			return (Criteria) this;
		}
		
		public Criteria andCategoryNotBetween(Integer value1, Integer value2) {
			addCriterion("`category` not between", value1, value2, "category");
			return (Criteria) this;
		}
		
		public Criteria andOrderIsNull() {
			addCriterion("`order` is null");
			return (Criteria) this;
		}
		
		public Criteria andOrderIsNotNull() {
			addCriterion("`order` is not null");
			return (Criteria) this;
		}
		
		public Criteria andOrderEqualTo(Integer value) {
			addCriterion("`order` =", value, "order");
			return (Criteria) this;
		}
		
		public Criteria andOrderNotEqualTo(Integer value) {
			addCriterion("`order` <>", value, "order");
			return (Criteria) this;
		}
		
		public Criteria andOrderGreaterThan(Integer value) {
			addCriterion("`order` >", value, "order");
			return (Criteria) this;
		}
		
		public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
			addCriterion("`order` >=", value, "order");
			return (Criteria) this;
		}
		
		public Criteria andOrderLessThan(Integer value) {
			addCriterion("`order` <", value, "order");
			return (Criteria) this;
		}
		
		public Criteria andOrderLessThanOrEqualTo(Integer value) {
			addCriterion("`order` <=", value, "order");
			return (Criteria) this;
		}
		
		public Criteria andOrderIn(List<Integer> values) {
			addCriterion("`order` in", values, "order");
			return (Criteria) this;
		}
		
		public Criteria andOrderNotIn(List<Integer> values) {
			addCriterion("`order` not in", values, "order");
			return (Criteria) this;
		}
		
		public Criteria andOrderBetween(Integer value1, Integer value2) {
			addCriterion("`order` between", value1, value2, "order");
			return (Criteria) this;
		}
		
		public Criteria andOrderNotBetween(Integer value1, Integer value2) {
			addCriterion("`order` not between", value1, value2, "order");
			return (Criteria) this;
		}
		
		public Criteria andParentIdIsNull() {
			addCriterion("`parent_id` is null");
			return (Criteria) this;
		}
		
		public Criteria andParentIdIsNotNull() {
			addCriterion("`parent_id` is not null");
			return (Criteria) this;
		}
		
		public Criteria andParentIdEqualTo(Integer value) {
			addCriterion("`parent_id` =", value, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andParentIdNotEqualTo(Integer value) {
			addCriterion("`parent_id` <>", value, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andParentIdGreaterThan(Integer value) {
			addCriterion("`parent_id` >", value, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("`parent_id` >=", value, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andParentIdLessThan(Integer value) {
			addCriterion("`parent_id` <", value, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andParentIdLessThanOrEqualTo(Integer value) {
			addCriterion("`parent_id` <=", value, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andParentIdIn(List<Integer> values) {
			addCriterion("`parent_id` in", values, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andParentIdNotIn(List<Integer> values) {
			addCriterion("`parent_id` not in", values, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andParentIdBetween(Integer value1, Integer value2) {
			addCriterion("`parent_id` between", value1, value2, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
			addCriterion("`parent_id` not between", value1, value2, "parentId");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoIsNull() {
			addCriterion("`ext_info` is null");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoIsNotNull() {
			addCriterion("`ext_info` is not null");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoEqualTo(String value) {
			addCriterion("`ext_info` =", value, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoNotEqualTo(String value) {
			addCriterion("`ext_info` <>", value, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoGreaterThan(String value) {
			addCriterion("`ext_info` >", value, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoGreaterThanOrEqualTo(String value) {
			addCriterion("`ext_info` >=", value, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoLessThan(String value) {
			addCriterion("`ext_info` <", value, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoLessThanOrEqualTo(String value) {
			addCriterion("`ext_info` <=", value, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoLike(String value) {
			addCriterion("`ext_info` like", value, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoNotLike(String value) {
			addCriterion("`ext_info` not like", value, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoIn(List<String> values) {
			addCriterion("`ext_info` in", values, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoNotIn(List<String> values) {
			addCriterion("`ext_info` not in", values, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoBetween(String value1, String value2) {
			addCriterion("`ext_info` between", value1, value2, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andExtInfoNotBetween(String value1, String value2) {
			addCriterion("`ext_info` not between", value1, value2, "extInfo");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeIsNull() {
			addCriterion("`create_time` is null");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeIsNotNull() {
			addCriterion("`create_time` is not null");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("`create_time` =", value, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("`create_time` <>", value, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("`create_time` >", value, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("`create_time` >=", value, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("`create_time` <", value, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("`create_time` <=", value, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("`create_time` in", values, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("`create_time` not in", values, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("`create_time` between", value1, value2, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("`create_time` not between", value1, value2, "createTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeIsNull() {
			addCriterion("`update_time` is null");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("`update_time` is not null");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("`update_time` =", value, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("`update_time` <>", value, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("`update_time` >", value, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("`update_time` >=", value, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("`update_time` <", value, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("`update_time` <=", value, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("`update_time` in", values, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("`update_time` not in", values, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("`update_time` between", value1, value2, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("`update_time` not between", value1, value2, "updateTime");
			return (Criteria) this;
		}
		
		public Criteria andValidIsNull() {
			addCriterion("`is_valid` is null");
			return (Criteria) this;
		}
		
		public Criteria andValidIsNotNull() {
			addCriterion("`is_valid` is not null");
			return (Criteria) this;
		}
		
		public Criteria andValidEqualTo(Boolean value) {
			addCriterion("`is_valid` =", value, "valid");
			return (Criteria) this;
		}
		
		public Criteria andValidNotEqualTo(Boolean value) {
			addCriterion("`is_valid` <>", value, "valid");
			return (Criteria) this;
		}
		
		public Criteria andValidGreaterThan(Boolean value) {
			addCriterion("`is_valid` >", value, "valid");
			return (Criteria) this;
		}
		
		public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
			addCriterion("`is_valid` >=", value, "valid");
			return (Criteria) this;
		}
		
		public Criteria andValidLessThan(Boolean value) {
			addCriterion("`is_valid` <", value, "valid");
			return (Criteria) this;
		}
		
		public Criteria andValidLessThanOrEqualTo(Boolean value) {
			addCriterion("`is_valid` <=", value, "valid");
			return (Criteria) this;
		}
		
		public Criteria andValidIn(List<Boolean> values) {
			addCriterion("`is_valid` in", values, "valid");
			return (Criteria) this;
		}
		
		public Criteria andValidNotIn(List<Boolean> values) {
			addCriterion("`is_valid` not in", values, "valid");
			return (Criteria) this;
		}
		
		public Criteria andValidBetween(Boolean value1, Boolean value2) {
			addCriterion("`is_valid` between", value1, value2, "valid");
			return (Criteria) this;
		}
		
		public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
			addCriterion("`is_valid` not between", value1, value2, "valid");
			return (Criteria) this;
		}
	}
	
	/**
	 * @author MyBatis Generator
	 * @version 1.0.0, 2018-06-06 18:01:51
	 */
	public static class Criteria extends GeneratedCriteria {
		
		protected Criteria() {
			super();
		}
	}
	
	/**
	 * @author MyBatis Generator
	 * @version 1.0.0, 2018-06-06 18:01:51
	 */
	public static class Criterion {
		private String condition;
		
		private Object value;
		
		private Object secondValue;
		
		private boolean noValue;
		
		private boolean singleValue;
		
		private boolean betweenValue;
		
		private boolean listValue;
		
		private String typeHandler;
		
		public String getCondition() {
			return condition;
		}
		
		public Object getValue() {
			return value;
		}
		
		public Object getSecondValue() {
			return secondValue;
		}
		
		public boolean isNoValue() {
			return noValue;
		}
		
		public boolean isSingleValue() {
			return singleValue;
		}
		
		public boolean isBetweenValue() {
			return betweenValue;
		}
		
		public boolean isListValue() {
			return listValue;
		}
		
		public String getTypeHandler() {
			return typeHandler;
		}
		
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}
		
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}
		
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}
		
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}
		
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}