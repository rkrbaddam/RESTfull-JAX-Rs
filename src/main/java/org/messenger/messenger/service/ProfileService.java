package org.messenger.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.messenger.messenger.database.DatabaseClass;
import org.messenger.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles=DatabaseClass.getProfiles();
    public ProfileService(){
    	
    	profiles.put("badam", new Profile(1L,"baddam","ravikiran","baddam"));
		profiles.put("sindhu",new Profile(2L,"sindhu","sindhu","karumuri"));
	
    }
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(profiles.values());

	}
	
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
		
	}
	
	public Profile addProfile(Profile Profile)
	{
		Profile.setId(profiles.size()+1);
		profiles.put(Profile.getProfileName(), Profile);
		return Profile;
	}
	
	public Profile updateProfile(Profile Profile){
		if(Profile.getFirstName().isEmpty()){
			return null;
		}
		profiles.put(Profile.getProfileName(), Profile);
		return Profile;
	}
	 public Profile removeProfile(String profileName){
		  return profiles.remove(profileName); 
	 }
	
	
}
