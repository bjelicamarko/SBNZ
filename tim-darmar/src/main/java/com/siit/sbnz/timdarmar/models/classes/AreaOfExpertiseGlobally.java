package com.siit.sbnz.timdarmar.models.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "area_of_expertise_globally")
@Getter @Setter 
@NoArgsConstructor
@AllArgsConstructor
public class AreaOfExpertiseGlobally {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	@NonNull
	private String nameOfArea;
	
	@ElementCollection()
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(name = "specializations_globally", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "specialization") // 3
	private List<String> specializations;
	
	public AreaOfExpertiseGlobally(String name) {
		this.nameOfArea = name;
		this.specializations = new ArrayList<>();
	}
	
}
