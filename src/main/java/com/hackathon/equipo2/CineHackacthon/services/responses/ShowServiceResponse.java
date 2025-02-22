package com.hackathon.equipo2.CineHackacthon.services.responses;

import com.hackathon.equipo2.CineHackacthon.utils.ShowServiceEnum;
import com.hackathon.equipo2.CineHackacthon.utils.ShowValidatorEnum;

public class ShowServiceResponse<T> extends ServiceResponse<T>  {

    public ShowServiceResponse() {
    }

    public ShowServiceResponse(ShowServiceEnum showServiceEnum, T payload) {
        super(showServiceEnum.getHttpStatus(), showServiceEnum.getCode(), showServiceEnum.getMessage(), payload);
    }


    public void setShowServiceEnum(ShowServiceEnum showServiceEnum) {
        this.setCode(showServiceEnum.getCode());
        this.setMessage(showServiceEnum.getMessage());
        this.setHttpStatus(showServiceEnum.getHttpStatus());
    }

    public void setShowValidatorEnum(ShowValidatorEnum showValidatorEnum) {
        this.setCode(showValidatorEnum.getCode());
        this.setMessage(showValidatorEnum.getMessage());
        this.setHttpStatus(showValidatorEnum.getHttpStatus());
    }


}
