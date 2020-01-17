package com.system.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "motorcycles")
@NoArgsConstructor
@Data
public class Motorcycle extends Vehicle {


}
