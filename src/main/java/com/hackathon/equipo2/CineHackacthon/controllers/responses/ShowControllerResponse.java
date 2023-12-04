package com.hackathon.equipo2.CineHackacthon.controllers.responses;

import com.hackathon.equipo2.CineHackacthon.utils.ShowServiceEnum;

public class ShowControllerResponse extends ControllerResponse {

    private ShowServiceEnum showServiceEnum;

    private Object showObj;


    public ShowControllerResponse() {
    }

    public ShowControllerResponse(ShowServiceEnum showServiceEnum, Object showObj) {
        this.showServiceEnum = showServiceEnum;
        this.showObj = showObj;
    }

    public ShowServiceEnum getShowEnum() {
        return showServiceEnum;
    }

    public void setShowEnum(ShowServiceEnum showServiceEnum) {
        this.showServiceEnum = showServiceEnum;
    }

    public Object getShowObj() {
        return showObj;
    }

    public void setShowObj(Object showObj) {
        this.showObj = showObj;
    }
}
