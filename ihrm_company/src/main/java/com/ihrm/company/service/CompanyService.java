package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ihrm_parent
 * @Package: com.ihrm.company.service
 * @ClassName: CompanyService
 * @Author: Bowen
 * @Description: Company业务逻辑层
 * @Date: 2019/9/29 1:17
 * @Version: 1.0.0
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * @param null
     * @Method 保存企业
     * @Author Bowen
     * @Version 1.0.0
     * @Description
     * @Return
     * @Exception
     * @Date 2019/9/29 1:18
     */
    public Company add(Company company) {
        company.setId(idWorker.nextId() + "");
        company.setAuditState("0");
        company.setState(1);
        return companyDao.save(company);
    }

    public Company update(Company company) {
        Company byId = companyDao.findById(company.getId()).get();
        company.setName(company.getName());
        company.setCompanyPhone(company.getCompanyPhone());
        return companyDao.save(company);
    }

    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    public Company findById(String id) {
        return companyDao.findById(id).get();
    }

    public List<Company> findAll() {
        return companyDao.findAll();
    }
}
