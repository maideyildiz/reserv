package com.maide.reserv.bed;

import com.maide.reserv.room.Room;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private BedType bedType;
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    public Bed(BedType bedType) {
        this.bedType = bedType;
    }
}
