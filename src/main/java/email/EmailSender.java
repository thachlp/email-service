package email;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public final class EmailSender {

    public static void sendEmail(String to, String subject, String body, String from, String password, List<String> imageUrls) {
        final Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.debug", "true");

        try {
            final Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });
            final Message message = new MimeMessage(session);
            message.setSubject(subject);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            final MimeMultipart multipart = new MimeMultipart();
            final MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(body);
            multipart.addBodyPart(textPart);
            addAttachments(multipart, imageUrls);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (Exception exception) {
            System.err.println("Email not sent!" + exception.getMessage());
        }
    }

    private static void addAttachments(MimeMultipart multipart, List<String> imageUrls) throws IOException, MessagingException {
        if (imageUrls != null && !imageUrls.isEmpty()) {
            for (String imageUrl : imageUrls) {
                final MimeBodyPart attachmentPart = new MimeBodyPart();
                final URL url = new URL(imageUrl);
                final InputStream inputStream = url.openStream();
                final byte[] imageBytes = IOUtils.toByteArray(inputStream);
                attachmentPart.setFileName("image_" + imageUrls.indexOf(imageUrl) + ".jpg");
                attachmentPart.setContent(imageBytes, "image/jpeg");
                multipart.addBodyPart(attachmentPart);
            }
        }
    }
}
