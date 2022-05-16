package com.siit.sbnz.timdarmar.models.classes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(name = "client")
@NoArgsConstructor
public class Admin extends Client {
	private static final long serialVersionUID = 1L;
		
}
