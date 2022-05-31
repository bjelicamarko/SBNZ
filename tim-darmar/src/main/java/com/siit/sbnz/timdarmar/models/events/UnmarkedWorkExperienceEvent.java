package com.siit.sbnz.timdarmar.models.events;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("24h")
@Getter
@Setter
@NoArgsConstructor
public class UnmarkedWorkExperienceEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date executionTime;
	private Employer employer;
	private WorkExperience workExperience;
	
	public UnmarkedWorkExperienceEvent(Employer employer, WorkExperience workExperience) {
		this.executionTime = new Date();
		this.employer = employer;
		this.workExperience = workExperience;
	}

}
