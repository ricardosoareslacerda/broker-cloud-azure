package br.com.fiap.broker.dronemonitorconsumer.service;

import br.com.fiap.broker.dronemonitorconsumer.vo.DroneVO;
import br.com.fiap.broker.dronemonitorconsumer.vo.MailVO;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    private final Configuration freemarkerConfiguration;

    @SneakyThrows
    @Override
    public void sendMail(final MailVO mailVO) {
        this.sendMail(mailVO.getFromAddress(), mailVO.getSubject(), this.getEmailContent(mailVO.getDrone()), mailVO.getToAddresses());
    }

    private void sendMail(final String fromAddress, final String subject, final String body, final String toAddresses) {
        this.sendMail(fromAddress, subject, body, toAddresses, null, null);
    }

    private void sendMail(final String fromAddress, final String subject, final String body, final String toAddresses, final String ccAddresses, final String bccAddresses) {
        this.sendMail(fromAddress, subject, body, toAddresses, ccAddresses, bccAddresses, null);
    }

    private void sendMail(final String fromAddress, final String subject, final String body, final String toAddresses, final String ccAddresses, final String bccAddresses, final String[] attachments) {
        try {
            final MimeMessagePreparator preparator = mimeMessage -> {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
                message.setFrom(fromAddress, "Drone Monitor");
                message.setTo(toAddresses.split("[,;]"));

                if (StringUtils.isNotBlank(ccAddresses))
                    message.setCc(ccAddresses.split("[;,]"));

                if (StringUtils.isNotBlank(bccAddresses))
                    message.setBcc(bccAddresses.split("[;,]"));

                message.setSubject(subject);
                message.setText(body, true);
            };

            mailSender.send(preparator);
            log.info("Email sent successfully To {} with Subject {}", toAddresses, subject);
        }
        catch (Exception e) {
            log.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

    private String getEmailContent(final DroneVO droneVO) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("drone", droneVO);
        freemarkerConfiguration.getTemplate("mail-drone.ftlh").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}

