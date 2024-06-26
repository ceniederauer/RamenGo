package com.RamenGo.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Protein {

  /**
   * id	string
   * imageInactive	string
   * imageActive	string
   * name	string
   * description	string
   * price	number
   */

  @Id
  private String id;

  @Column
  private String imageInactive;

  @Column
  private String imageActive;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private Number price;
}
