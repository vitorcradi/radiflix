package br.com.radiflix.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class IssueDTO {

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("reason")
    public String reason;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("description")
    public String description;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
