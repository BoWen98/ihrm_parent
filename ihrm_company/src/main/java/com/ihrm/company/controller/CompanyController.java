package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: ihrm_parent
 * @Package: com.ihrm.company.controller
 * @ClassName: CompanyController
 * @Author: Bowen
 * @Description: Company控制访问层
 * @Date: 2019/9/29 1:28
 * @Version: 1.0.0
 */

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 添加企业
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result add(@RequestBody Company company) throws Exception {
        companyService.add(company);
        return Result.SUCCESS();
    }

    /**
     * 根据id更新企业信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(name = "id") String id, @RequestBody Company
            company) throws Exception {
        Company one = companyService.findById(id);
        one.setName(company.getName());
        one.setRemarks(company.getRemarks());
        one.setState(company.getState());
        one.setAuditState(company.getAuditState());
        companyService.update(company);
        return Result.SUCCESS();
    }

    /**
     * 根据id删除企业信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(name = "id") String id) throws Exception {
        companyService.deleteById(id);
        return Result.SUCCESS();
    }

    /**
     *   * 根据ID获取公司信息
     *   
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Company company = companyService.findById(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     *   * 获取企业列表
     *   
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result findAll() throws Exception {
        List<Company> companyList = companyService.findAll();
        return new Result(ResultCode.SUCCESS);
    }
}
