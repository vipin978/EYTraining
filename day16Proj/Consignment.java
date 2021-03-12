package day16Proj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import jdk.vm.ci.meta.Local;

public class Consignment {
	public static void main(String[] args) {
		
		LocalDateTime start = LocalDateTime.now();
		int distance = 240;
		int speed = 5;
		
		PackageTracker pg = new PackageTracker(start,distance,speed);
		System.out.println(pg.calculateReachingTime());
	}
}


class PackageTracker{
	
	LocalDateTime startDatetime;
	LocalDateTime endDatetime;
	
	int distance;
	int speed;
	
	int totalHours;
	
	public PackageTracker(LocalDateTime startDateTime,int distance,int speed) {
		this.startDatetime = startDateTime;
		this.distance = distance;
		this.speed = speed;
		this.totalHours = PackageTrackerUtil.findTimeTake(distance, speed);
	}
	
	public LocalDateTime calculateReachTime() {
		
		endDatetime = startDatetime;
		while(this.totalHours < 0) {
			
		}
		return this.endDatetime;
	}
}

class PackageTrackerUtil{
	public static int findTimeTake(int distance,int speed) {
		return distance / speed;
	}
	
}

class WeekEnds{
	public static LocalDateTime currentWeekSaturday;
	public static LocalDateTime currentWeekSunday;

	public int isColliding(LocalDateTime datetime) {
		if (datetime.getDayOfWeek().getValue() == 6)  {
			if(datetime.getHour() < 6) {
				return 0;
			}
			return 18;
		}
		if(datetime.getDayOfWeek().getValue() == 7) {
			return 24;
		}
		return 0;
}
}




//class PackageTracker{
//	
//	private LocalDateTime startDateTIme;
//	private LocalDateTime endDateTIme;
//	
//	private String placeOfOrigin;
//	private String placeOfDestination;
//	
//	public int distance;
//	public int speed;
//	
//	public int timeTaken;
//	
//	public PackageTracker(LocalDateTime startDateTIme,int distance,int speed) {
//		this.startDateTIme = startDateTIme;
//		this.distance = distance;
//		this.speed = speed;
//		this.timeTaken = PackageTrackerUtil.findTimeTake(distance, speed);
//		System.out.println("Timetaken :"+this.timeTaken);
//	}
//	
//	public LocalDateTime calculateReachingTime() {
//		
//		int collidingHolidays;
//		int collidinWeekdays;
//		int collidingBreakHours;
//		endDateTIme = startDateTIme.plusHours(timeTaken);
//		System.out.println("calculate  "+endDateTIme + "    "+startDateTIme);
//		while(true) {
//			PackageTrackerUtil.setDependancy(startDateTIme);
//			collidingHolidays = PackageTrackerUtil.isHoliday.isColliding(endDateTIme);
//			collidinWeekdays = PackageTrackerUtil.isWeekday.isColliding(endDateTIme);
//			collidingBreakHours = PackageTrackerUtil.isBreakTime.isColliding(startDateTIme, endDateTIme);
//			System.out.println("collidingHolidays : "+collidingHolidays + " "+"CBH : "+collidingBreakHours + " CWD" + collidinWeekdays);
//			if((collidingBreakHours+collidingHolidays+collidinWeekdays) == 0) {
//				break;
//			}
//			else {
//				startDateTIme = endDateTIme.plusMinutes(0);
//				endDateTIme = endDateTIme.plusMinutes(collidingBreakHours);
//				endDateTIme = endDateTIme.plusDays(collidinWeekdays+collidingHolidays);
//				collidingBreakHours = 0;
//				collidingHolidays = 0;
//				collidinWeekdays = 0;
//			}
//		}
//		return endDateTIme;
//	}
//	
//	
//}
//
//
//class PackageTrackerUtil{
//	
//	static Specification isHoliday = new HolidaySpec();
//	static Specification isWeekday = new WeekEndSpec();
//	static Specification isBreakTime = new BreakTimeSpec();
//	
//	public static int findTimeTake(int distance,int speed) {
//		return distance / speed;
//	}
//	
//	public static void setDependancy(LocalDateTime start) {
//		WeekEndSpec.currentWeekSunday = start.plusDays(7-(start.getDayOfWeek().getValue() % 7)).with(LocalTime.of(0, 0));
//		WeekEndSpec.currentWeekSaturday = start.plusDays(6-(start.getDayOfWeek().getValue() % 7)).with(LocalTime.of(6, 0));
//		TimeSpec.todaysDatetime = start.with(LocalTime.of(0, 0));
//	}
//}
//
//abstract class Specification{
//	abstract public int isColliding(LocalDateTime datetime);
//	abstract public int isColliding(LocalDateTime start, LocalDateTime end);
//}
//
//
//class WeekEndSpec extends Specification{
//	public static LocalDateTime currentWeekSaturday;
//	public static LocalDateTime currentWeekSunday;
//	@Override
//	public int isColliding(LocalDateTime datetime) {
//		if(datetime.compareTo(currentWeekSaturday) > 0 || datetime.compareTo(currentWeekSunday) > 0) {
//			return 2;
//		}
//		return 0;
//	}
//	
//	@Override
//	public int isColliding(LocalDateTime start, LocalDateTime end) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//}
//
//class HolidaySpec extends Specification{
//	
//	ArrayList<LocalDate> holidays = new ArrayList<LocalDate>(Arrays.asList(
//			LocalDate.of(2014, Month.JANUARY, 1),LocalDate.of(2014, Month.OCTOBER, 2),
//			LocalDate.of(2014, Month.AUGUST, 15),LocalDate.of(2014, Month.JANUARY, 26)
//			));
//
//	@Override
//	public int isColliding(LocalDateTime datetime) {
//		int noOfDays = 0;
//		for(LocalDate LD:holidays) {
//			if(datetime.getMonth().getValue() == LD.getMonthValue() && 
//					datetime.getDayOfMonth() == LD.getDayOfMonth()) {
//				noOfDays += 1;
//			}
//		}
//		return noOfDays;
//	}
//	
//	@Override
//	public int isColliding(LocalDateTime start, LocalDateTime end) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//}
//
//
//class BreakTimeSpec extends Specification{
//	
//	TimeSpec morningBreak = new TimeSpec("10:30:00", 15);
//	TimeSpec lunchBreak = new TimeSpec("12:30:00", 60);
//	TimeSpec eveningBreak = new TimeSpec("21:30:00", 15);
//	
//	@Override
//	public int isColliding(LocalDateTime startDateTime,LocalDateTime endDatetime) {
//		int noOfMinutes = 0;
//		LocalDateTime tempEndDT = endDatetime;  // so that it wont calculate weekend days breaktime
//		
//		if(endDatetime.getDayOfWeek().getValue() == 6||endDatetime.getDayOfWeek().getValue() == 7) {
//			tempEndDT = startDateTime.with(LocalTime.of(23,0));
//		}
//		
//		if(morningBreak.isInRange(startDateTime, tempEndDT)) {
//			noOfMinutes += morningBreak.offset;
//		}
//		
//		if(lunchBreak.isInRange(startDateTime, tempEndDT)) {
//			noOfMinutes += lunchBreak.offset;
//		}
//		
//		if(eveningBreak.isInRange(startDateTime, tempEndDT)) {
//			System.out.println("Yes" + "     "+startDateTime + "      "+endDatetime);
//			noOfMinutes += eveningBreak.offset;
//		}
//		return noOfMinutes;
//	}
//	
//	@Override
//	public int isColliding(LocalDateTime datetime) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//}
//
//
//class TimeSpec{
//	
//	public static LocalDateTime todaysDatetime; // so that next days 5:30 wont confuse with this days 5:30
//	public LocalTime time;
//	public int offset;
//	
//	public TimeSpec(String d,int offset) {
//		this.time = LocalTime.parse(d, DateTimeFormatter.ISO_TIME);
//		this.offset = offset;
//	}
//	
//	public boolean isInRange(LocalDateTime startTime,LocalDateTime endTime) {
//		LocalDateTime tempDT = todaysDatetime.with(this.time);
//		if(startTime.compareTo(tempDT) <= 0 && endTime.compareTo(tempDT) > 0) {
//			return true;
//		}
//		return false;
//	}
//}
//


//
//6. Pacel tracking / consignment tracking (domestic and international)
//*
//* 1. You are asked to calculate the Date and Time on which the consignment will reach.
//* a. Domestic (within India)
//* b. International (all over world) - Time zones have to be considered.
//* Input parameters will be
//* Start Date:
//* Start Time:
//* Place of Origin:
//* Place of Destination:
//* Distance:
//* Travel Speed:
//* Travel Break in hrs and mts.
//* conditions
//* Consignment does not move on Saturday and Sunday - holiday (Morning 6 to Next day Morning 6)
//* Consignment does not move on jan1, aug15, oct 2, jan 26. (Morning 6 to Next day Morning 6