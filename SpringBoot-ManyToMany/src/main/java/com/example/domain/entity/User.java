package com.example.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer mark;
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinTable(
			  name = "users_places", 
			  joinColumns = @JoinColumn(name = "user_id", referencedColumnName="id"),
			  inverseJoinColumns = @JoinColumn(name="place_id", referencedColumnName="id"))
	private List<Place> placeList;
	
}
