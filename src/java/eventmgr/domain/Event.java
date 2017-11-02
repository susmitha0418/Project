/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author su393507
 */
public class Event
{
    private int id;
    private String name;
    private Date startdate;
    private Location location;
    private Set<Speaker> speakers;
    public Set<Speaker> getSpeakers() 
    { 
        return speakers; 
    }

	/** set the event speakers (for use by Hibernate) */
	protected void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}
	
	/** add a speaker. For use by application. */
	public void addSpeaker( Speaker speaker ) {
		if ( ! speakers.contains(speaker) ) speakers.add(speaker);
	}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate)
    {
        this.startdate = startdate;
    }

    public Location getLocation() 
    {
        return location;
    }

    public void setLocation(Location location) 
    {
        this.location = location;
    }
    public String toString() 
    {
        return "Event{" + "id=" + id + ", name=" + name + ", startdate=" + startdate + ", location=" + location + '}';
    }
    
    
}
