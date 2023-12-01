package com.hackathon.equipo2.CineHackacthon.models;

import java.util.Date;

public class ScheduleModel {
    private long id;
    private Date dateStart;
    private Date dateEnd;

    public ScheduleModel() {
    }

    public ScheduleModel(long id, Date dateStart, Date dateEnd) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
