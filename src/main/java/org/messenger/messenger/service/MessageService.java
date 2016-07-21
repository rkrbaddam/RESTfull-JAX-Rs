package org.messenger.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.messenger.messenger.database.DatabaseClass;
import org.messenger.messenger.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages=DatabaseClass.getMessage();
    public MessageService(){
    	
    	messages.put(1l, new Message(1L,"hello world","baddam"));
		messages.put(2l,new Message(2L,"hello jersey","baddam"));
	
    }
	
	public List<Message> getAllMessage()
	{
		return new ArrayList<Message>(messages.values());

	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear =new ArrayList<Message>();
		Calendar cal=Calendar.getInstance();
		for(Message message:messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
			
		}
		return messagesForYear;
		}
	public List<Message> getAllMessagesPaginatted(int start,int size){
		
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start+size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start+size);
	}
	
	
	
	
	
	
	
	
	
	public Message getMessage(long id)
	{
		return messages.get(id);
		
	}
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		
		return message;
	}
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	 public Message removeMessage(long id){
		  return messages.remove(id); 
	 }
	
	
}
