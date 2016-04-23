package model;

public class TimeQuantum implements Comparable<TimeQuantum> {
	private String id;
	// private int year;
	// private int month;
	// private int date;
	private int hour;
	private int minute;

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		// stringBuilder.append(year).append("-");
		// stringBuilder.append(month).append("-");
		// stringBuilder.append(date).append(" ");
		if (hour < 10) {
			stringBuilder.append("0");
		}
		stringBuilder.append(hour).append(":");
		if (minute < 10) {
			stringBuilder.append("0");
		}
		stringBuilder.append(minute);
		return stringBuilder.toString();
	}

	public TimeQuantum() {
	}

	// public TimeQuantum(int year, int month, int date, int hour, int minute) {
	// this.year = year;
	// this.month = month;
	// this.date = date;
	// this.hour = hour;
	// this.minute = minute;
	// }

	public TimeQuantum(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	@Override
	public int compareTo(TimeQuantum o) {
		/*
		 * if (this.year < o.year) { return -1; } else if (this.year > o.year) {
		 * return 1; } else if (this.month < o.month) { return -1; } else if
		 * (this.month > o.month) { return 1; } else
		 */
		if (this.hour < o.hour) {
			return -1;
		} else if (this.hour > o.hour) {
			return 1;
		} else if (this.minute < o.minute) {
			return -1;
		} else if (this.minute > o.minute) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TimeQuantum) {
			TimeQuantum t = (TimeQuantum) obj;
			if (this.hour == t.hour && this.minute == t.minute) {
				return true;
			}
		}
		return false;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
