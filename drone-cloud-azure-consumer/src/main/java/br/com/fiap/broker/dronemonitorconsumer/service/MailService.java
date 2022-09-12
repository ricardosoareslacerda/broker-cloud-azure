package br.com.fiap.broker.dronemonitorconsumer.service;

import br.com.fiap.broker.dronemonitorconsumer.vo.MailVO;

public interface MailService {

    void sendMail(final MailVO mailVO);
}
