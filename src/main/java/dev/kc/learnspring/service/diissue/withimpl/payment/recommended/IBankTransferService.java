package dev.kc.learnspring.service.diissue.withimpl.payment.recommended;

import dev.kc.learnspring.service.diissue.withimpl.payment.bank.IBankService;
import dev.kc.learnspring.service.diissue.withimpl.payment.transfer.ITransferService;

public interface IBankTransferService extends IBankService, ITransferService {
}
