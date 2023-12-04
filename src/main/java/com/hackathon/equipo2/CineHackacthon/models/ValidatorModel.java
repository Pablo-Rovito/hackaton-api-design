package com.hackathon.equipo2.CineHackacthon.models;

import com.hackathon.equipo2.CineHackacthon.utils.ValidatorEnum;


public class ValidatorModel {

    private boolean valid;

    private ValidatorEnum validatorEnum;

    public ValidatorModel() {
    }

    public ValidatorModel(boolean valid) {
        this.valid = valid;
    }

    public ValidatorModel(boolean valid, ValidatorEnum validatorEnum) {
        this.valid = valid;
        this.validatorEnum = validatorEnum;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public ValidatorEnum getValidatorEnum() {
        return validatorEnum;
    }

    public void setValidatorEnum(ValidatorEnum validatorEnum) {
        this.validatorEnum = validatorEnum;
    }
}
