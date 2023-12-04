package com.hackathon.equipo2.CineHackacthon.validators.showValidators;

import com.hackathon.equipo2.CineHackacthon.models.ScheduleModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowModel;
import com.hackathon.equipo2.CineHackacthon.models.ShowValidatorModel;
import com.hackathon.equipo2.CineHackacthon.services.ShowService;
import com.hackathon.equipo2.CineHackacthon.services.responses.ShowServiceResponse;
import com.hackathon.equipo2.CineHackacthon.utils.ShowValidatorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ShowScheduleOverlapValidator extends AbstractShowValidator {

    @Autowired
    ShowService showService;

    @Override
    public ShowValidatorModel apply(ShowModel key) {
        return this.scheduleOverlap(key);
    }

    public ShowValidatorModel scheduleOverlap(ShowModel showModel) {

        ShowValidatorModel validation = new ShowValidatorModel(true, ShowValidatorEnum.SHOW_VALID);
        ShowServiceResponse<List<ShowModel>> showList = this.showService.findAll();
        Date dateStart = showModel.getSchedule().getDateStart();
        Date dateEnd = showModel.getSchedule().getDateEnd();
        boolean ovelap = false;
        List<ShowModel> shows = showList.getPayload();
        for (ShowModel show: shows) {
            if (show.getRoomModel().getId() != showModel.getRoomModel().getId()) {
                continue;
            }
            ScheduleModel schedule = show.getSchedule();
//            if (dateStart.after(schedule.getDateStart()) && dateStart.before(schedule.getDateEnd())
//                    || dateEnd.after(schedule.getDateStart()) && dateEnd.before(schedule.getDateEnd())) {
//
//            }
            if (!(dateStart.after(schedule.getDateEnd())
                    || dateEnd.before(schedule.getDateStart())) ) {
                ovelap = true;
            }
        }

        if (ovelap) {
            validation.setValid(false);
            validation.setShowValidatorEnum(ShowValidatorEnum.SHOW_MOVIE_SCHEDULE_OVERLAP);
        }

        return  validation;
    }

}
