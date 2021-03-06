package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnChenCheckboxDao;
import com.sclience.survey.dwsurvey.entity.AnChenCheckbox;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnChenCheckboxManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 矩陈多选题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class AnChenCheckboxManagerImpl extends BaseServiceImpl<AnChenCheckbox, String> implements AnChenCheckboxManager{

	@Autowired
	private AnChenCheckboxDao anChenCheckboxDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anChenCheckboxDao;
	}
	@Override
	public List<AnChenCheckbox> findAnswer(String belongAnswerId, String quId) {//belongAnswerId quId
		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		Criterion criterion2=Restrictions.eq("quId", quId);
		return anChenCheckboxDao.find(criterion1,criterion2);
	}
	@Override
	public void findGroupStats(Question question) {
		anChenCheckboxDao.findGroupStats(question);
	}
}
