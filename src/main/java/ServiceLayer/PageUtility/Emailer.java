package ServiceLayer.PageUtility;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Emailer
{
    final String username = "OlskerLotta@gmail.com";
    final String password = "#_CupCakeLovR1337_#";
    String toEmail = "";
    String fromEmail = "OlskerLotta@gmail.com";
    String host = "smtp.gmail.com";
    Properties properties = System.getProperties();

    String pdfPath;
    String pngPath;

    public Emailer(String toEmail, String pdfPath, String pngPath)
    {
        this.toEmail = toEmail;
        this.pdfPath = pdfPath;
        this.pngPath = pngPath;
    }

    public void sendmail()
    {
        //TODO: Få metoden til at tage imod en array af strings som den kan bruge i message.setText
        // hvor der står pænt hvad man har bestilt.

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator()
        {

            protected PasswordAuthentication getPasswordAuthentication()
            {

                return new PasswordAuthentication(username, password);

            }

        });

        //Start out mail message
        MimeMessage msg = new MimeMessage(session);
        try
        {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Order Confirmation plus Material List");


            Multipart emailContent = new MimeMultipart();

            //Text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Thanks for ordering at Fog! Attached you will find your materials used for your carport and an SVG sketch of it");

            //Attachment body part
            MimeBodyPart pdfAttachment = new MimeBodyPart();
            MimeBodyPart pngAttachment = new MimeBodyPart();
            pdfAttachment.attachFile(pdfPath);
            pngAttachment.attachFile(pngPath);

            //Attach body parts
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(pdfAttachment);
            emailContent.addBodyPart(pngAttachment);

            //Attach multipart to message
            msg.setContent(emailContent);

            Transport.send(msg);
        }
        catch (MessagingException | IOException e)
        {
            e.printStackTrace();
        }
    }
}
