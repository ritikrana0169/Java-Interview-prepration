package com.interview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Interview {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@Size(min=10,max=500)
@NotNull
private String question;
@Size(min=10,max=2000)
@NotNull 
private String answer;
private Integer level;
	
}
