### Concepts
- **SMTP** (Simple Mail Transfer Protocol) is a protocol used to send emails.
- **SMTP host** is the server that sends the email.

    _Examples_:
  - `smtp.gmail.com` is the SMTP host for Gmail.
  - `smtp.mail.yahoo.com` is the SMTP host for Yahoo.
  - `smtp-mail.outlook.com` is the SMTP host for Outlook.
- **SMTP port**
  - `587` used for TSL (Transport Layer Security) encryption.
  - `465` used for SSL (Secure Sockets Layer) encryption.
  - `25` used for unencrypted communication.
- **Message** class is used to create an email message. It defines essential message attributes such as sender, recipient, subject, and body, etc.
- **Session** class is used to create a session object that represents a mail session.
- **Transport** class is used to send the message to the SMTP server.
### Steps
1. Create App Password for Gmail: https://myaccount.google.com/apppasswords (for 2-step verification)
2. Input the password in the code.
### Reference:
- [Jakarta Mail Spec](https://jakarta.ee/specifications/mail/2.1/jakarta-mail-spec-2.1)
