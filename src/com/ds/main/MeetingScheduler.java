package com.ds.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class MeetingScheduler {
    List<Room> rooms;

    public MeetingScheduler(int roomsCount) {
        this.rooms = new ArrayList<>();
        for (int i = 0; i < roomsCount; i++) {
            this.rooms.add(new Room(i));
        }
    }

    public int book(Date start, Date end) {
        for (Room room : rooms) {

            if (room.addMeeting(start, end)) {
                return room.id;
            }
        }
        return -1; // no room available.
    }

    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler(20);

        System.out.println(scheduler.book(new Date(0), new Date(1000)));
    }
}
 class Room {
    int id;
    TreeMap<Date, Date> meetings;

    public Room(int id) {
        this.id = id;
        meetings = new TreeMap<>();
    }

    public boolean addMeeting(Date start, Date end) {
        Date prev = meetings.floorKey(start);
        Date next = meetings.ceilingKey(start);

        if ((prev != null && meetings.get(prev).after(start)) || (next != null && next.before(end))) {
            return false;
        }

        meetings.put(start, end);

        return true;
    }
}
