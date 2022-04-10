package com.maide.reserv.room;

import com.maide.reserv.bed.Bed;
import com.maide.reserv.type.ReservationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String roomName;
    private Integer bedCount;
    private ReservationType roomType;
    @OneToMany(mappedBy = "bed")
    private List<Bed> beds;

    public Room(String roomName, ReservationType roomType) {
        this.roomName = roomName;
        this.roomType = roomType;
    }
}
