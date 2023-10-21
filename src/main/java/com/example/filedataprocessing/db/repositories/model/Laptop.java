package com.example.filedataprocessing.db.repositories.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "screen_type")
    private String screenType;

    @Column(name = "screen_resolution")
    private String screenResolution;

    @Column(name = "has_touch_screen")
    private String hasTouchScreen;

    @Column(name = "processor_name")
    private String processorName;

    @Column(name = "physical_cores_num")
    private String physicalCoresNum;

    @Column(name = "clock_speed")
    private String clockSpeed;

    @Column(name = "ram_size")
    private String ramSize;

    @Column(name = "disc_storage_size")
    private String discStorageSize;

    @Column(name = "disc_type")
    private String discType;

    @Column(name = "graphic_card_name")
    private String graphicCardName;

    @Column(name = "graphic_card_memory")
    private String graphicCardMemory;

    @Column(name = "os_name")
    private String osName;

    @Column(name = "disc_reader")
    private String discReader;
}
