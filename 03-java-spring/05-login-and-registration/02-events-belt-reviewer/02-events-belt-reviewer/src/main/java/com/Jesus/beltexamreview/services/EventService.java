package com.Jesus.beltexamreview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jesus.beltexamreview.models.Event;
import com.Jesus.beltexamreview.models.EventUser;
import com.Jesus.beltexamreview.models.Message;
import com.Jesus.beltexamreview.repositories.EventRepository;
import com.Jesus.beltexamreview.repositories.MessageRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eRepo;
	
	@Autowired
	private MessageRepository mRepo;
	
	public List<Event> getAllEvents(){
		return this.eRepo.findAll();
	}
	
	public List<Event> allEventsWithState(String state) {
		return this.eRepo.findByState(state);
	}
	
	public List<Event> allEventsNotState(String state) {
		return this.eRepo.findByStateIsNot(state);
	}
	
	public Event findById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	public Event create(Event event) {
		return this.eRepo.save(event);
	}
	
	public Event update(Event event) {
		return this.eRepo.save(event);
	}
	
	public void comment(EventUser user, Event event, String comment) {
		this.mRepo.save(new Message(user, event, comment));
	}
	
	public void delete(Long id) {
		this.eRepo.deleteById(id);
	}
	
	public void manageAttendees(Event event, EventUser user, boolean isJoining) {
		if(isJoining) {
			event.getAttendees().add(user);
		} else {
			event.getAttendees().remove(user);
		}
		this.eRepo.save(event);
	}
}