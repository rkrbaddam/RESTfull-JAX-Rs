package org.messenger.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.messenger.messenger.model.*;

public class DatabaseClass {
	private static Map<Long, Message> message = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessage() {
		return message;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
