package com.crr.dsa.crackingtheinterview;

import java.sql.Time;

public class testddd {
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");
	class Time {
	    private int hour;
	    private int minute;


	    public Time(int hour, int minute) {
	        this.hour = hour;
	        this.minute = minute;
	    }


	    public int getHour() {
	        return hour;
	    }

	    public int getMinute() {
	        return minute;
	    }


	    public boolean occursBefore(Time time) {

	        if (this.hour < time.hour)
	            return true;

	        if ((this.hour == time.hour) && (this.minute < time.minute))
	            return true;
	        return false;
	    }


	    public int getDifference(Time time) {
	        int hoursDiff = this.hour - time.hour;
	        return hoursDiff * 60 + this.minute - time.minute;
	    }


	    public String toString() {
	        String out = String.valueOf(hour) + ":" + String.valueOf(minute);
	        if (minute < 10)
	            out += "0";
	        if (hour < 10)
	            out = "0" + out;
	        return out;
	    }
	}
	static class Meeting {
	    private String day;
	    private Time start;
	    private Time end;

	    private static String days[] = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };


	    public Meeting(String day, Time start, Time end) {
	        this.day = day;
	        this.start = start;
	        this.end = end;
	    }


	    public String getDay() {
	        return day;
	    }

	    public Time getEnd() {
	        return end;
	    }

	    public Time getStart() {
	        return start;
	    }


	    public int getDayNumber() {
	        int i;

	        for (i = 0; i < days.length; i++) {
	            if (days[i].equals(day))
	                break;
	        }

	        return i;
	    }


	    public boolean occursBefore(Meeting meeting) {

	        if (this.getDayNumber() < meeting.getDayNumber())
	            return true;

	        if ((this.getDayNumber() == meeting.getDayNumber()) && (this.getStart().occursBefore(meeting.getStart())))
	            return true;
	        return false;
	    }


	    public int getSleepTime(Meeting meeting) {

	        if (this.getDayNumber() > meeting.getDayNumber()) {
	            int daySleep = (this.getDayNumber() - meeting.getDayNumber() - 1) * 24 * 60;
	            int currDaySleep = this.getStart().getDifference(new Time(0, 0));
	            int prevDaySleep = new Time(24, 0).getDifference(meeting.getEnd());
	            return currDaySleep + prevDaySleep + daySleep;
	        }

	        return this.getStart().getDifference(meeting.getEnd());
	    }

	    public String toString() {
	        String out = day;
	        out += " " + getStart().toString() + " " + getEnd().toString();
	        return out;
	    }
	}
	class Solution {
		
	  public  int solution(String s) {
	        String meets[] = s.split("\n");
	        int M = meets.length;

	        Meeting meetings[] = new Meeting[M];


	        for (int i = 0; i < M; i++) {

	            String currMeet = meets[i];

	            String dayTime[] = currMeet.split(" ");


	            String day = dayTime[0];
	            String time = dayTime[1];


	            String startEnd[] = time.split("-");


	            String start = startEnd[0];
	            String end = startEnd[1];


	            String startHourMinute[] = start.split(":");
	            String endHourMinute[] = end.split(":");


	            int startHourInt = Integer.parseInt(startHourMinute[0]);
	            int startMinuteInt = Integer.parseInt(startHourMinute[1]);
	            int endHourInt = Integer.parseInt(endHourMinute[0]);
	            int endMinuteInt = Integer.parseInt(endHourMinute[1]);


	            Time startTime = new Time(startHourInt, startMinuteInt);
	            Time endTime = new Time(endHourInt, endMinuteInt);


	            Meeting newMeeting = new Meeting(day, startTime, endTime);
	            meetings[i] = newMeeting;
	        }

	        sortMeetings(meetings);

	        int initialSleep = meetings[0].getStart().getDifference(new Time(0, 0)) + meetings[0].getDayNumber() * 24 * 60;
	        int endSleep = new Time(24, 0).getDifference(meetings[M - 1].getEnd())
	                + (6 - meetings[M - 1].getDayNumber()) * 24 * 60;

	        int maxSleep = Math.max(initialSleep, endSleep);
	        for (int i = 1; i < M; i++) {
	            int currSleep = meetings[i].getSleepTime(meetings[i - 1]);
	            maxSleep = Math.max(maxSleep, currSleep);
	        }
	        return maxSleep;
	    }


	    


	


	   
	    


	    public  void sortMeetings(Meeting[] meetings) {
	        int n = meetings.length;

	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {

	                if (meetings[j].occursBefore(meetings[j + 1]) == false) {
	                    Meeting temp = meetings[j];
	                    meetings[j] = meetings[j + 1];
	                    meetings[j + 1] = temp;
	                }
	            }
	        }
	    }
	
	}

}
