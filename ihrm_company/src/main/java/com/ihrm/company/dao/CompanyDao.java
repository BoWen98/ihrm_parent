package com.ihrm.company.dao;

import com.ihrm.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ProjectName: ihrm_parent
 * @Package: com.ihrm.company.dao
 * @ClassName: CompanyDao
 * @Author: Bowen
 * @Description: Company的数据访问层
 * @Date: 2019/9/29 1:11
 * @Version: 1.0.0
 */
public interface CompanyDao extends JpaRepository<Company, String>, JpaSpecificationExecutor<Company> {
}
