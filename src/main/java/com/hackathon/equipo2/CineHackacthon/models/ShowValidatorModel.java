package com.hackathon.equipo2.CineHackacthon.models;

import com.hackathon.equipo2.CineHackacthon.utils.ShowValidatorEnum;
import com.hackathon.equipo2.CineHackacthon.utils.ValidatorEnum;

public class ShowValidatorModel extends ValidatorModel {

    private ShowValidatorEnum showValidatorEnum;


    public ShowValidatorModel() {
    }

    public ShowValidatorModel(boolean valid, ShowValidatorEnum showValidatorEnum) {
        super(valid);
        this.showValidatorEnum = showValidatorEnum;
    }

    public ShowValidatorEnum getShowValidatorEnum() {
        return showValidatorEnum;
    }

    public void setShowValidatorEnum(ShowValidatorEnum showValidatorEnum) {
        this.showValidatorEnum = showValidatorEnum;
    }
}
