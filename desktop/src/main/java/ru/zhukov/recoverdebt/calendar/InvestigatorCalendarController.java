package ru.zhukov.recoverdebt.calendar;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;

import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import jfxtras.icalendarfx.VCalendar;
import jfxtras.icalendarfx.components.VEvent;
import jfxtras.icalendarfx.properties.calendar.CalendarScale;
import jfxtras.scene.control.agenda.icalendar.ICalendarAgenda;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.ResourceBundle;

public class InvestigatorCalendarController implements Initializable {

    private VCalendar vCalendar;
    private ICalendarAgenda iCalendarAgenda;
    private CalendarView calendarView;

    @FXML
    private AnchorPane calendarStage;

    public InvestigatorCalendarController() {
       /* vCalendar = new VCalendar();
        iCalendarAgenda = new ICalendarAgenda(vCalendar);
        iCalendarAgenda.setDisplayedLocalDateTime(LocalDateTime.now());
        vCalendar.setCalendarScale(new CalendarScale());
        vCalendar.withVEvents(new VEvent().withDateTimeStart(LocalDateTime.of(2017,10,29,10,00))
                                          .withDateTimeEnd(LocalDateTime.of(2017,10,29,11,00)));
*/

         calendarView = new CalendarView();
         calendarView.setRequestedTime(LocalTime.now());
         calendarView.setShowAddCalendarButton(false);
         calendarView.setShowPrintButton(false);
         calendarView.setShowPageToolBarControls(false);
         calendarView.showWeekPage();
         CalendarSource calendarSource = new CalendarSource();
         calendarSource.getCalendars().add(new Calendar("Invest"));
         calendarView.getCalendarSources().add(calendarSource);
         Entry entry =  new Entry<>();
         entry.setTitle("Позвонить домой");
         entry.setInterval(LocalDateTime.of(2017,10,28,12,00),
                 LocalDateTime.of(2017,10,28,13,00) );

         calendarView.getCalendars().get(0).addEntry(entry);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        show();
    }

    private void show(){
        AnchorPane anchorPane = new AnchorPane();
        //anchorPane.getChildren().add(iCalendarAgenda);

        anchorPane.getChildren().add(calendarView);
        AnchorPane.setTopAnchor(calendarView, 0.0);
        AnchorPane.setLeftAnchor(calendarView, 0.0);
        AnchorPane.setRightAnchor(calendarView, 0.0);
        AnchorPane.setBottomAnchor(calendarView, 0.0);

        this.calendarStage.getChildren().add(calendarView);
    }
}
