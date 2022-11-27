package com.codingz2m.springprofiles.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



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
  @Size(min=5, max=20)
  @Column(nullable=false, length=200)
  private String placeName;
  
  @Column(nullable=false, length=150)
  @Size(min=3, message="Country length must be atleast 3 chars")
  private String country;

 

}
