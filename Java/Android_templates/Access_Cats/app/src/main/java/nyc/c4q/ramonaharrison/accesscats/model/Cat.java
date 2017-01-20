package nyc.c4q.ramonaharrison.accesscats.model;

import java.util.Calendar;

import nl.qbusict.cupboard.annotation.Column;

/**
 * Created by Ramona Harrison
 * on 11/19/16.
 */

public class Cat {

    // a POJO for cupboard must always contain a variable of type Long called _id.
    // this will serve as the index for the POJO within the SQLite table and will
    // auto-increment.
    private Long _id;

    private String name;

    // column name defaults to field name
    // or we can use @Column annotation to specify a custom name
    @Column("last_fed")
    private Long lastFed;

    // required zero argument constructor
    public Cat() {
        this.name = "Unknown";
        this.lastFed = Calendar.getInstance().getTimeInMillis();
    }

    public Cat(String name, Long lastFed) {
        this.name = name;
        this.lastFed = lastFed;
    }

    public Long getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLastFed() {
        return lastFed;
    }
}
