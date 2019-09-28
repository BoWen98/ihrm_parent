package com.ihrm.company;

import com.ihrm.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

/**
 * @ProjectName: ihrm_parent
 * @Package: com.ihrm.company
 * @ClassName: CompanyApplicatioin
 * @Author: Bowen
 * @Description: Company启动类
 * @Date: 2019/9/29 1:00
 * @Version: 1.0.0
 */
@SpringBootApplication(scanBasePackages = "com.ihrm.company")
@EntityScan(value = "com.ihrm.domain")
public class CompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
