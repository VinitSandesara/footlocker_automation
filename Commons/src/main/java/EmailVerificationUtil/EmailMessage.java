package EmailVerificationUtil;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class EmailMessage {

    @JsonProperty("html")
    private String html;

    @JsonProperty("text")
    private String text;

    public String getHtml() {

        return html;
    }

    public String getText() {
        return text;
    }
}