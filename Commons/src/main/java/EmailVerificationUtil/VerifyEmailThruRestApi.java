package EmailVerificationUtil;

import GoogleApiUtil.GoogleSheetData;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class VerifyEmailThruRestApi {

    // private NadaEMailService nada;

    private static final Object lock = new Object();
    private static volatile NadaEMailService getNadaEmailServiceInstance;
    public static String newUserValidationUrlFromEmail;

   /* public static NadaEMailService getInstance() {
        NadaEMailService r = getNadaEmailServiceInstance;
        if (r == null) {
            synchronized (lock) {    // While we were waiting for the lock, another
                r = getNadaEmailServiceInstance;        // thread may have instantiated the object.
                if (r == null) {
                    r = new NadaEMailService();
                    getNadaEmailServiceInstance = r;
                }
            }
        }
        return r;
    } */

    static {
        NadaEMailService r = getNadaEmailServiceInstance;
        if (r == null) {
            synchronized (lock) {    // While we were waiting for the lock, another
                r = getNadaEmailServiceInstance;        // thread may have instantiated the object.
                if (r == null) {
                    r = new NadaEMailService();
                    getNadaEmailServiceInstance = r;
                }
            }
        }

    }


    public static void HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(String email, String EmailSubject) {

        getNadaEmailServiceInstance.getEmailId(email);
        String emailContent = null;
        try {
            Thread.sleep(15000);
            emailContent = getNadaEmailServiceInstance.getMessageWithSubjectThatContains(EmailSubject).getHtml();
            newUserValidationUrlFromEmail = FromHtmlParseClickHereUrl(emailContent);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(String email, String EmailSubject, String ExcelSheetName) {


       // String emailFromxls = GoogleSheetData.getSpecificRowColValueFromGoogleSheet(ExcelSheetName, email);
       //  String emailSubFromxls = GoogleSheetData.getSpecificRowColValueFromGoogleSheet(ExcelSheetName, EmailSubject);


        getNadaEmailServiceInstance.getEmailId(email);
        String emailContent = null;
        try {
            Thread.sleep(15000);
            emailContent = getNadaEmailServiceInstance.getMessageWithSubjectThatContains(EmailSubject).getHtml();
            newUserValidationUrlFromEmail = FromHtmlParseClickHereUrl(emailContent);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static String FromHtmlParseClickHereUrl(String emailContent) {
        Document doc = Jsoup.parse(emailContent, "utf-8");

        Elements links = doc.select("a[href]");

        for (Element link : links) {
            if (link.attr("abs:href").contains("/user-activation.html?activationToken=")) {
                System.out.println("Your final URL to activate is :-- \n" + link.attr("abs:href"));
                return link.attr("abs:href").toString();

            }
        }
        return null;

    }


}
