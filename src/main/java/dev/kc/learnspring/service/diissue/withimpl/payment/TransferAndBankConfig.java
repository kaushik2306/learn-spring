package dev.kc.learnspring.service.diissue.withimpl.payment;

import dev.kc.learnspring.service.diissue.withimpl.payment.bank.BankService;
import dev.kc.learnspring.service.diissue.withimpl.payment.bank.IBankService;
import dev.kc.learnspring.service.diissue.withimpl.payment.transfer.ITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dev.kc.learnspring.service.diissue.withimpl.payment.recommended.BankTransferServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Issue of DI with below java configuration<br><br>
 * 1. bankService is dependent on IBankService<br>
 * 2. IBankService is created after wards or in large application not sure if it at all it will be created<br>
 * 3. Recommended approach implemented in {@link BankTransferServiceImpl}<br><br>
 * Note: To understand the issue remove {@link Service} annotation from {@link BankTransferServiceImpl}<br><br>
 */
@Configuration
public class TransferAndBankConfig {

    private static final Logger log = LoggerFactory.getLogger(TransferAndBankConfig.class);

    @Bean
    public BankService bankService(IBankService bankService){
        log.info("{} java-config injection of bankService",getClass().getSimpleName());
        return new BankService();
    }

    @Bean
    public ITransferService transferService(){
        log.info("{} java-config injection of transferService",getClass().getSimpleName());
        return new TransferAndBankImpl();
    }
}
