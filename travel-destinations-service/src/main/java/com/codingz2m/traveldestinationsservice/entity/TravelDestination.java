package com.codingz2m.traveldestinationsservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GenerationType;

@Entity
@Table(name="travel_destination")
//@Setter
//@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelDestination  {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  @Size(min=5, max=20, message="Placename be bwetween 5 and 20 chars long")
  @NotNull(message="Placename can't be null")
  @Column(nullable=false, length=200)
  private String placeName;
  
  @Column(nullable=false, length=150)
  @Size(min=3, message="Country length must be atleast 3 chars")
  @NotNull(message="Country can't be null")
  private String country;

 

}
