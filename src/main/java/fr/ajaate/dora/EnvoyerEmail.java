package fr.ajaate.dora;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnvoyerEmail {
private String username = "geston.aphp.delire@gmail.com";
private String password = "delire2020";
public boolean envoyer(String mail, String cle) {
// Etape 1 : Création de la session
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.host","smtp.gmail.com");
props.put("mail.smtp.port","587");
Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
}
});
try {
// Etape 2 : Création de l'objet Message
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("gestion.aphp.delire@gmail.com"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse(mail));
message.setSubject("Mail oublié : " + mail);
message.setText("Bonjour, vous avez reçu ce mail car vous avez effectué(e) une demande de réinitialisation de mot de passe." +
        "\nVoici la clé pour réinitialiser votre mot de passe : " + cle + ".\nSi vous n'êtes pas l'auteur de cette demande, ignorez simplement ce mail." +
        "\n\nCordialement,\nAP-HP Service.");
// Etape 3 : Envoyer le message
Transport.send(message);
System.out.println("Message_envoye");
return true;
} catch (MessagingException e) {
throw new RuntimeException(e);
} }
}
