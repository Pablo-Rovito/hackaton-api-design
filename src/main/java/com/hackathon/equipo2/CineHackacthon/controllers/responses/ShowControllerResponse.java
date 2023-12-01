package com.hackathon.equipo2.CineHackacthon.controllers.responses;

import com.hackathon.equipo2.CineHackacthon.utils.ShowEnum;

public class ShowControllerResponse extends ControllerResponse {

    private ShowEnum showEnum;

    private Object showObj;


    public ShowControllerResponse() {
    }

    public ShowControllerResponse(ShowEnum showEnum, Object showObj) {
        this.showEnum = showEnum;
        this.showObj = showObj;
    }

    public ShowEnum getShowEnum() {
        return showEnum;
    }

    public void setShowEnum(ShowEnum showEnum) {
        this.showEnum = showEnum;
    }

    public Object getShowObj() {
        return showObj;
    }

    public void setShowObj(Object showObj) {
        this.showObj = showObj;
    }
}
