package email;

import java.util.List;

public final class App {
    public static void main(String[] args) {
        final String to = "lephuocthach@gmail.com";
        final String subject = "Test Email from Java";
        final String body = "This is a test email sent from Java using Jakarta Mail and Gmail. Attachments are included.";
        final String from = "abc@gmail.com"; // Your Gmail address
        final String password = "<password>"; // Your Gmail App Password
        final List<String> attachments = List.of(
                "https://www.gstatic.com/webp/gallery/1.jpg",
                "https://www.gstatic.com/webp/gallery/2.jpg",
                "https://www.gstatic.com/webp/gallery/3.jpg");
        EmailSender.sendEmail(to, subject, body, from, password, attachments);
    }
}
