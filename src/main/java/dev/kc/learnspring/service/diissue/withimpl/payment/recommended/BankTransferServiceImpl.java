package dev.kc.learnspring.service.diissue.withimpl.payment.recommended;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * To understand the issue of DI remove @Service from this class<br><br>
 * Recommended approach when you have a single class implementing multiple interface<br><br>
 * Recommendation :<br>
 * Create a composite Interface here we have created of IBankTransferService<br><br>
 */
@Service
public class BankTransferServiceImpl implements IBankTransferService {

    private static final Logger log = LoggerFactory.getLogger(BankTransferServiceImpl.class);

    public BankTransferServiceImpl(){
        log.info("{} Constructor invoked",getClass().getSimpleName());
    }

    @Override
    public String bankHandler() {
        return "";
    }

    @Override
    public String transfer(Double amount) {
        return "";
    }
}
