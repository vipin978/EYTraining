package day16Proj;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Consignment1 {
	public static void main(String[] args) {
		PackageTracker pt = new PackageTracker(LocalDateTime.now(), 200, 5);
		System.out.println(pt.calculateReachTime());
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
		
		LocalDateTime startDt = this.startDatetime;
		LocalDateTime endDt = PackageTrackerUtil.getEndDateTime(startDt);
		int breakHrs = 0;
		System.out.println(this.totalHours);
		
		while(this.totalHours > 0) {
			System.out.println("    "+ startDt +"   "+endDt);
			Duration dur = Duration.between(startDt, endDt);
			long hours = dur.toHours();
			if(WeekEndDays.isWeekEnd(startDt)) {
				startDt = endDt.minusHours(0);
				endDt = endDt.plusHours(24);
			}
			else {
				
				breakHrs = PackageTrackerUtil.tbh.durationHours(startDt, endDt);
			//	System.out.println("Break Hours ...."+breakHrs+"Total hours ...."+this.totalHours);
				this.totalHours -= (hours-(breakHrs/60));
			//	System.out.println("Break Hours 2 ...."+breakHrs+"Total hours 2...."+this.totalHours);
				startDt = endDt.minusHours(0);
				endDt = endDt.plusHours(hours);
			}
		}
		
		if(Math.abs(this.totalHours) > 0) {
			startDt = startDt.minusHours(24);
			endDt = endDt.minusHours(24);
			//System.out.println("DURATION [ "+startDt +" "+ endDt+" ]");
			endDt = endDt.minusHours(Math.abs(this.totalHours));
			//System.out.println("DURATION [ "+startDt +" "+ endDt+" ]");
			int bHrs = (breakHrs-PackageTrackerUtil.tbh.durationHours(startDt, endDt));
			endDt  = endDt.minusHours(bHrs/60);
		}
		
		return endDt;
	}
}

class PackageTrackerUtil{
	
	static TotalBreakHours tbh = new TotalBreakHours();
	
	public static int findTimeTake(int distance,int speed) {
		return distance / speed;
	}
	
	public static LocalDateTime getEndDateTime(LocalDateTime start) {
		LocalDateTime end;
		
		if(start.getHour() < 6) {
			end = start.with(LocalTime.of(6, 0));
		}
		else {
			end = start.plusDays(1).with(LocalTime.of(6, 0));
		}
		return end;
	}
	
}

class WeekEndDays{
	public static boolean isWeekEnd(LocalDateTime LDT) {
		if(LDT.getDayOfWeek().getValue() == 6 && LDT.getHour() > 6) {
			return true;
		}
		if(LDT.getDayOfWeek().getValue() == 1 && LDT.getHour() < 6) {
			return true;
		}
		if(LDT.getDayOfWeek().getValue() == 7) {
			return true;
		}
		return false;
	}
}

abstract class BreakHours{
	abstract public int durationHours(LocalDateTime start,LocalDateTime end);
}

class TotalBreakHours extends BreakHours{
	
	LunchBreakHour lunchBreak = new LunchBreakHour();
	EveningBreakHour eveBreak = new EveningBreakHour();
	MorningBreakHour mrngBreak = new MorningBreakHour();
	
	@Override
	public int durationHours(LocalDateTime start, LocalDateTime end) {
		
		mrngBreak.setMorningBreakTime(start.with(LocalTime.of(10, 30)));
		lunchBreak.setLunchBreakTime(start.with(LocalTime.of(13, 30)));
		eveBreak.setEveningBreakTime(start.with(LocalTime.of(17, 30)));
		
		int totalHours = 0;
		
		totalHours = mrngBreak.durationHours(start, end) + lunchBreak.durationHours(start, end) 
			+eveBreak.durationHours(start, end);
		
		return totalHours;
	}
}

class MorningBreakHour extends BreakHours{
	
	public static int offset = 15;
	private LocalDateTime morningBreakTime;
	
	public void setMorningBreakTime(LocalDateTime mrngDT) {
		this.morningBreakTime = mrngDT;
	}
	
	@Override
	public int durationHours(LocalDateTime start, LocalDateTime end) {
		if(start == null && end == null) {
			return offset;
		}
		else {
			if(start.compareTo(morningBreakTime) < 0 && end.compareTo(morningBreakTime) > 0) {
				return offset;
			}
		}
		return 0;
	}
}


class LunchBreakHour extends BreakHours{
	
	public static int offset = 60;
	private LocalDateTime lunchBreakTime;
	
	
	public void setLunchBreakTime(LocalDateTime lunchDT) {
		this.lunchBreakTime = lunchDT;
	}
	
	@Override
	public int durationHours(LocalDateTime start, LocalDateTime end) {
		if(start == null && end == null) {
			return offset;
		}
		else {
			if(start.compareTo(lunchBreakTime) < 0 && end.compareTo(lunchBreakTime) > 0) {
				return offset;
			}
		}
		return 0;
	}
}


class EveningBreakHour extends BreakHours{
	
	public static int offset = 15;
	private LocalDateTime eveningBreakTime;
	
	public void setEveningBreakTime(LocalDateTime eveDT) {
		this.eveningBreakTime = eveDT;
	}
	
	@Override
	public int durationHours(LocalDateTime start, LocalDateTime end) {
		if(start == null && end == null) {
			return offset;
		}
		else {
			if(start.compareTo(eveningBreakTime) < 0 && end.compareTo(eveningBreakTime) > 0) {
				return offset;
			}
		}
		return 0;
	}
}