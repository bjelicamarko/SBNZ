package com.siit.sbnz.timdarmar.models.classes;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "area_of_expertise")
@Getter @Setter 
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class AreaOfExpertise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	@NonNull
	private String nameOfArea;
	
	@ElementCollection
	@CollectionTable(name = "specializations", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "specialization") // 3
	private List<String> specializations;
	
}
