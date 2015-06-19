/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

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

    private List<Resultat> listResultat;

    private Resultat resultat;

    @PostConstruct
    public void init() {
        listResultat = new ArrayList<>();
        listResultat.add(new Resultat("www.test1.fr", "test1@gmail.com"));
        listResultat.add(new Resultat("www.test2.fr", "test2@gmail.com"));
        listResultat.add(new Resultat("www.test3.fr", "test3@gmail.com"));
        listResultat.add(new Resultat("www.test4.fr", "test4@gmail.com"));
        listResultat.add(new Resultat("www.test5.fr", "test5@gmail.com"));
        listResultat.add(new Resultat("www.test6.fr", "test6@gmail.com"));
        listResultat.add(new Resultat("www.test7.fr", "test7@gmail.com"));
        listResultat.add(new Resultat("www.test8.fr", "test8@gmail.com"));
        listResultat.add(new Resultat("www.test9.fr", "test9@gmail.com"));
    }

    public List<Resultat> getListResultat() {
        return listResultat;
    }

    public void setListResultat(List<Resultat> listResultat) {
        this.listResultat = listResultat;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    public String sendMailing() {
        String from = "gosselet.edgar@gmail.com";
        String pass = "fullmetal&1992";
        String[] to = {"gosselet.edgar@gmail.com"}; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";

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
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
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
        return "index?faces-redirect=true";
    }
}
