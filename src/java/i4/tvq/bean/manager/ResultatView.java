/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

import i4.tvq.bean.entity.ResultatMailing;
import i4.tvq.database.entity.Resultat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Edgar
 */
@ManagedBean
@RequestScoped
public class ResultatView {

    private List<ResultatMailing> listResultat;
    private ResultatMailing resultat;
    private String subject;
    private String body;

    @PostConstruct
    public void init() {
        listResultat = new ArrayList<>();
        listResultat.add(new ResultatMailing("www.test1.fr", "test1@gmail.com"));
        listResultat.add(new ResultatMailing("www.test2.fr", "test2@gmail.com"));
        listResultat.add(new ResultatMailing("www.test3.fr", "test3@gmail.com"));
        listResultat.add(new ResultatMailing("www.test4.fr", "test4@gmail.com"));
        listResultat.add(new ResultatMailing("www.test5.fr", "test5@gmail.com"));
        listResultat.add(new ResultatMailing("www.test6.fr", "test6@gmail.com"));
        listResultat.add(new ResultatMailing("www.test7.fr", "test7@gmail.com"));
        listResultat.add(new ResultatMailing("www.test8.fr", "test8@gmail.com"));
        listResultat.add(new ResultatMailing("www.test9.fr", "test9@gmail.com"));
    }

    public List<ResultatMailing> getListResultat() {
        return listResultat;
    }

    public void setListResultat(List<ResultatMailing> listResultat) {
        this.listResultat = listResultat;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(ResultatMailing resultat) {
        this.resultat = resultat;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String sendMailing() {
        String mailList = "";
        for (ResultatMailing res : listResultat) {
            if (res.isToSend()) {
                mailList += res.getMailresultat() + ",";
            }
        }
        if (mailList.isEmpty()) {
            String[] to = mailList.substring(0, mailList.length()).split(",");

            String[] bouchon = {"tuveuxquoi.epsi@gmail.com"};
            String from = "tuveuxquoi.epsi@gmail.com";
            String pass = "abcd4ABCD";
            Properties props = System.getProperties();
            String host = "smtp.gmail.com";
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            try {
                message.setFrom(new InternetAddress(from));
                InternetAddress[] toAddress;
                toAddress = new InternetAddress[bouchon.length];

                // To get the array of addresses
                for (int i = 0; i < bouchon.length; i++) {
                    toAddress[i] = new InternetAddress(bouchon[i]);
                }
                for (InternetAddress toAddres : toAddress) {
                    message.addRecipient(Message.RecipientType.TO, toAddres);
                }
                message.setSubject(subject);
                message.setText(body);
                Transport transport = session.getTransport("smtps");
                transport.connect(host, from, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            } catch (AddressException ae) {
            } catch (MessagingException me) {
            }
        }
        return "index?faces-redirect=true";
    }
}
