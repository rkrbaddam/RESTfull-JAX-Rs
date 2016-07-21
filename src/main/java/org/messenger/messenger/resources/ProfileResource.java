package org.messenger.messenger.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.messenger.messenger.model.Profile;
import org.messenger.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}

	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}

	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {

		return profileService.getProfile(profileName);

	}

	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName,
			Profile profile) {

		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);

	}

	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profileName) {
		profileService.removeProfile(profileName);
	}

}
