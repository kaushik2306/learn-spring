package dev.kc.learnspring.service.diissue.withimpl.payment;

import dev.kc.learnspring.service.diissue.withimpl.payment.bank.IBankService;
import dev.kc.learnspring.service.diissue.withimpl.payment.transfer.ITransferService;

public class TransferAndBankImpl implements IBankService, ITransferService {

    @Override
    public String bankHandler() {
        return "Bank-Handler";
    }

    @Override
    public String transfer(Double amount) {
        return "Transfer done of amount "+amount;
    }
}
