package sk.uniza.fri.customerjpa;

import javax.persistence.*;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "towns_name")),
        @AttributeOverride(name = "population", column = @Column(name = "towns_population"))
})
public class PlaceOfResidence {

    @Basic(optional = false) @Column(length = 75)
    private String name;
    @Basic(optional = false)
    private Long population;

    public PlaceOfResidence() {}

    public PlaceOfResidence(String name, Long population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("/" +
                "name = %s, population = %d/", name, population);
    }

}
