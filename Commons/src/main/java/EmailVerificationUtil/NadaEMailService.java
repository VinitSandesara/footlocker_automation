package EmailVerificationUtil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.lang.RandomStringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class NadaEMailService {

    //private static final String NADA_EMAIL_DOMAIN = "@getnada.com";
    private static final String INBOX_MESSAGE_KEY_NAME = "msgs";
    private static final String EMAIL_ID_ROUTE_PARAM = "email-id";
    private static final String MESSAGE_ID_ROUTE_PARAM = "message-id";
    private static final String NADA_EMAIL_INBOX_API = "https://getnada.com/api/v1/inboxes/{email-id}";
    private static final String NADA_EMAIL_MESSAGE_API = "https://getnada.com/api/v1/messages/{message-id}";
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final int EMAIL_CHARS_LENGTH = 10;

    private String emailId;


  /*  private void generateEmailId(){
        //this.emailId = RandomStringUtils.randomAlphanumeric(EMAIL_CHARS_LENGTH).toLowerCase().concat(NADA_EMAIL_DOMAIN);
       //  this.emailId = "stag_non_vip_user5@getnada.com";
    }*/

    //generates a random email for the first time.
    //call reset for a new random email
    public String getEmailId(String emailId){
        /*if(Objects.isNull(this.emailId)){
            this.generateEmailId();
        }*/

       return this.emailId = emailId;
       // return this.emailId;
    }

    //to re-generate a new random email id
    public void reset(){
        this.emailId = null;
    }

    public List<InboxEmail> getInbox() throws UnirestException, IOException {
        String msgs = Unirest.get(NADA_EMAIL_INBOX_API)
                            .routeParam(EMAIL_ID_ROUTE_PARAM, emailId)
                            .asJson()
                            .getBody()
                            .getObject()
                            .getJSONArray(INBOX_MESSAGE_KEY_NAME)
                            .toString();
        return MAPPER.readValue(msgs, new TypeReference<List<InboxEmail>>() {});
    }

    public EmailMessage getMessageById(final String messageId)  {
        String msgs = null;
        try {
            msgs = Unirest.get(NADA_EMAIL_MESSAGE_API)
                                    .routeParam(MESSAGE_ID_ROUTE_PARAM, messageId)
                                    .asJson()
                                    .getBody()
                                    .getObject()
                                    .toString();
                                    return MAPPER.readValue(msgs, EmailMessage.class);
        } catch (UnirestException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public EmailMessage getMessageWithSubjectThatContains(final String emailSubject) throws IOException, UnirestException {
        return  this.getInbox()
                    .stream()
                    .filter(ie -> ie.getSubject().contains(emailSubject))
                    .findFirst()
                    .map(InboxEmail::getMessageId)
                    .map(this::getMessageById)
                    .orElseThrow(IllegalArgumentException::new);
    }

     public EmailMessage getMessageWithSubjectEndsWith(final String emailSubject) throws IOException, UnirestException {
        return  this.getInbox()
                    .stream()
                    .filter(ie -> ie.getSubject().contains(emailSubject))
                    .findFirst()
                    .map(InboxEmail::getMessageId)
                    .map(this::getMessageById)
                    .orElseThrow(IllegalArgumentException::new);
    }





}
